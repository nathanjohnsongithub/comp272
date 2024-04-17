////////////////////////////////////////////////
//
//  Nathan Johnson / Comp 272-002
//
////////////////////////////////////////////////

import java.util.PriorityQueue;
import java.util.Collections;

/**
 * Priority Queue (PQ) Game 
 *
 * PQ1 Problem Statement:
 * -----------------------
 *
 * You are given an array of integers of boulders where boulders[i] is the 
 * weight of the ith boulder.
 *
 * We are playing a game with the boulders. On each turn, we choose the heaviest 
 * two boulders and smash them together. Suppose the heaviest two boulders have 
 * weights x and y. The result of this smash is:
 *
 *    If x == y, both boulders are destroyed, and
 *    If x != y, the boulder of weight x is destroyed, and the boulder of 
 *               weight y has new weight y - x.
 *
 * At the end of the game, there is at most one boulder left.
 *
 * Return the weight of the last remaining boulder. If there are no boulders 
 * left, return 0.
 *
 *
 * Example 1:
 * 
 * Input: boulders = [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the list converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the list converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the list converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the list converts to [1] then that's the
 * value of the last stone.
 * 
 * Example 2:
 * 
 * Input: boulders = [1]
 * Output: 1
 *
 *
 *
 * RECOMMENDED APPROACH
 *
 * Initializing Priority Queue in reverse order, so that it gives
 * max element at the top. Taking top Elements and performing the
 * given operations in the question as long as 2 or more boulders;
 * returning the 0 if queue is empty else return pq.peek().
 */



public class Main {


    public static int lastBoulder(int[] boulders) {
        // Initialize the priority queue in reverseOrder so its a Max heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        // Add all the boulders to the queue
        for (int boulder : boulders) {
            pq.add(boulder);
        }
        // While there are one or more elements
        while(pq.size() > 1) {
            // Pull off the first 2, y and x respectivelly. 
            int y = pq.poll();
            int x = pq.poll();
            // Calculate the difference 
            int z = y-x;
            // If there is still a "boulder left" we add it back to the queue.
            if (z != 0) {
                pq.add(z);
            }
        }
        // return 0 if the pq is empty of the last element.
        return pq.isEmpty() ? 0 : pq.poll();
    }

  
  /*
   * Main Routine - any unit testing goes here
   */
  
  public static void main(String[] args) {

      int list[] = {2,7,4,1,8,1};

      System.out.println("Output: " + lastBoulder(list)); // Expected: Outout: 1

  }
}