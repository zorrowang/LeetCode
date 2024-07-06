package src.java.medium.dp;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s==null || s.isEmpty()) return "";
        int start=0;
        int ret=1;
        
        int[][] dp = new int[s.length()][s.length()];
        for (int i=0; i<s.length(); i++){
            dp[i][i] = 1;
            if (i<s.length()-1){
                if (s.charAt(i)==s.charAt(i+1)){
                    dp[i][i+1] = 2;
                    start = i;
                    ret = 2;
                }
                else
                    dp[i][i+1] = 1;
            }
        }
        
        for (int i=s.length()-3; i>=0; i--){
            for (int j=i+2; j<s.length(); j++){
                if (s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==j-i-1){
                    dp[i][j] = j-i+1;
                    if (ret < dp[i][j]){
                        start = i;
                        ret = j-i+1;
                    }
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        return s.substring(start, start+ret);
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.isEmpty())   return s;
        int size = s.length();
        int[][] dp = new int[size][size];
        String ret = s.substring(0, 1);
        for (int i = 0; i < size; i++) {
            dp[i][i] = 1;
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                dp[i-1][i] = 2;
                ret = s.substring(i-1, i+1);
            }
        }
        for (int i = 2; i < size; i++) {
            for (int j = 0; j < i - 1; j++) {
                if (s.charAt(i) == s.charAt(j) && dp[j+1][i-1] > 0) {
                    dp[j][i] = Math.max(dp[j][i], dp[j+1][i-1] + 2);
                    if (ret.length() < dp[j][i])
                        ret = s.substring(j, i + 1);
                }
            }
        }
        return ret;
    }
}