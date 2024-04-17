/******************************************************************
 *
 *   Nathan Johnson / Comp272-002
 *
 *   Note, additional comments provided throughout source code for 
 *   educational purposes
 *
 ********************************************************************/

import java.util.BitSet;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import java.security.SecureRandom;
import java.lang.Math;

/**
 * Bloom Filters
 *
 * A Bloom filter is an implementation of a set which allows a certain 
 * probability of 'false positives' when determining if a given object is 
 * a member of that set, in return for a reduction in the amount of memory 
 * required for the set. It effectively works as follows:
 *    1) We allocate 'm' bits to represent the set data.
 *    2) We provide a hash function, which, instead of a single hash code, 
         produces'k' hash codes and sets those bits.
 *    3) To add an element to the set, we derive bit indexes from all 'k' 
         hash codes and set those bits.
 *    4) To determine if an element is in the set, we again calculate the 
 *       corresponding hash codes and bit indexes, and say it is likely 
 *       present if and only if all corresponding bits are set.
 *
 * The margin of error (or false positive rate) thus comes from the fact 
 * that as we add more and more objects to the set, we increase the likelihood
 * of "accidentally" setting a combination of bits that corresponds to an 
 * element that isn't actually in the set. However, through tuning the bloom 
 * filter setup based on the expected data, we mathematically have control 
 * over the desired false positive probability rate that we want to received
 * based on probability theory.
 *
 * False Positive rate discussion:
 *
 * The Bloom filter performance changes as we change parameters discussed 
 * below with the class constructors. There are two key variables that impact 
 * the false positive rate:
 *     1) number of bits per item
 *     2) number of hash codes
 *
 * In other words, how many more bits are there in the filter than the 
 * maximum number of items we want to represent in the set, and hence the 
 * number of bits that we actually set for each element that we add to the 
 * set. The more bits we require to be marked as set to '1' in order to mark 
 * an element as 'present' - e.g., the more hash code per item - the lower the 
 * chance of false positives, because for a given element potentially in
 * the set, there's less chance of some random combination of bits from other 
 * elements also accidentally marking that element as present when it isn't.
 *
 * But, for a given bit filter size, there is a 'point of no return', at 
 * which having more hash codes simply means that we fill up the bit set too 
 * quickly as we add elements -- and hence get more false positives -- than 
 * with fewer hash codes.
 *
 * Based on this discussion, you can find many Bloom Filter calculators 
 * available online to determine how to adjust the variables inorder to 
 * achieve the desired probability of false positive rates that you can 
 * tolerate and/or desire for your application, e.g.,:
 *  - https://toolslick.com/programming/data-structure/bloom-filter-calculator
 *  - https://www.engineersedge.com/calculators/bloom_filter_calculator_15596.htm
 *  - https://www.di-mgt.com.au/bloom-calculator.html
 *  - https://programming.guide/bloom-filter-calculator.html
 */

class BloomFilter {
    private static final int MAX_HASHES = 8;
    private static final long[] byteTable;
    private static final long HSTART = 0xBB40E64DA205B064L;
    private static final long HMULT = 7664345821815920749L;

    /*
     * Hash provision code provided below:
     *
     * The following methods implement a strong 64-bit hash function, which
     * produces a good dispersal. In other words, given a random set of
     * elements to hash, there is a high chance that our hash function will
     * produce corresponding hash codes that are well dispersed over the
     * possible range of hash codes. Hence:
     *    1) whatever the size of the hash table, the number of collisions will
     *       be close to the number that we would "theoretically" expect;
     *    2) for a given hash code width (i.e. the number of bits in the hash
     *       code), we can predict how likely it is for the above-mentioned goal
     *       to be met; e.g. given a typical random selection of element, for
     *       each element to be given a unique hash code.
     *
     * Additional discussion on hash implementation:
     *
     * Notice that Java's hash table implementation — and hence implementations
     * of hashCode() — don't require the goals above to be met. Java maps and 
     * sets, rather than storing just the hash code, store the actual key object.
     * This means that implementations of hashCode() generally only need to
     * be "fairly good". It isn't the end of the world if two key objects have
     * the same hash function, because the keys themselves are also compared in
     * deciding if a match has been found.
     *
     * Below implements a 64-bit Linear Congruential Generator (LCG). It uses 
     * a table of 256 random values indexed by successive bytes in the data, 
     * and recommends a multiple suitable for an LCG with a modulus of 2^64,
     * which is effectively what we have when we multiple using 64-bit long.
     *
     * The value of HMULT is found to be a good practice with 64-bit LCG. It 
     * has roughly half of its bits set and is 'virtually' prime (it is 
     * composed of three prime factors). The value of HSTART is arbitrary, 
     * essentially any value would do.
     *
     * Fore more information:
     *      Read about 'Linear Congruential Generators' (LCG) in the Literature.
     */

