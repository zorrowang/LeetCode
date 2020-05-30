package src.java.medium.matrix;

import java.util.LinkedList;

public class SurroundedRegions {
    // BFS
    public void solve(char[][] board) {
        if (board==null || board.length==0 || board[0].length==0)
            return;
        int m = board.length, n = board[0].length;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        LinkedList<int[]> q = new LinkedList<>();
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if ((i==0 || j==0 || i==m-1 || j==n-1) && board[i][j]=='O')
                    q.offer(new int[]{i, j});
            }
        }
        while (!q.isEmpty()) {
            int[] p = q.poll();
            board[p[0]][p[1]] = '.';
            for (int i=0; i<dirs.length; i++) {
                int newM = p[0]+dirs[i][0], newN = p[1]+dirs[i][1];
                if (newM>=0 && newM<m && newN>0 && newN<n && board[newM][newN]=='O')
                    q.offer(new int[]{newM, newN});
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '.') board[i][j] = 'O';
            }
        }
    }
    
    // DFS - TLE
    public void solve2(char[][] board) {
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

    // Using two stacks to implement BFS can pass the large test set
    public void solve3(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board==null || board.length==0) return;
        
        for(int i=0; i<board.length; i++)
            if(board[i][0]=='O')    search2(board, i, 0);
        for(int i=0; i<board[0].length; i++)
            if(board[board.length-1][i]=='O')    search2(board, board.length-1, i);
        for(int i=0; i<board.length; i++)
            if(board[i][board[0].length-1]=='O')    search2(board, i, board[0].length-1);
        for(int i=0; i<board[0].length; i++)
            if(board[0][i]=='O')    search2(board, 0, i);
            
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='Y')
                    board[i][j]='O';
            }
        }
    }
    
    public void search2(char[][] board, int i, int j) {
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