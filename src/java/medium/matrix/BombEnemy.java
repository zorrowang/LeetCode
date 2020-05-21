package src.java.medium.matrix;

public class BombEnemy {
    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // write your code here
        if (grid==null || grid.length==0)   return 0;
        int[][] leftToRight = new int[grid.length][grid[0].length];
        int[][] rightToLeft = new int[grid.length][grid[0].length];
        int[][] topToBot = new int[grid.length][grid[0].length];
        int[][] botToTop = new int[grid.length][grid[0].length];
        
        for (int i=0; i<grid.length; i++) {
            int left = 0, right = 0;
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 'E')
                    left++;
                else if (grid[i][j] == 'W')
                    left = 0;
                leftToRight[i][j] = left;
                
                if (grid[i][grid[i].length-j-1] == 'E')
                    right++;
                else if (grid[i][grid[i].length-j-1] == 'W')
                    right = 0;
                rightToLeft[i][grid[i].length-j-1] = right;
            }
        }
        
        for (int j=0; j<grid[0].length; j++) {
            int top = 0, bot = 0;
            for (int i=0; i<grid.length; i++) {
                if (grid[i][j] == 'E')
                    top++;
                else if (grid[i][j] == 'W')
                    top = 0;
                topToBot[i][j] = top;
                
                if (grid[grid.length-i-1][j] == 'E')
                    bot++;
                else if (grid[grid.length-i-1][j] == 'W')
                    bot = 0;
                botToTop[grid.length-i-1][j] = bot;
            }
        }
        
        int ret = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] != '0')  continue;
                int cur = 0;
                if (i<grid.length-1) cur += botToTop[i+1][j];
                if (i>0) cur += topToBot[i-1][j];
                if (j<grid[i].length-1) cur += rightToLeft[i][j+1];
                if (j>0) cur += leftToRight[i][j-1];
                ret = Math.max(ret, cur);
            }
        }
        return ret;
    }
}