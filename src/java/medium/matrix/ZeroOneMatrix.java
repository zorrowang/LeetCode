package src.java.medium.matrix;

import java.util.LinkedList;
import java.util.Queue;


public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0)  queue.offer(new int[]{i, j});
                else    matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!queue.isEmpty()) {
            int[] c = queue.poll();
            for (int[] d: dirs) {
                int s = c[0] + d[0];
                int t = c[1] + d[1];
                if (s >=0 && s<m && t>=0 && t<n && matrix[s][t] > matrix[c[0]][c[1]]+1) {
                    matrix[s][t] = matrix[c[0]][c[1]]+1;
                    queue.offer(new int[]{s, t});
}
            }
        }
        return matrix;
    }
}