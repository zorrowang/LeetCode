package src.java.medium.dp;

import java.util.List;

//Recursive solution doesn't pass test set
public class WordBreak {
    public boolean wordBreak(String s, List<String> dict) {
        if (s==null || s.length()==0)
            return false;
        return wordBreak(s, 0, dict);
    }
    
    public boolean wordBreak(String s, int start, List<String> dict) {
        for (int i=start+1; i<=s.length(); i++){
            if (dict.contains(s.substring(start, i))){
                if (wordBreak(s, i, dict))
                    return true;
            }
        }
        return false;
    }

    //DP solution
    public boolean wordBreak1(String s, List<String> dict) {
        if (s==null || s.length()==0)
            return false;
        boolean[] ret = new boolean[s.length()+1];
        ret[0] = true;
        
        for (int i=1; i<=s.length(); i++){
            for (int j=0; j<i; j++){
                if (ret[j] && dict.contains(s.substring(j,i))){
                    ret[i] = true;
                    break;
                }
            }
        }
        return ret[s.length()];
    }

    // Rewrite on 2020/04/19
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j<i; j++) {
                String str = s.substring(j, i);
                if (wordDict.contains(str) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}