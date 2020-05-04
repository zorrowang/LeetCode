package src.java.medium.string;

import java.util.Arrays;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        if (words == null || words.length==0)
            return 0;
        Arrays.sort(words, (w1, w2) -> w1.length()-w2.length());
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        int ret = 1;
        for (int i=1; i<words.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (isPredecessor(words[j], words[i]))
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
    
    private boolean isPredecessor(String w1, String w2) {
        if (w1.length()!=w2.length()-1)
            return false;
        int i=0;
        boolean flag = false;
        for (int j=0; j<w1.length(); j++) {
            if (w1.charAt(j) != w2.charAt(i++)) {
                if (flag || w1.charAt(j) != w2.charAt(i++))
                    return false;
                else
                    flag = true;
            }
        }
        return true;
    }
}