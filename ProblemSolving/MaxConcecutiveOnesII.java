package ProblemSolving;

/* 
 * Max Consecutive Ones II
 * Count maximum consecutive ones with one swap allowed (0 -> 1)
 * Example 1: 1,1,1,0,1,1,1,0 -> ans : 6
 * Example 2: 1,1,1,0,1,1,1,0,0,1 -> ans : 7
 */
public class MaxConcecutiveOnesII {

    public static void main(String args[]) {
        System.out.println(countConsecOnes(new int[]{1,1,1,0,1,1,1,0,0,1}));
        System.out.println(countConsecOnes(new int[]{1,1,1,0,1,1,1,0,0,0,0}));
        System.out.println(countConsecOnes(new int[]{1,1,1,1,1,1}));
    }

    public static int countConsecOnes(int[] arr) {
        int n = arr.length, ones = 0, ans = 0, temp = 0;
        int[] left = new int[n], right = new int[n];
        for (int i = 0; i < n; i++) {
            if(arr[i] == 1) {
                ones++;
                temp++;
                ans = Math.max(ans, temp); 
            } else {
                temp = 0;
            }
        }
        left[0] = arr[0] == 1 ? 1 : 0;
        right[n-1] = arr[n-1] == 1 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] == 1) {
                left[i] = left[i-1] + 1;
            } 
        }
        for (int i = n-2; i >= 0; i--) {
            if(arr[i] == 1) {
                right[i] = right[i+1] + 1;
            }
        }
        for (int i = 1; i < n -1; i++) {
            if(arr[i] == 0) {
                int curTotal = left[i-1] + right[i+1];
                if(curTotal < ones) {
                    ans = Math.max(ans, curTotal + 1);
                } else {
                    ans = Math.max(ans, curTotal);
                }
            }
        }
        return ans;
    }

    
}