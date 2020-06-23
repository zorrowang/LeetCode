package src.java.medium.string;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null)   return false;
        if (s1.isEmpty() && s2.isEmpty())   return true;
        if (s1.isEmpty() || s2.isEmpty())   return false;
        int[] check = new int[26];
        int[] window = new int[26];
        for (int i=0; i<s1.length(); i++)
            check[s1.charAt(i) - 'a']++;
        int i = 0, j = 0;
        while (j < s1.length() && j < s2.length())
            window[s2.charAt(j++) - 'a']++;
        if (verify(window, check))  return true;
        while (j < s2.length()) {
            window[s2.charAt(j++) - 'a']++;
            window[s2.charAt(i++) - 'a']--;
            if (verify(window, check))  return true;
        }
        return false;
    }
    
    private boolean verify(int[] window, int[] check) {
        for (int t = 0; t < 26; t++) {
            if (window[t] != check[t]) {
                return false;
            }
        }
        return true;
    }
}