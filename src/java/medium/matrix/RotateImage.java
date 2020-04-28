package src.java.medium.matrix;

public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix==null || matrix.length<2)    return;
        for (int i=0; i<matrix.length/2; i++)
            rotate(matrix, i);
    }
    
    public void rotate(int[][] matrix, int level) {
        int t1, t2;
        for (int i=level; i<matrix.length-level-1; i++){
            t1 = matrix[i][matrix.length-level-1];
            matrix[i][matrix.length-level-1] = matrix[level][i];
            t2 = matrix[matrix.length-level-1][matrix.length-i-1];
            matrix[matrix.length-level-1][matrix.length-i-1] = t1;
            t1 = matrix[matrix.length-i-1][level];
            matrix[matrix.length-i-1][level] = t2;
            matrix[level][i] = t1;
        }
    }
}