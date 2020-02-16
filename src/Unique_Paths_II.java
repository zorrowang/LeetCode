public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (obstacleGrid==null || obstacleGrid.length==0)   return 0;
        
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        for (int i=dp.length-1; i>=0; i--){
            if (obstacleGrid[i][obstacleGrid[0].length-1] != 1)
                dp[i][dp[0].length-1] = 1;
            else
                break;
        }
        
        for (int i=dp[0].length-1; i>=0; i--){
            if (obstacleGrid[obstacleGrid.length-1][i] != 1)
                dp[dp.length-1][i] = 1;
            else
                break;    
        }
        
        for (int i=dp.length-2; i>=0; i--){
            for (int j=dp[0].length-2; j>=0; j--){
                if (obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                else
                    dp[i][j] = 0;
            }
        }
        
        return dp[0][0];
    }
}