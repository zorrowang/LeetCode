package src.java.easy.number;

import java.util.ArrayList;
import java.util.List;

class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<>();
        for (int i=left; i<=right; i++)
            if (isSelfDividing(i))
                ret.add(i);
        return ret;
    }
    
    private boolean isSelfDividing(int n) {
        int num = n;
        while (n > 0) {
            int t = n%10;
            if (t==0 || num%t != 0) return false;
            n = n/10;
        }
        return true;
    }
}