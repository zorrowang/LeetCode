public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean neg = false;
        if (x<0){
            neg = true;
            x=-x;
        }
        
        int ret = 0;
        while(x>0){
            int temp = x%10;
            ret = ret*10 + temp;
            x /= 10;
        }
        
        if(neg) ret=-ret;
        return ret;
    }
}

