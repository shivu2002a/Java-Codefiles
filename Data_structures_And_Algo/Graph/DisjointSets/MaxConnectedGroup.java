package DisjointSets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxConnectedGroup {

    public static int findMaxConnGroup(int grid[][]) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        // STEP_1: Connect comps
        System.out.println(Arrays.deepToString(grid));
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) continue;
                int dx[] = { -1, 0, 1, 0 };
                int dy[] = { 0, -1, 0, 1 };
                int nodeNumber = (row * n) + col;
                for (int ind = 0; ind < 4; ind++) {
                    int adjr = row + dx[ind];
                    int adjc = col + dy[ind];
                    if(isValid(adjr, adjc, n) && grid[adjr][adjc] == 1) {
                        int adjNodeNumber = (adjr * n) + adjc;
                        ds.unionBySize(nodeNumber, adjNodeNumber);
                    }
                }
            }
        }

        int max = 0;
        // STEP 2: Convert 0 and check max group size
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {
                if (grid[row][col] == 1)
                    continue;
                int dx[] = { -1, 0, 1, 0 };
                int dy[] = { 0, -1, 0, 1 };
                Set<Integer> comps = new HashSet<>();
                for (int ind = 0; ind < dy.length; ind++) {
                    int adjr = row + dx[ind];
                    int adjc = col + dy[ind];
                    if (isValid(adjr, adjc, n) && grid[adjr][adjc] == 1) {
                        int adjNodeNumber = (adjr * n) + adjc;
                        comps.add(ds.findUltParent(adjNodeNumber));
                    }
                }
                int size = 0;
                for (Integer node : comps) {
                    size += ds.size[node];
                }
                System.out.println(size);
                max = Math.max(max, size  + 1);
            }
            for (int i = 0; i < n*n; i++) {
                max = Math.max(max, ds.size[ds.findUltParent(i)]);
            }
        }

        for (int i = 0; i < n*n; i++) {
            max = Math.max(max, ds.size[ds.findUltParent(i)]);
        }
        return max;
    }

    private static boolean isValid(int adjr, int adjc, int n) {
        return adjr >= 0 && adjc >= 0 && adjr < n && adjc < n;
    }

    public static void main(String[] args) {
        int arr[][] = {
                { 1, 1, 0, 1, 1 },
                { 1, 1, 0, 1, 1 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 1, 1, 1 },
                { 0, 0, 1, 1, 1 }
        };
        System.out.println(findMaxConnGroup(arr));
    }
}
