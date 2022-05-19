package ProblemSolving.BackTrack;
/*
Solving 9 X 9 sudoku by backtracking 
Time Complexity - 0(9^m) where m = number of empty spaces
*/

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        if(board == null)
            return;
        solve(board);
    }
    private boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9'; k++){
                        if(isValidSudoku(board, i, j, k)){
                            board[i][j] = k;
                            if(solve(board))    
                                return true;
                            else
                                board[i][j] = '.'; 
                        }
                    }
                    // Empty space but 1-9 is not valid 
                    return false;
                }
            }
        }
        //No empty spaces
        return true;
    }
    
    private boolean isValidSudoku(char[][] board, int row, int col, char k) {
        int i = 0;
        // check row, col
        while(i < 9){
            if((board[row][i] != '.' && board[row][i] == k) || (board[i][col]  != '.' && board[i][col] == k))
                return false;
            i++;
        }

        // check 3 X 3 box
        row -= row%3;
        col -= col%3;
        for(i = row; i < row+3; i++ ){
            for(int j = col; j < col+3; j++){
                if(board[i][j] != '.' && board[i][j] == k)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char board[][] = {
            {'6', '.', '.', '.','.', '.', '.', '.', '.'},
            {'1', '8', '.', '.','.', '.', '.', '.', '.'},
            {'.', '.', '.', '.','.', '.', '.', '.', '.'},
            {'.', '.', '.', '.','.', '.', '.', '.', '.'},
            {'.', '.', '.', '.','.', '.', '.', '.', '.'},
            {'.', '.', '.', '.','.', '.', '.', '.', '.'},
            {'.', '.', '.', '.','.', '.', '.', '.', '.'},
            {'.', '.', '.', '.','.', '.', '.', '.', '.'},
            {'.', '.', '.', '.','.', '.', '.', '.', '.'},
        };
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
                if( j != 0 && j%3 == 2)
                    System.out.print(" ");
            }
            if( i != 0 && i%3 == 2)
                    System.out.println();
            System.out.println();
        }
    }
    
}
