import java.util.*;

public class DfsMessageQuery {

    public Map<Integer, List<Integer>> graph;
    int dfs[], tin[], subtreesize[], counter = 1;

    DfsMessageQuery(Map<Integer, List<Integer>> graph, int nodes) {
        this.graph = graph;
        this.dfs = new int[nodes + 1];
        this.tin = new int[nodes + 1];
        this.subtreesize = new int[nodes + 1];
    }

    public void dfs(int node) {
        dfs[counter] = node;
        tin[node] = counter;
        subtreesize[node] = 1;
        counter++;

        if(!graph.containsKey(node)) return;
        for(int child : graph.get(node)) {
            dfs(child);
            subtreesize[node] += subtreesize[child];
        }
    }

    public int getNthReciever(int start, int nth) {
        if (this.subtreesize[start] < nth) {
            return -1;
        }
        return dfs[tin[start] + nth - 1];
    }

    public static void main(String[] args) {
        int[] pars = new int[]{-1, 1, 1, 1, 1, 5, 5, 5, 6, 7};
        int[][] query = new int[][]{
                {1,2},{4,5}, {5,6}
        };
         int ans[] = solve(pars, query);
    }

    public static int[] solve(int[] pars, int[][] q) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        adj.put(0, new ArrayList<>());
        for (int i = 1; i < pars.length; i++) {
            int child = i + 1;
            int parent = pars[i];
            adj.computeIfAbsent(parent, k -> new ArrayList<>());
            adj.get(parent).add(child);
        }
        System.out.println(adj);
        DfsMessageQuery obj = new DfsMessageQuery(adj, 10);
        obj.dfs(1);
        System.out.println(Arrays.toString(obj.subtreesize));

        int[] res = new int[q.length];
        int i = 0;
        for (int[] a : q) {
            res[i++] = obj.getNthReciever(a[0], a[1]);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
    
}
