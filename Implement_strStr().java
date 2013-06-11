public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(needle.isEmpty())    return haystack;
        int i=0;
        for(; i<haystack.length()-needle.length()+1; i++){
            if (isSubstring(haystack, i, needle))
                return haystack.substring(i);
        }
        return null;
    }
    
    public boolean isSubstring(String haystack, int start, String needle){
        for(int i=0; i<needle.length(); i++){
            if(start>=haystack.length())    return false;
            if (needle.charAt(i)!=haystack.charAt(start++)) return false;
        }
        return true;
    }
}