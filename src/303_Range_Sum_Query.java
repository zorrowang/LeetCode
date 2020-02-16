public class NumArray {
    int sum;
    int[] leftToRight;
    int[] rightToLeft;

    public NumArray(int[] nums) {
        leftToRight = new int[nums.length];
        rightToLeft = new int[nums.length];
        if (nums.length > 0) {
            leftToRight[0] = nums[0];
            rightToLeft[nums.length-1] = nums[nums.length-1];
            
            for(int i=1; i<nums.length; i++) {
                leftToRight[i] = leftToRight[i-1] + nums[i];
                rightToLeft[nums.length-i-1] = rightToLeft[nums.length-i] + nums[nums.length-i-1];
            }
            sum = leftToRight[nums.length-1];
        } else {
            sum = 0;
        }
    }

    public int sumRange(int i, int j) {
        int left = i<=0 ? 0 : leftToRight[i-1];
        int right = j>=rightToLeft.length-1 ? 0 : rightToLeft[j+1];
        return sum - left - right;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);