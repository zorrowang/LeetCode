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
}