public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0)    return 0;
        boolean[] check = new boolean[256];
        Arrays.fill(check, false);
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
}