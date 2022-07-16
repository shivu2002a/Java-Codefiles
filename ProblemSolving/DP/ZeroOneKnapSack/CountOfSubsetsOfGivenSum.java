package ProblemSolving.DP.ZeroOneKnapSack;
/* 
 * Find the number of subsets with sum equal to target sum
 * Author : Shivanagouda S A 
*/

public class CountOfSubsetsOfGivenSum {
    
    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 6, 8, 10};
        System.out.println(countSubsetsOfSum(arr, 10));
    }

    public static int countSubsetsOfSum(int[] arr, int sum) {
        int dp[][] = new int[arr.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i-1][j];
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[arr.length][sum];
    }
}
