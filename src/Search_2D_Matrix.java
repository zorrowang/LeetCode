public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix==null || matrix.length==0)   return false;
        
        int i=0, j=matrix[0].length-1;
        
        while(i<matrix.length && j>=0){
            if (matrix[i][j] > target)  j--;
            else if (matrix[i][j] < target) i++;
            else    return true;
        }
        
        return false;
    }
}

