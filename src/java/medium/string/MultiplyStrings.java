package src.java.medium.string;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1==null || num2==null)   return null;
        
        char[] ret = new char[num1.length()+num2.length()];
        for (int i=num1.length()-1; i>=0; i--){
            int n1 = num1.charAt(i)-'0';
            int carry = 0;
            for (int j=num2.length()-1; j>=0; j--){
                int n2 = num2.charAt(j)-'0';
                int val = n1*n2+carry+(ret[i+j+1]-'0'>0?ret[i+j+1]-'0':0);
                carry = val/10;
                val %= 10;
                ret[i+j+1] = (char)('0'+val);
            }
            if (carry>0)    ret[i] = (char)('0'+carry);
        }
        
        String str = new String(ret).trim();
        return str.charAt(0)=='0'?"0":str;
    }
}