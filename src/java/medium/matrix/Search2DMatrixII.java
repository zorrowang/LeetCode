package src.java.medium.matrix;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0)   return false;
        return search(matrix, target, 0, 0, matrix.length-1, matrix[0].length-1);
    }
    
    private boolean search(int[][] matrix, int target, int startM, int startN, int endM, int endN) {
        if (startM==endM && startN==endN)   
            return matrix[startM][startN]==target;
        if (startM>endM || startN>endN) 
            return false;
        int midM = startM + (endM - startM)/2;
        int midN = startN + (endN - startN)/2;
        if (matrix[midM][midN] == target)   
            return true;
        else if (matrix[midM][midN] > target)
            return search(matrix, target, startM, startN, midM, midN) || 
                   search(matrix, target, startM, midN+1, midM, endN) || 
                   search(matrix, target, midM+1, startN, endM, midN);
        else
            return search(matrix, target, startM, midN+1, midM, endN) || 
                   search(matrix, target, midM+1, startN, endM, midN) || 
                   search(matrix, target, midM+1, midN+1, endM, endN);
    }
}