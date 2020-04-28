package src.java.easy.matrix;

import java.util.LinkedList;

class OrangesRotting {
    // O(n*m)
    public int orangesRotting(int[][] grid) {
        int ret = 0;
        int[] verticalDirect = new int[]{1, -1, 0, 0};
        int[] horizontalDirect = new int[]{0, 0, 1, -1};
        
        LinkedList<Integer> vertical = new LinkedList<>();
        LinkedList<Integer> horizontal = new LinkedList<>();
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    horizontal.push(i);
                    vertical.push(j);
                }
            }
        }
        
        while(!vertical.isEmpty()) {
            LinkedList<Integer> newVertical = new LinkedList<>();
            LinkedList<Integer> newHorizontal = new LinkedList<>();
            while (!vertical.isEmpty()) {
                int h = horizontal.pop(); 
                int v = vertical.pop();
                for (int i=0; i<4; i++) {
                    int s = h + horizontalDirect[i];
                    int t = v + verticalDirect[i];
                    if (s < 0 || t < 0 || s >= grid.length || t >= grid[s].length || grid[s][t] == 0 || grid[s][t] == 2)
                        continue;
                    else {
                        newVertical.push(t);
                        newHorizontal.push(s);
                        grid[s][t] = 2;
                    }
                }
            }
            ret++;
            vertical = newVertical;
            horizontal = newHorizontal;
        }
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ret>0 ? ret-1 : ret;
    }
}