package src.java.easy.string;

public class ValidAnagram {
    //Rewritten on 2021/01/25
    public boolean isAnagram(String s, String t) {
        if (s==null || t==null) return false;
        if (s.length() != t.length())   return false;
        int[] cnts = new int[256];
        for (int i=0; i<s.length(); i++) {
            cnts[s.charAt(i)]++;
            cnts[t.charAt(i)]--;
        }
        for (int i=0; i<cnts.length; i++)
            if (cnts[i]!=0) return false;
        return true;
    }
    
    public boolean isAnagram2(String s, String t) {
        int[] counts = new int[26];
        for (int i=0; i<s.length(); i++)
            counts[s.charAt(i)-'a']++;
        for (int i=0; i<t.length(); i++) 
            counts[t.charAt(i)-'a']--;
        for (int i=0; i<26; i++)
            if (counts[i]!=0)
                return false;
        return true;
    }
}