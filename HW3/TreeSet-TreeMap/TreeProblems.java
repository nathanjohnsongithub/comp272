//////////////////////////////////////////////////////////////
//
//  Nathan Johnson / Comp 272-002
//
//////////////////////////////////////////////////////////////

import java.util.*;

public class TreeProblems {

  /*
   * Method different()
   *
   * Given two TreeSets of integers, return a TreeSet containing all elements 
   * that are not in both sets. In otherwords, return a TreeSet of all the 
   * elements that are in one set but not the other.
   */
  
    public static Set<Integer> different(Set<Integer> setA, Set<Integer> setB) {
    // Use the TreeSet methods to return the correct set. This can
    // be done with only *several* lines of code by creating two temporary
    // TreeSets and using the methods retainAll(), addAll(), and removeAll(). 
    // But in the end, get something to work. 

        // Make two temporary sets so that we dont effect the sets 
        Set<Integer> tmp1 = new TreeSet<Integer>(setA);
        Set<Integer> tmp2 = new TreeSet<Integer>(setB);
        // take the set intersect.
        // Removes everything that are in both A & B. Leaving everything in A.
        tmp1.removeAll(setB);
        // Removes everything that are in both A & B. Leaving everything in B.
        tmp2.removeAll(setA);
        // Combine the two sets.
        tmp1.addAll(tmp2);
        // Return the new set with the different elements between the two.
        return tmp1;
    }


  /*
   * Method removeEven()
   *
   * Given a treeMap with the key as an integer, and the value as a String,
   * remove all <key, value> pairs where the key is even. 
   */

    public static void removeEven(Map<Integer, String> treeMap) {

        // Turn the tree map into a set of Key-value pairs. We then 
        // turn that set into an iterator so we can iterate over the tree.
        Iterator<Map.Entry<Integer, String>> iterator = treeMap.entrySet().iterator();

        // keep iterating over a tree until its empty
        while (iterator.hasNext()) {
            // Get the current Key-Value from the iterator 
            Map.Entry<Integer, String> entry = iterator.next();
            // check if the entry is even
            if (entry.getKey() % 2 == 0) {
                // if it is, remove it using the iterator remove function.
                iterator.remove();
            }
        }
    }

}
