package src.java.easy.bit;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        int i = 1;
        while(n != 0) {
            if ((n & 1) == 1)
                ret |= (1 << 32-i);
            i++;
            n >>>= 1;
        }
        return ret;
    }
}