package src.java.medium.string;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> ret = new ArrayList<>();
        int[] target = compress(B);
        for (String s : A) {
            if (verify(transfer(s), target))
                ret.add(s);
        }
        return ret;
    }
    
    private int[] transfer(String s) {
        int[] ret = new int[26];
        for (int i=0; i<s.length(); i++)
            ret[s.charAt(i)-'a']++;
        return ret;
    }
    
    private int[] compress(String[] strs) {
        int[] ret = new int[26];
        for (String s : strs) {
            int[] cnt = transfer(s);
            for (int i=0; i<26; i++)
                ret[i] = Math.max(ret[i], cnt[i]);
        }
        return ret;
    }
    
    private boolean verify(int[] cnt, int[] target) {
        for (int i=0; i<26; i++) {
            if (cnt[i] < target[i])  return false;
        }
        return true;
    }
}