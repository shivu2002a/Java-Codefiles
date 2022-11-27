package ProblemSolving.DP.LongestCommonSubsequence.Recursive;

import java.util.Arrays;

class LCS {

    static int dp[][];
    public static void main(String[] args) {
        System.out.println(lcs("abcdef", "abcdegfj"));
        System.out.println(lcs("abcdef", "abdegfj", new StringBuilder()));
    }

    public static int lcs(String a, String b) {
        dp = new int[a.length()+1][b.length()+1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return util(a, b, 0, 0, 0);
    }

    public static String lcs(String a, String b , StringBuilder sb) {
        return util(a, b, 0, 0, sb);
    }
    
    public static int util(String a, String b, int i, int j, int ans) {
        if (i == a.length() || j == b.length() || dp[i][j] != -1) {
            return dp[i][j];
        }
        if (a.charAt(i) == b.charAt(j)) {
            dp[i][j] = 1 + util(a, b, i + 1, j + 1, ans + 1);
        } else {
            dp[i][j] = Math.max(util(a, b, i + 1, j, ans), util(a, b, i, j + 1, ans));
        }
        return dp[i][j];

    }

    public static String util(String a, String b, int i, int j, StringBuilder sb) {
        if (i == a.length() || j == b.length()) {
            return sb.toString();
        }
        if (a.charAt(i) == b.charAt(j)) {
            return util(a, b, i + 1, j + 1, sb.append(b.charAt(j)));
        }
        String s1 = util(a, b, i + 1, j, new StringBuilder(sb));
        String s2 = util(a, b, i, j + 1, new StringBuilder(sb));
        return s1.length() > s2.length() ? s1 : s2;
    }

}