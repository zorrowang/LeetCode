class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        index = {}
        for i,v in enumerate(nums):
            if target-v in index:
                return [index[target-v], i]
            else:
                index[v] = i
        raise Exception('Not found any valid result!')