    static {
        byteTable = new long[256 * MAX_HASHES];
        long h = 0x544B2FBACAAF1684L;
        for (int i = 0; i < byteTable.length; i++) {
            for (int j = 0; j < 31; j++)
                h = (h >>> 7) ^ h; h = (h << 11) ^ h; h = (h >>> 10) ^ h;
            byteTable[i] = h;
        }
    }

    private long hashCode(String s, int hcNo) {
        long h = HSTART;
        final long hmult = HMULT;
        final long[] ht = byteTable;
        int startIx = 256 * hcNo;
        for (int len = s.length(), i = 0; i < len; i++) {
            char ch = s.charAt(i);
            h = (h * hmult) ^ ht[startIx + (ch & 0xff)];
            h = (h * hmult) ^ ht[startIx + ((ch >>> 8) & 0xff)];
        }
        return h;
    }

    private final BitSet data;          // The hash bit map
    private final int noHashes;         // number of hashes
    private final int hashMask;         // hash mask


    /*
     * Constructors discussion:
     *
     *   1) The first constructor will take as the first parameter the
     *      base 2 logarithm of the number of bits, so passing an
     *      example of 16, gives you a bloom filter of size 2^16. The
     *      second parameter is the number of hash functions to use.
     *
     *   2) On the second constructor, consider that we can calculate
     *      bit indexes from hash codes simply by ANDing with the mask. In
     *      actual practice, we may not want to have to pass in the logarithm
     *      of the number of bits, so we also provide a constructor that
     *      in effect calculates the required value from a maximum number of
     *      items and a number of bits per item.
     */

    public BloomFilter(int log2noBits, int noHashes) {
        if (log2noBits < 1 || log2noBits > 31)
            throw new IllegalArgumentException("Invalid number of bits");
        if (noHashes < 1 || noHashes > MAX_HASHES)
            throw new IllegalArgumentException("Invalid number of hashes");

        this.data = new BitSet(1 << log2noBits);
        this.noHashes = noHashes;
        this.hashMask = (1 << log2noBits) - 1;
    }

    public BloomFilter(int noItems, int bitsPerItem, int noHashes) {
        int bitsRequired = noItems * bitsPerItem;
        if (bitsRequired >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Bloom filter would be too big");
        }
        int logBits = 4;
        while ((1 << logBits) < bitsRequired)
            logBits++;
        if (noHashes < 1 || noHashes > MAX_HASHES)
            throw new IllegalArgumentException("Invalid number of hashes");
        this.data = new BitSet(1 << logBits);
        this.noHashes = noHashes;
        this.hashMask = (1 << logBits) - 1;
    }


    /*
     * Method add
     *
     * The method will set the bits in the bloom filter map for each of the 'k'
     * hash codes based on the passed String being added to the set.
     *
     * @param String - the value to add the to set
     */

    public void add(String s) {
        for (int n = 0; n < noHashes; n++) {
            long hc = hashCode(s, n);
            int bitNo = (int) (hc) & this.hashMask;
            data.set(bitNo);
        }
    }


    /*
     * Method contains
     *
     * The method will check the bits in the bloom filter map for each
     * of the 'k' hash codes based on the passed in parameter. It returns
     * false if not in the set, else true if most probably in the set.
     *
     * @param boolean - false if not in set, else true for most probably in set
     */

    public boolean contains(String s) {
        // Loop over and hash the given string noHashes amount of times.
        for (int i = 0; i < this.noHashes; i++) {
            // Get the hashCode.
            long hc = hashCode(s,i);
            // Get the bitNo to account for rollover
            int bitNo = (int) (hc) & this.hashMask;
            // Check if its inside the bitSet / Hashmap.
            if(!data.get(bitNo)) {
                // If its not inside, Definetily not in the bitSet / Hashmap.
                return false;
            }
        }
        // Return true if we got here. Probably in the bitSet / Hashmap.
        return true;
    }

    /*********************************
     *
     * Method randomString
     *
     * This static method is used by the main routine for testing purposes.
     * It generates random strings for entering into our Bloom filter hash map.
     *
     *********************************/

