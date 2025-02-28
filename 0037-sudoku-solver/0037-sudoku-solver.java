import java.util.*;
class Solution {
boolean helper(char[][] board,int row, int col){
    if(row == board.length){
        return true;
    }
    int nrow = row, ncol = col+1;
    if(board[0].length == ncol){
        nrow = row+1;
        ncol = 0;
    }
    if(board[row][col] != '.'){
       return helper(board,nrow,ncol);
        }
        for(char dig = '1'; dig<='9'; dig++){
           if( isSafe(board,row,col,dig)){
                board[row][col] = dig;
                if(helper(board,nrow,ncol)){
                    return true;
                 }
                board[row][col] = '.';
            }
                      
        }
        return false;

    }
    boolean isSafe(char[][] board,int row, int col,int dig){
        for(int i = 0; i<board.length; i++){
            //check row
            if(board[i][col] == dig){
                return false;
            }
            //check col
           if(board[row][i] == dig){
                return false;
            }
            //check grid
            int subgridRow = 3*(row/3) + i/3;
            int subgridCol = 3*(col/3) + i%3;

            if(board[subgridRow][subgridCol] == dig){
                return false;
            }
        }
        return true;
    }

     
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
}