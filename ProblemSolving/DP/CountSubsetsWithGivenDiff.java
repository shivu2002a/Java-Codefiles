package ProblemSolving.DP;

/**
 * Count number of Subsets pairs With given diff
 * Author : Shivanagouda S A
 * 
 * Main idea :
 *   Subset 1: s1, subset 2: s2
 *   s1 - s2 = diff
 *   s1 + s2 = sum(Array) 
 *   adding above eqs we get, s1 = (diff + sum(arr)) / 2 
 * Constraint : arr[i] > 0
 */
public class CountSubsetsWithGivenDiff {

    public static void main(String[] args) {
        int arr[] = {2,1,1,3};
        int diff = 1;
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }
        int findSum = (totalSum + diff) / 2;
        System.out.println(CountOfSubsetsOfGivenSum.countSubsetsOfSum(arr, findSum));
    }
    
}