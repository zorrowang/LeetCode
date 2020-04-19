package src.medium.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {
    // BFS for Backtracking
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<String>();
        LinkedList<String> list1 = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        
        int length = 1;
        boolean flag = false;
        list1.add(beginWord);
        set.add(beginWord);
        
        while(!list1.isEmpty()){
            String str = list1.poll();
            if (str.equals(endWord)){
                flag = true;
                break;
            }
            
            for(int i=0; i<str.length(); i++){
                String str1 = str.substring(0, i);
                String str2 = str.substring(i+1);
                for(int j=0; j<26; j++){
                    char ch = (char)('a'+j);
                    String newStr = str1+ch+str2;
                    if (!set.contains(newStr) && wordList.contains(newStr)){
                        set.add(newStr);
                        list2.offer(newStr);
                    }
                }
            }
            
            if (list1.isEmpty() && !list2.isEmpty()){
                list1 = list2;
                list2 = new LinkedList<String>();
                length++;
            }
        }
        
        return flag?length:0;
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
}