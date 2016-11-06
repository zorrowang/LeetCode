public class Solution {
    public int titleToNumber(String s) {
        if (s==null || s.isEmpty()) return 0;
        int ret = 0;
        for (int i=0; i<s.length(); i++){
            int val = (int)(s.charAt(i)-'A')+1;
            ret = ret*26+val;
        }
        return ret;
    }
}