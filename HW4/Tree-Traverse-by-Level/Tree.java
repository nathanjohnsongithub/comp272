/////////////////////////////////////////////////
//
// Nathan Johnson / Comp 272-002
//
//////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {

  public Tree() {
    root = null;
  }

  public Tree(int val) {
    root = new Node(val);
  }

  /*
   * Class Node. 
   *
   * This is the main iterface you will be using. The 
   * this tree handlkes n-ary children! So, do not just 
   * assume it is a binary tree (only 2 children). 
   * 
   * The children are stored in an arrary list. So, when
   * you do your traversal by level, you have the children
   * nodes in the array list (in the proper order from left
   * to right).
   */
  
  static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<Node>();
    Node parent = null;

    public Node(int d) {
      data = d;
    }

    public Node addChild(int d) {
      Node n = new Node(d);
      n.setParent(this);
      children.add(n);
      return n;
    }

    // This method returns an array of a node's children
    public ArrayList<Node> getChildren() {
      return children;
    }

    public void setParent(Node p) {
      parent = p;
    }

    public Node getParent() {
      return parent;
    }
  }

  Node root = null;

  //
  // DO NOT MODIFIY CODE ABOVE THIS LINE
  //
  
  /**
   *  Method traverseByLevel
   *
   * The method will return a String of the tree's
   * data values using a breadth first traversal. In 
   * otherword, it prints the node value level by level
   * starting at the root node and working down one
   * level at a time printing the values from left to right. 
   *
   * Returns 
   * A string with the tree's data values separated by spaces.
   * If tree is empty, return an empty string.
   */

    public String traverseByLevel() {
        // Initialize the string that we will return
        String result = "";
        // edge case to make sure theres a tree
        if (root == null) {
            return result;
        }
        // If theres a tree, initialize the queue which will store trees nodes.
        Queue<Node> queue = new LinkedList<Node>();
        // Add the root to "prime" the loop
        queue.add(root);
        // Keep looping until we run out of children
        while (!queue.isEmpty()) {
            // Dequeue the current elements
            Node node = queue.poll();
            // Add the value to the string
            result += node.data + " ";
            // Add all of its children to the queue
            queue.addAll(node.children);
        }
        // Return the breadth first traversal
        return result;
    }
}
