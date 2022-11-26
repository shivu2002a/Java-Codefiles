import java.util.Arrays;

// package Data_structures_And_Algo.Graph;


public class FloodFillAlgorithm {
    
    //Don't tamper with the data. It's a SE best practice to work on it, not manipulate it
    public static int[][] floodFill(int grid[][], int r, int c, int newColour){
        
        int adj[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                adj[i][j] = grid[i][j];
            }
        } 
        int col = grid[r][c];
        dfs(adj, r, c, col, newColour);
        return grid;
    }

    public static void dfs(int grid[][], int r, int c, int oldCol, int newCol){
        if(c < 0 || r < 0 || r == grid.length || c == grid[0].length || grid[r][c] != oldCol)
            return;
        grid[r][c] = newCol;
        dfs(grid, r + 1, c, oldCol, newCol);
        dfs(grid, r, c - 1, oldCol, newCol);
        dfs(grid, r - 1, c, oldCol, newCol);
        dfs(grid, r, c + 1, oldCol, newCol);
    }

    public static void main(String[] args) {
        int adj[][] = {
            {1, 2, 3, 4, 5},
            {1, 1, 2, 2, 2},
            {1, 2, 1, 1, 1},
            {1, 2, 1, 1, 1}
        };
        floodFill(adj, 3, 1, 5);
        for (int[] is : adj) {
            System.out.println(Arrays.toString(is));
        }
    }
}
