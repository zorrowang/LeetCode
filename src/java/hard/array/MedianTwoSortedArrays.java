package src.java.hard.array;

public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if ((len1+len2)%2 == 0)
            return (find(nums1, 0, len1-1, nums2, 0, len2-1, (len1+len2)/2)+
                find(nums1, 0, len1-1, nums2, 0, len2-1, (len1+len2)/2+1))/2.;
        else
            return find(nums1, 0, len1-1, nums2, 0, len2-1, (len1+len2)/2+1);
    }
    
    public int find(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        if (start1>end1)    return nums2[start2+k-1];
        if (start2>end2)    return nums1[start1+k-1];
        
        if (k<=1)   return Math.min(nums1[start1], nums2[start2]);
        
        int mid1 = start1+(end1-start1)/2;
        int mid2 = start2+(end2-start2)/2;
        if ((mid1-start1)+(mid2-start2) < k-1) {
            if (nums1[mid1] > nums2[mid2])
                return find(nums1, start1, end1, nums2, mid2+1, end2, k-mid2+start2-1);
            else
                return find(nums1, mid1+1, end1, nums2, start2, end2, k-mid1+start1-1);
        } else {
            if (nums1[mid1] > nums2[mid2])
                return find(nums1, start1, mid1-1, nums2, start2, end2, k);
            else
                return find(nums1, start1, end1, nums2, start2, mid2-1, k);
        }
    }
}

