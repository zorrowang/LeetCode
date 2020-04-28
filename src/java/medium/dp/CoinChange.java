package src.java.medium.dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i=1; i<=amount; i++) {
            for (int j=0; j<coins.length && coins[j]<=i; j++) {
                int index = i-coins[j];
                if (dp[index] == -1)
                    continue;
                dp[i] = dp[i]==-1 ? dp[index]+1 : Math.min(dp[i], dp[index]+1);
            }
        }
        return dp[amount];
    }

    // Legacy solution
    public int coinChange2(int[] coins, int amount) {
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