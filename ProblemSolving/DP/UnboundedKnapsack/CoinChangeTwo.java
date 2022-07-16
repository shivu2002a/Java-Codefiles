package ProblemSolving.DP.UnboundedKnapsack;

/* 
 * Given an array of coins and sum, find the minimum number of coind to make the given sum using those coins
   where the coins supply is unlimited (you can use any coin any number of times)
    Sample Input -> arr = {1,2,3}, sum = 5
    Sample Output -> 2
    Explainaition:
    Number of ways -> 1+1+1+1+1
                      1+1+1+2
                      1+1+3
                      2+2+1
                      2+3
    Minimum number of coins in case of {2,3} is 2

    Author : Shivanagouda S A 
 */
public class CoinChangeTwo {

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        System.out.println(minNumOfCoins(5, arr));
    }

    private static int minNumOfCoins(int sum, int[] coins) {
        if(sum == 0)
            return 0;
        int dp[][] = new int[coins.length + 1][sum+1];
        //1st row
        for(int i = 0;  i< dp[0].length; i++)
            dp[0][i] = Integer.MAX_VALUE-1;
        //1st col
        for(int i = 1;  i< dp.length; i++)
            dp[i][0] = 0;
        //2nd row
        for(int i = 1, j = 1;  j < dp[0].length; j++){
            if(j%coins[0] == 0){
                dp[i][j] = j/coins[0];
            }else
                dp[1][j] = Integer.MAX_VALUE-1;
        } 
        
        for(int i = 2; i < dp.length; i++){
            for(int j= 1; j < dp[0].length; j++){
                if(coins[i-1] <= j)
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]]+1 , dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1] == Integer.MAX_VALUE-1 ? -1 : dp[dp.length-1][dp[0].length-1];
    }
    
}
