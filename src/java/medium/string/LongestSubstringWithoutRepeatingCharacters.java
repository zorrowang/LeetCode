package src.java.medium.string;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0)    return 0;
        boolean[] check = new boolean[256];

        int max = 1;
        int start = 0, end = 1;
        check[s.charAt(start)] = true;
        
        while(end < s.length()){
            if (check[s.charAt(end)]){
                max = Math.max(max, end-start);
                while(s.charAt(start) != s.charAt(end)){
                    check[s.charAt(start++)] = false;
                }
                start++;
                end++;
            }
            else{
                check[s.charAt(end++)] = true;
            }
        }
        return Math.max(max, end-start);
    }

    // HashSet solution : the performance is slightly worse
    public int lengthOfLongestSubstring2(String s) {
        int ret = 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                while (s.charAt(i) != s.charAt(j))
                    set.remove(s.charAt(i++));
                set.remove(s.charAt(i++));
            }
            ret = Math.max(ret, j-i+1);
            set.add(s.charAt(j++));                
        }
        return ret;
    }
}