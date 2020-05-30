package src.java.medium.array;

public class ReverseWordsStringII {
    /**
     * @param str: a string
     * @return: return a string
     */
    public char[] reverseWords(char[] str) {
        // write your code here
        if (str==null || str.length==0) return str;
        reverse(str, 0, str.length-1);
        int s=0;
        for (int i=0; i<str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, s, i-1);
                s = i+1;
            }
        }
        // reverse the tailing one
        if (s < str.length) reverse(str, s, str.length-1);
        return str;
    }
    
    private void reverse(char[] str, int start, int end) {
        while(start < end) {
            char t = str[start];
            str[start++] = str[end];
            str[end--] = t;
        }
    }
}