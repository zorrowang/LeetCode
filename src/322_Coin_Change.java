public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return 0;
        int[] ret = new int[amount+1];
        Arrays.fill(ret, -1);
        for (int i=1; i <= amount; i++) {
            for (int j=0; j<coins.length; j++) {
                if (coins[j] == i) {
                    ret[i] = 1;
                    break;
                } else if (coins[j] < i && ret[i-coins[j]] != -1) {
                    ret[i] = ret[i] == -1 ? ret[i-coins[j]]+1 : Math.min(ret[i-coins[j]]+1, ret[i]);
                }
            }
        }
        return ret[ret.length-1];
    }
}