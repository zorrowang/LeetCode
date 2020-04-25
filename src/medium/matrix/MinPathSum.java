package src.medium.matrix;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (i > 0)
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                if (j > 0) {
                    if (dp[i][j] > 0)
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + grid[i][j]);
                    else
                        dp[i][j] = dp[i][j-1] + grid[i][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    
    public int minPathSum2(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (grid==null || grid.length==0)   return 0;
        
        int[][] dp = new int[grid.length][grid[0].length];
        dp[dp.length-1][dp[0].length-1] = grid[grid.length-1][grid[0].length-1];
        
        for(int i=grid[0].length-2; i>=0; i--)
            dp[dp.length-1][i] = grid[dp.length-1][i] + dp[dp.length-1][i+1];
            
        for (int i=grid.length-2; i>=0; i--)
            dp[i][dp[0].length-1] = grid[i][dp[0].length-1] + dp[i+1][dp[0].length-1];
            
        for (int i=dp.length-2; i>=0; i--){
            for (int j=dp[0].length-2; j>=0; j--){
                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }
        
        return dp[0][0];
    }
}