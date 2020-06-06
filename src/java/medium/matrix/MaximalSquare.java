package src.java.medium.matrix;

public class MaximalSquare {
    // dp[i][j] = the max length of square ending at {i, j}
    // dp[i][j] = min{dp[i-1][j-1], min{dp[i][j-1], dp[i-1][j]}} + 1
    public int maximalSquare(char[][] matrix) {
        if (matrix==null || matrix.length==0)   return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        
        int ret = 0;
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                    ret = Math.max(ret, dp[i][j]);
                }
            }
        }
        return ret*ret;
    }

    // O(m*n*n) solution
    public int maximalSquare2(char[][] matrix) {
        if (matrix==null || matrix.length==0)   return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] rightToLeft = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (j==0)   
                    rightToLeft[i][j] = (int)(matrix[i][j]-'0');
                else if (matrix[i][j] == '1')
                    rightToLeft[i][j] += rightToLeft[i][j-1] + 1;
            }
        }
        int ret = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == '0')  continue;
                int curMin = Integer.MAX_VALUE;
                for (int s=i; s>=0; s--) {
                    curMin = Math.min(curMin, rightToLeft[s][j]);
                    if (curMin >= i-s+1)
                        ret = Math.max(ret, (i-s+1)*(i-s+1));
                }
            }
        }
        return ret;
    }
}