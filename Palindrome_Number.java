public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0) return false;
        
        int length=1;
        while(x/length >= 10)
            length *= 10;
            
        while(x>=10){
            int last = x%10;
            int first = x/length;
            if (last != first)  return false;
            x = (x%length)/10;
            length /= 100;
        }
        return true;
    }
}