package src.hard.dp;

public class BestTimeBuySellStockIII {
    public int maxProfit(int[] prices) {
        int ret = 0;
        if (prices==null || prices.length==0)   return ret;
        
        int max = 0;
        int[] maxEndingHere = new int[prices.length];
        int[] maxStartingHere = new int[prices.length];
        
        int minEndingHere = prices[0];
        for (int i=1; i<prices.length; i++){
            if (minEndingHere > prices[i]){
                minEndingHere = prices[i]; 
            }
            else{
                maxEndingHere[i] = prices[i]-minEndingHere;
                max = Math.max(max, maxEndingHere[i]);
            }
        }
        
        int maxSofar = prices[prices.length-1];
        for (int i=prices.length-2; i>=0; i--){
            if (maxSofar < prices[i])
                maxSofar = prices[i];
            else
                maxStartingHere[i] = maxSofar-prices[i];
        }
        
        int doubleMax = 0;
        for (int i=0; i<prices.length-2; i++){
            int temp = maxEndingHere[i];
            int tempMax = maxStartingHere[i+1];
            for (int j=i+2; j<prices.length-1; j++){
                if (tempMax < maxStartingHere[j])
                    tempMax = maxStartingHere[j];
            }
            temp += tempMax;
            doubleMax = Math.max(doubleMax, temp);
        }
        
        return Math.max(max, doubleMax);
    }

    // Improving the solution from O(n^2) to O(n)
    public int maxProfit2(int[] prices) {
        int ret = 0;
        if (prices==null || prices.length==0)   return ret;
        
        int max = 0;
        int[] maxEndingHere = new int[prices.length];
        int[] maxStartingHere = new int[prices.length];
        
        int minEndingHere = prices[0];
        for (int i=1; i<prices.length; i++){
            if (minEndingHere > prices[i]){
                minEndingHere = prices[i]; 
                maxEndingHere[i] = max;
            }
            else{
                maxEndingHere[i] = Math.max(max, prices[i]-minEndingHere);
                max = Math.max(max, maxEndingHere[i]);
            }
        }
        
        max = 0;
        int maxSofar = prices[prices.length-1];
        for (int i=prices.length-2; i>=0; i--){
            if (maxSofar < prices[i]){
                maxSofar = prices[i];
                maxStartingHere[i] = max;
            }
            else{
                maxStartingHere[i] = Math.max(max, maxSofar-prices[i]);
                max = Math.max(max, maxStartingHere[i]);
            }
        }
        
        int doubleMax = 0;
        for (int i=0; i<prices.length-2; i++){
            int temp1 = maxEndingHere[i];
            int temp2 = maxStartingHere[i+1];
            doubleMax = Math.max(doubleMax, temp1+temp2);
        }
        
        return Math.max(max, doubleMax);
    }

    // Slightly improving the performance and make the code more concise
    public int maxProfit3(int[] prices) {
        int ret = 0;
        if (prices==null || prices.length==0)   return ret;
        
        int[] maxEndingHere = new int[prices.length];
        int[] maxStartingHere = new int[prices.length];
        
        int minEndingHere = prices[0];
        int maxSofar = prices[prices.length-1];
        for (int i=1; i<prices.length; i++){
            if (minEndingHere > prices[i]){
                minEndingHere = prices[i]; 
                maxEndingHere[i] = maxEndingHere[i-1];
            }
            else{
                maxEndingHere[i] = Math.max(maxEndingHere[i-1], prices[i]-minEndingHere);
            }
            
            int j=prices.length-i-1;
            if (maxSofar < prices[j]){
                maxSofar = prices[j];
                maxStartingHere[j] = maxStartingHere[j+1];
            }
            else{
                maxStartingHere[j] = Math.max(maxStartingHere[j+1], maxSofar-prices[j]);
            }
        }
                       
        for (int i=0; i<prices.length; i++){
            int temp1 = maxEndingHere[i];
            int temp2 = maxStartingHere[i];
            ret = Math.max(ret, temp1+temp2);
        }
        
        return ret;
    }
}