public class Solution {
    public String getHint(String secret, String guess) {
        int[] chars = new int[10];
        for (int i=0; i<secret.length(); i++) {
            chars[secret.charAt(i)-'0']++;
        }
        int bulls = 0;
        int cows = 0;
        for (int i=0; i<guess.length(); i++) {
            char c = guess.charAt(i);
            if (chars[c-'0']>0) {
                cows++;
                chars[c-'0']--;
            }
            if (secret.length() > i && secret.charAt(i) == c) {
                bulls++;
            }
        }
        return Integer.toString(bulls) + "A" + Integer.toString(cows-bulls>0?cows-bulls:0) + "B";
    }
}