import java.util.*;

public class LUCSorter {
  private int[] a;

  public LUCSorter(int[] anArray) {
    a = anArray;
  }

    public void divisibleByKFirst(int k) {
        if (k == 0)
          return;
        
        if (a.length <= 1)
          return;
        int[] first = new int[a.length / 2];
        int[] second = new int[a.length - first.length];
        System.arraycopy(a, 0, first, 0, first.length);
        System.arraycopy(a, first.length, second, 0, second.length);
        LUCSorter firstSorter = new LUCSorter(first);
        LUCSorter secondSorter = new LUCSorter(second);
        firstSorter.divisibleByKFirst(k);
        secondSorter.divisibleByKFirst(k);
        merge(first, second, k);
    }

    private void merge(int[] first, int[] second, int k) {

        /* Merge sort implementation with slight adjustment to sort things
        *  divisble by k first then the rest of the sorting.        */

        // Initialize all the lengths and index positions.
        int firstLength = first.length;
        int secondLength = second.length;
        int totalLength = firstLength + secondLength;
        int i = 0, j = 0, w = 0;

        // Compare the ith and jth values
        while (i < firstLength && j < secondLength) {
            // If one value is divisible by k and the other isnt
            // we add the value that is and move that pointer forward
            if (first[i] % k == 0 && second[j] % k != 0) {
                a[w++] = first[i++];
            // If the other value is divisible by k and the other isnt
            // we add the value that is and move that pointer forward
            } else if (first[i] % k != 0 && second[j] % k == 0) {
                a[w++] = second[j++];
                // Otherwise we sort normally, by putting the smallest ith or 
                // Jth value first. Assuming both are divisible by k then
                // the smaller value that is divisible will go first
                // Satisfying the condition
            } else {
                if (first[i] >= second[j]) {
                     a[w++] = second[j++];
                } else if (first[i] < second[j]) {
                    a[w++] = first[i++];
                }
            }
        }

        // Add the remaining value if needed
        while (i < firstLength && w < totalLength) {
            a[w++] = first[i++];
        }
        while (j < secondLength && w < totalLength) {
            a[w++] = second[j++];
        }
    }

  /*
   * Do not modify this routine, it is used for testing your code.
   */ 

  public static void checkExercise(int[] a, int k) {
    LUCSorter sorter = new LUCSorter(a);
    sorter.divisibleByKFirst(k);
  }
}

