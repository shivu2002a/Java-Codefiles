package Bridges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author Shivanagouda S A
 * @implSpec Time complexity - O(V + 2E)
 * @implSpec Space complexity - O (V + 2E + 3V)
 */
public class TarjansAlgo {
    
    public static void main(String[] args) {
        int edges[][] = {
            {0,1},{1,2},{2,3},{0,3},{3,4},{4,5},{5,6},{6,7},{7,8},{5,8},{7,9},{9,10},{10,11},{9,11}
        };
        var v = 12;
        /* int[][] ans =  */ bridges(v, edges); 
        System.out.println();
    }
    
    public static int timer = 0;
    public static List<List<Integer>> bridgesList;

    public static void bridges(int v, int edges[][]){
        // Create adj list
        var graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] a : edges){
            graph.get(a[0]).add(a[1]);
            graph.get(a[1]).add(a[0]);
        }
        System.out.println(graph);
        // Requesites
        int[] vis = new int[v];
        int[] timeInsertion = new int[v];
        int[] lowestTime = new int[v];
        bridgesList = new ArrayList<List<Integer>>();
        dfs(0, -1, graph, vis, timeInsertion, lowestTime);
        System.out.println(bridgesList);
    }

    public static void dfs(int node, int par, List<List<Integer>> graph, int[] vis, int[] tin, int[] lowest){
        vis[node] = 1;
        tin[node] = lowest[node] = timer;
        timer++;
        for (int neighbour : graph.get(node)) {
            if(par == neighbour) continue;
            if(vis[neighbour] == 0){
                dfs(neighbour, node, graph, vis, tin, lowest);
                lowest[node] = Math.min(lowest[node], lowest[neighbour]);
                // To check if edge node-----neighbour is a bridge
                if(tin[node] < lowest[neighbour]){
                    bridgesList.add(Arrays.asList(node, neighbour));
                }
            }else{
                lowest[node] = Math.min(lowest[node], lowest[neighbour]);
            }
        }
    }
}
