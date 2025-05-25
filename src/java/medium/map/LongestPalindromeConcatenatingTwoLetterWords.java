package java.medium.map;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        int pCnt = 0, sCnt = 0;
        Map<String, Integer> pMap = new HashMap<>();
        Map<String, Integer> sMap = new HashMap<>();
        for (String str : words) {
            if (str.charAt(0) == str.charAt(1)) {
                sMap.put(str, sMap.getOrDefault(str, 0) + 1);
            }
            else {
                String tmp = new StringBuilder(str).reverse().toString();
                if (pMap.containsKey(tmp) && pMap.get(tmp) > 0) {
                    pCnt++;
                    pMap.put(tmp, pMap.get(tmp)-1);
                } else {
                    pMap.put(str, pMap.getOrDefault(str, 0)+1);
                }
            }
        }
        boolean odd = false;
        for (Map.Entry<String, Integer> entry : sMap.entrySet()) {
            int cnt = entry.getValue();
            if (cnt % 2 == 1) {
                sCnt += cnt - 1;
                odd = true;
            } else {
                sCnt += cnt;
            }
        }
        return odd ? pCnt*4 + sCnt*2 + 2 : pCnt*4 + sCnt*2;
    }
}
