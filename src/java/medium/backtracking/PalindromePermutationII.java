package src.java.medium.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePermutationII {
    /**
     * @param s: the given string
     * @return: all the palindromic permutations (without duplicates) of it
     */
    public List<String> generatePalindromes(String s) {
        // write your code here
        List<String> ret = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        int[] counts = new int[26];
        for(int i=0; i<s.length(); i++) {
            counts[s.charAt(i)-'a']++;
        }
        String odd = "";
        for(int i=0; i<26; i++) {
            if (counts[i]%2 == 1) {
                odd += (char)(i+'a');
                for (int j=0; j*2<counts[i]-1; j++)
                    chars.add((char)(i+'a'));
            } else {
                for (int j=0; j*2<counts[i]; j++)
                    chars.add((char)(i+'a'));
            }         
        }
        if (odd.length() > 1)    return ret;
        
        permute(chars, new ArrayList<>(), new HashSet<>(), ret, odd);
        return ret;
    }
    
    private void permute(List<Character> chars, List<Character> list, Set<Integer> used,
        List<String> ret, String odd) {
        if (list.size() == chars.size()) {  
            ret.add(buildString(list, odd));
            return;
        }
        for (int i=0; i<chars.size(); i++) {
            if (i>0 && chars.get(i-1) == chars.get(i) && !used.contains(i-1))
                continue;
            if (!used.contains(i)) {
                used.add(i);
                list.add(chars.get(i));
                permute(chars, list, used, ret, odd);
                list.remove(list.size()-1);
                used.remove(i);
            }
        }
    }
    
    private String buildString(List<Character> list, String odd) {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<list.size(); i++)
            builder.append(list.get(i));
        builder.append(odd);
        for(int i=list.size()-1; i>=0; i--)
            builder.append(list.get(i));
        return builder.toString();
    }
}