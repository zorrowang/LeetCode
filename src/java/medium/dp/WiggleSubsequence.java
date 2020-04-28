package src.java.medium.dp;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        // dp{i} = max: positive[j] + 1 if nums[i] < nums[j]
        //              negative[j] + 1 if nums[i] > nums[j]
        //              for all j < i
        if (nums==null || nums.length<1)
            return 0;
        
        int[] positive = new int[nums.length];
        int[] negative = new int[nums.length];
        positive[0] = negative[0] = 1;
        int ret = 1;
        
        for (int i=1; i<nums.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (nums[j] < nums[i])
                    positive[i] = Math.max(positive[i], negative[j]+1);
                else if (nums[j] > nums[i])
                    negative[i] = Math.max(negative[i], positive[j]+1);
            }
            ret = Math.max(ret, Math.max(positive[i], negative[i]));
        }
        return ret;
    }

    // Optimize the above solution by reserving the previous longest subsequence
    // Time complexity is improved from O(n^2) to O(n)
    public int wiggleMaxLength2(int[] nums) {
        if (nums==null || nums.length<1)
            return 0;

        int len = nums.length;
        int[] positive = new int[len];
        int[] negative = new int[len];
        positive[0] = negative[0] = 1;
        
        for (int i=1; i<len; i++) {
            if (nums[i-1] < nums[i]) {
                positive[i] = negative[i-1]+1;
                negative[i] = negative[i-1];
            } else if (nums[i-1] > nums[i]) {
                positive[i] = positive[i-1];
                negative[i] = positive[i-1]+1;
            } else {
                positive[i] = positive[i-1];
                negative[i] = negative[i-1];
            }
        }
        return Math.max(positive[len-1], negative[len-1]);
    }
}