package src.hard.string;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s==null || t==null) return null;
        
        int[] letters = new int[256];
        int[] found = new int[256];
        int start = 0;
        int num = 0, foundNum = 0;
        String ret = "";
        
        for (int i=0; i<t.length(); i++){
            if (letters[t.charAt(i)-'A'] == 0)
                num++;
            letters[t.charAt(i)-'A']++;
        }
        
        for (int i=0; i<s.length(); i++){
            int index = s.charAt(i)-'A';
            found[index]++;
            if (found[index] == letters[index])
                foundNum++;
            if (foundNum == num){
                while(start<i && found[s.charAt(start)-'A']>letters[s.charAt(start)-'A']){
                    found[s.charAt(start++)-'A']--;
                }
                if (ret.isEmpty() || ret.length()>i-start+1)
                    ret = s.substring(start, i+1);
            }
        }
        
        return ret;
    }
}