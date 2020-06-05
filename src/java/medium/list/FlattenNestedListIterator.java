package src.java.medium.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


class NestedIterator implements Iterator<Integer> {
    List<Integer> list;
    int cur;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        flatten(nestedList, list);
        cur = 0;
    }
    
    private void flatten(List<NestedInteger> nestedList, List<Integer> list) {
        for (NestedInteger i : nestedList) {
            if (i.isInteger())  list.add(i.getInteger());
            else    flatten(i.getList(), list);
        }
    }

    @Override
    public Integer next() {
        return list.get(cur++);
    }

    @Override
    public boolean hasNext() {
        return cur < list.size();
    }
}