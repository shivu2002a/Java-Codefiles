package ProblemSolving.BackTrack;
/*
 * Problem statement: Given n, generate different permutations of valid parenthesis( "()" ) of size n
 * Sample Input: n = 2
 * Sample Output: ()(), (())
 * 
 * Author: Shivanagouda S A
 */
import java.util.*;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        return utilGenerate(new ArrayList<String>(), new StringBuilder(), 0, 0, n);
    }

    public static List<String> utilGenerate(List<String> res, StringBuilder sb, int open, int close, int n) {
        if(sb.length() == n*2){
            res.add(sb.toString());
            return res;
        }
        if(open < n){
            sb.append('(');
            utilGenerate(res, sb, open + 1, close, n);
            sb.setLength(sb.length()-1);
        }
        if (close < open) {
            sb.append(')');
            utilGenerate(res, sb, open, close+1, n);
            sb.setLength(sb.length()-1);
        }
        return res;

    }
    
}
