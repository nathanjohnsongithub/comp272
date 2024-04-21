/////////////////////////////////////////
//
//  Nathan Johnson / Comp 272-002
//
/////////////////////////////////////////

import java.util.*;

class Solution {

    /*
     * Assignment Graphing - Number of groups.
     *
     * There are n people. Some of them are connected 
     * as friends forming a group. If person 'a' is
     * connected to person 'b', and person 'b' is 
     * connected to person 'c', they form a connected 
     * group.
     *
     * Not all groups are interconnected, meaning there
     * can be 1 or more groups depending on how people
     * are connected.
     *
     * This example can be viewed as a graph problem, 
     * where people are represented as nodes, and
     * edges between them represent people being 
     * connected. In this problem, we are representing
     * this graph externally as an non-directed 
     * Adjacency Matrix. And the graph itself may not 
     * be fully connected, it can have 1 or more 
     * non-connected components (subgraphs).
     *
     * Example 1:
     *   Input : 
         AdjMatrix = [[0,1,0], [1,0,0], [0,0,0]]
     *   Output: 2
     *   Explanation: The Adjacency Matrix defines an 
     *   undirected graph of 3 nodes (indexed 0 to 2).
     *   Where nodes 0 and 1 aee connected, and node 2 
     *   is NOT connected. This forms two groups of 
     *   nodes.
     *
     * Example 2:
     *   Input : AdjMatrix = [ [0,0,0], [0,0,0], [0,0,0]]
     *   Output: 3
     *   Explanation: The Adjacency Matrix defines an 
     *   undirected graph of 3 nodes (indexed 0 to 2).
     *   There are no connected nodes, hence forming 
     *   three groups.
     *
     * Example 3:
     *   Input : AdjMatrix = [[0,1,0], [1,0,0], [0,1,0]]
     *   Output: 1
     *   Explanation, The adjacency Matrix defined an 
     *   undirected graph of 3 nodes (index 0 to 2).
     *   All three nodes are connected by at least one 
     *   edge. So they form on large group.
     */

    public int numGroups(int[][] adjMatrix) {
        int numNodes = adjMatrix.length;
        Map<Integer,List<Integer>> graph = new HashMap();

        /*
         * Converting the Graph Adjacency Matrix to 
         * an Adjacency List representation. This
         * sample code illustrates a technique to do so. 
         */

        for(int i = 0; i < numNodes ; i++){
            for(int j = 0; j < numNodes; j++){
                if( adjMatrix[i][j] == 1 && i != j ){
                  // Add AdjList for node i if not there
                  graph.putIfAbsent(i, new ArrayList());  
                  // Add AdjList for node j if not there
                  graph.putIfAbsent(j, new ArrayList());  

                  // Update node i adjList to include node j
                  graph.get(i).add(j);        
                  // Update node j adjList to include node i
                  graph.get(j).add(i);                
                }
            }
        }
        /* Implementation for this is to use depth first search and every time
        *  we need to call the function from this method, that means there is
        *  a disconnect inside of the graph meaning there is another group. */

        // Initialize a boolean array to keep track if we have visited the vertex before.
        boolean[] visited = new boolean[adjMatrix.length];
        // Return variable to keep track of how many groups, or disconnected graphs
        // we have.
        int numberOfGroups = 0;
        // We want to loop over the entire Adjacency List.
        for (int i = 0; i < adjMatrix.length; i++) {
            // We will be doing this initial call here for DFS because at the 
            // start the array is all false, the value will get updated while 
            // we are searching the graph. If we need to call something again
            // that means we have a disconnect and we need to increment
            // the counter return variable.
            if (!visited[i]) {
                depthFirstSearch(graph, visited, i);
                numberOfGroups++;
            }
        }
        return numberOfGroups;
    }

    public void depthFirstSearch(Map<Integer,List<Integer>> graph, boolean[] visited, int person) {
        // Set the value to true because we have started searching on another vertex.
        visited[person] = true;
        // Got the List of all of the edges that connect to this given "person" or "vertex."
        for (List<Integer> edges : graph.values()) {
            // Loop over all the edges
            for (int neighbors : edges) {
                // If we havent visited this person yet lets search.
                if (!visited[neighbors]) {
                    depthFirstSearch(graph, visited, neighbors);
                }
            }
        }
    }

}


/*
 * Main Driver - Add any Unit testing needed here.
 */

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();


        /*
         * Driver for method numGroups()
         */

        int[][] adjMatrix1 = new int[][] { {0,1,0}, 
                                           {1,0,0}, 
                                           {0,0,0} };
        int[][] adjMatrix2 = new int[][] { {0,0,0}, 
                                           {0,0,0},
                                           {0,0,0} };
        int[][] adjMatrix3 = new int[][] { {0,1,0}, 
                                           {1,0,0},
                                           {0,1,0} };

        System.out.println("Num of groups in g1: " 
                + s.numGroups(adjMatrix1) ); // should be 2
        System.out.println("Num of groups in g2: " 
                + s.numGroups(adjMatrix2) ); // should be 3
        System.out.println("Num of groups in g3: "
                + s.numGroups(adjMatrix3) ); // should be 1

        int[][] adjMatrix4 = new int[][] { {0,1,0,0}, 
                                           {1,0,0,0}, 
                                           {0,0,0,0}, 
                                           {0,0,0,0} };
        int[][] adjMatrix5 = new int[][] { {0,0,0,0}, 
                                           {0,0,0,0}, 
                                           {0,0,0,0}, 
                                           {0,0,0,0} };
        int[][] adjMatrix6 = new int[][] { {0,1,0,0}, 
                                           {1,0,0,0}, 
                                           {0,1,0,0}, 
                                           {1,0,0,0} };

        System.out.println("Num of groups in g4: "
              + s.numGroups(adjMatrix4) ); // should be 3
        System.out.println("Num of groups in g5: "
              + s.numGroups(adjMatrix5) ); // should be 4
        System.out.println("Num of groups in g6: "
              + s.numGroups(adjMatrix6) ); // should be 1
    }
}