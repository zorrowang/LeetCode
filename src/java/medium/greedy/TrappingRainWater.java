package src.java.medium.greedy;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height==null || height.length==0) return 0;
        int h=0;
        int left=0, right=height.length-1;
        int ret=0;
        
        while(left<right){
            h = Math.max(h, Math.min(height[left], height[right]));
            ret += h-Math.min(height[left], height[right]);
            if (height[left] > height[right]) right--;
            else    left++;
        }
        
        return ret;
    }
}