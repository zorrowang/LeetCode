class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        ret = None
        if nums is None or len(nums) <= 2:
            return ret
        nums.sort()
        for i, num in enumerate(nums):
            left = i+1
            right = len(nums)-1
            while left<right:
                val = num + nums[left] + nums[right]
                if ret is None or abs(ret-target) >= abs(val-target):
                    ret = val
                    if val >= target:
                        right -= 1
                    else:
                        left += 1
                elif val <= target:
                    left += 1
                elif val > target:
                    right -= 1
        return ret