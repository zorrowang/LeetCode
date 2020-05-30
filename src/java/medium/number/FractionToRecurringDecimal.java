package src.java.medium.number;

import java.util.HashMap;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator==0)   return "0";
        if (denominator==0) return null;
        
        boolean flag = (numerator>0)^(denominator>0);
        String ret = "";
        if (flag)   ret += "-";
        
        long n = numerator, d = denominator;  
        n = Math.abs(n);  
        d = Math.abs(d);  
        
        ret += n/d;
        n = (n%d)*10;
        if (n==0)   return ret;
        ret += ".";
        
        String secondPart = "";
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();

        int i=0;
        while (n!=0){
            if (map.containsKey(n)){
                ret += secondPart.substring(0, map.get(n))+"("+secondPart.substring(map.get(n))+")";
                return ret;
            }
            
            map.put(n, i++);
            long val1 = n/d;
            long val2 = n%d;
            n = val2*10;
            secondPart += val1;
        }
        ret += secondPart;
        return ret;
    }
}