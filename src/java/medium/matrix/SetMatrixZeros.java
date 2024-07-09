package src.java.medium.matrix;

public class SetMatrixZeros {
    // Constant space complexity 
    public void setZeroes(int[][] matrix) {
        boolean h = false, v = false;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0)     h = true;
                    if (j == 0)     v = true;
                }
            }
        }
        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (h == true)
            for (int i=0; i<matrix[0].length; i++)  matrix[0][i] = 0;
        if (v == true)
            for (int i=0; i<matrix.length; i++)  matrix[i][0] = 0;
    }

    public void setZeroes2(int[][] matrix) {
        if (matrix==null || matrix.length==0)   return;
        
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if (matrix[i][j]==0){
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if (rows[i] || columns[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

