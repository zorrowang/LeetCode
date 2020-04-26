package src.easy.array;

public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
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