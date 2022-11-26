package DisjointSets;

import java.util.Arrays;

class DS{
    int[] parent, size;

    DS(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
           parent[i] = i;
           size[i] = 1; 
        }
    }

    public int findUP(int node){
        if(parent[node] == node) return node;
        return parent[node] = findUP(parent[node]);
    }
    
    public void union(int u, int v){
        int pu = findUP(u);
        int pv = findUP(v);
        if(pu == pv) return;
        if(size[pu] > size[pv]){
            parent[pv] = pu;
            size[pu] += size[pv];
        }else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}

public class RedundantConnection {
    
    public static int[] findRedundantConnection(int[][] edges) {
        DS ds = new DS(10001);
        int[] remove = new int[2];
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            if(ds.findUP(a) == ds.findUP(b)) remove = edge;
            else ds.union(a, b);
        }
        return remove;
    }

    public static void main(String[] args) {
        int edges[][] = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }
}
