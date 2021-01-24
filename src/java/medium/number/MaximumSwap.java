package src.java.medium.number;

import java.util.LinkedList;
import java.util.List;

public class MaximumSwap {
    public int maximumSwap(int num) {
        List<Integer> nums = genList(num);
        int firstDescending = 0;
        while (firstDescending < nums.size()) {
            if (firstDescending + 1 < nums.size() && nums.get(firstDescending) < nums.get(firstDescending+1))
                break;
            firstDescending++;
        }
        if (firstDescending == nums.size()) return num;
        int maxIndex = firstDescending+1, i = firstDescending+1;
        while (i < nums.size()) {
            if (nums.get(maxIndex) <= nums.get(i))
                maxIndex = i;
            i++;
        }
        int minIndex = 0;
        while (minIndex < firstDescending && nums.get(minIndex) >= nums.get(maxIndex))
            minIndex++;
        swap(nums, maxIndex, minIndex);
        return getNum(nums);
    }
    
    private void swap(List<Integer> nums, int i, int j) {
        int t = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, t);
    }
    
    private List<Integer> genList(int num) {
        List<Integer> ret = new LinkedList<>();
        while (num > 0) {
            ret.add(0, num%10);
            num = num/10;
        }
        return ret;
    }
    
    private int getNum(List<Integer> nums) {
        int ret = 0;
        for (int i=0; i<nums.size(); i++)
            ret = ret*10 + nums.get(i);
        return ret;
    }
}