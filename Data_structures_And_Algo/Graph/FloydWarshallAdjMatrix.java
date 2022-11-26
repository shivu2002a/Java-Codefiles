package Data_structures_And_Algo.Graph;

import static java.lang.Double.POSITIVE_INFINITY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Double.NEGATIVE_INFINITY;

public class FloydWarshallAdjMatrix {
    
    int n;
    double dp[][];
    Integer next[][];
    boolean solved;

    private static final int NEGATIVE_CYCLE = -1;

    public FloydWarshallAdjMatrix( double[][] adjMatrix){
        n = adjMatrix.length;
        dp = new double[n][n];
        next = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = adjMatrix[i][j];
                if(adjMatrix[i][j] != POSITIVE_INFINITY)
                    next[i][j] = j;
            }
        }
    }

    public double[][] solve(){
        findAPSPMatrix();
        return dp;
    }

    private void findAPSPMatrix() {
        if(solved)
            return;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < dp.length; k++) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < dp.length; k++) {
                    if (dp[i][k] != POSITIVE_INFINITY &&  dp[k][j] != POSITIVE_INFINITY &&  dp[k][k] < 0) {
                        dp[i][j] = NEGATIVE_INFINITY;
                        next[i][j] = NEGATIVE_CYCLE;
                    }
                }
            }
        }
        solved = true;
    }

    public List<Integer> constructShortestPath(int start, int end){
        solve();
        List<Integer> path = new ArrayList<>();
        if (dp[start][end] == POSITIVE_INFINITY) {
            return path;
        }
        int at = start;
        for(; at != end; at = next[at][end]){
            if (at == NEGATIVE_CYCLE) {
                return null;
            }
            path.add(at);
        }
        if (next[at][end] == NEGATIVE_CYCLE) {
            return null;
        }    
        path.add(end);
        return path;
    }

    public static double[][] graph(int n){
        double matrix[][] = new double[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], POSITIVE_INFINITY);
            matrix[i][i] = 0;
        }
        return matrix;
    }

    public static void main(String[] args) {
        // int n = 4; 
    }
}
