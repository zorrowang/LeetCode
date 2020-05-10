package src.java.easy.string;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] nums = new int[256];
        boolean odd = false;
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'A']++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                ret += nums[i];
            } else {
                ret += nums[i] - 1;
                odd = true;
            }
        }
        return odd ? ret+1 : ret;
    }
}