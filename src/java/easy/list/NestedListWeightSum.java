package src.java.easy.list;

import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    public boolean isInteger();
    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        int sum = 0;
        for (NestedInteger n : nestedList)
            sum += dfs(n, 1);
        return sum;
    }
    
    private int dfs(NestedInteger n, int level) {
        int sum = 0;
        if (n.isInteger())  
            sum += level * n.getInteger();
        if (n.getList() == null || n.getList().isEmpty())
            return sum;
        for (NestedInteger ni : n.getList())
            sum += dfs(ni, level + 1);
        return sum;
    }
}