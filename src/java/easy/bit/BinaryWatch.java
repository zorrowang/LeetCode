package src.java.easy.bit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList<>();
        for (int h=0; h<12; h++)
            for (int m=0; m<60; m++)
                if (Integer.bitCount(h) + Integer.bitCount(m) == num)
                    ret.add(String.format("%d:%02d", h, m));
        return ret;        
    }

    // DFS solution
    public List<String> readBinaryWatchDfs(int num) {
        boolean[] hours = new boolean[4];
        boolean[] mins = new boolean[6];
        Set<String> ret = new HashSet<>();
        dfs(num, hours, mins, ret);
        return new ArrayList<>(ret);
    }
    
    private void dfs(int num, boolean[] hours, boolean[] mins, Set<String> ret) {
        if (num == 0) {
            int h = gen(hours);
            int m = gen(mins);
            if (h >= 12 || m >= 60) return;
            ret.add(String.format("%d:%02d", h, m));
            return;
        }
        for (int i=0; i<hours.length; i++) {
            if (!hours[i]) {
                hours[i] = true;
                dfs(num-1, hours, mins, ret);
                hours[i] = false;
            }
        }
        for (int i=0; i<mins.length; i++) {
            if (!mins[i]) {
                mins[i] = true;
                dfs(num-1, hours, mins, ret);
                mins[i] = false;
            }
        }
    }
    
    private int gen(boolean[] array) {
        int ret = 0;
        for(int i=0; i<array.length; i++)
            if (array[i])
                ret = ret | (1 << i);
        return ret;
    }
}