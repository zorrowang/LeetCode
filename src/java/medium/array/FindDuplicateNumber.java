package src.java.medium.array;

import java.util.Arrays;

public class FindDuplicateNumber {
    // Similar to "detect cycle in linked list"
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
		int fast = nums[nums[0]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		fast = 0;
		while (fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
    }

    // O(nlogn) solution
    // Modify the input array
    public int findDuplicate2(int[] nums) {
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