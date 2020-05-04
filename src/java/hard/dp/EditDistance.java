package src.java.hard.dp;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        // dp[i][j]: the min distance from word1[1..i] to word2[1..j]
        // dp[i][j] = dp[i-1][j-1] if word1[i] == word2[j]
        //            min{dp[i-1][j](insert), dp[i-1][j-1](replace), dp[i][j-1](delete)} + 1
        if (word1==null || word2==null)  return 0;
        if (word1.isEmpty() || word2.isEmpty())
            return word1.isEmpty()?word2.length():word1.length();
        
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        
        int[][] dp = new int[arr1.length+1][arr2.length+1];
        
        for (int i=1; i<=arr1.length; i++){
            if (arr1[i-1]==arr2[0])
                dp[i][1] = i-1;
            else
                dp[i][1] = dp[i-1][1]+1;
        }
        
        for (int i=1; i<=arr2.length; i++){
            if (arr2[i-1]==arr1[0])
                dp[1][i] = i-1;
            else
                dp[1][i] = dp[1][i-1]+1;
        }
        
        for (int i=2; i<=arr1.length; i++){
            for (int j=2; j<=arr2.length; j++){
            if (arr1[i-1]==arr2[j-1])
                dp[i][j] = dp[i-1][j-1];
            else
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
            }
        }
        
        return dp[arr1.length][arr2.length];
    }
}