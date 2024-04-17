
/*
 * Unit testing - Augment below by adding your out unit 
 *                testing to test edge cases.
 */ 

public class Main {
  
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    int[] values = { 3, 4, 2, 1, 4, 5, 1 };

    /*
     * TEST 1: Test insertAll()
     */

    System.out.println("TEST 1: Test insertAll()");
    System.out.println("Empty tree      : " + tree);      
    tree.insertAll(values);
    
    // Should print [1, 1, 2, 3, 4, 4, 5]
    System.out.println("After InsertAll : " + tree);

    
    /*
     * TEST 2: Test increaseAll()
     */

    System.out.println("\nTEST 2: Test increaseAll()");
    System.out.println("Before tree  : " + tree);      
    tree.increaseAll(5);

    // Should print [6, 6, 7, 8, 9, 9, 10]
    System.out.println("After tree   : " + tree);
    
  }

}