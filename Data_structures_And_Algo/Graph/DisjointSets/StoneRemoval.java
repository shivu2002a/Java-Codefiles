package DisjointSets;

import java.util.HashMap;
import java.util.Map;

/** 
 * Given 2d arr[][ which indicates ar[xi, yi] = 1 (presence of stone)
 * To remove a stone, at least one other stone should be in the same col or row
 * @Return max stones that can be removed
 * 
 */
class DS{
    int parent[], size[];

    public DS(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int parent(int node){
        while(parent[node] != node){
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }

    public void union(int a, int b){
        int pu = parent(a);
        int pv = parent(b);
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

public class StoneRemoval {
    
    public static int maxStone (int n, int[][] arr){
        int mr = 0, mc = 0, comps = 0;
        for (int[] is : arr) {
            mr = Math.max(mr, is[0]);
            mc = Math.max(mc, is[1]);
        }
        DS ds = new DS(mr + mc + 1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] a : arr) {
            ds.union(a[0], a[1]);
            map.put(a[0], 1);
            map.put(a[1], 1);
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(ds.parent[e.getKey()] == e.getKey()) comps++;
        }
        return n - comps;
    }

    public static void main(String[] args) {
        int n = 6;
        int arr[][] = {
            {0, 0},{0, 1},{1, 0},{1, 2},{2, 1}, {2, 2}
        };
        System.out.println(maxStone(n, arr));
    }
}
