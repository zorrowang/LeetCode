package src.java.hard.dp;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        // dp[i][j]: the number of distinct subsequences of t[1..j] from s[1..i] 
        // dp[i][j] = dp[i-1][j-1] + dp[i-1][j] if s[i] == s[j]
        if (s==null || t==null || s.isEmpty()) return 0;
        if (t.isEmpty())    return 1;
        
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int[][] dp = new int[arr1.length+1][arr2.length+1];
        
        for(int i=1; i<=arr1.length; i++){
            if (arr1[i-1] == arr2[0])
                dp[i][1] = dp[i-1][1]+1;
            else
                dp[i][1] = dp[i-1][1];
        }
        
        for(int i=2; i<=arr1.length; i++){
            for(int j=2; j<=arr2.length; j++){
                if (arr1[i-1]==arr2[j-1])
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            } 
        }
        
        return dp[arr1.length][arr2.length];
    }
}