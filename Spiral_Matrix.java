public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix==null)   return null;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (matrix.length==0 || matrix[0].length==0)    return ret;
        for (int i=0; matrix.length>2*i&&matrix[0].length>2*i; i++)
            ret.addAll(spiralOrder(matrix, i));
        return ret;
    }
    
    public ArrayList<Integer> spiralOrder(int[][] matrix, int level) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        
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