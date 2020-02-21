package src.easy.matrix;

import java.util.PriorityQueue;

class Pair {
    int index;
    int count;
    
    Pair(int index, int count) {
        this.index = index;
        this.count = count;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] counts = new int[mat.length];
        int[] ret = new int[k];
        
        for (int i=0; i<mat.length; i++)
            for (int j=0; j<mat[i].length && mat[i][j]==1; j++)
                counts[i]++;
        
        PriorityQueue<Pair> maxQueue = new PriorityQueue<>((x, y) -> x.count==y.count ? y.index-x.index : y.count-x.count);
        for (int i=0; i<counts.length; i++) {
            if (maxQueue.size()<k)
                maxQueue.offer(new Pair(i, counts[i]));
            else if (maxQueue.peek().count>counts[i] || (maxQueue.peek().count==counts[i] && maxQueue.peek().index>i)) {
                maxQueue.poll();
                maxQueue.offer(new Pair(i, counts[i]));
            }
        }
        
        for (int i=ret.length-1; i>=0; i--)
            ret[i] = maxQueue.poll().index;
        return ret;
    }
}