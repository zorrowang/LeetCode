public class Solution {
    public String convertToTitle(int n) {
        String ret = "";
        while(n > 0){
            int num = (n-1)%26;
            char ch = (char)('A'+num);
            ret = ch+ret;
            n = (n-1)/26;
        }
        return ret;
    }
}