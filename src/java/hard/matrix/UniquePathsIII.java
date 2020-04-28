package src.java.hard.matrix;

public class UniquePathsIII {
    int ret = 0;
    int count = 0;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int startM = 0, startN = 0;
        int endM = 0, endN = 0;
        int zeros = 0;
        boolean[][] checked = new boolean[m][n];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    startM = i;
                    startN = j;
                } else if (grid[i][j] == 2) {
                    endM = i;
                    endN = j;
                } else if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        
        checked[startM][startN] = true;
        uniquePathsIII(grid, startM, startN, endM, endN, checked, zeros);
        return ret;
    }
    
    private void uniquePathsIII(int[][] grid, int startM, int startN, int endM, int endN, boolean[][] checked, int zeros) {
        if (startM == endM && startN == endN) {
            if (zeros-1 == count)     ret++;
            return;
        }
        
        int[] dm = {1, 0, -1, 0};
        int[] dn = {0, 1, 0, -1};
        
        for (int i=0; i<4; i++) {
            int newM = startM + dm[i];
            int newN = startN + dn[i];
            if (newM>=0 && newM<grid.length && newN>=0 && newN<grid[newM].length && !checked[newM][newN] && grid[newM][newN]!=-1) {
                checked[newM][newN] = true;
                uniquePathsIII(grid, newM, newN, endM, endN, checked, zeros+1);
                checked[newM][newN] = false;
            }
        }
    }
}