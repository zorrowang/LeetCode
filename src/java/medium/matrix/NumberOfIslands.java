package src.java.medium.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    // DFS
    public int numIslands(char[][] grid) {
        int cnt = 0;
        if (grid==null || grid.length==0 || grid[0].length==0)
            return cnt;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
    
    private void dfs(char[][] grid, int m, int n) {
        grid[m][n] = '0';
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for (int i=0; i<dirs.length; i++) {
            int newM = m + dirs[i][0];
            int newN = n + dirs[i][1];
            if (newM>=0 && newM<grid.length && newN>=0 && newN<grid[0].length && grid[newM][newN]=='1')
                dfs(grid, newM, newN);
        }
    }

    // BFS
    public int numIslands2(char[][] grid) {
        int cnt = 0;
        if (grid==null || grid.length==0 || grid[0].length==0)
            return cnt;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    bfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
    
    private void bfs(char[][] grid, int m, int n) {
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{m, n});
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            grid[cell[0]][cell[1]] = '0';
            for (int i=0; i<dirs.length; i++) {
                int newM = cell[0] + dirs[i][0];
                int newN = cell[1] + dirs[i][1];
                if (newM>=0 && newM<grid.length && newN>=0 && newN<grid[0].length && grid[newM][newN]=='1')
                    q.offer(new int[]{newM, newN});
            }
        }
    }
}