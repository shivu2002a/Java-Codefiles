package ShortestPathAlgos.Dijkstra;

import java.util.*;

public class DijkstraAdjMatrix {
    
    private void findShortestPath(int[][] graph, int src) {
        //final distances
        int distance[] = new int[graph.length];
        //finalized or not
        boolean foudShortest[] = new boolean[graph.length];
        //initialize
        for (int i = 0; i < graph.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            foudShortest[i] = false;
        }
        //finalize src dist as zero
        distance[src] = 0;

        //loop for finding minDistance for other nodes except src
        for (int count = 0; count < graph.length-1; count++) {
            //find the next shortest distance node
            int u = minDistance(distance, foudShortest);
            foudShortest[u] = true;
            //check for other distances
            for (int v = 0; v < foudShortest.length; v++) {
                if(!foudShortest[v] &&  // not finalized
                   graph[u][v] != 0 && //edge is present
                   distance[u] != Integer.MAX_VALUE && // shortest distance in not indefinite
                   distance[u] + graph[u][v] < distance[v] // that edge dist is min
                   ){
                       distance[v] = distance[u] + graph[u][v];
                       
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }

    
    private int minDistance(int[] dist, boolean[] foudShortest) {
        int minDist = Integer.MAX_VALUE, min_index = -1;
        for (int i = 0; i < foudShortest.length; i++) {
            if(!foudShortest[i] && dist[i] <= minDist ){
                min_index = i;
                minDist = dist[i];
            }
        }
        return min_index;

    }


    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        DijkstraAdjMatrix dikstra = new DijkstraAdjMatrix();
        dikstra.findShortestPath(graph, 0);
    }

}
