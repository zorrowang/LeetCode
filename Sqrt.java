public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        double epsilon = 1e-15;    // relative error tolerance
        double t = x;              // estimate of the square root of c

        // repeatedly apply Newton update step until desired precision is achieved
        while (Math.abs(t - x/t) > epsilon*t) {
            t = (x/t + t) / 2.0;
        }
        
        return (int)t;
    }
}

