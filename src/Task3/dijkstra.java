package Task3;

public class dijkstra {

    // Function to find the vertex with the minimum distance value,
    // from the set of vertices not yet included in the shortest path tree
    private static int minDistance(int[] shortestPathArr, boolean[] visited) {
        int min = Integer.MAX_VALUE; // Initialize minimum distance as infinity
        int minIndex = -1; // i will apdate this to store the indix of the min i will found

        // Iterate through all vertices to find the minimum distance vertex
        for (int v = 0; v < shortestPathArr.length; v++) {


        	// not visted and less than? 
        	if (!visited[v] && shortestPathArr[v] < min) {
                min = shortestPathArr[v]; // LET U STORE THE NEW MIN distance
                minIndex = v; // store  index of minimum distance vertex becouse this is what i will need 
            }
        }

        return minIndex; // Return the index of the minimum distance vertex
    }

    // Function to print the distances from the source vertex to all other vertices
    private static void printSolution(int[] shortestToall) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < shortestToall.length; i++) {
            System.out.println(i + " \t " + shortestToall[i]); // Print vertex and its distance from source
        }
    }

    
    
    public static void dijkstra(int[][] graph, int src) {
        int V = graph.length; 
        int[] shortestPatharr = new int[V]; // Array to store the shortest distance from source to each vertex
        boolean[] visited = new boolean[V]; // what are visted and non visted  
        
        
        // marking all as non visted and all are infinity 
        for (int i = 0; i < V; i++) {
            shortestPatharr[i] = Integer.MAX_VALUE;
            visited[i] = false; // alll are non visted
        }

        shortestPatharr[src] = 0; // source to 0

        // Iterate over vertices to find shortest paths
        for (int count = 0; count < V - 1; count++) {
            int x = minDistance(shortestPatharr, visited); // vertex with the minimum distance not yet visited
            visited[x] = true; // when i reach it that means it is visted 

   

            // Update distances for the neighbors of the picked vertex
            for (int v = 0; v < V; v++) {
               //  if it is viosted i will not change the distance
               //  if thier existsed an edge from the x to the other v ertieces ( v) 
               //  if thier is already a known path ( not infinity ) 
                if (!visited[v] && graph[x][v] != 0 && shortestPatharr[x] != Integer.MAX_VALUE && shortestPatharr[x] + graph[x][v] < shortestPatharr[v]) {
                    shortestPatharr[v] = shortestPatharr[x] + graph[x][v]; // the grahg holds the edge value
                }
            }
        }

        // Print the distances from source to all vertices
        System.out.println("Shortest distances from source vertex " + src + ":");
        printSolution(shortestPatharr);
    }
}
