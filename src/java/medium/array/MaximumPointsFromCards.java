package src.java.medium.array;

public class MaximumPointsFromCards {
    // Sliding Window
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i=0; i<k; i++)
            sum += cardPoints[i];
        int ret = sum;
        for (int i=k-1; i>=0; i--) {
            sum += cardPoints[cardPoints.length-k+i]-cardPoints[i];
            ret = Math.max(ret, sum);
        }
        return ret;
    }

    // DP Solution
    public int maxScoreDP(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int[] sumLeft = new int[len];
        int[] sumRight = new int[len];
        for (int i=0; i<len; i++) {
            if (i==0) {
                sumLeft[i] = cardPoints[i];
                sumRight[len-1] = cardPoints[len-1];
            } else {
                sumLeft[i] = sumLeft[i-1] + cardPoints[i];
                sumRight[len-i-1] = sumRight[len-i] + cardPoints[len-i-1];
            }
        }
        
        int ret = 0;
        for (int i=0; i<k; i++) {
            if (i==0) {
                ret = Math.max(ret, sumRight[len-k]);
                ret = Math.max(ret, sumLeft[k-1]);
            } else {
                ret = Math.max(ret, sumLeft[i-1]+sumRight[len-k+i]);
                ret = Math.max(ret, sumLeft[k-i-1]+sumRight[len-i]);
            }
        }
        return ret;
    }
}