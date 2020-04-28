package src.java.easy.array;

class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits==null || digits.length==0)   return digits;
        int carry = 1;
        int i = digits.length-1;
        while(i>=0){
            digits[i] += carry;
            carry = digits[i]/10;
            if (carry<1)   break;
            digits[i--] %= 10;
        }
        
        if (carry==1){
            int[] ret = new int[digits.length+1];
            System.arraycopy(digits, 0, ret, 1, digits.length);
            ret[0] = 1;
            return ret;
        }
        return digits;
    }
}