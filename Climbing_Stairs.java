public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n<=0)   return 0;
        if (n==1)   return 1;
        if (n==2)   return 2;
        int a=1, b=2;
        while(n>2){
            int temp = b;
            b = a+b;
            a=temp;
            n--;
        }
        return b;
    }
}