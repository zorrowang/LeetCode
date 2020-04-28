package src.java.easy.number;

public class ReverseInteger {
    // Overflow does NOT exist
    public int reverse(int x) {
        int ret = 0;
        while(x != 0){
            int temp = x%10;
            ret = ret*10 + temp;
            x /= 10;
        }        
        return ret;
    }

    // Overflow does exist
    public int reverse2(int x) {
        int ret = 0;
        while(x != 0){
            int temp = x%10;
            int newRet = ret*10 + temp;
            if ((newRet-temp)/10 != ret)
                return 0;
            ret = newRet;
            x /= 10;
        }        
        return ret;
    }  
}

