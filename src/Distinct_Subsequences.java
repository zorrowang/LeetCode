// The question description is very confusing
public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (S==null || T==null || S.isEmpty()) return 0;
        if (T.isEmpty())    return 1;
        
        char[] arr1 = S.toCharArray();
        char[] arr2 = T.toCharArray();
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