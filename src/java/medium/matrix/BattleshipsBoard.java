package src.java.medium.matrix;

public class BattleshipsBoard {
    public int countBattleships(char[][] board) {
        int ret = 0;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j]=='X' && (i==0 || board[i-1][j]=='.') && (j==0 || board[i][j-1]=='.'))
                    ret++;
            }
        }
        return ret;
    }
}