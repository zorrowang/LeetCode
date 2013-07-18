// If there is no duplicate letters in the string, the algorithm below works more effeciently
public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1.equals(s2))  return true;
        if (s1.length()==1 && !s1.equals(s2))   return false;
        char start = s1.charAt(0);
        int index=0;
        while(index<s2.length()&&start!=s2.charAt(index))
            index++;

        if (index==s2.length()) return false;
        
        if (index==s2.length()-1)
            return isScramble(s1.substring(1), s2.substring(0, s2.length()-1));
        else{
            if (index==(s2.length()-1)/2 && isScramble(s1.substring(0, index+1), s2.substring(index))
                &&isScramble(s1.substring(index+1), s2.substring(0, index)))
                return true;
            return isScramble(s1.substring(0, index+1), s2.substring(0, index+1))
                &&isScramble(s1.substring(index+1), s2.substring(index+1));
        }
    }
}

public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1.length()!=s2.length())   return false;
        if (s1.equals(s2))  return true;
        
        int[] check = new int[256];
        for (int i=0; i<s1.length(); i++)
            check[s1.charAt(i)-'A']++;
        
        for (int i=0; i<s2.length(); i++)
            check[s2.charAt(i)-'A']--;
        
        for (int i=0; i<256; i++)
            if (check[i]!=0)    return false;
        
        for (int i=1; i<s1.length(); i++) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i))
                &&isScramble(s1.substring(i), s2.substring(i))) ||
                (isScramble(s1.substring(0, i), s2.substring(s2.length()-i))
                &&isScramble(s1.substring(i), s2.substring(0, s2.length()-i))))
                return true;
        }
        return false;
    }
}