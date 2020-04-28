package src.java.medium.math;

public class Pow {
    public double myPow(double x, int n) {
        if(n < 0) return 1/x * myPow(1/x, -(n+1));
        if(n == 0) return 1;
        if(n == 2) return x*x;
        if(n%2 == 0) return myPow(myPow(x, n/2), 2);
        else return x*myPow(myPow(x, n/2), 2);
    }

    // Legacy solution, causing stack overflow
    public double myPow2(double x, int n) {
        if (n==0)   return 1;
        if (n==1)   return x;
        boolean neg = (n<0)?true:false;
        n = neg?-n:n;
        double ret = myPow(x, n/2);
        if (n%2==1)  ret = ret*ret*x;
        else    ret = ret*ret;
        return neg?1/ret:ret;
    }
}