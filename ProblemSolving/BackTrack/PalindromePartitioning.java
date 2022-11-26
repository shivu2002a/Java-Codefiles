package ProblemSolving.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        bt(s, list, new ArrayList<>(), 0, s.length()-1); 
        return list;
    }
    
    public static void bt(String s, List<List<String>> res, List<String> list, int low, int high){
        if(low > high){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = low; i <= high; i++){
            System.out.println(list);
            if(isPal(s, low, i)){
                list.add(s.substring(low, i + 1));
                bt(s, res, list, i  + 1, high);
                list.remove(list.size()-1);
            }
        }
    }
                         
    public static boolean isPal(String s, int i, int j){
        while(i <= j)
            if(s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }
}
