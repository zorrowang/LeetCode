package src.easy.array;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                if (mid > 0 && isBadVersion(mid-1)) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }
}