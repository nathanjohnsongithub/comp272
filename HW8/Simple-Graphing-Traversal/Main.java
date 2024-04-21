
public class Main {

  /*
   * Main - Add any unit testing you need here. 
   */
  
  public static void main(String[] args) {
    Graph graph = new Graph(6);   // Graph with 6 nodes

    // Add vertices and assoicated values 
    graph.setValue(0, 10);
    graph.setValue(1, 20);
    graph.setValue(2, 30);
    graph.setValue(3, 40);
    graph.setValue(4, 50);
    graph.setValue(5, 60);

    // Add directed edges 
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(4, 2);
    graph.addEdge(2, 5);
    graph.addEdge(5, 1);
    graph.addEdge(1, 0);
    graph.addEdge(1, 2);

    graph.printGraph();


    int rootValue = graph.findRoot();
    
    if (rootValue == -1) {
      System.out.println("\nNo root vertex in graph.");
    } else {
      System.out.println(
        "\nShould be '40', Root vertex is: " + rootValue);
    }
  }
}
