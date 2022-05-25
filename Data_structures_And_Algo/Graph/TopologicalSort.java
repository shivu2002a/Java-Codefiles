package Data_structures_And_Algo.Graph;

import java.util.*;

public class TopologicalSort {
    
    public static void main(String[] args) {
        int adj[][] = { 
             {0, 0, 1, 1, 0, 0},
             {0, 0, 1, 0, 1, 0},
             {0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 1},
             {0, 0, 0, 0, 0, 1},
             {0, 0, 0, 0, 0, 0},
        };
        topologicalSort(adj);
    }
    
    private static void topologicalSort(int[][] adj) {
        Stack<Integer> stack = new Stack<>();
        int visited[] = new int[adj.length];
        
        for(int i = 0; i < adj.length; i++){
            if(visited[i] == 0) {
                topoUtil(i, adj, visited, stack);
                System.out.println(Arrays.toString(visited));
            }
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    
    private static void topoUtil(int i, int[][] adj, int[] visited, Stack<Integer> stack) {
        visited[i] = 1;
        for(int j = i; j < adj.length; j++){
            if(adj[i][j] == 1 && visited[j] != 1){
                topoUtil(j, adj, visited, stack);
            }
        }
        stack.push(i);
    }
    
}
