class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ret = []
        if nums is None or len(nums) <= 2:
            return ret
        nums.sort()
        for i,num in enumerate(nums):
            if i > 0 and num == nums[i-1]:
                continue;
            j = i + 1
            k = len(nums) - 1
            while j<k:
                if num + nums[j] + nums[k] == 0:
                    ret.append([num, nums[j], nums[k]])
                    while True:
                        j = j+1
                        if j>=k or nums[j]!=nums[j-1]:
                            break
                    while True:
                        k = k-1
                        if j>=k or nums[k]!=nums[k+1]:
                            break
                elif num + nums[j] + nums[k] > 0:
                    k = k-1
                elif num + nums[j] + nums[k] < 0:
                    j = j+1
        return ret