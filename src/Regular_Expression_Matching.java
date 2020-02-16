public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.isEmpty() && p.isEmpty()) return true;
        if (s.isEmpty() && p.length()>1 && p.charAt(1)=='*')    
            return isMatch(s, p.substring(2));
        if (s.isEmpty() || p.isEmpty()) return false;
        
        if (p.length()>1 && p.charAt(1)=='*'){
            if (isMatch(s, p.substring(2))) return true;
            if (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.')   
                return isMatch(s.substring(1), p);
            else    
                return false;
        }
        else{
            if (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.')   
                return isMatch(s.substring(1), p.substring(1));
            else return false;
        }
        
    }
}

