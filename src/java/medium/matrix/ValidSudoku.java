package src.java.medium.matrix;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] checkRows = new boolean[board.length][board[0].length];
        boolean[][] checkColumns = new boolean[board.length][board[0].length];
        boolean[][] checkSubs = new boolean[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if (board[i][j] != '.'){
                    if (checkRows[i][board[i][j]-'0'-1])
                        return false;
                    checkRows[i][board[i][j]-'0'-1] = true;
                    if (checkColumns[board[i][j]-'0'-1][j])
                        return false;
                    checkColumns[board[i][j]-'0'-1][j] = true;
                }
            }
        }
        
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                for (int m=0; m<3; m++){
                    for (int n=0; n<3; n++){
                        if (board[i*3+m][j*3+n] != '.'){
                            if (checkSubs[i*3+j][board[i*3+m][j*3+n]-'0'-1])
                                return false;
                            checkSubs[i*3+j][board[i*3+m][j*3+n]-'0'-1] = true;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}