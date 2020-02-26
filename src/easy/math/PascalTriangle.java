package src.easy.math;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (numRows <= 0)   return ret;
        
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ret.add(list);
        
        while(numRows>1){
            List<Integer> temp = new ArrayList<>();
            for (int i=0; i<=list.size(); i++){
                if(i==0 || i==list.size())
                    temp.add(1);
                else
                    temp.add(list.get(i-1)+list.get(i));
            }
            ret.add(temp);
            list = temp;
            numRows--;
        }
        
        return ret;
    }
}

