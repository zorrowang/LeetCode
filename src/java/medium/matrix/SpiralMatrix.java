package src.java.medium.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
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