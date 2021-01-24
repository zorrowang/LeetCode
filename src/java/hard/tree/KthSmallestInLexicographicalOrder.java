public class KthSmallestInLexicographicalOrder {
    // Reference: https://www.youtube.com/watch?v=yMnR63e3KLo&feature=youtu.be
    public int findKthNumber(int n, int k) {
        long cur = 1;
        while (k > 1) {
            long gap = findGap(cur, cur+1, n);
            if (gap <= k-1) {
                k -= gap;
                cur++;
            } else {
                cur = cur*10;
                k--;
            }
        }
        return (int)cur;
    }
    
    public long findGap(long s, long t, int n) {
        long gap = 0;
        while (s <= n) {
            gap +=  Math.min(n+1, t) - s;
            s = s*10;
            t = t*10;
        }
        return gap;
    }
}