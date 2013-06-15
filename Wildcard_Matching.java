// This backtracking solution written by Java can't pass the large test set
// I think it's because of the instinct JVM slowness, but the algorith is correct
public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.isEmpty() && p.isEmpty())   return true;
        if(s.isEmpty() && p.charAt(0)=='*')   return isMatch(s, p.substring(1));
        if(s.isEmpty() || p.isEmpty())  return false;
        
        char ch1 = s.charAt(0);
        char ch2 = p.charAt(0);
        
        if (ch1==ch2 || ch2=='?')
            return isMatch(s.substring(1), p.substring(1));
        else if (ch2=='*')
            if(isMatch(s, p.substring(1)))  return true;
            else    return isMatch(s.substring(1), p);
        else
            return false;
    }
}
