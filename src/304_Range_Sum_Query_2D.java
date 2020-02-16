// This solution can be improved to O(1) by implementing a matrix for DP
public class NumMatrix {
    int[] sums;
    int[][] leftToRight;
    int[][] rightToLeft;
    
    public NumMatrix(int[][] matrix) {
        sums = new int[matrix.length];
        if (matrix.length > 0) {
            leftToRight = new int[matrix.length][matrix[0].length];
            rightToLeft = new int[matrix.length][matrix[0].length];
            for (int i=0; i<matrix.length; i++) {
                leftToRight[i][0] = matrix[i][0];
                rightToLeft[i][matrix[i].length-1] = matrix[i][matrix[i].length-1];
                for(int j=1; j<matrix[i].length; j++) {
                    leftToRight[i][j] = leftToRight[i][j-1] + matrix[i][j];
                    rightToLeft[i][matrix[i].length-j-1] = rightToLeft[i][matrix[i].length-j] + matrix[i][matrix[i].length-j-1];
                }
                sums[i] = leftToRight[i][matrix[i].length-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ret = 0;
        for (int i=row1; i<=row2; i++) {
            int left = col1<=0 ? 0 : leftToRight[i][col1-1];
            int right = col2>= rightToLeft[i].length-1 ? 0 : rightToLeft[i][col2+1];
            ret += sums[i] - left - right;
        }
        return ret;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);