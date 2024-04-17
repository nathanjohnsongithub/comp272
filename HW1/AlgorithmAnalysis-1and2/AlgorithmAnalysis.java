public class AlgorithmAnalysis {

  /*
   * Instructions: Print the routine's math equation and time complexity 
   * of each method in the main routine (file Main.java), ***NOT*** here.
   */

    public static int algorithmOne(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int algorithmTwo(int[] arr1, int[] arr2) {
        int sum = 0;

        // Assume arrays are same length for pusposes of 
        // of complexity analysis
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                sum += arr1[i] + arr2[j];
            }
        }
        return sum;
    }
}

