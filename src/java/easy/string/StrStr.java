package src.java.easy.string;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())    return 0;
        for(int i=0; i<haystack.length()-needle.length()+1; i++){
            if (isSubstring(haystack, i, needle))
                return i;
        }
        return -1;
    }
    
    private boolean isSubstring(String haystack, int start, String needle){
        for(int i=0; i<needle.length(); i++){
            if(start>=haystack.length())    return false;
            if (needle.charAt(i)!=haystack.charAt(start++)) return false;
        }
        return true;
    }
}
