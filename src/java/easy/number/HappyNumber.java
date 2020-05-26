package src.java.easy.number;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int s, t;
        while (set.add(n)) {
            s = 0;
            while (n > 0) {
                t = n%10;
                s += t*t;
                n = n/10;
            }
            if (s == 1) return true;
            if (set.contains(s))    return false;
            n = s;
        }
        return true;
    }
}