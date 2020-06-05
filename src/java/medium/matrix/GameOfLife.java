package src.java.medium.matrix;

public class GameOfLife {
    // Time: O(m*n), Space: O(1)
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0)  return;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                int live = 0;
                if (isValid(board, i-1, j-1) && (board[i-1][j-1] & 1) == 1)    live++;
                if (isValid(board, i-1, j+1) && (board[i-1][j+1] & 1) == 1)    live++;
                if (isValid(board, i+1, j-1) && (board[i+1][j-1] & 1) == 1)    live++;
                if (isValid(board, i+1, j+1) && (board[i+1][j+1] & 1) == 1)    live++;
                if (isValid(board, i-1, j) && (board[i-1][j] & 1) == 1)    live++;
                if (isValid(board, i, j-1) && (board[i][j-1] & 1) == 1)    live++;
                if (isValid(board, i+1, j) && (board[i+1][j] & 1) == 1)    live++;
                if (isValid(board, i, j+1) && (board[i][j+1] & 1) == 1)    live++;
                if ((board[i][j] & 1) == 1) {
                    if (live == 2 || live == 3)    board[i][j] |= 1<<1;
                } else {
                    if (live == 3)  board[i][j] |= 1<<1;
                }
            }
        }
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                board[i][j] = board[i][j]>>1;
            }
        }
    }
    
    public boolean isValid(int[][] board, int m, int n) {
        return m >= 0 && m < board.length && n >= 0 && n < board[0].length;
    }

    // Time: O(m*n), Space: O(m*n)
    public void gameOfLife2(int[][] board) {
        int[][] ret = new int[board.length][board[0].length];
        if (board.length == 0 || board[0].length == 0)  return;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                int live = 0;
                if (isValid(board, i-1, j-1) && board[i-1][j-1] == 1)    live++;
                if (isValid(board, i-1, j+1) && board[i-1][j+1] == 1)    live++;
                if (isValid(board, i+1, j-1) && board[i+1][j-1] == 1)    live++;
                if (isValid(board, i+1, j+1) && board[i+1][j+1] == 1)    live++;
                if (isValid(board, i-1, j) && board[i-1][j] == 1)    live++;
                if (isValid(board, i, j-1) && board[i][j-1] == 1)    live++;
                if (isValid(board, i+1, j) && board[i+1][j] == 1)    live++;
                if (isValid(board, i, j+1) && board[i][j+1] == 1)    live++;
                if (board[i][j] == 1) {
                    if (live < 2)   ret[i][j] = 0;
                    else if (live == 2 || live == 3)    ret[i][j] = 1;
                    else    ret[i][j] = 0;
                } else {
                    if (live == 3)  ret[i][j] = 1;
                }
            }
        }
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                board[i][j] = ret[i][j];
            }
        }
    }
}