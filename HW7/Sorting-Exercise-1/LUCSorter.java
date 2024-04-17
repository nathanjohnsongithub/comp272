////////////////////////////////////////////////////////
//
//       Nathan Johnson / Comp 272-002
//
////////////////////////////////////////////////////////


public class LUCSorter {

  private final int[] intArray;

  public LUCSorter(int[] intArray) {
    this.intArray = intArray;
  }

    // Selection sort implementation 
    public void sort() {
        // Loop through the entire array. Everything from < i has been sorted.
        for (int i = 0; i < intArray.length; i++) {
            // Get the max value.
            int max = maximumPosition(i);
            // Swap the max value into the current position.
            swap(max, i);
        }
    }

    private int maximumPosition(int from) {
        // Initialize the max value to start from where we are starting.
        int maxPos = from;
        // Loop from the value we start from to the end and find the
        // Position of the maximum value
        for(; from < intArray.length; from++) {
            if (intArray[maxPos] < intArray[from]) {
                maxPos = from;
            }
        }
        // return the position of the maximum value
        return maxPos;
        
    }

    private void swap(int i, int j) {
        int temp = intArray[i];
        intArray[i] = intArray[j];
        intArray[j] = temp;
    }

  /*
   * Check your code using this method for Exercise 1
   */
  public static int[] checkExercise(int[] values) {
    LUCSorter sorter = new LUCSorter(values);
    sorter.sort();
    return values;
  }

}

