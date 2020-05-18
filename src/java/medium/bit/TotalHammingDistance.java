package src.java.medium.bit;

public class TotalHammingDistance {
    // Reference https://leetcode.com/problems/total-hamming-distance/discuss/96226/Java-O(n)-time-O(1)-Space
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j=0;j<32;j++) {
            int bitCount = 0;
            for (int i=0;i<n;i++) 
                bitCount += (nums[i] >> j) & 1;
            total += bitCount*(n - bitCount);
        }
        return total;
    }

    // TLE
    public int totalHammingDistance2(int[] nums) {
        int ret = 0;
        for (int i = 0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                ret += Integer.bitCount(nums[i]^nums[j]);
            }
        }
        return ret;
    }
}