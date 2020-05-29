package src.java.medium.matrix;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
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

