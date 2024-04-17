////////////////////////////////////////////////////////////////
//
//   Nathan Johnson  / Comp 272-002
//
////////////////////////////////////////////////////////////////

import java.util.*;

public class Main {

    /**
    * Method showDuplicates
    *
    * This method identifies duplicate strings in an arrary list. The list
    * is passed as an ArrayList<String> and the method returns an ArrayList<String>
    * containing only unique strings that appear more than once in the input list. 
    *
    * For example, if the input list was: "Dog", "Cat", "Dog", "Horse", "Lion"
    * the method would return an ArrayList<String> containing: "Dog"
    *
    * @param  list  an ArrayList<String>
    * @return       an ArrayList<String> containing only unique 
    *               strings that appear more than once in the input list
    */
    public static ArrayList<String> showDuplicates(ArrayList<String> input) {       
        // Sort the input array so the searching algorithm works.
        input = insertionSortDuplicate(input);
        
        // Initialize the array list that will story the duplicates
        ArrayList<String> duplicates = new ArrayList<String>();
        
        // Loop over the input array to size - 1 because we will be accesing 
        // The ith + 1 element.
        for (int i = 0; i < input.size() - 1; i++) {
            // If the current element equals the next element and we havent
            // Added the elements yet.
            if(input.get(i).equals(input.get(i+1)) && !duplicates.contains(input.get(i))){
                // Add into the duplicates array.
                duplicates.add(input.get(i));
            }
        }
        // return all the duplicates
        return duplicates;
    }


    /**
    * Finds pairs in the input array that add up to k.
    * 
    * @param input   Array of integers
    * @param k       The sum to find pairs for
    
    * @return an ArrayList<String> containing a list of strings. The ArrayList
    *        of strings needs to be ordered both within a pair, and 
    *        between pairs. E.g.,
    *
    *         - Ordering within a pair:
    *            A string is a pair in the format "(a, b)", where a and b are 
    *            ordered lowest to highest, e.g., if a pair was the numbers 
    *            6 and 3, then the string would be "(3, 6)", and NOT "(6, 3)".
    *         - Ordering between pairs:
    *            The ordering of strings of pairs should be sorted in lowest to 
    *            highest pairs. E.g., if the following two string pairs within
    *            the returned ArraryList, "(3, 6)" and "(2, 7), they shoiuld be
    *            ordered in the ArrayList returned as "(2, 7)" and "(3, 6 )".
    * 
    *         Example output:
    *         If the input array list was {2, 3, 3, 4, 5, 6, 7}, then the 
    *         returned ArrayList<String> would be {"(2, 7", "(3, 6)", "(4, 5)"}
    */
    
    public static ArrayList<String> pair(int[] input, int k) {
    
        // Initialize the ArrayList that we will use to store the pairs
        ArrayList<String> pairs = new ArrayList<String>();
        // Sort the input array; This insures that the pairs we return are in order.
        input = insertionSortPair(input);
        // Loop over the array
        for (int i = 0; i < input.length; i++) {
            // Loop over the current index of array next to check for pairs
            for (int j = i + 1; j < input.length; j++) {
                // If the pairs are add up to k
                if (input[i] + input[j] == k) {
                    // Create the String of the pair
                    String s = "(" + input[i] + ", " + input[j] + ")";
                    // if its not already inside we add it
                    if (!pairs.contains(s)){
                        pairs.add(s);
                    }
                }
            }
        }
        // Return what we found
        return pairs;
    }

    /*
    * Method insertionSort which sorts a given array "input"
    * using insertion sort.
    * this is O(n^2)
    * @param int[] input. array to be sorted
    * @return int[] the sorted array
    */
    public static ArrayList<String> insertionSortDuplicate(ArrayList<String> input) {
        // Get the size of the array;
        int size = input.size(); 
        // If there is only one element it is already sorted so we return
        if (size < 2) {
            return input;
        }
        // If not; we start insertion sort.
        for (int i = 1; i < size; i++) {
            // Get the current position for i and call it the key.
            String key = input.get(i);
            // Make int j that is one before i
            int j = i - 1;
            // While we still have elements to move from the ith position
            // we will 'bubble down'
            // If there are still elements to check and the element is not sorted
            // i.e. input[j] is greater than the ith postion element
            while (j >= 0 && (input.get(j).compareToIgnoreCase(key) > 0)) {
                // We move up the element
                input.set(j+1, input.get(j));
                // we then travel down the array
                j -= 1;
            }
            // Place the key at the new sorted position. everything at position
            // 0 <= j+1 (i) is now sorted.
            input.set(j+1, key);
            
        }
        // Return sorted array.
        return input;
    }
    
    
    /*
    * Method insertionSortPair which sorts a given array "input"
    * using insertion sort.
    * this is O(n^2)
    * @param int[] input. array to be sorted
    * @return int[] the sorted array
    */
    public static int[] insertionSortPair(int[] input) {
        // Get the size of the array;
        int size = input.length; 
        // If there is only one element it is already sorted so we return
        if (size < 2) {
            return input;
        }
        // If not; we start insertion sort.
        for (int i = 1; i < size; i++) {
            // Get the current position for i and call it the key.
            int key = input[i];
            // Make int j that is one before i
            int j = i - 1;
            // While we still have elements to move from the ith position
            // we will 'bubble down'
            // If there are still elements to check and the element is not sorted
            // i.e. input[j] is greater than the ith postion element
            while (j >= 0 && input[j] > key) {
                // We move up the element
                input[j + 1] = input[j];
                // we then travel down the array
                j -= 1;
            }
            // Place the key at the new sorted position. everything at position
            // 0 <= j+1 (i) is now sorted.
            input[j + 1] = key;
        }
        // Return sorted array.
        return input;
    }

  
 /*
  * Main Routine -- Add any additional unit testing here as needed
  */
  
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>(Arrays.asList("apple", "apple", 
                                                      "banana", "banana", "banana", 
                                                      "cherry", "cherry", "cherry", 
                                                      "cherry"));
    int[] input = new int[]{2, 3, 3, 4, 5, 6, 7};
    int k = 9;

    /*
     * Sample Test of Sort #1
     */
    
    System.out.println(showDuplicates(list));  // Expected: [apple, banana, cherry]

    
    /*
     * Sample Test of Sort #2
     */

    System.out.println(pair(input, k));       // Expected: [(2, 7), (3, 6), (4, 5)]
  }
}