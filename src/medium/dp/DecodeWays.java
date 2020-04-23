package src.medium.dp;

public class DecodeWays {
    // Stand 1D DP
    public int numDecodings(String s) {
        if (s==null || s.length()==0 || s.charAt(0) == '0')
            return 0;
        // Initialize DP memorization
        int[] dp = new int[s.length()+1];
        dp[1] = 1;
        
        for (int i=2; i<dp.length; i++) {
            if (s.charAt(i-1)!='0')
                dp[i] += dp[i-1];
            int n = Integer.parseInt(s.substring(i-2, i));
            if (n>9 && n<=26) {
                dp[i] += dp[i-2];
                if (i-2==0)
                    dp[i] += 1;
            }
            if (dp[i]==0)
                return 0;
        }
        return dp[dp.length-1];
    }

    // O(1) space
    public int numDecodings2(String s) {
        if (s==null || s.length()==0 || s.charAt(0) == '0')
            return 0;
        int count = 1, preCount = 0;
        
        for (int i=1; i<s.length(); i++) {
            int temp = 0;
            if (s.charAt(i)!='0')
                temp += count;
            int n = Integer.parseInt(s.substring(i-1, i+1));
            if (n>9 && n<=26) {
                temp += preCount;
                if (i-1==0)
                    temp += 1;
            }
            if (temp==0)
                return 0;
            else {
                preCount = count;
                count = temp;
            }
        }
        return count;
    }

    public int numDecodingsLegacy(String s) {
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