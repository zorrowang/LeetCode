//Recursive solution doesn't pass test set
public class Solution {
    public boolean wordBreak(String s, HashSet<String> dict) {
        if (s==null || s.length()==0)
            return false;
        return wordBreak(s, 0, dict);
    }
    
    public boolean wordBreak(String s, int start, HashSet<String> dict) {
        for (int i=start+1; i<=s.length(); i++){
            if (dict.contains(s.substring(start, i))){
                if (wordBreak(s, i, dict))
                    return true;
            }
        }
        return false;
    }
}