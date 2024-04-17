import java.util.Stack;

////////////////////////////////////////////
// NATHAN JOHNSON     /   COMP 272-002    //
////////////////////////////////////////////

/*
 * Class: Stacks
 * 
 * You are to wrote the code for both methods. Please see the
 * instructions on the supplied PDF for assignment # 1. It provides
 * the specifications for each method.
 */

public class Stacks {
  
  /* isPalindrome method to check if a String is a palindrome.
   * i.e. that is is the same forwards and backwards.
   * 
   * @param input String to check.
   * @return true if input is a palindrome, false otherwise.
   */
  public static boolean isPalindrome(String input) {
    // Guard Statement.
    // Assuming that if the string is null it cannot be a palindrome.
    if (input == null) {
      return false;
    }
    
    // Remove all the spaces from the string and make all characters lowercase
    // A string can still be a palindrome if it has spaces or different cases.
    input = input.replaceAll("\\s", "").toLowerCase();
    
    // Initialize the Stack which we will use to check if the string is a palindrome.
    Stack<Character> stringStack = new Stack<>();
    // Push all the elements onto the stack
    for (int i = 0; i < input.length(); i++) {
      stringStack.push(input.charAt(i));
    }
    
    // initialize the boolean palindrome to keep track of if the string is a palindrome.
    // Assuming it is a palindrome until proven otherwise o we set it to true.
    boolean palindrome = true;
    // int i for using charAt.
    int i = 0;
    // While it still could be a palindrome and we still havent checked every letter.
    // i.e. the stack is not empty.
    while (palindrome && !stringStack.isEmpty()) {
      // We check if the characters are the same forward as they are backwards.
      // We put that value into the palindrome boolean.
      palindrome = stringStack.pop() == input.charAt(i);
      // increment
      i++;
    }
    // return what we found.
    return palindrome;
  }

  /*
   * Finds the index of the first occurrence of the value k in the stack.
   * If k is not in the stack, it returns -1.
   * 
   * @param stack The stack in which to search for the value k
   * @param k The integer value to search for in the stack
   * @return The index of the first occurrence of the value k in the stack, 
   * or -1 if k is not in the stack.
   */
  public static int findLargestK(Stack<Integer> stack, int k) {
    // Guard statement: Check for null or empty stack.
    // Assuming k can be positive and negative.
    if (stack == null || stack.isEmpty()) {
      return -1;
    }
    // Initializing the value of indexOfK to the maximum integer value.
    // Assuming the index can't be as large as 2 billion.
    int indexOfK = Integer.MAX_VALUE;
    /* Initialize i to store values in the array
     * i here is being set to negative one to account for the edge case that
     * the kth value doesnt exist in the stack. Traditionally, with i being set
     * to 0 and incrementing at the end of the loop, this would cause i to be
     * equal to the array.length, which would cause an out of bounds error.
     * To account for this, i is set to -1 and incremented at the start of the
     * loop.
     */
    int i = -1;
    // Initialize the array to store the values of the stack.
    int[] array = new int[stack.size()];
    // While the stack is not empty and we haven't found the kth value.
    while (!stack.isEmpty() && indexOfK == Integer.MAX_VALUE) {
      // Increment i. See above for explanation.
      i++;
      // Pop the top of the stack and store it in the array.
      array[i] = stack.pop();
      // Check if the popped value is the kth value.
      if (array[i] == k) {
        // If it is, store the index.
        indexOfK = stack.size();
      }
    }
    // Restore stack. Loop in reverse, pushing the values 
    // originally from the stack back onto it.
    for (; i >= 0; i--) {
      stack.push(array[i]);
    }

    // If the index of K is still the maximum value of an integer, 
    // the index was not found, so return -1.
    // Otherwise, return the found index.
    return (indexOfK == Integer.MAX_VALUE) ? -1 : indexOfK;
  }
}
