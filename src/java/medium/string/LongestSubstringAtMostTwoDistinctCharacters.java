package src.java.medium.string;

public class LongestSubstringAtMostTwoDistinctCharacters {
    /**
     * @param s: a string
     * @return: the length of the longest substring T that contains at most 2 distinct characters
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s==null || s.isEmpty()) return 0;
        int[] count = new int[256];
        count[s.charAt(0)-'A']++;
        int unique = 1, ret = 1;
        int i=1, j=0;
        for (; i<s.length(); i++) {
            int c = s.charAt(i)-'A';
            if (count[c] == 0)
                unique++;
            while (unique>2) {
                int t = s.charAt(j++)-'A';
                count[t]--;
                if (count[t]==0) {
                    unique--;
                    break;
                }
            }
            count[c]++;
            ret = Math.max(ret, i-j+1);
        }
        return ret;
    }
}