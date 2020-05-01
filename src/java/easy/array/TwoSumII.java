package src.java.easy.array;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int i=0, j=numbers.length-1;
        while(i<j) {
            int sum = numbers[i]+numbers[j];
            if (sum == target){
                ret[0] = i+1;
                ret[1] = j+1;
                return ret;
            } else if (sum < target)
                i++;
            else
                j--;
        }
        return ret;
    }
}