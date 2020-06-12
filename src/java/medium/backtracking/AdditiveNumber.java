package src.java.medium.backtracking;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num==null || num.isEmpty()) return false;
        for (int i=1; i<=num.length()/2; i++) {
            if (num.charAt(0)=='0' && i>1)  break;
            for (int j=i+1; j<num.length(); j++) {
                if (num.charAt(i)=='0' && j-i>1) break;
                long prev1 = Long.parseLong(num.substring(0, i));
                long prev2 = Long.parseLong(num.substring(i, j));
                if (isValid(num.substring(j), prev1, prev2)) return true;
            }
        }
        return false;
    }
    
    private boolean isValid(String num, long prev1, long prev2) {
        long sum = prev1 + prev2;
        String s = String.valueOf(sum);
        if (num.equals(s))  
            return true;
        else if (num.length()<s.length() || Long.parseLong(num.substring(0, s.length()))!=sum)  
            return false;
        return 
            isValid(num.substring(s.length()), prev2, sum);
    }
}