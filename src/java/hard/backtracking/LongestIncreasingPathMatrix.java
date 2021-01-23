package src.java.hard.backtracking;

public class LongestIncreasingPathMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        if (matrix==null || matrix.length==0)   return max;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                int t = dfs(matrix, i, j, cache);
                max = Math.max(max, t);
            }
        }
        return max;
    }
    
    public int dfs(int[][] matrix, int startM, int startN, int[][] cache) {
        if (cache[startM][startN]>0)    
            return cache[startM][startN];
        int max = 1;
        int[] directM = {1, -1, 0, 0};
        int[] directN = {0, 0, 1, -1};
        for (int i=0; i<4; i++) {
            int newM = startM + directM[i];
            int newN = startN + directN[i];
            if (newM >=0 && newM < matrix.length && newN >= 0 && newN < matrix[0].length && matrix[startM][startN] < matrix[newM][newN]) {
                int t = dfs(matrix, newM, newN, cache);
                max = Math.max(max, t+1);
            }
        }
        cache[startM][startN] = max;
        return max;
    }

    // Rewritten on 2021/01/21
    // A bit faster than the previous version
    public int longestIncreasingPath2(int[][] matrix) {
        int ret = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                ret = Math.max(ret, dfs2(matrix, i, j, cache));
        return ret;
    }
    
    private int dfs2(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] > 0)    return cache[i][j];
        if ((i==0 || matrix[i][j]>matrix[i-1][j]) && 
            (i==matrix.length-1 || matrix[i][j]>matrix[i+1][j]) && 
            (j==0 || matrix[i][j]>matrix[i][j-1]) && 
            (j==matrix[i].length-1 || matrix[i][j]>matrix[i][j+1])) {
            cache[i][j] = 1;
            return 1;
        }
        int up=0, down=0, left=0, right=0;
        if (i>0 && matrix[i][j]<matrix[i-1][j])
            up = dfs2(matrix, i-1, j, cache);
        if (i<matrix.length-1 && matrix[i][j]<matrix[i+1][j])
            down = dfs2(matrix, i+1, j, cache);
        if (j>0 && matrix[i][j]<matrix[i][j-1])
            left = dfs2(matrix, i, j-1, cache);
        if (j<matrix[i].length-1 && matrix[i][j]<matrix[i][j+1])
            right = dfs2(matrix, i, j+1, cache);
        cache[i][j] = Math.max(up, Math.max(down, Math.max(left, right)))+1;
        return cache[i][j];
    }
}