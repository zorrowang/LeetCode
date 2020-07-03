class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ret = []
        self.helper(n*2, 0, 0, '', ret)
        return ret
        
    def helper(self, n, left, right, s, ret):
        if left < right or left+right > n:
            return
        elif left == right and left+right == n:
            ret.append(s)
        else:
            self.helper(n, left+1, right, s+'(', ret)
            self.helper(n, left, right+1, s+')', ret)