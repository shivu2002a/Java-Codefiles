package StronglyConnectedComponents;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Collections.stack;

/*
    0 <----- 2 -------> 3 -------- > 4 ---- > 7
    |        ^                      | ^       ^
    |       /                       |  \     /
    |      /                        |   \   /
    |     /                         v    \ /
    |    /                          5 --> 6
    |   /
    |  /
    v /
    1 
 */

public class KosarajuAlgo {

    private void dfs(int node, int vis[], List<List<Integer>> list, Stack<Integer> st){
        vis[node] = 1;
        for(Integer neighbour : list.get(node)){
            if(vis[neighbour] == 0)
                dfs(neighbour, vis, list, st);
        }
        st.push(node);
    }

    private void dfs2(int node, int vis[], List<List<Integer>> list){
        vis[node] = 1;
        for(Integer neighbour : list.get(node)){
            if(vis[neighbour] == 0)
                dfs2(neighbour, vis, list);
        }
    }

    public int kosaraju(int v, List<List<Integer>> list){
        
        //Sort the edges according to lowest finish time
        var st = new Stack<Integer>();
        int vis[] = new int[v];
        for (int i = 0; i < v; i++) {
            if(vis[i] == 0){
                dfs(i, vis, list, st);
            }
        }

        //Create a reverse graph
        var revList = new ArrayList<List<Integer>>(8);
        for (int i = 0; i < v; i++) {
            revList.add(new ArrayList<>());
        }
        for (int i = 0; i < vis.length; i++) {
            vis[i] = 0;
            for (Integer neigh : list.get(i)) {
                revList.get(neigh).add(i);
            }
        }
        System.out.println(revList);
        //Run DFS
        var scc = 0;
        while (!st.isEmpty()) {
            var node = st.pop();
            if(vis[node] == 0){
                scc++;
                dfs2(node, vis, revList);
            }
        }
        return scc;
    }

    public static void main(String[] args) {
        var adjList = new ArrayList<List<Integer>>(8);
        var n = 8;
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(2).add(0);
        adjList.get(2).add(3);
        adjList.get(3).add(4);
        adjList.get(4).add(5);
        adjList.get(4).add(7);
        adjList.get(5).add(6);
        adjList.get(6).add(4);
        adjList.get(6).add(7);
        System.out.println(adjList);
        var countScc = new KosarajuAlgo();
        System.out.println(countScc.kosaraju(n, adjList));
    }
    
}
