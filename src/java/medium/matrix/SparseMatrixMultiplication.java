package src.java.medium.matrix;

import java.util.ArrayList;
import java.util.List;

public class SparseMatrixMultiplication {
    // skip 0's
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int t = A[0].length;
        int n = B[0].length;
        
        int[][] ret = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < t; k++) {
                if (A[i][k] != 0) {        
                    for (int j = 0; j < n; j++)
                        ret[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return ret;
    }

    // Compress sparse matrix
    public int[][] multiply2(int[][] A, int[][] B) {
        int m = A.length;
        int t = A[0].length;
        int n = B[0].length;
        
        int[][] ret = new int[m][n];
        
        List<Integer>[] index = new List[m];
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                if (A[i][j] != 0) {
                    list.add(j);
                    list.add(A[i][j]);
                }
            }
            index[i] = list;
        }
        
        for (int i = 0; i < m; i++) {
            List<Integer> list = index[i];
            for (int p = 0; p < list.size() - 1; p += 2) {
                int col = list.get(p);
                int val = list.get(p + 1);
                for (int j = 0; j < n; j++) {
                    ret[i][j] += val * B[col][j];
                }
            }
        }
        
        return ret;
    }
}