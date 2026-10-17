package Task3;

import java.util.ArrayList;
import java.util.Arrays;

public class main {

    public static void main(String[] args) {

	// Define number of vertices (n), number of edges (m), and source vertex (src)
	int n = 8, m = 15, src = 0;

	// Initialize the edges list
	ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

	

	// create each edge between tasks 
	
	//  task a is 0 
	//	B is 1
	//	c is 2
	//	d is 3
	//	e is 4
	//	f is 5 
	//	g is 6
	//	h is 7
	
	ArrayList<Integer> edge1 = new ArrayList<>(Arrays.asList(0, 1, 1));
	ArrayList<Integer> edge2 = new ArrayList<>(Arrays.asList(0, 7, 4));
	ArrayList<Integer> edge3 = new ArrayList<>(Arrays.asList(0, 2, 4));
	ArrayList<Integer> edge4 = new ArrayList<>(Arrays.asList(1, 2, -5));
	ArrayList<Integer> edge5 = new ArrayList<>(Arrays.asList(1, 3, 3));
	ArrayList<Integer> edge6 = new ArrayList<>(Arrays.asList(2, 4, 2));
	ArrayList<Integer> edge7 = new ArrayList<>(Arrays.asList(3, 5, 7));
	ArrayList<Integer> edge8 = new ArrayList<>(Arrays.asList(3, 4, 2));
	ArrayList<Integer> edge9 = new ArrayList<>(Arrays.asList(4, 5, 1));
	ArrayList<Integer> edge10 = new ArrayList<>(Arrays.asList(4, 1, 5));
	ArrayList<Integer> edge11 = new ArrayList<>(Arrays.asList(4, 3, 3));
	ArrayList<Integer> edge12 = new ArrayList<>(Arrays.asList(4, 6, 1));
	ArrayList<Integer> edge13 = new ArrayList<>(Arrays.asList(5, 7, 8));
	ArrayList<Integer> edge14 = new ArrayList<>(Arrays.asList(5, 6,2 ));
	ArrayList<Integer> edge15 = new ArrayList<>(Arrays.asList(6, 7, 9));

	
	// add edges to the list
	edges.add(edge1);
	edges.add(edge2);
	edges.add(edge3);
	edges.add(edge4);
	edges.add(edge5);
	edges.add(edge6);
	edges.add(edge7);
	edges.add(edge8);
	edges.add(edge9);
	edges.add(edge10);
	edges.add(edge11);
	edges.add(edge12);
	edges.add(edge13);
	edges.add(edge14);
	edges.add(edge15);
	
//	 System.out.println("Edges:");
//	    for (ArrayList<Integer> edge : edges) {
//	        System.out.println(edge.get(0) + " -> " + edge.get(1) + ", Weight: " + edge.get(2));
//	    }
	BellmanFord.bellmanFord(n, m, src, edges);

	
	  int[][] graph = new int[][]{
		  //a
          {0, 1, 4, 0, 0, 0, 0, 4},
          //b
         {0, 0, 5, 3, 0, 0, 0, 0},
         //c
          {0, 0, 0, 0, 2, 0, 0, 0},
          //d
          {0, 0, 0, 0, 2, 7, 0, 0},
          //e
          {0, 5, 0, 3, 0, 1, 1, 0},
          //f
          {0, 0, 0, 0, 0, 0, 0, 8},
          //g
          {0, 0, 0, 0, 0, 0, 0, 9},
          //h
          {0, 0, 0, 0, 0, 0, 0, 0},
        
	  };
	  System.out.println("\n\n");
	  dijkstra. dijkstra(graph, 0);

}
}
