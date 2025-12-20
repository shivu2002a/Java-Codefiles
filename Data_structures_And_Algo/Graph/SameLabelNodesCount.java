import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameLabelNodesCount {
    int ans[], vis[];

    public int[] dfs(List<List<Integer>> g, int start, String lb) {
        vis[start] = 1;
        int f[] = new int[26];
        for(int ch : g.get(start)) {
            if(vis[ch] == 1) 
                continue;
            int cha[] = dfs(g, ch, lb);
            for(int i = 0; i < 26; i++) {
                f[i] += cha[i];
            }
        }
        f[lb.charAt(start)-'a']++;
        ans[start] = f[lb.charAt(start)-'a'];
        return f;

    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ans = new int[n];
        vis = new int[n];
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < n; i++) 
            g.add(new ArrayList<>());
        for(int a[] : edges) {
            g.get(a[0]).add(a[1]);
            g.get(a[1]).add(a[0]);
        } 
        dfs(g, 0, labels);
        return ans;
    }

    public static void main(String[] args) {
        
        System.out.println(
            Arrays.toString(
                new SameLabelNodesCount()
                    .countSubTrees(5, new int[][]{{0,1},{0,2},{1,3},{0,4}}, "aabab")
            )
        );
    }
}
