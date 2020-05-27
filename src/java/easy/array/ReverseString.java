package src.java.easy.array;

public class ReverseString {
    public void reverseString(char[] s) {
        if (s==null || s.length<=1) return;
        int i = 0, j = s.length-1;
        while(i < j) {
            char t = s[i];
            s[i++] = s[j];
            s[j--] = t;
        }
    }
}