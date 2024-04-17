///////////////////////////////////////////////////////////
//
//         Nathan Johnson / Comp 272-002
//
////////////////////////////////////////////////////////////

import java.util.*;

public class Main {


    
    public static int numRescueCanoes(int[] people, int limit) {
        // Sort the array so the code logic works
        Arrays.sort(people);
        // Initialize the counters and left & right pointers
        int count = 0;
        int left = 0;
        int right = people.length - 1;
        // Keep looping until the pointers cross
        while (left <= right) {
            // If the sum of the current smallest weighted person
            // plus the current heaviest person is less than or equal
            // to the limit, we add them to the boat and move the pointers in
            // effectively eliminating them from being put into another boat.
            if (people[left] + people[right] <= limit) {
                count++;
                left++;
                right--;
            // Otherwise, the heaviest person plus the lightest person could
            // Not fit so we 'add' the heaviest person and move right pointer
            // in, causing the person to be 'saved'
            } else {
                count++;
                right--;
            }
        }
        // return the amount of boats
        return count;
    }

  /*
   *  Main - Add any additional unit testsing you need below
   */
  
  public static void main(String[] args) {
 
      int people1[] = {1,2};
      int people2[] = {3,2,2,1};
      int people3[] = {3,5,3,4};
      System.out.println("Output: " + numRescueCanoes(people1,3));
      System.out.println("Output: " + numRescueCanoes(people2,3));
      System.out.println("Output: " + numRescueCanoes(people3,5));

  }
}