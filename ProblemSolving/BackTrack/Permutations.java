package ProblemSolving.BackTrack;

import java.util.*;
public class Permutations {
    
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        System.out.println(permutations(null));
        System.out.println(permutations(arr));

    }

    public static List<List<Integer>> permutations(int arr[]){
        List<List<Integer>> res = new ArrayList<>();
        if(arr == null || arr.length == 0)
            return res;
        backtrack(res, new ArrayList<>(), arr);
        return res;
        
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> curr, int arr[]) {
        if(curr.size() == arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if (curr.contains(arr[j])) {
                continue;
            }
            curr.add(arr[j]);
            backtrack(res, curr, arr);
            curr.remove(curr.size()-1);

        }
    }
}
