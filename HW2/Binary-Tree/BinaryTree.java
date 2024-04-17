////////////////////////////////////////////
//   Nathan Johnson /     Comp272-002     //
////////////////////////////////////////////

// Importing array just for fun for some methods.
import java.util.ArrayList;

/*
 * Class BinaryTree
 *
 * Simple Binary Search Tree. 
 */

public class BinaryTree {

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node node) {
        root = node;
    }


    /*
     * Class Node
     *
     * This class represents a node in a binary tree. Each node has a 
     * data value alonge with left and right children pointers. 
     */
  
    public class Node {

        Node( int d) {
          data = d;
          left = null;
          right = null;
        }
      
        Node(int d, Node l, Node r) {
            data = d;
            left = l;
            right = r;
        }

        public int data;
        public Node left;
        public Node right;
    }

    public  Node root;

    public  void deleteTree() { 
      root = null; 
    }
    public  Node insert(int data) { 
      return insert(root, data); 
    }

    /*
     * Method Insert
     *
     * This method inserts a new node into the binary search tree. It
     * returns a pointer to the node that was added in the tree.
     */
  
    private Node insert(Node node, int value) {

        // Empty tree scenario; create it's first node. 
        if ( root == null ) {
            return root = new Node(value, null, null);
        }

        // If 'node' is null, we found the location to insert the new node, 
        // else recursively traverse tree to identify location to insert. 
      
        if ( node == null ) {
            node = new Node(value, null, null);
        } else  if (value > node.data) {
            node.right = insert(node.right, value);  // recursively traverse right
        }
        else if (value < node.data) {
            node.left = insert(node.left, value);    // recursively travser left
        }
      
        return node;
  }

  // Below can be used by println, e.g., System.out.println(tree);
  // where tree is a BinaryTree object. The JUnit tests also use these 
  // methods, so do not modify.
  
  public String toString() {
      return toStringHelper(root);
  }

  private String toStringHelper(Node n) {
      if (n == null) {
          return "";
      }
      return n.data + " " + toStringHelper(n.left) + toStringHelper(n.right);
  }


  
  /***********************************************************
   *
   * YOUR CODE GOES BELOW
   *
   * THERE IS NO NEED TO CHANGE THE CODE ABOVE. DO NOT FORGET TO PLACE
   * YOUR NAME AND SECTION NUMBER ABOVE. ANY UNIT TESTING YOU DO
   * SHOULD BE DONE IN MAIN().
   *
   *
   * YOU ARE TO WRITE THE METHODS:
   *    - preOrder
   *    - findMin
   *    - NodesGT
   *    - average
   *    - balanceHeight
   *
   ***********************************************************/
   

    // Helper Method for recursive method invocation.
    public String preOrder() {
        // Start the recursion
        return preOrder(root);
    }

    /*
    * method preOrder
    * method recursively searches through a tree and returns the string of 
    * the preOrder search.
    *
    *  @param Node node. A node of the binary tree which will continue to be 
    *                    passed on with recursion 
    *  @return String with the preOrder traversal of the given binary tree
    */
    private String preOrder(Node node) {
        // Initialize an empty string to store the pre-order traversal.
        String preOrderString = "";

        // Base case. If the node is null we return the string we've found.
        // Else, we add whatever node were on then recurse.
        if (node != null) {
            // Add the value of the current node were on to the string
            preOrderString += node.data + " ";
            // Recursively traverse the left subtree and 
            // append the result to the string.
            preOrderString += preOrder(node.left);
            // Recursively traverse the right subtree and 
            // append the result to the string.
            preOrderString += preOrder(node.right);
        }
        // Return the final pre-order traversal string for 
        // the subtree at the current node.
        return preOrderString;
    }
    
    // Helper Method for recursive method invocation.
    public String postOrder() {
        // Start the recursion
        return postOrder(root);
    }

    /*
    * method preOrder
    * method recursively searches through a tree and returns the string of 
    * the preOrder search.
    *
    *  @param Node node. A node of the binary tree which will continue to be 
    *                    passed on with recursion 
    *  @return String with the preOrder traversal of the given binary tree
    */
    private String postOrder(Node node) {
        // Initialize an empty string to store the pre-order traversal.
        String postOrderString = "";

        // Base case. If the node is null we return the string we've found.
        // Else, we add whatever node were on then recurse.
        if (node != null) {
            // Recursively traverse the left subtree and 
            // append the result to the string.
            postOrderString += postOrder(node.left);
            // Recursively traverse the right subtree and 
            // append the result to the string.
            postOrderString += postOrder(node.right);
            // Add the value of the current node were on to the string
            postOrderString += node.data + " ";
        }
        // Return the final pre-order traversal string for 
        // the subtree at the current node.
        return postOrderString;
    }


    // Helper Method for recursive method invocation.
    public String inOrder() {
        // Start the recursion
        return inOrder(root);
    }

    /*
    * method preOrder
    * method recursively searches through a tree and returns the string of 
    * the preOrder search.
    *
    *  @param Node node. A node of the binary tree which will continue to be 
    *                    passed on with recursion 
    *  @return String with the preOrder traversal of the given binary tree
    */
    private String inOrder(Node node) {
        // Initialize an empty string to store the pre-order traversal.
        String inOrderString = "";

        // Base case. If the node is null we return the string we've found.
        // Else, we add whatever node were on then recurse.
        if (node != null) {
            // Recursively traverse the left subtree and 
            // append the result to the string.
            inOrderString += inOrder(node.left);
            // Add the value of the current node were on to the string
            inOrderString += node.data + " ";
            // Recursively traverse the right subtree and 
            // append the result to the string.
            inOrderString += inOrder(node.right);
            
        }
        // Return the final pre-order traversal string for 
        // the subtree at the current node.
        return inOrderString;
    }

    

    /*
    * Method I made for fun for the alternative NodesGT and average methods.
    *
    * Never finished the alternative NodesGT and average methods.
    */
    public ArrayList<Integer> returnTreeAsArray(Node node) {
        ArrayList<Integer> treeArray = new ArrayList<Integer>();
        
        if (node != null) {
            treeArray.add(node.data);
            treeArray.addAll(returnTreeAsArray(node.left));
            treeArray.addAll(returnTreeAsArray(node.right));
        }
        return treeArray;
    }

    // Helper Method for recursive method invocation.
    public int findMin() {
        // Start the recursion
        return findMin(root);
    }

    /*
    * method findMin. Find the minimum value of the inside of binary tree.
    *
    * @param Node node. A node of the binary tree which will continue to be 
    *                   passed on with recursion 
    * @return an integer with the minimum value of the binary search tree.
    */
    private int findMin(Node node) {
        // base case to stop recursion
        if (node.left == null) {
            // return the minimum value
            return node.data;
        }
        // Recurse left down the tree.
        // This works because we know the minimum value is all the way left.
        return findMin(node.left);
    }
        
    /*
    * method NodesGT. returns a count of all of the integers greater than
    *                 the cutoff value
    *
    *   Method idea is to use the string we get from the preOrder traversal to 
    *   calculate all of the Nodes greater than the cutoff. A lot easier to
    *   work with a string than recursion.
    *
    * @param int val. A cutoff value the data needs to be greater than.
    * @return an integer with the count of nodes greater than the cutoff.
    */
    public int NodesGT(int val) {
        // Get the string of all the data Values of the BST.
    	String string = preOrder();
        // Can't be any Nodes greater than the value if the tree is empty.
        if (string.isBlank()) {
            return 0;
        }
        // Convert the string into an array of strings with each data value
        // As an element
        String[] stringTreeValues = string.split(" ");
        // Initialize variable to keep track of how many nodes are GT.
        int tally = 0;
        // Loop through the array
        for (int i = 0; i < stringTreeValues.length; i++) {
            // increment tally if the value is greater than the cutoff value
            // Converting the string value in the 
            // array into an integer for comparison
            tally = (Integer.parseInt(stringTreeValues[i]) > val) ? ++tally: tally;
        }
        // return what we found
        return tally;
    }

    /*
    * method average. returns the average of all of the nodes data 
    *                 inside the tree.
    *
    *   Method idea is to use the string we get from the preOrder traversal to 
    *   calculate the average value of the tree. A lot easier to
    *   work with a string than recursion.
    *
    * @return a Double with the average of all the nodes in the tree.
    */
    public double average() {
        // Get the string of all the data Values of the BST.
        String string = preOrder();
        // If the tree is empty/ the string is blank
        if (string.isBlank()) {
            // we return NaN
            return 0.0/0.0;
        }
        // Convert the string into an array of strings with each data value
        // As an element
        String[] stringTreeValues = string.split(" ");
        // Variable to keep track of the sum
        double sum = 0.0;
        // Loop through the array
        for (int i = 0; i < stringTreeValues.length; i++) {
            // Sum all the values of the array
            // using parseDouble to convert the String to the double.
            sum += Double.parseDouble(stringTreeValues[i]);
        }
        // Return the sum divided by the length also known as the average.
        return sum / (double) stringTreeValues.length;
    }


    // Helper Method for recursive method invocation.
    public int balanceHeight() {
        // Start the recursion
        return balanceHeight(root);
    }

    /*
    * method balanceHeight
    *
    * the method returns the the height of the tree if the tree is balanced or 
    * returns -1 if the tree is unbalanced
    *
    *  @param Node node. A node of the binary tree which will continue to be 
    *                    passed on with recursion 
    *  @return integer to tell you the height and if the tree is unbalanced 
    */
    private int balanceHeight(Node node) {
        // Base case. If were at a null node we stop recursion
        if (node == null) {
            return 0; 
        }
        // Recurse left down the tree
        balanceHeight(node.left);
        // Recurse right down the tree
        balanceHeight(node.right);
        // We then check the balance factor using recursion. 
        // If the absolute value of the balance factor is greater than one
        // We know that the tree is unbalanced so we return -1;
        // Check the current nodes and all its left and right children
        if (Math.abs(getBalanceFactor(node)) > 1 || 
            Math.abs(getBalanceFactor(node.left)) > 1 ||
            Math.abs(getBalanceFactor(node.right)) > 1) {
            // we return -1 if we reached here which means the 
            // tree is unbalanced so we return -1.
            return -1;
        // If the balance factor is less than 1 we know its still balanced
        // so we return the height of the tree
        } else {
            return height(root);
        }
    }

    /*
    * method getBalanceFactor
    * the method takes the heights of the left and right and subtracts them.
    * Which gives you the balance factor
    *
    *  @param Node node. A node of the binary tree which will continue to be 
    *                    passed on with recursion 
    *  @return integer to tell you the balance factor of the tree. 
    */
    private int getBalanceFactor(Node node) {
        // If the node is null the balance factor is 0 so we return that.
        if (node == null) {
            return 0;
        }
        // Return the height of the left minus the height of the right
        return height(node.left) - height(node.right);
    }

    /*
    * method height
    *
    * the method recurses down and gives you the height of the node you're on.
    *
    *  @param Node node. A node of the binary tree which will continue to be 
    *                    passed on with recursion 
    *  @return integer to tell you the height of the tree. 
    */
    private int height(Node node) {
        // Base case to stop the recursion
        if (node == null) {
            // If the node is null the height must be 0 so we return
            return 0;
        }
        // The height is the max of the left and right sides so we take the max
        // We add one to account for the node were currently on.
        // Recurses down left and down right to get the height.
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
