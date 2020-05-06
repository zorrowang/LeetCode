package src.java.hard.matrix;

public class SwimRisingWater {
    // Union Find solution
    class UnionFind {
        private int[] parent;  // parent[i] = parent of i

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];  // path compression by halving
                p = parent[p];
            }
            return p;
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            parent[rootQ] = rootP;
        }
        
        boolean isUnion(int p, int q) {
            return find(p) == find(q);
        }
    }
    
    public int swimInWater(int[][] grid) {
        int len = grid.length;
        UnionFind uf = new UnionFind(len*len);
        int time = 0;
        while (!uf.isUnion(0, len*len-1)) {
            for (int i=0; i<len; i++) {
                for (int j=0; j<len; j++) {
                    if (grid[i][j] > time) continue;
                    if (i < len-1 && grid[i+1][j]<=time) 
                        uf.union(i*len+j, (i+1)*len+j);
                    if (j < len-1 && grid[i][j+1]<=time) 
                        uf.union(i*len+j, i*len+j+1);
                }
            }
            time++;
        }
        return time-1;
    }

    // Backtracking (DFS) solution
    // Time Limit Exceeded
    public int swimInWater2(int[][] grid) {
        if (grid==null || grid.length==0)
            return 0;
        
        int len = grid.length;
        boolean[][] visited = new boolean[len][len];
        visited[0][0] = true;
        return swimInWaterRec(grid, 0, 0, visited, Integer.MIN_VALUE);
    }
    
    private int swimInWaterRec(int[][] grid, int startM, int startN, boolean[][] visited, int max) {
        if (startM==grid.length-1 && startN==grid[0].length-1)
            return Math.max(max, grid[startM][startN]);
        
        int min = Integer.MAX_VALUE;
        max = Math.max(max, grid[startM][startN]);
        int[] directM = {1, -1, 0, 0};
        int[] directN = {0, 0, 1, -1};
        for (int i=0; i<4; i++) {
            int newM = startM + directM[i];
            int newN = startN + directN[i];
            if (newM>=0 && newN>=0 && newM<grid.length && newN<grid[0].length && !visited[newM][newN]) {
                visited[newM][newN] = true;
                int t = swimInWaterRec(grid, newM, newN, visited, max);
                min = Math.min(min, t);
                visited[newM][newN] = false;
            }
        }
        return min;
    }
}