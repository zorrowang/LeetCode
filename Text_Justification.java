public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String>();
        if(words==null || words.length==0)  return ret;
        ArrayList<String> temp = distribute(words, L);
        for(int i=0; i<temp.size()-1; i++){
            if(temp.get(i).split(" ").length>1)
                ret.add(justifyStr(temp.get(i), L));
            else
                ret.add(justifySingleStr(temp.get(i), L));
        }
        ret.add(justifySingleStr(temp.get(temp.size()-1), L));
        return ret;
    }
    
    public ArrayList<String> distribute(String[] words, int L){
        ArrayList<String> ret = new ArrayList<String>();
        String str=words[0];
        
        for(int i=1; i<words.length; i++){
            if(str.length()+words[i].length()+1<=L)
                str = str+" "+words[i];
            else{
                ret.add(str);
                str = words[i];
            }
        }
        ret.add(str);
        return ret;
    }
    
    public String justifyStr(String str, int L){
        String[] words = str.split(" ");
        int even = (L-str.length()+words.length-1)/(words.length-1);
        int rest = (L-str.length()+words.length-1)%(words.length-1);
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

