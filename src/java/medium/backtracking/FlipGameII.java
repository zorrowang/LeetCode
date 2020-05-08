package src.java.medium.backtracking;

public class FlipGameII {
    /**
     * @param s: the given string
     * @return: if the starting player can guarantee a win
     */
    public boolean canWin(String s) {
        // write your code here
        if (s==null || s.length()<2)    return false;
        return canWinHelper(s.toCharArray());
    }
    
    private boolean canWinHelper(char[] s) {
        for(int i=0; i<s.length-1; i++) {
            if (s[i]=='+' && s[i+1]=='+') {
                s[i]='-';
                s[i+1]='-';
                boolean win = canWinHelper(s);
                s[i]='+';
                s[i+1]='+';
                if(!win)    return true;
            }
        }
        return false;
    }
}