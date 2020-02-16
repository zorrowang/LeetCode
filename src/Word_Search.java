public class Solution {
    public boolean exist(char[][] board, String word) {
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

