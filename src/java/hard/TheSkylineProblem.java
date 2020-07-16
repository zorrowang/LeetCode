package src.java.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheSkylineProblem {

    // LTE
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ret = new ArrayList<>();
        if (buildings==null || buildings.length==0)
            return ret;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<buildings.length; i++) {
            for (int j=buildings[i][0]; j<buildings[i][1]; j++) {
                if (!map.containsKey(j) || map.get(j) < buildings[i][2])
                    map.put(j, buildings[i][2]);
            }
            if (!map.containsKey(buildings[i][1]))
                map.put(buildings[i][1], 0);
        }
        for (Integer i : map.keySet()) {
            if (map.containsKey(i-1) && map.get(i-1)==map.get(i))
                continue;
            ret.add(Arrays.asList(i, map.get(i)));
        }
        return ret;
    }
}