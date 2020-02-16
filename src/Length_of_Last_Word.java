public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null || s.isEmpty())  return 0;
        s = s.trim();
        int i=s.length()-1;
        int ret=0;
        
        while(i>=0 && Character.isLetter(s.charAt(i))){
            i--;
            ret++;
        }
        return ret;
    }
}

