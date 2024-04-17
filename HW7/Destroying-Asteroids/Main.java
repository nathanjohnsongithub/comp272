/////////////////////////////////////////////////////////////
//
//        Nathan Johnson / Comp 272-002
//
/////////////////////////////////////////////////////////////


public class Main {

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // Sort the asteroids array using insertion sort
        insertionSort(asteroids);
        // Loop over all the meteors starting with the smallest
        for(int meteor : asteroids) {
            // We effectively want to build up the planet as much as possible
            // so we start by smashing smallest to largest. If the planet is 
            // destroyed it will return false otherwise we keep adding on the 
            // the masses
            if (mass - meteor >=0) {
                mass += meteor;
            } else {
                return false;
            }
        }
        // If we've reached here the planet is alive and we can return true.
        return true;
    }

  private static void insertionSort(int[] arr) {
      int n = arr.length;
      for (int i = 1; i < n; ++i) {
          int key = arr[i];
          int j = i - 1;

          /* Move elements of arr[0..i-1], that are
             greater than key, to one position ahead
             of their current position */
          while (j >= 0 && arr[j] > key) {
              arr[j + 1] = arr[j];
              j = j - 1;
          }
          arr[j + 1] = key;
      }
  }
  /*
   * Main - Add any additional unit testing below
   */

  public static void main(String[] args) {
    int mass = 10;
    int[] asteroids = new int[] {3,9,19,5,21};

    System.out.println("Test 1 - Asteroids destroyed? : " +
            asteroidsDestroyed(mass, asteroids));

    mass = 5;
    asteroids = new int[] {4,9,23,4};
    System.out.println("Test 2 - Asteroids destroyed? : " +
            asteroidsDestroyed(mass, asteroids));

  }

}
  