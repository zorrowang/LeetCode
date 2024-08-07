package src.java.medium.array;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int[][] f = firstList;
        int[][] s = secondList;
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            if (!(f[i][0] > s[j][1] || s[j][0] > f[i][1])) {
                int[] arr = new int[2];
                arr[0] = Math.max(f[i][0], s[j][0]);
                arr[1] = Math.min(f[i][1], s[j][1]);
                list.add(arr);
            }
            if (f[i][1] > s[j][1]) j++;
            else if (f[i][1] < s[j][1]) i++;
            else {
                i++;
                j++;
            }
        }
        int[][] ret = new int[list.size()][2];
        for (i=0; i<list.size(); i++)
            ret[i] = list.get(i);
        return ret;
    }
}
