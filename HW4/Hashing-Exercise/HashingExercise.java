/////////////////////////////////////////////
//
//  Nathan Johnnson / Comp 272-002
//
/////////////////////////////////////////////

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

class HashingExercise {

    public double getAverage(HashMap<Integer, Integer> map, int[] array) {
        // Variable to keep track of the sum and the number of items.
        double sum = 0.0;
        double num = 0.0;
        // Edge case to make sure the HashMap isnt empty
        if (map.isEmpty()) {
            return sum / 0.0;
        }
        // We now know its not empty so lets iterate.
        // Iterating through the HashMap using .entrySet() 
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            // Loop through and check if the array holds the same key were on.
            for (int key : array) {
                if (set.getKey() == key) {
                    // If it does, add it to the sum
                    sum += set.getValue();
                    // increment because we added another item.
                    num++;
                }
            }
        }
        // return the sum/num or the average
        return sum / num;
    }

  
    public ArrayList<String> odd(HashMap<Integer, String> map) {
        // Create arraylist of Strings because we 
        // dont know the number of odd keys.
        ArrayList<String> result = new ArrayList<>();
        // Iterate over all the keys in the Hashmap using .keySet()
        for (int key : map.keySet()) {
            // If the key is odd
            if (key % 2 == 1) {
                // add to the list
                result.add(map.get(key));
            }
        }
        // Return the odd keys
        return result;
    }
}
