// O(nlgn) solution
public class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == pre) {
                return pre;
            }
            pre = nums[i];
        }
        return pre;
    }
}