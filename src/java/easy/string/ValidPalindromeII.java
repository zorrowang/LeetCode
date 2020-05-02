package src.java.easy.string;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }

        if (i >= j) return true;

        if (isValid(s, i + 1, j) || isValid(s, i, j - 1))
            return true;
        return false;
    }

    private boolean isValid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++; 
                j--;
            }
            else 
                return false;
        }
        return true;
    }
}