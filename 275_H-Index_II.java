public class Solution {
    public int hIndex(int[] citations) {
        int start = 0;
        int end = citations.length-1;
        int len = citations.length;
        int mid = 0;
        while (start<=end) {
            mid = (start+end)/2;
            int m = citations[mid];
            if (m < len-mid) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return len-start;
    }
}