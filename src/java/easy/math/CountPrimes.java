package src.java.easy.math;

public class CountPrimes {
    public int countPrimes(int n) {
        int ret = 0;
        for (int i=2; i<n; i++)
            if (isPrime(i)) ret++;
        return ret;
    }
    
    private boolean isPrime(int n) {
        int m = (int)Math.sqrt(n);
        for (int i=2; i<=m; i++)
            if (n%i == 0)   return false;
        return true;
    }
}