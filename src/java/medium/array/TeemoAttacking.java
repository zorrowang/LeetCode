package src.java.medium.array;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = timeSeries.length * duration;
        for (int i=1; i<timeSeries.length; i++) {
            int diff = timeSeries[i] - timeSeries[i-1];
            if (diff < duration)    sum -= duration - diff;
        }
        return sum;
    }
}