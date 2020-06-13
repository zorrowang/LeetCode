package src.java.medium.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();
        if (matrix==null || matrix.length==0)   return ret;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] toAtlantic = new boolean[m][n];
        boolean[][] toPacific = new boolean[m][n];
        LinkedList<int[]> toAtlanticQueue = new LinkedList<>();
        LinkedList<int[]> toPacificQueue = new LinkedList<>();
        
        for(int i=0; i<m; i++) {
            toPacific[i][0] = true;
            toPacificQueue.offer(new int[]{i, 0});
            toAtlantic[i][n-1] = true;
            toAtlanticQueue.offer(new int[]{i, n-1});
        }
        for(int i=0; i<n; i++) {
            toPacific[0][i] = true;
            toPacificQueue.offer(new int[]{0, i});
            toAtlantic[m-1][i] = true;
            toAtlanticQueue.offer(new int[]{m-1, i});
        }
        
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!toPacificQueue.isEmpty()) {
            int[] cell = toPacificQueue.poll();
            toPacific[cell[0]][cell[1]] = true;
            for (int i=0; i<dirs.length; i++) {
                int newM = cell[0] + dirs[i][0];
                int newN = cell[1] + dirs[i][1];
                if (newM>=0 && newM<m && newN>=0 && newN<n && !toPacific[newM][newN] && 
                    matrix[newM][newN] >= matrix[cell[0]][cell[1]])
                    toPacificQueue.offer(new int[]{newM, newN});
            }
        }
        while(!toAtlanticQueue.isEmpty()) {
            int[] cell = toAtlanticQueue.poll();
            toAtlantic[cell[0]][cell[1]] = true;
            for (int i=0; i<dirs.length; i++) {
                int newM = cell[0] + dirs[i][0];
                int newN = cell[1] + dirs[i][1];
                if (newM>=0 && newM<m && newN>=0 && newN<n && !toAtlantic[newM][newN] && 
                    matrix[newM][newN] >= matrix[cell[0]][cell[1]])
                    toAtlanticQueue.offer(new int[]{newM, newN});
            }
        }
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (toAtlantic[i][j] && toPacific[i][j])
                    ret.add(Arrays.asList(i, j));
            }
        }
        return ret;
    }
}