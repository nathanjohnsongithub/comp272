
/****************************************************
 *
 *  *** PLACE YOUR ANSWER IN FILE 'Main.java' ***
 *
 ****************************************************/

public class AlgorithmAnalysis3 {

    public static void algorithmThree(int[] arr) {
        int length = arr.length;
        if (length < 2) {
            return;
        }

        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, length - mid);

        algorithmThree(left);
        algorithmThree(right); 
        algorithmThreeHelper(arr, left, right);
    }

  private static void algorithmThreeHelper(int[] arr, int[] left, int[] right) {
      int leftLength = left.length;
      int rightLength = right.length;
      int i = 0, j = 0, k = 0;

      while (i < leftLength && j < rightLength) {
          if (left[i] <= right[j]) {
              arr[k++] = left[i++];
          } else {
              arr[k++] = right[j++];
          }
      }

      while (i < leftLength) {
          arr[k++] = left[i++];
      }

      while (j < rightLength) {
          arr[k++] = right[j++];
      }
  }
}

