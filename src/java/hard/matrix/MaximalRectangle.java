package src.java.hard.matrix;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length==0)   return 0;
        int ret = 0;
        
        int[][] nums = new int[matrix.length][matrix[0].length];
        for (int i=0; i<nums.length; i++){
            for (int j=0; j<nums[i].length; j++){
                if (matrix[i][j]=='0')
                    nums[i][j] = 0;
                else{
                    if (j==0)   nums[i][j] = 1;
                    else    nums[i][j] = nums[i][j-1]+1;
                }
            }
        }
        
        for (int i=0; i<nums.length; i++){
            for (int j=0; j<nums[i].length; j++){
                if (nums[i][j]>0){
                    int min = nums[i][j];
                    for (int s=i; s<nums.length; s++){
                        if (nums[s][j]==0)  break;
                        min = Math.min(nums[s][j], min);
                        ret = Math.max(ret, min*(s-i+1));
                    }
                }
            }
        }
        
        return ret;
    }
}