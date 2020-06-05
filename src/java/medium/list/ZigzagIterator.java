package src.java.medium.list;

import java.util.List;

public class ZigzagIterator {
    List<Integer> v1, v2;
    int cur1, cur2;
    /*
    * @param v1: A 1d vector
    * @param v2: A 1d vector
    */
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // do intialization if necessary
        this.v1 = v1;
        this.v2 = v2;
        cur1 = 0;
        cur2 = 0;
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        if ((cur1==cur2 || cur2>=v2.size()) && cur1 < v1.size())
            return v1.get(cur1++);
        else
            return v2.get(cur2++);
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return cur1<v1.size() || cur2<v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */