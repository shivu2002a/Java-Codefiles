package ProblemSolving.DP.ZeroOneKnapSack;
/*
 *Given an arrays, state whether it is possible to divide array into two subsets of equal sum 
 */
public class PartitionIntoEqualSum {

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 6, 8, 10};
        System.out.println(equalSumPartition(arr));
    }

    public static boolean equalSumPartition(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if(sum % 2 == 1){
            return false;
        }
        // if sum is even, only then can we make equal sum partitions where 
        // each partition should have sum equal to half of total sum 
        return SubsetWithGivenSum.subsetOfSum(arr, sum/2);
    }
}
