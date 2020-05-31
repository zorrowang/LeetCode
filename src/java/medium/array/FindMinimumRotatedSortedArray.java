package src.java.medium.array;

public class FindMinimumRotatedSortedArray {
    public int findMin(int[] num) {
        int start=0, end=num.length-1;
        while (start<end) {
            if (num[start]<num[end])
                return num[start];
            int mid = (start+end)/2;
            if (num[mid]>=num[start])   start = mid+1;
            else    end = mid;
        }
        return num[start];
    }
}