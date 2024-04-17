
/*************************************
 *
 *  You can Perform Unit Testing in Main
 *
 *************************************/


public class Main {
    public static void main(String[] args) {

        myHashMap<String, Integer> hashmap = new myHashMap<>();
        /*
         * The following code is simply just exercising methods 
         * only, these are NOT tests cases for the methods. Not 
         * edge testing is being done here that exercises all 
         * paths of the code. So, *** PLEASE FEEL FREE *** to 
         * remove and/or change the code in main() for your 
         * testing purposes.
         */

        if ( ! hashmap.isEmpty() )
            System.out.println(
                    "isEmpty() is false, should be true");

        /*
         * Simply just invoking the methods add(), replace(), 
         * remove(), contains(), containsKey(), get(), 
         * getSize() and clear()
         */

        // Load hashmap with initial <k, v> pairs
        hashmap.put("Key_1", 1);
        hashmap.put("Key_2", 2);
        hashmap.put("Key_3", 3);
        hashmap.put("Key_4", 4);
        hashmap.put("Key_5", 5);
        hashmap.put("Key_6", 6);
        hashmap.put("Key_7", 7);
        hashmap.put("Key_8", 8);

        System.out.println("Test 1: testing replace");
      
        hashmap.replace("Key_8", 16);
        if ( hashmap.replace("Key_7", 7, 14) != true )
            System.out.println("replace() failed");
        if ( hashmap.replace("Key_3", 6, 6) == true )
            System.out.println("replace() worked");

        /*
         * Remove an existing key, and then insert a new key 
         * with almost the same name. The first put() will 
         * insert the new <k,v>, while the second will update 
         * the value only as the key already exists.
         */
        hashmap.remove("Key_2");
        hashmap.put("KEY_2", 2);
        hashmap.put("KEY_2", 10);


        /*
         * Invoking various methods to ensure they return 
         * the expected values.
         */

        System.out.println("Test 2: testing ContainsValues, get, putIfAbsent, remove");
      
        if ( hashmap.containsValue(999))
            System.out.println("containsValues() error");

        if ( ! hashmap.containsValue(10))
            System.out.println("containsValues() error");

        if ( hashmap.containsKey("NON-EXISTENT KEY"))
            System.out.println("containsKey() error");

        if ( ! hashmap.containsKey("Key_8"))
            System.out.println("containsKey error");

        if ( hashmap.get("Key_8") != 16 )
            System.out.println("get() error");

        if ( hashmap.get("NON-EXISTENT KEY") != null )
            System.out.println("get() error");

        if ( hashmap.Size() != 8 )
            System.out.println("Size() error");

        if ( hashmap.putIfAbsent("Key_8", 18) != 16)
            System.out.println("putIfAbsent() error");

        if ( hashmap.putIfAbsent("NEW-KEY", 44) != null)
            System.out.println("putIfAbsent() error");

        if ( hashmap.remove("Key_1", 2) )
            System.out.println("remove() error");

        if ( hashmap.remove("Key_1", 1) == false)
            System.out.println("remove() error");

        /*
         * Printing all elements, verify they are all there 
         * (no order, they will be traversed from conceptual 
         * bucket to bucket, and for each, print all
         * <key,value> pairs that are linked to that bucket.
         *
         * Shoudl be: <Key_3,3> <Key_4,4> <Key_5,5> <Key_6,6> 
         *       <Key_7,14> <Key_8,16> <NEW-KEY,44> <KEY_2,10> 
         */

        System.out.println("\nhashmap after first 2 tests");
      
        hashmap.printAllElements();

        if ( hashmap.isEmpty() )
            System.out.println("isEmpty() error");

        hashmap.clear();

        if ( ! hashmap.isEmpty() )
            System.out.println("isEmpty() error");


        /*
         *
         * Tests for routines students need to write, 
         * Start by loading up Hash Map
         *
         */

        hashmap.put("String 1", 1);
        hashmap.put("String 2", 2);
        hashmap.put("String 3", 3);
        hashmap.put("String 4", 1);
        hashmap.put("String 5", 2);
        hashmap.put("String 6", 3);
        hashmap.put("String 7", 1);
        hashmap.put("String 8", 2);
        hashmap.put("String 9", 3);
        hashmap.put("String 10", 1);
        hashmap.put("String 11", 2);
        hashmap.put("String 12", 3);
        hashmap.put("String 13", 1);
        hashmap.put("String 14", 2);
        hashmap.put("String 15", 3);
        hashmap.put("String 16", 1);
        hashmap.put("String 17", 2);
        hashmap.put("String 18", 3);
        hashmap.put("String 19", 1);
        hashmap.put("String 20", 2);
        hashmap.put("String 21", 3);
        hashmap.put("String 22", 1);
        hashmap.put("String 23", 2);
        hashmap.put("String 24", 3);
        hashmap.put("String 25", 1);
        hashmap.put("String 26", 2);
        hashmap.put("String 27", 3);
        hashmap.put("String 28", 1);
        hashmap.put("String 29", 2);
        hashmap.put("String 30", 3);


        //
        // Test #3 for Replace(K, V, V)
        //

        hashmap.replace("String 30", 30, 40); // Will NOT replace, as val != 30
        hashmap.replace("String 29", 2, 20);  // Will replace 2 with 20
        hashmap.replace("STRING 28", 1, 10);  // Will not replace anything, no key found
        hashmap.replace("String 27", 3, 30);  // Will replace 3 with 30


        System.out.println("\nTest 3: replace()");
      
        hashmap.printAllElements(); // manually verify


        //
        // Test #4 for ContainsValue(V)
        //

        System.out.println("\nTest 4: containsValue()...");

        if ( ! hashmap.containsValue(30) )
            System.out.println("failed");

        if ( hashmap.containsValue(999) )
            System.out.println("Failed");

        if ( ! hashmap.containsValue(1) )
            System.out.println("Failed");


        //
        // test #5 for ContainsKey(k)
        //

       System.out.println("Test 5: containsKey()...");
      
        if ( hashmap.containsKey("SHOULD NOT FIND") )
            System.out.println("Failed");

        if ( ! hashmap.containsKey("String 9") )
            System.out.println("Failed");

        if ( hashmap.containsKey("String1") )
            System.out.println("Failed");

       System.out.println("Tests complete");

    }
}