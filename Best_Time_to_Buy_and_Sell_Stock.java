public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ret = 0;
        if (prices==null || prices.length==0)   return ret;
        
        int minEndingHere = prices[0];
        for (int i=1; i<prices.length; i++){
            if (prices[i] < minEndingHere)
                minEndingHere = prices[i];
            else
                ret = Math.max(ret, prices[i]-minEndingHere);
        }
        return ret;
    }
}