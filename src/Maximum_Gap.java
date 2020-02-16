public class Solution {
    public int maximumGap(int[] num) {
        if (num==null || num.length<2)
            return 0;
        int max=num[0], min=num[0];
        for (int i=1; i<num.length; i++){
            if (max < num[i])   max = num[i];
            if (min > num[i])   min = num[i];
        }
        
        double interval = 1.0 * (max-min) / (num.length-1);
        int[] maxForInterval = new int[num.length-1];
        int[] minForInterval = new int[num.length-1];
        Arrays.fill(minForInterval, Integer.MAX_VALUE);
        minForInterval[0] = min;
        maxForInterval[num.length-2] = max;
        if (num.length > 2){
            maxForInterval[0] = min;
            minForInterval[num.length-2] = max;
        }
        
        for (int i=0; i<num.length; i++){
            if (num[i] == min || num[i] == max)
                continue;
            int diff = num[i]-min;
            int index = (int)(diff/interval);
            if (minForInterval[index] > num[i]) 
                minForInterval[index] = num[i];
            if (maxForInterval[index] < num[i])
                maxForInterval[index] = num[i];
        }
        
        int ret = 0;
        int preMax = 0; 
        for (int i=0; i<maxForInterval.length; i++){
            if (minForInterval[i] == Integer.MAX_VALUE) continue;
            ret = Math.max(maxForInterval[i] - minForInterval[i], ret);
            if (i > 0)
                ret = Math.max(minForInterval[i] - preMax, ret);
            preMax = maxForInterval[i];
        }
        return ret;
    }
}