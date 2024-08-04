package src.java.medium.array;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationstoReduceXtoZero {
    // O(n) solution
    public int minOperations(int[] nums, int x) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Map<Integer, Integer> leftSum = new HashMap<>();
        Map<Integer, Integer> rightSum = new HashMap<>();

        left[0] = nums[0];
        if (left[0] == x)   return 1;
        leftSum.put(left[0], 1);
        right[nums.length-1] = nums[nums.length-1];
        if (right[nums.length-1] == x)  return 1;
        rightSum.put(right[nums.length-1], 1);

        int ret = Integer.MAX_VALUE;
        
        for (int i=1; i<nums.length; i++) {
            left[i] = nums[i] + left[i-1];
            right[nums.length-i-1] = right[nums.length-i] + nums[nums.length-i-1];
            if (left[i] == x)   ret = Math.min(ret, i+1);
            if (right[nums.length-i-1] == x) ret = Math.min(ret, i+1);
            if (!leftSum.containsKey(left[i]))  leftSum.put(left[i], i+1);
            if (!rightSum.containsKey(right[nums.length-i-1]))
                rightSum.put(right[nums.length-i-1], i+1);
        }

        for (int i=0; i<nums.length; i++) {
            if (rightSum.containsKey(x - left[i])) {
                int ind = rightSum.get(x - left[i]);
                if (ind+i+1 > nums.length)  continue;
                ret = Math.min(i+1+ind, ret);
            }
        }
        for (int j=nums.length-1; j>=0; j--) {
            if (leftSum.containsKey(x - right[j])) {
                int ind = leftSum.get(x - right[j]);
                if (ind+nums.length-j > nums.length)  continue;
                ret = Math.min(nums.length-j+leftSum.get(x - right[j]), ret);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    // DFS solution
    public int minOperations2(int[] nums, int x) {
        return dfs(nums, x, 0, nums.length-1, 0);
    }

    private int dfs(int[] nums, int x, int left, int right, int move) {
        if (x == 0) return move;
        if (x < 0 || left > right)  return -1;
        
        int lm = dfs(nums, x-nums[left], left+1, right, move+1);
        int rm = dfs(nums, x-nums[right], left, right-1, move+1);
        if (lm == -1)   return rm;
        else if (rm == -1)  return lm;
        else    return Math.min(lm, rm);
    }

    // O(n^2) solution
    public int minOperations3(int[] nums, int x) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        if (left[0] == x)   return 1;
        right[nums.length-1] = nums[nums.length-1];
        if (right[nums.length-1] == x)  return 1;
        
        int ret = Integer.MAX_VALUE;
        for (int i=1; i<nums.length; i++) {
            left[i] = nums[i] + left[i-1];
            right[nums.length-i-1] = right[nums.length-i] + nums[nums.length-i-1];
            if (left[i] == x)   ret = Math.min(ret, i+1);
            if (right[nums.length-i-1] == x) ret = Math.min(ret, i+1);
        }

        for (int i=0; i<nums.length; i++) {
            for (int j=nums.length-1; j>i; j--) {
                if (left[i] + right[j] == x)    
                    ret = Math.min(ret, i+1+nums.length-j);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}
