////////////////////////////////////////
//
//  Nathan Johnson / Comp 272-002
//
////////////////////////////////////////

import java.util.*;

class Solution {

    /*
    To reach your goal of 'master programmer', you 
    need to complete 'n' certification exams, each 
    being specific to a topic. Some exams have 
    prerequisites of needing to take and pass earlier
    certificate exams.

    You can represent these 'n' exams as nodes in a 
    graph, numbered from 0 to n-1. And represent the 
    prerequisite between taking exams as directed edges
    between two nodes which represent those two exams. 

    You are given a 2-dimensional array of exam 
    prerequisites where prerequisites[i] = [ai, bi] 
    indicating that you must take exam bi first if you 
    want to take exam ai. For example, the pair [0, 1], 
    indicates that to take exam certification 0, you 
    have to first have the certification for exam 1. 

    Return true if you can finish all certification 
    exams. Otherwise, return false (e.g., meaning it is 
    a cyclic or cycle graph). 

    Example 1:
    Input: numExams = 2, prerequisites = [[1,0]]
    Output: true
    Explanation: There are a total of 2 exams to take.
    To take exam 1 you should have completed the 
    certification of exam 0. So, it is possible (no 
    cyclic or cycle graph of prereqs).


    Example 2:
    Input: numExams = 2, prerequisites = [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 exams to take. 
    To take exam 1 you should have completed the 
    certification of exam 0, and to take exams 0 you 
    should also have completed the certification of exam 
    1. So, it is impossible (it is a cycle graph).

    */

    public boolean canFinish(int numExams, 
                             int[][] prerequisites) {
      
        int numNodes = numExams;  // # of nodes in graph

        // Build directed graph's adjancy list
        ArrayList<Integer>[] adj = getAdjList(numExams, 
                                        prerequisites); 


        boolean[] visited = new boolean[numNodes];
        boolean[] recVisited = new boolean[numNodes];
        for (int i = 0; i < adj.length; i++) {
            if (dfsCycle(adj, i, visited, recVisited)) {
                // Returning false if there is a cycle because
                // we CANNOT complete the exams.
                return false;
            }
        }
        // Return that we CAN complete the exams.
        return true;
    }

    public boolean dfsCycle(ArrayList<Integer>[] adj, int vertex, 
                            boolean[] visited, boolean[] recVisited) {

        // If we've already visited this vertex in the recursion we know 
        // there is a cycle so we return true.
        if (recVisited[vertex]) {
            return true;
        }
        // If we've already visited we know we dont need to keep searching 
        // so we stop the recursion and return false;
        if (visited[vertex]) {
            return false;
        }
        // Update boolean arrays.
        recVisited[vertex] = true;
        visited[vertex] = true;

        // Loop over all the possible neighbors and check for a cycle.
        for (Integer neighbor : adj[vertex]) {
            if (dfsCycle(adj, neighbor, visited, recVisited)) {
                // If we have a cycle return true;
                return true;
            }
        }
        // If we have reached here we know there is not a cycle for vertex 
        // 'vertex' so we can remove if from the recursive stack/visited
        // array and we return false because there is no cylce to this vertex.
        recVisited[vertex] = false;
        return false;
    }

    /*
     * Building an Adjacency List for the directed 
     * graph based on number of nodes and passed in 
     * directed edged.
     */

    private ArrayList<Integer>[] getAdjList(
            int numNodes, int[][] edges) {
      
        ArrayList<Integer>[] adj 
                    = new ArrayList[numNodes];

        for (int node = 0; node < numNodes; node++){
            adj[node] = new ArrayList<Integer>();
        }
        for (int[] edge : edges){
            adj[edge[0]].add(edge[1]);
        }
        return adj;
    }
}


/*
 * Main Driver
 */

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        /*
         * Driver Code for method canFinish(), the 
         * driver builds simple directed graphs,
         * where edges represent prerequisites. 
         * Your code should build more complex
         * directed graphs.
         */

        // Prereq edges for graph g1 of 2 /examsnodes
        int[][] g1 = new int[][] { {0,1} };    
      
        // Prereq edges for graph g2 of 2 exams/nodes
        int[][] g2 = new int[][] { {1,0}, {0,1} };  
      
        // Prereq edges for graph g3 of 4 exams/nodes
        int[][] g3 = new int[][] { {1,0}, {3,1} };   
      

        System.out.println("\nStartng tests ...");
      
        if ( ! s.canFinish(2, g1) )
          System.out.println("Test 1 error");

        if ( s.canFinish(2, g2) )
          System.out.println("Test 2 error");
      
        if ( ! s.canFinish(4, g3) )
          System.out.println("Test 3 error");

        // Add more testing with and without cycles 
        // in directed graphs. Include larger directed
        // graphs, as the JUnit tests will.

        int[][] g4 = new int[][] { };
        int[][] g5 = new int[][] { {1,0}, {3,1}, {3,0} };
        int[][] g6 = new int[][] { {1,0}, {3,1}, {0,3} };

        if ( ! s.canFinish(2, g4) )
          System.out.println("Test 4 error");
      
        if ( ! s.canFinish(4, g5) )
          System.out.println("Test 5 error");

        if ( s.canFinish(4, g6) )
          System.out.println("Test 6 error");

        System.out.println("Testing complete");
    }
}