package src.java.medium.array;

public class SortColors {
	// One-pass algorithm using only constant space
	public void sortColors(int[] nums) {
        if (nums==null || nums.length==0) return;
        
        int redSt=0, blueSt=nums.length-1;
        int i=0;
        
        while(i<=blueSt){
            if (nums[i] == 0)
                swap(nums, redSt++, i++);
            else if (nums[i] == 2)
                swap(nums, blueSt--, i);
            else
                i++;
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

