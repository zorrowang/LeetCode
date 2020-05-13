package src.java.medium.string;

public class MinimumAddParenthesesValid {
    public int minAddToMakeValid(String S) {
        int ret = 0, left = 0;
        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(')   left++;
            else {
                if (left > 0)   left--;
                else ret++;
            }
        }
        return ret+left;
    }
}