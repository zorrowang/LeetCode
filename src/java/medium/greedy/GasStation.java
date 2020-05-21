package src.java.medium.greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {  
        int leftSum=0, sum=0, start=0;
        for (int i=0; i<gas.length; i++){
            int diff = gas[i] - cost[i];
            leftSum += diff;
            sum += diff;
            if (sum < 0){
                sum = 0;
                start = i+1;
            }
        }
        return (leftSum<0)?-1:start;
    }
}