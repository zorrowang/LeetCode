package src.java.medium.backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (dfs(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int m, int n, String word, int cur) {
        if (word.length() == cur)   return true;
        else if (word.charAt(cur) != board[m][n])   return false;
        board[m][n] = '.';
        if (m>0 && dfs(board, m-1, n, word, cur+1)) return true;
        else if (m<board.length-1 && dfs(board, m+1, n, word, cur+1)) return true;
        else if (n>0 && dfs(board, m, n-1, word, cur+1)) return true;
        else if (n<board[m].length-1 && dfs(board, m, n+1, word, cur+1)) return true;
        board[m][n] = word.charAt(cur);
        return cur+1 == word.length();
    }

    // Use extra memory to do search prune
    public boolean exist2(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] checked =  new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                checked[i][j] = true;
                if (exist(board, word, 0, i, j, checked))
                    return true;
                checked[i][j] = false;
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, String word, int start, int startM, int startN, boolean[][] checked) {
        if (start >= word.length())
            return true;
        if (board[startM][startN] != word.charAt(start))
            return false;
        
        int[] directM = {1, 0, -1, 0};
        int[] directN = {0, -1, 0, 1};
        for (int i=0; i<4; i++) {
            int newM = directM[i] + startM;
            int newN = directN[i] + startN;
            if (newM>=0 && newM<board.length && newN>=0 && newN<board[newM].length && !checked[newM][newN]) {
                checked[newM][newN] = true;
                if (exist(board, word, start+1, newM, newN, checked))
                    return true;
                checked[newM][newN] = false;
            }
        }
        return start==word.length()-1;
    }


    // Legacy Solution
    // Modify original matrix
    public boolean exist3(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(word==null || word.isEmpty())    return true;
        if(board==null || board.length==0)  return false;
        char[]  array = word.toCharArray();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(existHelper(board, i, j, array, 0))
                    return true;
            }
        }
        return false;
    }
    
    public boolean existHelper(char[][] board, int i, int j, char[] word, int index){
        if(index>=word.length) return true;
        if(board[i][j]==word[index]){
            char temp = board[i][j];
            board[i][j] = '$';
            if(i>0 && existHelper(board, i-1, j, word, index+1))
                return true;
            if(i<board.length-1 && existHelper(board, i+1, j, word, index+1))
                return true;
            if(j>0 && existHelper(board, i, j-1, word, index+1))
                return true;
            if(j<board[i].length-1 && existHelper(board, i, j+1, word, index+1))
                return true;
            board[i][j] = temp;
            return index==word.length-1;
        }
        else
            return false;
    }
}

