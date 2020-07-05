package src.java.hard.string;

public class LongestSubstringWithAtMostKDistinctCharacters {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s==null || s.isEmpty() || k==0) return 0;
        int[] cnt = new int[256];
        int ret = 0,  unique = 0;
        for (int i=0, j=0; i<s.length(); i++) {
            int index = (int)(s.charAt(i)-'A');
            cnt[index]++;
            if (cnt[index]==1)  unique++;
            if (unique <= k)    ret = Math.max(ret, i-j+1);
            while (unique > k && j<=i) {
                if (--cnt[s.charAt(j++)-'A']==0)  unique--;
            }
        }
        return ret;
    }
}