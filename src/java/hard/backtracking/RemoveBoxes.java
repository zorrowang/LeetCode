package src.java.hard.backtracking;

public class RemoveBoxes {
    // Backtracking DFS - TLE
    public int removeBoxes(int[] boxes) {
        int i=0, j=0;
        int ret = 0;
        while(i<boxes.length) {
            while(j<boxes.length && boxes[i] == boxes[j])
                j++;
            int sum = (j-i)*(j-i) + removeBoxes(transfer(boxes, i, j));
            ret = Math.max(ret, sum);
            i = j;
        }
        return ret;
    }
    
    // remove elements between start (inclusive) and end (exclusive)
    private int[] transfer(int[] m, int start, int end) {
        int[] ret = new int[m.length+start-end];
        int j=0;
        for (int i=0; i<m.length; i++) {
            if (i>=start && i<end)  continue;
            ret[j++] = m[i];
        }
        return ret;
    }
}