package Problems;

import java.util.Arrays;

/*
 * Find if every edge belongs to any of the shortest path between 0th to (n-1)th node.
 * The below solution doesn't work for larger testcases 
 * 
 * Intuition:
 *  If an edge (u,v,w) belongs to shortest path, then 
 *   dist(0, u) + dist(v, n-1) + w == distance(0, n-1) || 
 *   dist(0, v) + dist(u, n-1) + w == distance(0, n-1)
 */

public class EdgesInShortestPath {

    public static boolean[] findAnswer(int n, int[][] edges) {
        int INF = Integer.MAX_VALUE;
        long[][] distances = new long[n][n];

        // Initialize distances with infinity
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = INF;
            }
            distances[i][i] = 0; // Distance to itself is 0
        }

        // Populate distances with edge weights
        for (int[] edge : edges) {
            distances[edge[0]][edge[1]] = edge[2];
            distances[edge[1]][edge[0]] = edge[2];
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                }
            }
        }
        boolean[] answer = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            answer[i] = distances[0][n-1] == distances[0][u] + w + distances[v][n-1];
            answer[i] = answer[i] || distances[0][n-1] == distances[0][v] + w + distances[u][n-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int edges[][] = {{0,1,4},{0,2,1},{1,3,2},{1,4,3},{1,5,1},{2,3,1},{3,5,3},{4,5,2}};
        boolean ans[] = findAnswer(n, edges);
        System.out.println(Arrays.toString(ans));
    }
}
