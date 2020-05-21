package src.java.easy.number;

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class GuessNumber extends GuessGame {
    public int guessNumber(int n) {
        return helper(1, n);
    }
    
    private int helper(int start, int end) {
        if (start > end)    return 0;
        int mid = (end-start)/2 + start;
        int ret = guess(mid);
        if (ret == 0)   return mid;
        else if (ret < 0)   return helper(start, mid-1);
        else return helper(mid+1, end);
    }
}
