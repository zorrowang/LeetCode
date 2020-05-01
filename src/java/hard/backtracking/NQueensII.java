package src.java.hard.backtracking;

public class NQueensII {
    int ret = 0;

    public int totalNQueens(int n) {
        int[] num = new int[n];
        solveNQueens(0, num);
        return ret;
    }
    
    public void solveNQueens(int n, int[] num){
        if (n==num.length){    
            ret++;
            return;
        }
        for (int i=0; i<num.length; i++){
            num[n] = i;
            if (validate(n, num))
                solveNQueens(n+1, num);
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