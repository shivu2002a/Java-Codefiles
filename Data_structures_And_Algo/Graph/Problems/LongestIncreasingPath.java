package Problems;
public class LongestIncreasingPath {
    
    public static int lip(int arr[][]){
        int m = arr.length, n = arr[0].length; 
        int dp[][] = new int[m][n];
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dfs(arr, i, j, dp, Integer.MIN_VALUE);       
            }
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                max = Math.max(max, dp[i][j]);       
            }
        }
        return max;
    }

    private static int dfs(int[][] arr, int i, int j, int[][] dp, int prev) {
        if(i < 0 || j < 0 || i == dp.length || j == dp[0].length || prev >= arr[i][j])
            return 0;
        if(dp[i][j] > 0) return dp[i][j];
        int tempMax = 0;
        tempMax = Math.max(tempMax, dfs(arr, i + 1, j, dp, arr[i][j]));
        tempMax = Math.max(tempMax, dfs(arr, i - 1, j, dp, arr[i][j]));
        tempMax = Math.max(tempMax, dfs(arr, i, j + 1, dp, arr[i][j]));
        tempMax = Math.max(tempMax, dfs(arr, i, j - 1, dp, arr[i][j]));
        dp[i][j] = ++tempMax;
        return tempMax;
    }

    public static void main(String[] args) {
        int arr[][] = {
            {9,9,4},
            {6,6,8},
            {2,1,1},
        };
        System.out.println(lip(arr));
    }
}
