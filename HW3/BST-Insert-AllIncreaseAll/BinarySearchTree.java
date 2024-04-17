
//////////////////////////////////////////////////////
//
// Nathan Johnson / Comp272-002
//
//////////////////////////////////////////////////////


public class BinarySearchTree {

  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  Node root;

  public BinarySearchTree()   { root = null;}

  /**
   * Method insertAll
   * 
   * This methiod takes an array of integers and inserts them into 
   * the binary search tree. Duplicate values are allowed in this BST. 
   *
   * This method SHOULD utilize the 'insert' method below.
   */
  
    public void insertAll(int[] data) {
        // loop through the array of values and call the insert method 
        // to insert them one by one.
        for (int val: data) {
            insert(val);
        }
    }


  /**
   * Method Insert
   *
   * This method inserts a new node into the binary search tree. The 
   * tree *DOES ALLOW* duplicates. Duplicates values are to the right. 
   * E.g., if inserting a value '6' and '6' already exists in the tree,
   * the newly inserted value '6' will be to the right child [subtree] 
   * of the existing node with value '6'.
   *
   * Use the helper private method provided below which is called by 
   * the public method.
   */
  
    public void insert(int data) {
        // Call the private insert method to start the recursion
        root = insert(data, root);
    }

    private Node insert(int data, Node node) {
        // guard statement for empty tree
        // Also the base case to stop recursion.
        if (node == null) {
            // if were at a leaf OR the tree was empty we return the new node.
            return new Node(data);
        } else if (data < node.data) {
            // recurse left
            node.left = insert(data, node.left);
        } else if (data >= node.data) {
            // recurse right
            node.right = insert(data, node.right);
        }
        // return the node to recurse back
        return node;
    }

  
  /**
   * Method increaseAll
   *
   * This method inserts the value of ever node in the tree by  
   * a supplied value. 
   *
   * Use the helper private method provided below which is called by 
   * the public method.  
   */

    public void increaseAll(int value) {
        // call the private increaseAll method to start the recursion.
        increaseAll(root, value);
    }

    private Node increaseAll(Node node, int value) {
        // Base case. stop when we've reached a leaf also known as a null node.
        if (node != null) {
            // add the value to increase as we recurse.
            node.data += value;
            // recurse left and right
            increaseAll(node.left, value);
            increaseAll(node.right, value);
        }
        // Return the node and recurse back up. 
        return node;
    }

    

  
  
  /**
   * Do NOT change below, the methid toString() is used by
   * in creating a string reprensentation of the tree. It can 
   * be used by System.out.println(tree) to print the tree, and
   * it is also used by the JUnit tests.
   */
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    toStringHelper(root, sb);
    if (sb.length() != 1) {
      sb.setLength(sb.length() - 2);
    }
    sb.append("]");
    return sb.toString();
  }

  private void toStringHelper(Node node, StringBuilder sb) {
    if (node == null) {
      return;
    }
    toStringHelper(node.left, sb);
    sb.append(node.data);
    sb.append(", ");
    toStringHelper(node.right, sb);
  }
}