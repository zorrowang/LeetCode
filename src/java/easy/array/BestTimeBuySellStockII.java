package src.java.easy.array;

public class BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {
        int ret = 0;
        if (prices==null || prices.length==0)   return ret;
        
        int minEndingHere = prices[0];
        int maxEndingHere = prices[0];
        
        for(int i=1; i<prices.length; i++){
            if (maxEndingHere<prices[i]){
                maxEndingHere = prices[i];
            }
            else{
                ret += maxEndingHere-minEndingHere;
                minEndingHere = prices[i];
                maxEndingHere = prices[i];
            }
        }
        ret += maxEndingHere-minEndingHere;
        return ret;
    }
}