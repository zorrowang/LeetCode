package src.java.medium.array;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        boolean[] checked = new boolean[arr.length];
        return canReach(arr, start, checked);
    }
    
    private boolean canReach(int[] arr, int start, boolean[] checked) {
        if (arr[start] == 0)    return true;
        checked[start] = true;
        if (start+arr[start] < arr.length && !checked[start+arr[start]])
            if (canReach(arr, start+arr[start], checked))
                return true;
        if (start-arr[start] >= 0 && !checked[start-arr[start]])
            if (canReach(arr, start-arr[start], checked))
                return true;
        return false;
    }
}