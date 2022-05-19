package ProblemSolving.BackTrack;

import java.util.*;

public class Subsets {
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        System.out.println(subsets(null));
        System.out.println(subsets(arr));

    }

    public static List<List<Integer>> subsets(int arr[]){
        List<List<Integer>> res = new ArrayList<>();
        if(arr == null)
            return res;
        backtrack(res, new ArrayList<>(), arr, 0);
        return res;
        
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> curr, int arr[], int start) {
        res.add(new ArrayList<>(curr));
        for (int j = start; j < arr.length; j++) {
            curr.add(arr[j]);
            backtrack(res, curr, arr, j+1);
            curr.remove(curr.size()-1);

        }
    }
}
