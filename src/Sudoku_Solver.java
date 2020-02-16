public class Solution {
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] checkRows = new boolean[board.length][board[0].length];
        boolean[][] checkColumns = new boolean[board.length][board[0].length];
        boolean[][] checkSubs = new boolean[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if (board[i][j] != '.'){
                    checkRows[i][board[i][j]-'0'-1] = true;
                    checkColumns[board[i][j]-'0'-1][j] = true;
                }
            }
        }
        
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                for (int m=0; m<3; m++){
                    for (int n=0; n<3; n++){
                        if (board[i*3+m][j*3+n] != '.'){
                            checkSubs[i*3+j][board[i*3+m][j*3+n]-'0'-1] = true;
                        }
                    }
                }
            }
        }
        
        solveSudoku(board, checkRows, checkColumns, checkSubs);
    }
    
    public boolean solveSudoku(char[][] board, boolean[][] checkRows, boolean[][] checkColumns, boolean[][] checkSubs) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if (board[i][j] == '.'){
                    for (int t=0; t<9; t++){
                        if (!checkRows[i][t] && !checkColumns[t][j] && !checkSubs[i/3*3+j/3][t]){
                            checkRows[i][t] = true;
                            checkColumns[t][j] = true; 
                            checkSubs[i/3*3+j/3][t] = true;
                            board[i][j] = (char)('1'+t);
                            if (solveSudoku(board, checkRows, checkColumns, checkSubs))
                                return true;
                            checkRows[i][t] = false;
                            checkColumns[t][j] = false; 
                            checkSubs[i/3*3+j/3][t] = false;
                            board[i][j] = '.';
                        }
                    }
                }
				return false;
            }
        }
        return true;
    }
}

public class Solution {
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        solveSudokuHelper(board);
    }
    
    public boolean solveSudokuHelper(char[][] board) {
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board[i][j] == '.'){
                    for (int t=0; t<9; t++){
                        board[i][j] = (char)('1'+t);
                        if (validSudoku(board, i, j) && solveSudokuHelper(board))
                            return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean validSudoku(char[][] board, int row, int col) {
        boolean[] flag = new boolean[9];
        
        for (int i=0; i<9; i++){
    		if(board[row][i]>'0' && board[row][i]<='9'){
				int temp = board[row][i]-'1';
				if (flag[temp]) return false;
				flag[temp] = true;
			}
        }
        
        Arrays.fill(flag, false);
        for (int i=0; i<9; i++){
			if(board[i][col]>'0' && board[i][col]<='9'){
				int temp = board[i][col]-'1';
				if (flag[temp]) return false;
				flag[temp] = true;
			}
        }
        
        Arrays.fill(flag, false);
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
				if (board[row/3*3+i][col/3*3+j]>'0' && board[row/3*3+i][col/3*3+j]<='9'){
					int temp = board[row/3*3+i][col/3*3+j]-'1';
					if (flag[temp]) return false;
					flag[temp] = true;
				}
            }
        }
        return true;
    }
}