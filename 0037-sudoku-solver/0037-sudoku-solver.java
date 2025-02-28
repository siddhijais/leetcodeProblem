import java.util.*;

class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rowUsed = new boolean[9][9];
        boolean[][] colUsed = new boolean[9][9];
        boolean[][] boxUsed = new boolean[9][9];

        // Initialize the boolean tracking arrays
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '1';
                    int boxIndex = (r / 3) * 3 + (c / 3);
                    rowUsed[r][num] = true;
                    colUsed[c][num] = true;
                    boxUsed[boxIndex][num] = true;
                }
            }
        }

        helper(board, 0, 0, rowUsed, colUsed, boxUsed);
    }

    private boolean helper(char[][] board, int row, int col, boolean[][] rowUsed, boolean[][] colUsed, boolean[][] boxUsed) {
        if (row == 9) return true; // Sudoku solved

        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col == 8) ? 0 : col + 1;

        if (board[row][col] != '.') {
            return helper(board, nextRow, nextCol, rowUsed, colUsed, boxUsed);
        }

        for (char dig = '1'; dig <= '9'; dig++) {
            int num = dig - '1';
            int boxIndex = (row / 3) * 3 + (col / 3);

            if (!rowUsed[row][num] && !colUsed[col][num] && !boxUsed[boxIndex][num]) {
                board[row][col] = dig;
                rowUsed[row][num] = colUsed[col][num] = boxUsed[boxIndex][num] = true;

                if (helper(board, nextRow, nextCol, rowUsed, colUsed, boxUsed)) {
                    return true; // Solution found
                }

                // Backtrack
                board[row][col] = '.';
                rowUsed[row][num] = colUsed[col][num] = boxUsed[boxIndex][num] = false;
            }
        }

        return false; // No valid number found
    }
}
