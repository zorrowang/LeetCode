package src.java.medium.string;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        if (s==null || s.isEmpty()) return 0;
        int ret = 0;
        int i=0, j=0;
        while(i<s.length() && j<s.length()) {
            if (isValid(cnt, k)) {
                ret = Math.max(ret, i-j);
                cnt[s.charAt(i++)-'A']++;
            }
            else
                cnt[s.charAt(j++)-'A']--;
        }
        if (isValid(cnt, k))    ret = Math.max(ret, i-j);
        return ret;
    }
    
    private boolean isValid(int[] cnt, int k) {
        int sum = 0, max = 0;
        for (Integer i : cnt) {
            sum += i;
            max = Math.max(max, i);
        }
        return sum-max<=k;
    }
}