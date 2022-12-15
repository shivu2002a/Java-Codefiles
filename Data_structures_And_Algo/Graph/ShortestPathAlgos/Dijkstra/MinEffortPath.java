package ShortestPathAlgos.Dijkstra;
/** 
 * You're to move from top-left corner to bottom-right corner. Calc min effort path.
 * @implNote Minimum Effort is the maximum absolute difference between two consec cells
 */
public class MinEffortPath {
 
    public static void main(String[] args) {
        int arr[][] = {
            {1, 2, 2},
            {3, 8, 2},
            {5, 3 ,5}
        };
        System.out.println(minEffort(arr));
    }

    static int max = 0;
    private static int minEffort(int[][] arr) {
        max = 0;
        dfs(arr, 0, 0, 0);
        return max;
    }
    private static void dfs(int[][] arr, int r, int c, int prev) {

        if(r < 0 || c < 0 || r == arr.length || c == arr[0].length)
            return;
        if(r == arr.length && c == arr[0].length){
            max = Math.max(max, Math.abs(prev - arr[r][c]));
            return;
        }
        if(!(r == 0 && c == 0)){

        }else{
            max = Math.max(max, Math.abs(prev - arr[r][c]));
            
        }
        dfs(arr, r + 1, c, arr[r][c]);
        dfs(arr, r, c + 1, arr[r][c]);
    }

    
}
