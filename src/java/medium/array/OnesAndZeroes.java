package src.java.medium.array;

import java.util.HashSet;
import java.util.Set;

public class OnesAndZeroes {
    // DP (0/1 Knapsack) - Passed 
    // dp[i][j][k] = max{dp[i-1][j][k], dp[i-1][j-number of 0's in i-th string][k-number of 1's in i-th string] + 1}
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] matrix = new int[len][2];
        for (int i=0; i<len; i++) {
            for (int j=0; j<strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                if (c == '0')   matrix[i][0]++;
                else            matrix[i][1]++;
            }
        }
        
        int[][][] dp = new int[len+1][m+1][n+1];
        for (int i=0; i<=len; i++) {
            for (int j=0; j<=m; j++) {
                for (int t=0; t<=n; t++) {
                    if (i==0)   dp[i][j][t] = 0;
                    else if(matrix[i-1][0]<=j && matrix[i-1][1]<=t)
                        dp[i][j][t] = Math.max(dp[i-1][j][t], dp[i-1][j-matrix[i-1][0]][t-matrix[i-1][1]]+1);
                    else dp[i][j][t] = dp[i-1][j][t];
                }
            }
        }
        return dp[len][m][n];
    }

    // Backtracking (DFS) - TLE
    public int findMaxFormDfs(String[] strs, int m, int n) {
        int[][] matrix = new int[strs.length][2];
        for (int i=0; i<strs.length; i++) {
            for (int j=0; j<strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                if (c == '0')   matrix[i][0]++;
                else            matrix[i][1]++;
            }
        }
        return dfs(matrix, m, n, new HashSet<>());
    }
    
    private int dfs(int[][] matrix, int m, int n, Set<Integer> used) {
        if (m==0 && n==0)   return 0;
        if (used.size()==matrix.length && m>=0 && n>=0) return 0;
        if (m<0 || n <0)    return -1;
        
        int ret = 0;
        for (int i=0; i<matrix.length; i++) {
            if (used.contains(i))   continue;
            used.add(i);
            int t = dfs(matrix, m-matrix[i][0], n-matrix[i][1], used);
            if (t >= 0)  ret = Math.max(ret, t+1);
            used.remove(i);
        }
        return ret;
    }
}