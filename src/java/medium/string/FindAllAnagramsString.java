package src.java.medium.string;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int len = p.length();
        for (int i=0; i<len; i++)
            cnt2[p.charAt(i)-'a']++;
        for (int i=0; i<s.length(); i++) {
            cnt1[s.charAt(i)-'a']++;
            if (i < len-1)   continue;
            if (i >= len)    cnt1[s.charAt(i-len)-'a']--;
            if (isAnagram(cnt1, cnt2))  ret.add(i-len+1);
        }
        return ret;
    }
    
    private boolean isAnagram(int[] cnt1, int[] cnt2) {
        for (int i=0; i<26; i++) {
            if (cnt1[i] != cnt2[i])
                return false;
        }
        return true;
    }
}