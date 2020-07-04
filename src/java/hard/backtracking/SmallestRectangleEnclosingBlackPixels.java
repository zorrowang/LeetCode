package src.java.hard.backtracking;

public class SmallestRectangleEnclosingBlackPixels {
    int minX, minY;
    int maxX, maxY;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // write your code here
        minX = minY = Integer.MAX_VALUE;
        maxX = maxY = Integer.MIN_VALUE;
        dfs(image, x, y);
        return (maxX - minX + 1) * (maxY - minY + 1);
    }
    
    private void dfs(char[][] image, int x, int y) {
        if (image[x][y] == '0') return;
        minX = Math.min(minX, x);
        minY = Math.min(minY, y);
        maxX = Math.max(maxX, x);
        maxY = Math.max(maxY, y);
        image[x][y] = '0';
        for (int i=0; i<4; i++) {
            int s = dirs[i][0] + x;
            int t = dirs[i][1] + y;
            if (s >=0 && s < image.length && t >= 0 && t < image[0].length && image[s][t] == '1')
                dfs(image, s, t);
        }
    }
}