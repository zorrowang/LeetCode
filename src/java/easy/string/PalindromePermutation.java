package src.java.easy.string;

public class PalindromePermutation {
    /**
     * @param s: the given string
     * @return: if a permutation of the string could form a palindrome
     */
    public boolean canPermutePalindrome(String s) {
        // write your code here
        int[] array = new int[26];
        for(int i=0; i<s.length(); i++) {
            array[s.charAt(i)-'a']++;
        }
        int odd = 0;
        for(int i : array) {
            if (i%2 == 1)
                odd++;
        }
        return odd<=1;
    }
}