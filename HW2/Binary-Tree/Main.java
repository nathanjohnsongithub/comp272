
/*
 * Your Unit Testing goes below. 
 */

public class Main {

  /*
   * Sample tests are included which excerise each of the method you
   * are to write. The expected return retults for each is also provided
   * based on each's tree setup.
   * 
   * You should also do your unit testing by changing the test scenarios
   * below. Good unit testing should cover edge cases. 
   * 
   * When you are ready to submit your assignment, don'd forget to run 
   * the replit tests under the tools panel. Think of this as running your 
   * code through system testing (black box testing) before publishing it. 
   */
  
  public static void main(String[] args) {
      BinaryTree tree = new BinaryTree();

      //
      // Sample Test 1: For this test, a sample tree is provided
      //         That looks like the following:
      //            14
      //           / \
      //           2 11
      //          / \ / \
      //         1 3 10 30
      //             /\  \
      //            7 12 40
      //
      //  The expected preorder output for this tree is "5 3 2 4 7"
      //
    
      tree.insert(44);
      tree.insert(17);
      tree.insert(78);
      tree.insert(32);
      tree.insert(50);
      tree.insert(88);
      tree.insert(48);
      tree.insert(62);
      System.out.println("Test 1: inorder traversal  : " + tree.inOrder());
      System.out.println("Test 1: Preorder traversal  : " + tree.preOrder());
      System.out.println("Test 1: postorder traversal  : " + tree.postOrder());


      //
      // Sample Tests 2-4: For this test, a sample tree is provided
      //         That looks like the following:
      //                17
      //               /  \  
      //             5      47
      //              \    /  \
      //              11  23   99      
      //             /  
      //            8
      //              \
      //               9  
      //
      // The expected results on the println below are ....
      //                    Expected Minimal value : 5
      //                    # nodes w/ value GT    : 3
      //                    Average value          : 27.375
      //
      // tree.deleteTree();
      // System.out.println(tree.balanceHeight());
      // tree.insert(17);
      // tree.insert(47);
      // tree.insert(5);
      // tree.insert(23);
      // tree.insert(99);
      // tree.insert(11);
      // tree.insert(8);
      // tree.insert(9);
      // System.out.println("Test 2: Minimal value       : " + tree.findMin());
      // System.out.println("Test 3: # nodes w/ val GT   : " + tree.NodesGT(17));
      // System.out.println("Test 4: Average value       : " + tree.average()); 

      // 
      // Sample Test 5: is 1st tree balanced?: Yes
      //         is 2nd tree balanced?: No
      //
    
      // tree.deleteTree();
      // tree.insert(5);
      // tree.insert(3);
      // tree.insert(7);
      // tree.insert(2);
      // System.out.println("Test 5: 1st tree balanced?  : " + 
      //                     (tree.balanceHeight() == -1 ? "No" : "Yes"));

      // // System.out.println("balance factor "+ tree.getBalanceFactor(tree.root));
      // // System.out.println("Height from height() " + tree.height(tree.root));
      // System.out.println("Height from balanceHeight"+ tree.balanceHeight());
      // tree.deleteTree();
      // tree.insert(5);
      // tree.insert(3);
      // tree.insert(7);
      // tree.insert(6);
      // tree.insert(2);
      // tree.insert(8);
      // tree.insert(9);
      // tree.insert(10);
      // System.out.println(tree.preOrder());
      // System.out.println("Test 5: 2nd tree balanced?  : " + 
      //                     (tree.balanceHeight() == -1 ? "No" : "Yes"));


      // System.out.println("Height"+ tree.balanceHeight());
  }
}