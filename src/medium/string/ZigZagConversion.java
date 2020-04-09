package src.medium.string;

import java.util.ArrayList;

public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if (s==null || nRows<=1) return s;
        ArrayList<Character>[] list = new ArrayList[nRows];
        for (int i=0; i<nRows; i++)
            list[i] = new ArrayList<Character>();
        
        for (int i=0; i<s.length(); i++){
            int t = i%(nRows*2-2);
            if (t>=nRows){
                t -= nRows;
                list[nRows-t-2].add(s.charAt(i));
            }
            else{
                list[t%nRows].add(s.charAt(i));
            }
        }
        
        StringBuilder str = new StringBuilder();
        for (int i=0; i<nRows; i++)
            for (int j=0; j<list[i].size(); j++)
                str.append(list[i].get(j));
        return str.toString();
    }
}