package src.java.medium.greedy;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height==null || height.length==0)   return 0;
        int left=0, right=height.length-1;
        int ret=0;
        
        while(left<right){
            ret = Math.max(ret, Math.min(height[left], height[right])*(right-left));
            if (height[left]<height[right]) left++;
            else right--;
        }
        return ret;
    }
}