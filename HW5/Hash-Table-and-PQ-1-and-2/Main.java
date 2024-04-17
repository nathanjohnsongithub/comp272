////////////////////////////////////////////////////
//
// Nathan Johnson  / Comp 272-002
//
/////////////////////////////////////////////////////

import java.util.*;

/*
 *  Utility Methods Class
 * 
 *  This class contains utility methods that are used throughout 
 *  the program.
 */

class UtilMethods {

    /*
     * Hash Table Programming Exercise
     * 
     * Write a method that takes two arrays A and B, and returns
     * whether array B is a subset of array A. 
     *
     * USE a HashMap ADT to solve this problem.
     */
  
    public boolean isSubset(int list1[], int list2[]) {
        // Initalize variables we will use for the function.
        // isSubset to keep track if the two arrays are subsets
        // HashMap to check if they do not contain the same values.
        boolean isSubset = true;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        // Add all the elements from the array to the Hashmap
        for (int elm: list1) {
            hm.put(elm, elm);
        }

        // Loop throught the array and break the loop if the key is not found.
        // That would mean they're not subsets
        int i = 0;
        while (isSubset && i < list2.length) {
            isSubset = hm.containsKey(list2[i]);
            i++;
        }
        return isSubset;
    }


   /*
    * Priority Queue 1 Programming Exercise
    *
    * Given an array A and integer k, return the k-th maximum
    * element in the array.
    *
    * USE a Priority Queue ADT to solve this problem.
    */
  
    public int findKthLargest(int[] array, int k) {
        // Initialize the priority queue with minimum value
        Queue<Integer> pq = new PriorityQueue<>();
        // Add all the elements into the priority queue.
        for (int elm : array) {
            pq.add(elm);
        }
        // Remove k elements and return the k-th element.
        int res = -1;
        for (int i = 0; i < k; i++) {
            res = pq.remove();
        }
        // return what we found.
        return res;
    }


   /*
    * Priority Queue 2 Programming Exercise
    *
    * Given two arrays A and B with n and m integers respectively, 
    * return a singe sorted array of elements from both arrays.
    *
    * USE a Priority Queue ADT to solve this problem.
    */
  
    public int[] sort2Arrays(int[] array1, int[] array2) {
        // Initialze the priority queue which we will use for sorting
        Queue<Integer> pq = new PriorityQueue<>();
        // Add all the elements from array1 into the pq.
        for (int elm : array1) {
            pq.add(elm);
        }
        // Add all the elements from array2 into the pq.
        for (int elm : array2) {
            pq.add(elm);
        }
        // Keep track of the size so it doesnt change.
        int size = pq.size();
        // Initialize the result array which will be sorted.
        int[] resArray = new int[size];
        // Loop over the entire Priority queue and remove elements.
        for (int i = 0; i < size; i++) {
            // Because removed elements are popped of min this will be sorted. 
            resArray[i] = pq.remove();
        }
        // return
        return resArray;
    }
}


/*
 * Main Routine - Unit Testing 
 */

public class Main {

    public static void main(String[] args) {

      UtilMethods u = new UtilMethods();

      int list1[] = {10, 50, 35, 82, 13, 25};
      int list2[] = {10, 35, 13};
      int list3[] = {10, 35, 13, 8};

      // Sample HashTable isSubset() tests
      System.out.println("HashTable test, should be true : "  
                         + u.isSubset(list1, list2));
      System.out.println("HashTable test, should be false: " 
                        + u.isSubset(list1, list3));

      
      // Sample PriorityQueue findKthLargest() tests
      int list4[] = {1,7,3,10,34,5,8};
      int k = 4;
      System.out.println("The " + k + " largest should be 7      : " 
                          + u.findKthLargest(list4, k));

      // Sample PriorityQueue sort2Arrays() tests
      int list5[] = {4,1,5};
      int list6[] = {3,2};
      int sorted[];
      
      sorted = u.sort2Arrays(list5, list6);

      System.out.print("Printing the combined sorted array: ");
      for (int i=0; i < sorted.length ; i++)
         System.out.print(sorted[i] + " ");
      System.out.println();
    }
}