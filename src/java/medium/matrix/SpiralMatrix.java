package src.java.medium.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // Written on 2021/01/19
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix == null || matrix.length==0 || matrix[0].length==0)
            return ret;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n-1;
        int up = 0, down = m-1;
        while (ret.size() < m*n) {
            for (int i=left; i<=right && ret.size() < m*n; i++)
                ret.add(matrix[up][i]);
            for (int i=up+1; i<=down && ret.size() < m*n; i++)
                ret.add(matrix[i][right]);
            for (int i=right-1; i>=left && ret.size() < m*n; i--)
                ret.add(matrix[down][i]);
            for (int i=down-1; i>up && ret.size() < m*n; i--)
                ret.add(matrix[i][left]);
            left++; right--; up++; down--;
        }
        return ret;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        if (matrix==null)   return null;
        List<Integer> ret = new ArrayList<>();
        if (matrix.length==0 || matrix[0].length==0)    return ret;
        for (int i=0; matrix.length>2*i && matrix[0].length>2*i; i++)
            ret.addAll(spiralOrder(matrix, i));
        return ret;
    }
    
    public List<Integer> spiralOrder(int[][] matrix, int level) {
        List<Integer> ret = new ArrayList<>();
        
        if(matrix.length-level*2==1 && matrix[0].length-level*2>1){
            for(int i=level; i<matrix[0].length-level; i++)
                ret.add(matrix[level][i]);
        }
        else if(matrix[0].length-level*2==1){
            for(int i=level; i<matrix.length-level; i++)
                ret.add(matrix[i][level]);
        }
        else{
            for(int i=level; i<matrix[0].length-level-1; i++)
                ret.add(matrix[level][i]);
            for(int i=level; i<matrix.length-level-1; i++)
                ret.add(matrix[i][matrix[0].length-level-1]);
            for(int i=level; i<matrix[0].length-level-1; i++)
                ret.add(matrix[matrix.length-level-1][matrix[0].length-i-1]);
            for(int i=level; i<matrix.length-level-1; i++)
                ret.add(matrix[matrix.length-i-1][level]);
        }
        
        return ret;
    }
}