public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (divisor==0) return dividend;
        
        boolean neg = false;
        if ((dividend>0&&divisor<0)||(dividend<0&&divisor>0))
            neg = true;
        
        // Avoid overflow
        long newDividend = dividend;
        long newDivisor = divisor;
        newDividend = Math.abs(newDividend);
        newDivisor = Math.abs(newDivisor);
                
        int ret=0, temp=0;
        while(newDividend > newDivisor<<temp)
            temp++;
        
        while(temp >= 0){
            while(newDivisor<<temp <= newDividend){   
                newDividend -= newDivisor<<temp;
                ret |= 1<<temp;
            }
            temp--;
        }
        
        return neg?-ret:ret;
    }
}