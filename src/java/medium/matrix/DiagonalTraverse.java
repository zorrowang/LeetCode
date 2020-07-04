package src.java.medium.matrix;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix==null || matrix.length==0)   return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int[] ret = new int[m*n];
        int j = 0, s = 0, t = 0;
        for (int i=0; i<=m+n-2; i++) {
            if ((i & 1) != 0) {
                if (i <= n-1) {
                    s = 0; t = i;
                    while (t >= 0 && s < m)
                        ret[j++] = matrix[s++][t--];
                } else {
                    t = n-1; s = i-t;
                    while (s <= m-1 && t >= 0)
                        ret[j++] = matrix[s++][t--];
                }
            } else {
                if (i <= m-1) {
                    s = i; t = 0;
                    while (s >= 0 && t < n)
                        ret[j++] = matrix[s--][t++];
                } else {
                    s = m-1; t = i-s;
                    while (t <= n-1 && s >= 0)
                        ret[j++] = matrix[s--][t++];
                }
            } 
        }
        return ret;
    }
}