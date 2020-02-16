public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int[] diff = new int[gas.length];
        int ret = 0;
        for(int i=0; i<gas.length; i++){
            diff[i] = gas[i] - cost[i];
        }
        
        int leftSum=0, sum=0, start=0;
        for (int i=0; i<diff.length; i++){
            leftSum += diff[i];
            sum += diff[i];
            if (sum < 0){
                sum = 0;
                start = i+1;
            }
        }
        return (leftSum<0)?-1:start;
    }
}