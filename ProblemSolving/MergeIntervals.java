package ProblemSolving;
import java.util.*;
/*
    Given an array of intervals, merge intervals if they overlap
*/

class MergeIntervals {

    public static void main(String Args[]) {
        int[][] arr = {{1,4},{4,5},{3,7},{2,17},{3,9},{4,5},{4,5},{4,4}};
        System.out.println(Arrays.deepToString(merge(arr)));
    }

    public static int[][] merge(int[][] arr) {
        if(arr == null || arr.length == 1)
            return arr;
        Arrays.sort(arr, (i,j) -> Integer.compare(i[0], j[0]));
        
        List<int[]> list = new LinkedList<>(); 
        System.out.println(Arrays.deepToString(arr));
        int[] curr = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(curr[1]-arr[i][0] >= 0 && arr[i][1] > curr[1]){
                curr[1] =  arr[i][1];
            }else if(arr[i][1] > curr[1]) {
                list.add(curr);
                curr = arr[i];
            }
        }
        list.add(curr);
        int[][] a = new int[list.size()][];
        int i = 0;
        for(int[] b : list)
            a[i++] = b;
        return a;
    }

}