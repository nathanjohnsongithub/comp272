////////////////////////////////////////////
// NATHAN JOHNSON     /   COMP 272-002    //
////////////////////////////////////////////


/*
 * Class: LUCLinkedList
 *
 * The class implments a Singly linked-list. For this class, you are to   
 * complete the 'removeElementsLT' method (below), which is to remove 
 * all elements from the linked-list with values that are less than the
 * input paramter passed to the method. 
 */

public class LUCLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int d)           
        {
            data = d;
            next = null;
        }
    }
    Node head;                 

    /*
     * Method inserting an elment (new node) into the linked-list
     */
  
    public void insert(int data) {
        Node new_node = new Node(data); 
        new_node.next = null;
        if (this.head == null) { 
            this.head = new_node;
        }
        else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node; // Insert the new_node at last node
        }
    }

    /* 
     * Method to convert linked-list to a string, this method 
     * is used by println()
     */
  
     public String toString() {   
        String output="[";
        Node currNode = this.head;

        while (currNode != null) { 
          output+=currNode.data + " ";
          currNode = currNode.next; 
        }
        return output.trim()+"]";
    }

    /*
     * Method to remove all the nodes that store a given value less
     * than the passed value "ltValue". E.g., the invocation of the
     * method removeElementsLT(8) would remove all nodes from the 
     * linked-list that store a value less than 8.
     *
     * @param ltValue - the value to be used as a cutoff data inside the list.
     */
  /**
   * Removes elements in the linked list that are less than the specified value.
   * If the head of the list is below the cutoff, updates the head accordingly.
   *
   * @param ltValue The cutoff value for removing elements.
   */
  public void removeElementsLT(int ltValue) {
      // Guard statement to ensure we have a list to work with.
      if (this.head == null) {
          return;
      }

      // Handle the Head edge case where the head is below the cutoff.
      // Initialize the cursor to the start of the list, knowing it cannot be null.
      Node cursor = this.head;
      // If there are elements to check and the value is still below the cutoff.
      while (cursor != null && cursor.data < ltValue) {
          // Remove the current node by updating the head to the next node.
          cursor = cursor.next;
          this.head = cursor;
      }

      // Initialize the previousNode variable to keep track of the previous position,
      // allowing removal if needed.
      Node previousNode = this.head;
      // Check if the head is not null, indicating there are elements to check.
      if (this.head != null) {
          // Move the cursor to the next node. previousNode is now on the head,
          // and cursor is on the next node.
          cursor = cursor.next;
          // While there are still nodes to check.
          while (cursor != null) {
              // If the current node's data is less than the cutoff value, remove it.
              if (cursor.data < ltValue) {
                  // Update previousNode to point to the next node's next,
                  // skipping over the node that is below the cutoff value.
                  previousNode.next = cursor.next;
                  cursor = previousNode.next;
              } else {
                  // If the value isn't less than the cutoff, move down the list.
                  cursor = cursor.next;
                  previousNode = previousNode.next;
              }
          }
      }
  }
}
