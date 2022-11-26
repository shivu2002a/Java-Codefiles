package DisjointSets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge>{

    int src, dest, weight;

    
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}
public class KruskalAlgo {

    public static int minSpanTree(int v, List<List<List<Integer>>> adj){
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);
                int weight = adj.get(i).get(j).get(1); 
                int node = i;
                edges.add(new Edge(node, adjNode, weight));
            }   
        }
        int mincost = 0;
        DisjointSet ds = new DisjointSet(v);
        Collections.sort(edges);
        for (Edge edge : edges) {
            int s = edge.src;
            int d = edge.dest;
            int w = edge.weight;
            if(ds.findUltParent(s) != ds.findUltParent(d)){
                mincost += w;
                ds.unionBySize(s, d);
            }
        }
        return mincost;
    } 

    public static void main(String[] args) {
        // List<List<List<Integer>>> adj = new ArrayList<List<List<Integer>>>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(1);
        l.add(5);
        list.add(l);
    }
}
