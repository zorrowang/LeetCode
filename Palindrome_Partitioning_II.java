public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null || s.length()<=1)    return 0;
        
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i=1; i<=s.length(); i++){
            for (int j=i-1; j>=0; j--){
                if (isPalindrome(s.substring(j, i))){
                    if (j==0)   
                        dp[i] = 0;
                    else
                        dp[i] = Math.min(dp[j]+1, dp[i]);
                }
            }
        }
        
        return dp[s.length()];
    }
    
    public boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if (s.charAt(i++)!=s.charAt(j--))
                return false;
        }
        return true;
    }
}