package ProblemSolving.BackTrack;

import java.util.*;

public class CombinationSum {
    
    public static void main(String[] args) {
        int arr[] = {2,5,3,6};
        int n = 10;
        System.out.println(combSum(arr, n));
    }

    public static List<List<Integer>> combSum(int[] nums, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        helperCombsum(res, new ArrayList<>(), nums, sum, 0);
        return res;
    }

    public static void helperCombsum(List<List<Integer>> res, List<Integer> list, int[] nums, int sum, int start) {
        if(sum == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum < 0)
            return;
        for (int j = start; j < nums.length; j++) {
            if (nums[j] > sum ) {
                continue;
            }
            list.add(nums[j]);
            helperCombsum(res, list, nums, sum-nums[j], j);
            list.remove(list.size()-1);
        }
    }
}
