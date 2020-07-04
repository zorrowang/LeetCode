package src.java.hard.matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ShortestDistanceFromAllBuildings {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    /**
     * @param grid: the 2D grid
     * @return: the shortest distance
     */
    public int shortestDistance(int[][] grid) {
        // write your code here
        if (grid==null || grid.length==0)   return 0;
        int m = grid.length, n = grid[0].length;
        int cnt = 0;
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if (grid[i][j]==1)  cnt++;
        
        int ret = Integer.MAX_VALUE;
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if (grid[i][j]==0)  ret = Math.min(ret, bfs(grid, i, j, cnt));
        return ret;
    }
    
    private int bfs(int[][] grid, int s, int t, int cnt) {
        Set<Integer> set = new HashSet<>();
        LinkedList<int[]> queue = new LinkedList<>();
        LinkedList<Integer> dis = new LinkedList<>();
        queue.offer(new int[]{s, t});
        set.add(s*grid[0].length+t);
        dis.offer(0);
        int ret = 0, cur = 0;
        while (!queue.isEmpty()) {
            int[] mn = queue.poll();
            int d = dis.poll();
            if (grid[mn[0]][mn[1]] == 2)    continue;
            if (grid[mn[0]][mn[1]] == 1) {
                ret += d;
                if (cnt == ++cur)   break;
                continue;
            }
            for (int i=0; i<4; i++) {
                int m = mn[0] + dirs[i][0];
                int n = mn[1] + dirs[i][1];
                if (m >=0 && m < grid.length && n >= 0 && n < grid[0].length && !set.contains(m*grid[0].length+n)) {
                    queue.offer(new int[]{m, n});
                    set.add(m*grid[0].length+n);
                    dis.offer(d+1);
                }
            }
        }
        return cnt == cur ? ret : Integer.MAX_VALUE;
    }
}