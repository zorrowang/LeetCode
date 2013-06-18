public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s==null || s.isEmpty()) return 0;
        int[] num = new int[s.length()];
        
        if (isSingleDigit(s.charAt(0)))
            num[0] = 1;
        else
            return 0;
        
        if (s.length()>1){
            if (isSingleDigit(s.charAt(1)))  num[1]++;
            if (isDoubleDigit(s.charAt(0), s.charAt(1)))  num[1]++;
            if (num[1]==0)  return 0;
        }
        
        for (int i=2; i<s.length(); i++){
            if (isSingleDigit(s.charAt(i)))
                num[i] += num[i-1];
            if (isDoubleDigit(s.charAt(i-1), s.charAt(i))) 
                num[i] += num[i-2];
            if (num[i]==0)  return 0;
        }
        
        return num[s.length()-1];
    }
    
    public boolean isSingleDigit(char ch){
        return ch!='0';
    }
    
    public boolean isDoubleDigit(char ch1, char ch2){
        if (ch1=='1'){
            return true;
        }
        else if (ch1 == '2'){
            return ch2>='0'&&ch2<'7';
        }
        else
            return false;
    }
}