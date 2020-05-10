package src.java.medium.list;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {
    int first, sec;
    List<List<Integer>> vec2d;
    
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        first = 0;
        sec = 0;
        this.vec2d = vec2d;
    }

    @Override
    public Integer next() {
        // Write your code here
        return vec2d.get(first).get(sec++); 
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while(first<vec2d.size() && sec >= vec2d.get(first).size()) {
            first++;
            sec = 0;
        }
        return first!=vec2d.size();
    }
}