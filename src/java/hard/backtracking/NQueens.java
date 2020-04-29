package src.java.hard.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        int[] num = new int[n];
        List<List<String>> ret = new ArrayList<>();
        solveNQueens(0, num, ret);
        return ret;
    }
    
    public void solveNQueens(int n, int[] num, List<List<String>> ret){
        if (n==num.length){    
            ret.add(convert(num));
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
    
    public List<String> convert(int[] n){
        List<String> ret = new ArrayList<>();
        for (int i=0; i<n.length; i++){
            StringBuilder str = new StringBuilder();
            for (int j=0; j<n.length; j++){
                if (n[i]==j)
                    str.append('Q');
                else
                    str.append('.');
            }
            ret.add(str.toString());
        }
        return ret;
    }
}