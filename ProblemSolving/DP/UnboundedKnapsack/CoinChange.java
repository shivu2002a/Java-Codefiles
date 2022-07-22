package ProblemSolving.DP.UnboundedKnapsack;

/**
 * Given an array of coins and sum, find the number of ways to make the given sum using those coins
   where the coins supply is unlimited (you can use any coin any number of times)
    Sample Input -> arr = {1,2,3}, sum = 5
    Sample Output -> 5
    Number of ways -> 1+1+1+1+1
                      1+1+1+2
                      1+1+3
                      2+2+1
                      2+3

    Author : Shivanagouda S A 
 */


public class CoinChange {

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        System.out.println(change(5, arr));
    }

    public static int change(int sum, int[] coins) {
        int dp[][] = new int[coins.length + 1][sum+1];
        for(int i = 0;  i< dp[0].length; i++)
            dp[0][i] = 0;
        for(int i = 0;  i< dp.length; i++)
            dp[i][0] = 1;
        for(int i = 1; i < dp.length; i++){
            for(int j= 1; j < dp[0].length; j++){
                dp[i][j] = dp[i-1][j];
                if(coins[i-1] <= j)
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    
}
