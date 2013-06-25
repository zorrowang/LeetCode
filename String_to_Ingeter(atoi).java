public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long ret = 0L;
        if (str==null || str.isEmpty()) return (int)ret;
        str = str.trim();
        int neg = 1;
        if (str.charAt(0)=='-'){
            neg = -1;
            str = str.substring(1);
        }
        else if (str.charAt(0)=='+')
            str = str.substring(1);
            
        for (int i=0; i<str.length(); i++){
            if (Character.isDigit(str.charAt(i))){
                ret *= 10;
                ret += (str.charAt(i)-'0');
                if (ret>Integer.MAX_VALUE)
                    return (neg<0)?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            else
                return (int)ret*neg;
        }
        
        return (int)ret*neg;
    }
}