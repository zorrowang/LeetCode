package src.java.medium.bit;

public class BitwiseANDNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0)     return 0;
        int factor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            factor <<= 1;
        }
        return m*factor;
    }
}