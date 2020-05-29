package src.java.medium.bit;

public class DivideTwoInteger {
    // Idea is from https://leetcode.com/discuss/general-discussion/651719/how-to-solve-dp-string-template-and-4-steps-to-be-followed
    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) 
            return (1 << 31) - 1;
        int a = Math.abs(dividend), b = Math.abs(divisor);
        int ret = 0;
        for (int x = 31; x >= 0; x--)
            if ((a >>> x) - b >= 0) {
                ret += 1 << x;
                a -= b << x;
            }
        return (dividend > 0) == (divisor > 0) ? ret : -ret;
    }
}