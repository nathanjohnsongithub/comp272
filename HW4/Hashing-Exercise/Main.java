/*
 * Your Unit Testing goes here
 */

import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    HashingExercise he = new HashingExercise();

    // Sample test for getAverage()
    
    HashMap<Integer, Integer> hash_map = new HashMap<>();
    hash_map.put(1, 10);
    hash_map.put(2, 20);
    hash_map.put(5, 50);
    int[] arr = {1, 2, 7, 8};

    System.out.println("Test 1: Average should be 15.0");
    System.out.println("        The result was  : " +  
                        he.getAverage(hash_map, arr));

    
    // Sample test for odd()
    
    HashMap<Integer, String> hash_map2 = new HashMap<>();
    hash_map2.put(1, "Diana");
    hash_map2.put(2, "Naomi");
    hash_map2.put(3, "Adam");
    hash_map2.put(4, "Eric");
    hash_map2.put(5, "Kavitha");
    hash_map2.put(6, "Yu");
    hash_map2.put(7, "Mushjtaba");
    hash_map2.put(8, "Marisa");
    hash_map2.put(9, "Peter");
    hash_map2.put(10, "Slanovich");
      
    // Should print: [Adam, Diana, Kavitha, Mushjtaba, Peter]
    System.out.println("Test 2: Should be: [Diana, Adam, Kavitha, Mushjtaba, Peter");
    System.out.println("        Outout is: " 
                       + he.odd(hash_map2));
  }
}