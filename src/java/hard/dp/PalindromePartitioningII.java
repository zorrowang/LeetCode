package src.java.hard.dp;

public class PalindromePartitioningII {
    public int minCut(String s) {
        // dp[i][j] = min cut between i-th and j-th element
        // dp[i][j] = 0 if s[i]=s[j] && dp[i+1][j-1]==0
        //          = min{dp[i][t] + dp[t+1][j]} + 1 | i<=t<=j if s[i]!=s[j]
        if (s==null || s.length()<=1)   return 0;
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i=len-1; i>=0; i--) {
            for (int j=i+1; j<len; j++) {
                if (s.charAt(i)==s.charAt(j) && (j-i<=1 || dp[i+1][j-1]==0)) {
                    dp[i][j] = 0;
                } else {
                    for (int t=i; t<j; t++) {
                        if (dp[i][j] == 0)
                            dp[i][j] = dp[i][t]+dp[t+1][j]+1;
                        else
                            dp[i][j] = Math.min(dp[i][j], dp[i][t]+dp[t+1][j]+1);
                    }
                }
            }
        }
        return dp[0][len-1];
    }
    
    //Reference: http://fisherlei.blogspot.com/2013/03/leetcode-palindrome-partitioning-ii.html
    public int minCut2(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null || s.length()<=1)    return 0;
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        int[] ret = new int[s.length()+1];
        
        for(int i=0; i<s.length(); i++)
            ret[i] = s.length()-i;
        
        for (int i=s.length()-1; i>=0; i--){
            for (int j=i; j<s.length(); j++){
                if (s.charAt(i)==s.charAt(j)&&(j-i<=1||palindrome[i+1][j-1])){
                    palindrome[i][j]=true;
                    ret[i] = Math.min(ret[i], ret[j+1]+1);
                }
            }
        }
        
        return ret[0]-1;
    }
}

