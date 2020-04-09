package src.medium.dp;

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
}