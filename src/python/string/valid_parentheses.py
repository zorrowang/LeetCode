class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        map = {'(':')', '[':']', '{':'}'}
        q = []
        for c in s:
            if c in map:
                q.append(c)
            else:
                if q and map[q[-1]] == c:
                    q.pop()
                else:
                    return False
        return len(q)==0