package src.java.medium.bit;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    // http://en.wikipedia.org/wiki/Gray_code
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        if (n<0)   return ret;
        
        for (int i=0; i<Math.pow(2, n); i++){
            ret.add((i>>1)^i);
        }
        
        return ret;
    }

    // Reflect-and-prefix method
    public List<Integer> grayCode2(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        if (n<0)   return null;
        if (n==0){
            ret.add(0);
            return ret;
        }
        
        ret.add(0);
        ret.add(1);
        for (int i=2; i<=n; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(ret);
            for (int j=ret.size()-1; j>=0; j--){
                temp.add(ret.get(j)|(1<<(i-1)));
            }
            ret = temp;
        }
        
        return ret;
    }
}