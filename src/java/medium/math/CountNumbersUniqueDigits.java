package src.java.medium.math;

public class CountNumbersUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n<=0)   return 1;
        // single digit
        int sum = 10;
        // multiple digits
        for(int i=2; i<=n && i<=10; i++) {
            int t = 1;
            for (int j=1; j<=i; j++) {
                // cannot start with s '0'
                if (j==1)
                    t *= (10-j);
                else
                    t *= (10-j+1);
            }
            sum += t;
        }
        return sum;
    }
}