package src.java.medium.string;

import java.util.ArrayList;

/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger { // Constructor initializes an empty nested list. public
 * NestedInteger();
 *
 * // Constructor initializes a single integer. public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer. public void
 * setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it. public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */

public class MiniParser {
    public NestedInteger deserialize(String s) {
        NestedInteger ret = new NestedInteger();
        if (s.startsWith("[")) {
            ArrayList<String> list = split(s);
            for (String str : list) {
                ret.add(deserialize(str));
            }
        } else {
            ret.setInteger(Integer.parseInt(s));
        }
        return ret;
    }
    
    private ArrayList<String> split(String s) {
        s = s.substring(1, s.length() - 1);
        ArrayList<String> list = new ArrayList<>();
        int i = 0; 
        int j = 1;
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                int count = 1;
                while (j < s.length() && count != 0) {
                    if (s.charAt(j) == '[') {
                        count++;
                    } else if (s.charAt(j) == ']') {
                        count--;
                    }
                    j++;
                }
                list.add(s.substring(i, j));
                i = j++;
            } else if (s.charAt(i) == ',') {
                i++;
                j++;
            } else {
                while (j < s.length() && s.charAt(j) != ',') {
                    j++;
                }
                list.add(s.substring(i, j++));
                i = j++;
            }
        }
        return list;
    }
}