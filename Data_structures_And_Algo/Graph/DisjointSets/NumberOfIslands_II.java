package DisjointSets;

import java.util.ArrayList;
import java.util.List;
/** 
 * @param Grid of 0's and 1's is given and 2D array of queries
 * query[i] = [row, col] -> set the given position to 1 and count the no of islands
 * @return List of no. of islands at i'th query at i'th index   
*/

public class NumberOfIslands_II {

    public static List<Integer> numberOfIslands(int m, int n, int q[][]){
        DisjointSet ds = new DisjointSet(n*m);
        int visited[][] = new int[m][n];
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int dx[] = { -1,  0, 1,  0};
        int dy[] = {  0,  1, 0, -1};
        for (int a[] : q) {

            int r = a[0];
            int c = a[1];
            if(visited[r][c] == 1){
                res.add(count);
                continue;
            }

            //visit and imagine it's alone
            visited[r][c] = 1;
            count++;
            for (int ind = 0; ind < dy.length; ind++) {
                int adjr = r + dx[ind];
                int adjc = c + dy[ind];
                if(isValid(adjr, adjc, m, n)){
                    if( visited[adjr][adjc] == 1){
                        int nodeNumber = (r * n) + c;
                        int adjNodeNumber = (adjr * n) + adjc;
                        //Not connected, decrease count because they'll get connected
                        if(ds.findUltParent(nodeNumber) != ds.findUltParent(adjNodeNumber)){
                            count--;
                        }
                        ds.unionBySize(nodeNumber, adjNodeNumber);
                    }
                }
            }
            res.add(count);
        }
        return res;
    }

    private static boolean isValid(int adjr, int adjc, int m, int n) {
        if(adjr < 0 || adjc < 0 || adjr == m || adjc == n)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int arr[][] = {{0,0}, {0, 0},{1, 1}, {1, 0}, {0, 1}, {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0,2}};
        System.out.println(numberOfIslands(4, 5, arr));
    }
    
}
