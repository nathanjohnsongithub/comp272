////////////////////////////////////////////
// NATHAN JOHNSON     /   COMP 272-002    //
////////////////////////////////////////////


class Main {
  public static void main(String[] args) {
    int n = 10;         // Change n to any positive integer
    int result;

    result = AlgorithmAnalysis.algorithmOne(n);

    int[] array1 = {1, 2, 3}; // Change the array values as needed
    int[] array2 = {4, 5, 6}; // Change the array values as needed

    result = AlgorithmAnalysis.algorithmTwo(array1, array2);

    
    /*
     * ENTER YOUR ANSWERS BELOW, DO NOT FORGET TO PLACE YOUR
     * NAME AND SECTIOIN NUMBER ABOVE.
     *
     * REPLACE WHAT IS IN BRACKETS <> BELOW WITH YOUR ANSWERS
     */ 

    System.out.println("\nAlgorithmOne Analysis:");
    System.out.println("Math equation is: 1 + 1n + 1"); 
    System.out.println("Big-Oh is       : O(n)");
    System.out.println("Big-Omega is    : Ω(n)");
    System.out.println("Big-Theta is    : θ(n)");

    System.out.println("\nAlgorithmTwo Analysis:");
    System.out.println("Math equation is: 1 + 1n^2 + 1"); 
    System.out.println("Big-Oh is       : O(n^2)");
    System.out.println("Big-Omega is    : Ω(n^2)");
    System.out.println("Big-Theta is    : θ(n^2)");
  }

}