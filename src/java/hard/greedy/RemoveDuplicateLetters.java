package src.java.hard.greedy;

import java.util.LinkedList;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        boolean[] included = new boolean[26];
        for(int i=0; i<s.length(); i++)
            cnt[s.charAt(i)-'a']++;
        
        LinkedList<Character> stack = new LinkedList<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!included[c-'a']) {
                while (!stack.isEmpty() && stack.peek()>c && cnt[stack.peek()-'a']>0)
                    included[stack.pop()-'a'] = false;
                stack.push(c);
                included[c-'a'] = true;
            }
            cnt[c-'a']--;
        }
        
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty())
            builder.insert(0, stack.pop());
        return builder.toString();
    }
}