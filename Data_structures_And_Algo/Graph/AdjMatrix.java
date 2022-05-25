package Data_structures_And_Algo.Graph;

import java.util.*;

public class AdjMatrix {

    public static void main(String[] args) {
        int adj[][] = { {0,1,1,1,0},  
                        {0,0,1,0,0},
                        {0,0,0,0,1},
                        {0,0,1,0,0},
                        {0,0,0,0,0}
                      };
        System.out.println(bfs(adj, 0));
        if (checkPath(adj,3,4))
            System.out.println("path exists");
    }

    public static int[] visited = new int[5];
    
    private static boolean checkPath(int[][] adj, int source, int dest) {
        visited[source] = 1;
        if(adj[source][dest] == 1){
            return true;
        }
        for (int place = 0; place < visited.length; place++) {
            if(adj[source][place] == 1){
                if(visited[place] != 1)
                    if(checkPath(adj, place, dest))
                        return true;
                    else
                        visited[place] = 1;
            }
        }
        return false;
    }

    public static List<List<Integer>> bfs(int[][] adj, int start){
        int visited[] = new int[adj.length];
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        list.add(start);
        res.add(list);
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            list = new ArrayList<>();
            int v = q.poll();
            visited[v] = 1;
            for (int i = 0; i < visited.length; i++) {
                if(adj[v][i] == 1){
                    if (visited[i] != 1) {
                        list.add(i);
                        visited[i] = 1;
                        q.offer(i);
                    }
                }
            }
            if(list.size() != 0)
                res.add(list);
        }
        return res;
    }
    
}
