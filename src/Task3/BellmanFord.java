package Task3;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

	// 1- having an array that stores the distances strating with infinity for all
	// and 0 for source
	// 2- Relaxation process:
	// loop for ( V num ( n ) -1 ) times
	// each loop will do relaxation : if starting ponit is not infinity ( to ensure
	// we visited it )
	// & if the the distance from the strat to the end by the wieght is more than
	// the found ( so i have shorter )
	// Do : chang the end value.

	// 3-Negative detiction process ( one more time )
	// if the start + wight is less than the end that mean i have shorter path
	// 4- priting results

	
	
	
	
	
	 static void bellmanFord(int n, int m, int src, ArrayList<ArrayList<Integer>> edges) {
			// i have edges array list , each elemnt in it repersented by  arraylist ( is is an edge ) is storing the start in 0 and the end in 1 and the wieght in 2   
			
			// Initialize the path array to store the shortest path from src to other
			int[] distance = new int[n];
			Arrays.fill(distance, Integer.MAX_VALUE);  // Set all distances to infinity for the first time
			distance[src] = 0;  // Distance to source is zero

			
			
			// relaxation process : 
			
			
			for (int i = 0; i <= n-1 ; i++) {  // // Loop through vertices (V - 1) times

				for (int j = 0; j < m; j++) {  // Iterate through all edges
					int startV = edges.get(j).get(0);  // Get the start vertex of the edge
					int endV = edges.get(j).get(1);  // Get the end vertex of the edge
					int w = edges.get(j).get(2);  // Get the weight of the edge
							// i am reaching it by indixes.
					
					  // Check if the starting vertex is reachable ( not infinity) and if the distance can be shortened
	                if (distance[startV] != Integer.MAX_VALUE && distance[startV] + w < distance[endV]) {
	                	distance[endV] = distance[startV] + w; // Update distance to the end vertex
	                }	
				}
			}
			
			 // Negative cycle detection once  over all .
	        for (int i = 0; i < m; i++) { // Iterate through all edges
	            int startV = edges.get(i).get(0); // Start vertex of edge
	            int endV = edges.get(i).get(1); // End vertex of edge
	            int w = edges.get(i).get(2); // Weight of edge

	            // If the distance can still be shortened, a negative cycle exists
	            if (distance[startV] != Integer.MAX_VALUE && distance[startV] + w < distance[endV]) {
	                System.out.println("There is a negative cycle in the graph");
	                return;
	            }
	        }
	        
	        
	        
	     // Printing results
	        for (int i = 0; i < n; i++) {
	            System.out.print("The shortest path between " + src + " and " + i + " is: ");
	            if (distance[i] == Integer.MAX_VALUE) {
	                System.out.println("No path");
	            } else {
	                System.out.println(distance[i]);
	            }
	        }
		

		
		
	}
}
