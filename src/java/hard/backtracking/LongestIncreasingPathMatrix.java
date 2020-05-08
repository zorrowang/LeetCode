package src.java.hard.backtracking;

public class LongestIncreasingPathMatrix {
    // Backtracking (DFS) solution - TLE
    int max = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix==null || matrix.length==0)   return max;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                visited[i][j] = true;
                longestIncreasingPath(matrix, i, j, visited, 1);
                visited[i][j] = false;
            }
        }
        return max;
    }
    
    public void longestIncreasingPath(int[][] matrix, int startM, int startN, boolean[][] visited, int cur) {
        max = Math.max(max, cur);
        int[] directM = {1, -1, 0, 0};
        int[] directN = {0, 0, 1, -1};
        for (int i=0; i<4; i++) {
            int newM = startM + directM[i];
            int newN = startN + directN[i];
            if (newM >=0 && newM < matrix.length && newN >= 0 && newN < matrix[0].length && !visited[newM][newN] && matrix[startM][startN] < matrix[newM][newN]) {
                visited[newM][newN] = true;
                longestIncreasingPath(matrix, newM, newN, visited, cur+1);
                visited[newM][newN] = false;
            }
        }
    }
}