package ProblemSolving.DP.ZeroOneKnapSack;

public class MinSubsetSumDiff {

    public static void main(String[] args) {
        int arr[] = {2,2,3,2};
        minSubsetSumDiff(arr);
        System.out.println(minDiff);
    }
    
    static int minDiff = Integer.MAX_VALUE;
    
    public static void minSubsetSumDiff(int[] arr) {
        int totalSum = 0;
        for (int i : arr) {
            totalSum += (i);
        }
        boolean validSums[] = subsetOfSum(arr, totalSum);
        for (int i = 0; i < validSums.length/2; i++) {
            if(validSums[i])
                minDiff = Math.min(minDiff, totalSum-2*i);
        }
    }

    public static boolean[] subsetOfSum(int[] arr, int sum) {
        boolean dp[][] = new boolean[arr.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i-1][j];
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[dp.length-1];
    }
    



    
}
