package src.java.hard.matrix;

// Idea is from https://www.programcreek.com/2014/04/leetcode-range-sum-query-2d-immutable-java/
class NumMatrix {
    int[][] sum, matrix;
    int m, n;
    
    public NumMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0||matrix[0].length==0)
            return;
        
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        sum = new int[m][n];
        
        for (int i=0; i<m; i++) {
            int cur = 0;
            for (int j=0; j<n; j++) {
                cur += matrix[i][j];
                if (i==0)   sum[i][j] = cur;
                else        sum[i][j] = cur + sum[i-1][j];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        for (int i=row; i<m; i++)
            for (int j=col; j<n; j++)
                sum[i][j] += diff;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum == null)    return 0;
        if (row1==0 && col1==0)     return sum[row2][col2];
        else if (row1==0)           return sum[row2][col2] - sum[row2][col1-1];
        else if (col1==0)           return sum[row2][col2] - sum[row1-1][col2];
        else    return sum[row2][col2] - sum[row2][col1-1] - sum[row1-1][col2] + sum[row1-1][col1-1];
    }
}