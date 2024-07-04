package src.java.medium.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    // BFS for Backtracking
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        
        int len = 1;
        queue.add(beginWord);
        visited.add(beginWord);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.equals(endWord))    return len;
                
                for(int j = 0; j < str.length(); j++) {
                    for(int k = 'a'; k <= 'z'; k++){
                        char[] array = str.toCharArray();
                        array[j] = (char) k;
                        String newStr = new String(array);
                        if (!visited.contains(newStr) && set.contains(newStr)){
                            visited.add(newStr);
                            queue.add(newStr);
                        }
                    }
                }
            }
            len++;
        }
        return 0;
    }

    // DFS for Backtracking
    private int ret = Integer.MAX_VALUE;
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> used = new HashSet<String>(Arrays.asList(beginWord));
        ladderLengthRec(beginWord, endWord, wordList, used, 1);
        return ret==Integer.MAX_VALUE?0:ret;
    }
    
    private int ladderLengthRec(String beginWord, String endWord, List<String> wordList, HashSet<String> used, int cur) {
        if (beginWord.equals(endWord)) {
            ret = Math.min(ret, cur);
            return ret;
        }
        
        char[] chars = beginWord.toCharArray();
        for(int i=0; i<chars.length; i++){
            char c = chars[i];
            for(int j=0; j<26; j++){
                chars[i] = (char)('a'+j);
                String newStr = new String(chars);
                if (!used.contains(newStr) && wordList.contains(newStr)){
                    used.add(newStr);
                    ladderLengthRec(newStr, endWord, wordList, used, cur+1);
                    used.remove(newStr);
                }
            }
            chars[i] = c;
        }
        return Integer.MAX_VALUE;
    }

    // DFS without using global variable
    public int ladderLengthDfs(String beginWord, String endWord, List<String> wordList) {
        return dfs(beginWord, endWord, wordList, 1, new HashSet<>());
    }
    
    private int dfs(String beginWord, String endWord, List<String> wordList, int level, Set<String> used) {
        if (beginWord.equals(endWord))  return level;
        if (wordList.size() == used.size()) return 0;
        
        int ret = 0;
        for (int i=0; i<wordList.size(); i++) {
            String s = wordList.get(i);
            if (used.contains(s))   continue;
            if (canTransfer(beginWord, s)) {
                used.add(s);
                int t = dfs(s, endWord, wordList, level+1, used);
                if (t > 0) {
                    if (ret==0) ret = t;
                    else ret = Math.min(ret, t);
                }
                used.remove(s);
            }
        }
        return ret;
    }
    
    private boolean canTransfer(String s1, String s2) {
        int count = 0;
        for (int i=0; i<s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i))
                count++;
        return count==1;
    }
}