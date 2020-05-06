package src.java.hard.string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<String>();
        if(words==null || words.length==0)  return ret;
        List<String> temp = distribute(words, maxWidth);
        for(int i=0; i<temp.size()-1; i++){
            if(temp.get(i).split(" ").length>1)
                ret.add(justifyStr(temp.get(i), maxWidth));
            else
                ret.add(justifySingleStr(temp.get(i), maxWidth));
        }
        ret.add(justifySingleStr(temp.get(temp.size()-1), maxWidth));
        return ret;
    }
    
    public List<String> distribute(String[] words, int maxWidth){
        List<String> ret = new ArrayList<String>();
        String str=words[0];
        
        for(int i=1; i<words.length; i++){
            if(str.length()+words[i].length()+1<=maxWidth)
                str = str+" "+words[i];
            else{
                ret.add(str);
                str = words[i];
            }
        }
        ret.add(str);
        return ret;
    }
    
    public String justifyStr(String str, int maxWidth){
        String[] words = str.split(" ");
        int even = (maxWidth-str.length()+words.length-1)/(words.length-1);
        int rest = (maxWidth-str.length()+words.length-1)%(words.length-1);
        StringBuilder s = new StringBuilder();
        for(int i=0; i<words.length; i++){
            s.append(words[i]);
            for(int j=0; (i!=words.length-1)&&j<even; j++)
                s.append(" ");
            if(rest>0){
                s.append(" ");
                rest--;
            }
        }
        return s.toString();
    }
    
    public String justifySingleStr(String str, int L){
        int n = L-str.length();
        for(int i=0; i<n; i++)
            str += " ";
        return str;
    }
}
