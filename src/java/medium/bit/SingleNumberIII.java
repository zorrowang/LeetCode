package src.java.medium.bit;

public class SingleNumberIII {
    // Reference: https://leetcode.com/problems/single-number-iii/discuss/68900/Accepted-C%2B%2BJava-O(n)-time-O(1)-space-Easy-Solution-with-Detail-Explanations
    public int[] singleNumber(int[] nums) {
        // Pass 1 : 
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        // Get its last set bit
        diff &= -diff;
        
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums) {
            // the bit is not set
            if ((num & diff) == 0)  rets[0] ^= num;
            // the bit is set
            else    rets[1] ^= num;
        }
        return rets;
    }
}