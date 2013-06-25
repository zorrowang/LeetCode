public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (S==null || T==null) return null;
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        
        int[] letters = new int[256];
        int[] found = new int[256];
        int start = 0;
        int num = 0, foundNum = 0;
        String ret = new String();
        
        for (int i=0; i<t.length; i++){
            if (letters[t[i]-'A'] == 0)
                num++;
            letters[t[i]-'A']++;
        }
        
        for (int i=0; i<s.length; i++){
            found[s[i]-'A']++;
            if (found[s[i]-'A'] == letters[s[i]-'A'])
                foundNum++;
            if (foundNum == num){
                while(start<i && found[s[start]-'A']>letters[s[start]-'A']){
                    found[s[start]-'A']--;
                    start++;
                }
                if (ret.isEmpty() || ret.length()>i-start+1)
                    ret = S.substring(start, i+1);
            }
        }
        
        return ret;
    }
}