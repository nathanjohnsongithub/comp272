import java.util.*;

/*
 * Unit testing the AVL tree. 
 * 
 * Please free to add, remove, or modify the test cases for your 
 * purposes of unit testing. 
 */

public class Main {
    public static void main(String[] args) {

        LUC_AVLTree tree = new LUC_AVLTree();
        Scanner console = new Scanner(System.in);
        int input, element;
        int loop = 1;

        System.out.println("Start AVL Tree Program!");

        /*
         * The following loop allows manual tree manipulations. When exiting 
         * this loop, then 4 automated tests are ran, each causing LL, RR, RL, 
         * LL rotations, respectively. Each of these tests are causing a 
         * specific tree rotation during a deletion.
         */

        while ( loop == 1 ) {
            System.out.println("Options:");
            System.out.println("  1) Insert value into tree");
            System.out.println("  2) Delete value from tree");
            System.out.println("  3) Print tree using inorder traversal");
            System.out.println("  4) exit");
            System.out.println();
            System.out.print("Input: ");

            input = console.nextInt();

            switch( input ) {
                case 1:
                    System.out.print("  Value to insert: ");
                    element = console.nextInt();
                    tree.insert(element);
                    System.out.println();
                    break;

                case 2:
                    System.out.print("  Value to delete: ");
                    element = console.nextInt();
                    tree.delete(element);
                    System.out.println();
                    break;

                case 3:

                    System.out.print("\nInorder Traversal of tree: \n");
                    tree.inorderTraversal();
                    System.out.println();
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Exiting user input mode");
                    loop = 0;
                    break;

                default:
                    System.out.println();
                    System.out.println("Please enter 1, 2, 3, or 4 only");
                    System.out.println();
            }
        }


        /*
         * Automated tests for testing the delete method. There are 4 automated
         * tests, each rebuilds the exact same tree, then performs tree 
         * manipulations to cause a tree rotation during a delete operation. 
         * The 4 tests each test one of the 4 rotations ... RR, LL, RL, and LR.
         *
         * For each test, the pre-loaded tree is printed (before rotation), 
         * followed by the tree after the test's manipulations (post rotation).
         *
         * _Note_: When printing a tree, the tree is printed in "inorder" 
         * traversal. And what is printed for each node is (1) the value of the 
         * node and (2) its height from the botton of the tree (e.g., a leaf 
         * node has a height of 0, its parent node has a value of 1, et al).
         */

        System.out.println("\nAVL Automated Sample Unit tests starting ...\n");

        /*
         * TEST 1 - Deletions causing a RR rotation
         */
        tree.removeAll();
        tree.insert(40);
        tree.insert(50);
        tree.insert(20);
        tree.insert(60);
        tree.insert(29);
        tree.insert(25);
        tree.insert(24);
        tree.insert(27);
        tree.insert(18);
        tree.insert(22);

        System.out.print("Test 1: Inorder Tree Traversal : ");
        tree.inorderTraversal();
        System.out.println();

        tree.delete(27);
        tree.delete(29);
        System.out.print("\nTest 1: After RR Rotation      : ");
        tree.inorderTraversal();
        System.out.println();


        /*
         * TEST 2 - Deletions causing a LL Rotation
         */

        tree.removeAll();
        tree.insert(40);
        tree.insert(50);
        tree.insert(20);
        tree.insert(60);
        tree.insert(29);
        tree.insert(25);
        tree.insert(24);
        tree.insert(27);
        tree.insert(18);
        tree.insert(22);

        System.out.print("\n\nTest 2: Inorder Tree Traversal : ");
        tree.inorderTraversal();
        System.out.println();

        tree.insert(17);
        tree.delete(22);
        tree.delete(24);
        System.out.print("\nTest 2: After LL Rotation      : ");
        tree.inorderTraversal();
        System.out.println();


        /*
         * Test 3: Deletions causing a RL Rotation
         */

        tree.removeAll();
        tree.insert(40);
        tree.insert(50);
        tree.insert(20);
        tree.insert(60);
        tree.insert(29);
        tree.insert(25);
        tree.insert(24);
        tree.insert(27);
        tree.insert(18);
        tree.insert(22);

        System.out.print("\n\nTest 3: Inorder Tree Traversal : ");
        tree.inorderTraversal();
        System.out.println();

        tree.delete(18);
        System.out.print("\nTest 3: After RL Rotation      : ");
        tree.inorderTraversal();
        System.out.println();


        /*
         * Test 4: Deletions causing a LR Rotation
         */

        tree.removeAll();
        tree.insert(40);
        tree.insert(50);
        tree.insert(20);
        tree.insert(60);
        tree.insert(29);
        tree.insert(25);
        tree.insert(24);
        tree.insert(27);
        tree.insert(18);
        tree.insert(22);

        System.out.print("\n\nTest 4: Inorder Tree Traversal : ");
        tree.inorderTraversal();
        System.out.println();

        tree.insert(30);
        tree.delete(27);
        tree.delete(60);
        tree.delete(50);
        System.out.print("\nTest 4: After LR Rotation      : ");
        tree.inorderTraversal();
        System.out.println();

        System.out.println("\n... AVL Automated Sample Unit tests completed.\n");

        return;
    }
}