public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] num = new int[n];
        ArrayList<String[]> ret = new ArrayList<String[]>();
        solveNQueens(0, num, ret);
        return ret;
    }
    
    public void solveNQueens(int n, int[] num, ArrayList<String[]> ret){
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
    
    public String[] convert(int[] n){
        String[] ret = new String[n.length];
        for (int i=0; i<n.length; i++){
            StringBuilder str = new StringBuilder();
            for (int j=0; j<n.length; j++){
                if (n[i]==j)
                    str.append('Q');
                else
                    str.append('.');
            }
            ret[i] = str.toString();
        }
        return ret;
    }
}