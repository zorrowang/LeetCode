package src.java.medium.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0)   return 0;
        Queue<int[]> st = new LinkedList<>();
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

        if (grid[0][0] != 1) {
            st.offer(new int[]{0, 0, 1});
            grid[0][0] = 1;
        }
        while (!st.isEmpty()) {
            int[] g = st.poll();
            if (g[0] == grid.length-1 && g[1] == grid[0].length-1)
                return g[2];
            
            for (int i=0; i<8; i++) {
                int h = g[0] + dir[i][0];
                int v = g[1] + dir[i][1];
                if (h < 0 || h >= grid.length || v < 0 || v >= grid[0].length)
                    continue;
                if (grid[h][v] == 1)    continue;
                st.offer(new int[]{h, v, g[2]+1});
                grid[h][v] = 1;
            }
        }
        return -1;
    }
}
