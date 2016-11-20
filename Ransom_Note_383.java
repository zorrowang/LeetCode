public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];
        for (int i=0; i<magazine.length(); i++) {
            counts[magazine.charAt(i)-'a']++;
        }
        for (int i=0; i<ransomNote.length(); i++) {
            if (counts[ransomNote.charAt(i)-'a'] == 0) {
                return false;
            }
            counts[ransomNote.charAt(i)-'a']--;
        }
        return true;
    }
}