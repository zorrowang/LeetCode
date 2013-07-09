public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] ret = new int[n][n];
        if (n<=0)   return ret;
        for(int i=0; n>2*i; i++)
            helper(ret, i);
        return ret;
    }
    
    public void helper(int[][] matrix, int level){
        int start=0;
        for(int i=0; i<level; i++)
            start += (matrix.length-2*i-1)*4;
        
        if(matrix.length-2*level==1){
            matrix[matrix.length-level-1][matrix.length-level-1] = ++start;
            return;
        }
            
        for(int i=level; i<matrix[0].length-level-1; i++)
            matrix[level][i] = ++start;
        for(int i=level; i<matrix.length-level-1; i++)
            matrix[i][matrix[0].length-level-1] = ++start;
        for(int i=level; i<matrix[0].length-level-1; i++)
            matrix[matrix.length-level-1][matrix[0].length-i-1] = ++start;
        for(int i=level; i<matrix.length-level-1; i++)
            matrix[matrix.length-i-1][level] = ++start;
    }
}

