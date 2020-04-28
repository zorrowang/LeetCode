package src.java.easy.array;

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0; // 0 pointer
        while (i < nums.length && nums[i] != 0) i++;
        if (i == nums.length)   return; // no 0's
        int j = i+1; // first pointer after 0's pointer
        while (i < nums.length && j < nums.length) {
            nums[i] = nums[j];
            nums[j] = 0;
            while (i < nums.length && nums[i] != 0) i++;
            j = i+1;
            while (j < nums.length && nums[j] == 0) j++;
        }
    }
}