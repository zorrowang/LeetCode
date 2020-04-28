package src.java.easy.dp;

// O(n) solution
class RotatedDigits {

    // loop through all digits
    public int rotatedDigits(int N) {
        if (N <= 0) return 0;
        int ret = 0;
        for (int i=1; i<=N; i++) {
            if (isValid(i))
                ret++;
        }
        return ret;
    }
    
    private boolean isValid(int n) {
        int same = 0, len = 0;
        while(n > 0) {
            int i = n%10;
            if (i == 3 || i == 4 || i == 7)
                return false;
            else if (i == 0 || i == 1 || i == 8)
                same++;
            n = n/10;
            len++;
        }
        return same!=len;
    }

    // DP solution
    public int rotatedDigitsDP(int N) {
        int ret = 0;
        int[] dp = new int[N+1];
        
        for (int i=0; i<=N; i++) {
            if (i<10) {
                if (i == 0 || i == 1 || i == 8)
                    dp[i] = 1;
                else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    ret++;
                }
            } else {
                int last1 = dp[i/10], last2 = dp[i%10];
                if (last1 == 0 || last2 == 0)
                    continue;
                else if (last1 == 2 || last2 == 2) {
                    ret++; dp[i]=2;
                } else
                    dp[i]=1;
            }
        }
        return ret;
    }
}