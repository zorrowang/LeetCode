package src.java.easy.array;

class PeakIndexInMountainArray {
    // O(n) solution
    public int peakIndexInMountainArray(int[] A) {
        int maxIndex = 0;
        for (int i=1; i<A.length; i++) {
            if (A[maxIndex] < A[i])
                maxIndex = i;
            else
                break;
        }
        return maxIndex;
    }

    // Binary search: O(logn)
    public int peakIndexInMountainArray2(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }
}
