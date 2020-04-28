package src.java.hard.string;

public class WildcardMatching {
    // This backtracking solution written by Java can't pass the large test set
    public boolean isMatch(String s, String p) {
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

    // Iterative solution
    // The time complexity is O(m*n)
    public boolean isMatch2(String s, String p) {
        int i=0, startI=-1;
        int j=0, startJ=-1;
        
        while(i<s.length()){
            if (j<p.length()){
                if (s.charAt(i)==p.charAt(j)||p.charAt(j)=='?'){
                    i++;
                    j++;
                }
                else if (p.charAt(j)=='*'){
                    startI = i;
                    startJ = j;
                    j++;
                }
                else if (startI!=-1 && startJ!=-1){
                    i = ++startI;
                    j = startJ+1;
                }
                else 
                    return false;
            }
            else{
                if (startI!=-1 && startJ!=-1){
                    i = ++startI;
                    j = startJ+1;
                }
                else
                    return false;
            }
            
        }
        
        while (j<p.length() && p.charAt(j)=='*')
            j++;
        return j==p.length();
    }
}

