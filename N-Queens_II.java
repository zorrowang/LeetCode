public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] num = new int[n];
        int[] ret = new int[1];
        solveNQueens(0, num, ret);
        return ret[0];
    }
    
    public void solveNQueens(int n, int[] num, int[] ret){
        if (n==num.length){    
            ret[0]++;
            return;
        }
        for (int i=0; i<num.length; i++){
            num[n] = i;
            if (validate(n, num))
                solveNQueens(n+1, num, ret);
        }
    }
    
    public boolean validate(int n, int[] num){
        for (int i=0; i<n; i++){
            if (num[i]==num[n] || Math.abs(num[n]-num[i])==n-i)
                return false;
        }
        return true;
    }
}