package src.java.hard.matrix;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    class UnionFind {
        int[] parents;

        UnionFind(int n) {
            parents = new int[n];
            for (int i=0; i<n; i++)
                parents[i] = i;
        }
        
        int find(int p) {
            while(p != parents[p])
                p = parents[p];
            return p;
        }
        
        boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parents[rootQ] = rootP;
                return true;
            }
            return false;
        }
    }
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        UnionFind uf = new UnionFind(n*m);
        List<Integer> ret = new ArrayList<>();
        if (operators == null)  return ret;
        boolean[][] matrix = new boolean[n][m];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int cnt = 0;
        for (int i=0; i<operators.length; i++) {
            Point p = operators[i];
            if (!matrix[p.x][p.y]) {
                matrix[p.x][p.y] = true;
                cnt++;
                int index = p.x*m + p.y;
                for (int j=0; j<4; j++) {
                    int newX = p.x + dirs[j][0];
                    int newY = p.y + dirs[j][1];
                    if (newX>=0 && newX<n && newY>=0 && newY<m && matrix[newX][newY]) {
                        int newIndex = newX*m + newY;
                        if (uf.union(index, newIndex))
                            cnt--;
                    }
                }
            }
            ret.add(cnt);
        }
        return ret;
    }
}