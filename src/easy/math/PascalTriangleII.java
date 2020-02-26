package src.easy.math;

import java.util.ArrayList;

public class PascalTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (rowIndex<0)    return ret;
        
        int[] retArray = new int[rowIndex+1];
        retArray[0] = 1;
        
        for(int i=1; i<=rowIndex; i++){
            for (int j=i; j>0; j--){
                retArray[j] = retArray[j]+retArray[j-1];
            }
        }
        
        for(int i=0; i<=rowIndex; i++)
            ret.add(retArray[i]);
        
        return ret;
    }
}

