// This solution does not pass the large test set
// Recursion is so costly in Java
public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board==null || board.length==0) return;
        
        for(int i=0; i<board.length; i++)
            if(board[i][0]=='O')    search(board, i, 0);
        for(int i=0; i<board[0].length; i++)
            if(board[board.length-1][i]=='O')    search(board, board.length-1, i);
        for(int i=0; i<board.length; i++)
            if(board[i][board[0].length-1]=='O')    search(board, i, board[0].length-1);
        for(int i=0; i<board[0].length; i++)
            if(board[0][i]=='O')    search(board, 0, i);
            
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='Y')
                    board[i][j]='O';
            }
        }
    }
    
    public void search(char[][] board, int i, int j) {
        board[i][j] = 'Y';
        if(i<board.length-1 && board[i+1][j]=='O')   search(board, i+1, j);
        if(i>0 && board[i-1][j]=='O')   search(board, i-1, j);
        if(j<board[i].length-1 && board[i][j+1]=='O')   search(board, i, j+1);
        if(j>0 && board[i][j-1]=='O')   search(board, i, j-1);
    }
}

// Using two stacks to implement BFS can pass the large test set
public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board==null || board.length==0) return;
        
        for(int i=0; i<board.length; i++)
            if(board[i][0]=='O')    search(board, i, 0);
        for(int i=0; i<board[0].length; i++)
            if(board[board.length-1][i]=='O')    search(board, board.length-1, i);
        for(int i=0; i<board.length; i++)
            if(board[i][board[0].length-1]=='O')    search(board, i, board[0].length-1);
        for(int i=0; i<board[0].length; i++)
            if(board[0][i]=='O')    search(board, 0, i);
            
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='Y')
                    board[i][j]='O';
            }
        }
    }
    
    public void search(char[][] board, int i, int j) {
        LinkedList<Integer> stackX = new LinkedList<Integer>();
        LinkedList<Integer> stackY = new LinkedList<Integer>();
        stackX.push(i);
        stackY.push(j);
        
        while(!stackX.isEmpty() && !stackY.isEmpty()){
            int x = stackX.pop();
            int y = stackY.pop();
            board[x][y] = 'Y';
            if(x<board.length-1 && board[x+1][y]=='O'){
                stackX.push(x+1);
                stackY.push(y);
            }
            if(x>0 && board[x-1][y]=='O'){
                stackX.push(x-1);
                stackY.push(y);
            }
            if(y<board[x].length-1 && board[x][y+1]=='O'){
                stackX.push(x);
                stackY.push(y+1);
            }
            if(y>0 && board[x][y-1]=='O'){
                stackX.push(x);
                stackY.push(y-1);
            }
        }
    }
}