package src.java.medium.dp;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int ret = 0, curDiff = 0;
        int[] dp = new int[A.length];
        for (int i=1; i<A.length; i++) {
            int diff = A[i] - A[i-1];
            if (i == 1 || diff != curDiff) {
                curDiff = diff;
            } else {
                dp[i] = dp[i-1] + 1;
                ret += dp[i];
            }
        }
        return ret;
    }
}