    public static final String LETTERS =
            "abcdefghijklmnopqrstuvexyABCDEFGHIJKLMNOPQRSTUVWYXZzéèêàôû";
    public static String randomString(Random r) {
        int wordLen;
        do {
            wordLen = 5 + 2 * (int) (r.nextGaussian() + 0.5d);
        } while (wordLen < 1 || wordLen > 12);
        StringBuilder sb = new StringBuilder(wordLen);
        for (int i = 0; i < wordLen; i++) {
            char ch = LETTERS.charAt(r.nextInt(LETTERS.length()));
            sb.append(ch);
        }
        return new String(sb);
    }
}


/***************************************
 *
 * Main Routine Tests - Unit Testing 
 *
 ***************************************/

public class Main {
    public static void main(String[] args) {
        System.out.println("Start Bloom Filter Exercise...!");

        BloomFilter bm = new BloomFilter(16, 3);

        /*
         * A simple tests follow, which adds elements to the bloom filter, 
         * then check their presence in the set. We are not putting in 
         * enough elements in the bloom filter hash map on this simple test 
         * to expect and false positives
         */

        bm.add("String 1");
        bm.add("String 2");
        bm.add("String 3");
        bm.add("String 12");

        System.out.println("Checking if 'String 1' is possibly in set: " 
                           + bm.contains("String 1"));
        System.out.println("Checking if 'String 2' is possibly in set: " 
                           + bm.contains("String 2"));
        System.out.println("Checking if 'String 5' is possibly in set: " 
                           + bm.contains("String 5"));
        System.out.println("Checking if 'String 12' is possibly in set: " 
                           + bm.contains("String 12"));
        System.out.println("Checking if 'STRING 12' is possibly in set: " 
                           + bm.contains("STRING 12"));


        /*
         * False positivity tests compare various combinations of:
         *      1) number of bits (size of hash map)
         *      2) number of hash functions use per hash map
         *
         * The test will loop through hash map sizes between 2^14 through 2^23,
         * and for each hash map size, will run through tests using 1 to 8 hash 
         * codes per instantiation of the bloom filter. Each instantiation will 
         * be populated with 16,384 random strings, and the test will probe the 
         * bloom filter instantiation (a.k.a., invoke methods contains() using 
         * random strings) 2,500,000 times. The false positive rate will be 
         * displayed for each bloom filter instantiation.
         */
        
        final int NO_FALSE_POSITIVE_TESTS = 2500000; // 2,500,000 probes
        Random r = new SecureRandom();
        final int noItems = 1 << 14;

        System.out.println("\nFalse Positivity test ...");
        System.out.println("\tTest loops through bitmap sizes for the Bloom filter from "
                           + (int) Math.pow(2,14) + " to " + (int) Math.pow(2,23) + " bits.");
        System.out.println("\tFor each bitmap size, tests are conducted using from 1 to 8 hash codes per hashmap.");
        System.out.println("\tAnd, each test combination probes the bloom filter "
                           + NO_FALSE_POSITIVE_TESTS + " times!\n");

        for (int log2bits = 14; log2bits <= 23; log2bits++) {
            for (int noHashes = 1; noHashes <= 8; noHashes++) {
                double noFalsePositives = 0;
                int noNotIn = 0;

                BloomFilter bf = new BloomFilter(log2bits, noHashes);
                Set already = new HashSet(noItems);
                // Add items fo Bloom filter
                for (int itemNo = 0; itemNo < noItems; itemNo++) {
                    String s = bm.randomString(r);
                    already.add(s);
                    bf.add(s);
                }
                // Now test for false positives
                for (int n = 0; n < NO_FALSE_POSITIVE_TESTS; n++) {
                    String s = bm.randomString(r);
                    if (!already.contains(s)) {
                        noNotIn++;
                        if (bf.contains(s)) noFalsePositives++;
                    }
                }
                double falsePositiveRate = noNotIn == 0 ? 0d :
                        noFalsePositives / noNotIn;

                System.out.println("\nBloom filter populated with " 
                                   + noItems + " elements with map size of "
                                   + (int) Math.pow(2,log2bits) + " and " 
                                   + noHashes + " hash codes");
                System.out.print("\tCombination's false positive ratio is: " 
                                 + falsePositiveRate);
                if ( falsePositiveRate == 0 ) 
                  System.out.print(" - no false positives on this combination!");
                System.out.println();
            }
        }

      System.out.println("\nEnd Bloom Filter Exercise...!");
        
    }
}
