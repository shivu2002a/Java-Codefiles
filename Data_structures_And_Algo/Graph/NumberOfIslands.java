package Data_structures_And_Algo.Graph;
/* 
* Given a matrix, where 1 indicates land and 0 indicates water, find the number of islands.
 */

public class NumberOfIslands {
    
    public static void main(String[] args) {
        int adjMatrix[][] = {
            {0,1,0,1,0,0,0,0,0,0,0},
            {1,0,0,1,0,0,0,0,0,0,0},
            {0,0,0,1,1,1,1,1,1,1,0},
            {0,1,1,1,0,0,1,0,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0},
            {0,0,0,1,1,0,0,0,0,0,0},
        };
        System.out.println(numsOfIsalnds(adjMatrix));
    }

    private static int numsOfIsalnds(int[][] adjMatrix) {
        int count = 0;
        boolean visited[][] = new boolean[adjMatrix.length][adjMatrix[0].length];
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[0].length; j++) {
                if(adjMatrix[i][j] == 1 && !visited[i][j]){
                    count++;
                    dfs(adjMatrix, visited, i, j);
                }
            }
        }     
        return count;
    }

    private static void dfs(int[][] adjMatrix, boolean[][] visited, int i, int j) {
        if(i < 0 || j < 0 || i == adjMatrix.length || j == adjMatrix[0].length || adjMatrix[i][j] == 0 || visited[i][j])
            return;
        visited[i][j] = true;
        dfs(adjMatrix, visited, i-1, j);
        dfs(adjMatrix, visited, i, j-1);
        dfs(adjMatrix, visited, i+1, j);
        dfs(adjMatrix, visited, i, j+1);
    }
}
