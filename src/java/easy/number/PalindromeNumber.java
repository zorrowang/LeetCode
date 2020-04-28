package src.java.easy.number;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0) return false;
        
        int div=1;
        while(x/div >= 10)
            div *= 10;
            
        while(x!=0){
            int last = x%10;
            int first = x/div;
            if (last != first)  return false;
            x = (x%div)/10;
            div /= 100;
        }
        return true;
    }
}