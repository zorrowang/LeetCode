package src.java.medium.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        if (map.containsKey(val)) {
            map.get(val).add(list.size()-1);
            return false;
        }
        else {
            Set<Integer> set = new HashSet<>();
            set.add(list.size()-1);
            map.put(val, set);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))  return false;
        Set<Integer> set = map.get(val);
        int index = set.iterator().next();
        set.remove(index);
        int lastElement = list.get(list.size() - 1);
        if (map.get(lastElement).remove(list.size() - 1)) {
            map.get(lastElement).add(index);
        }
        list.set(index, lastElement);
        list.remove(list.size() - 1);
        if (set.isEmpty()) {
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get((int)(Math.random() * list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */