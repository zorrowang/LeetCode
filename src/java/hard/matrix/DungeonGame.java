package src.java.hard.matrix;

import java.util.ArrayList;
import java.util.List;

public class DungeonGame {
    // Backtracking - TLE
    public int calculateMinimumHP(int[][] dungeon) {
        List<Integer> list = new ArrayList<>();
        list.add(dungeon[0][0]);
        int ret = dfs(dungeon, 0, 0, list);
        if (ret >= 0)    return 1;
        else    return -ret+1;
    }
    
    private int dfs(int[][] dungeon, int m, int n, List<Integer> list) {
        if (m==dungeon.length-1 && n==dungeon[m].length-1) {
            int sum = 0, ret = 0;
            for (int i=0; i<list.size(); i++) {
                sum += list.get(i);
                if (ret > sum)  ret = sum;
            }
            return ret;
        }
        int max = Integer.MIN_VALUE;
        int[][] dirs = {{0, 1}, {1, 0}};
        for (int i=0; i<dirs.length; i++) {
            int newM = m + dirs[i][0];
            int newN = n + dirs[i][1];
            if (newM < dungeon.length && newN < dungeon[0].length) {
                list.add(dungeon[newM][newN]);
                int curMin = dfs(dungeon, newM, newN, list);
                list.remove(list.size()-1);
                max = Math.max(max, curMin);
            }
        }
        return max;
    }

    // DP solution
    public int calculateMinimumHP2(int[][] dungeon) {
        //dp[i][j] = minimum health level required to reach the princess when entering (i, j)
        // dp[i][j] = max{min{dp[i-1][j], dp[i][j-1]} - dungeon[i][j], 0}
        int m = dungeon.length;
        int n = m == 0 ? 0 : dungeon[0].length;
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++) dp[i][n] = Integer.MAX_VALUE;
        for(int i=0; i<=n; i++) dp[m][i] = Integer.MAX_VALUE;
        dp[m-1][n] = 0;
        dp[m][n-1] = 0;
        
        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j], 0);
            }
        }
        return dp[0][0]+1;
    }
}