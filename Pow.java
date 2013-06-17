public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n==0)   return 1;
        if (n==1)   return x;
        boolean neg = (n<0)?true:false;
        n = neg?-n:n;
        double ret = pow(x, n/2);
        if (n%2==1)  ret = ret*ret*x;
        else    ret = ret*ret;
        return neg?1/ret:ret;
    }
}