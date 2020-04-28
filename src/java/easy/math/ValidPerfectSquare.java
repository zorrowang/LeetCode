package src.java.easy.math;

class ValidPerfectSquare {
    // Time Limit Exceeded
    public boolean isPerfectSquare(int num) {
        if (num <= 0)   return false;
        for (int i=1; i*i<=num; i++) {
            if ((num%i == 0) && (num/i == i)) 
                return true; 
        }
        return false;
    }
    
    // Like #69 using Newton's method
    public boolean isPerfectSquareRevised(int num) {
        double epsilon = 1e-15;    // relative error tolerance
        double t = num;              // estimate of the square root of c

        // repeatedly apply Newton update step until desired precision is achieved
        while (Math.abs(t - num/t) > epsilon*t) {
            t = (num/t + t) / 2.0;
        }
        
        int ret = (int)t;
        return ret*ret == num;
    }
}