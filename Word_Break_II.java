//This solution did not pass stress testing
public class Solution {
    public LinkedList<String> wordBreak(String s, Set<String> dict) {
        if (s==null || s.length()==0)
            return null;
        boolean[] breakFlag = new boolean[s.length()+1];
        LinkedList<String>[] ret = new LinkedList[s.length()+1];
        breakFlag[0] = true;
        ret[0] = new LinkedList<String>();
        ret[0].add("");
        
        for (int i=1; i<=s.length(); i++){
            for (int j=0; j<i; j++){
                String sub = s.substring(j,i);
                if (breakFlag[j] && dict.contains(sub)){
                    breakFlag[i] = true;
                    
                    for (String str : ret[j]){
                        StringBuilder temp = new StringBuilder(str);
                        if (temp.length() == 0)   
                            temp.append(sub);
                        else{
                            temp.append(' ');
                            temp.append(sub);
                        }
                        if (ret[i] == null)
                            ret[i] = new LinkedList<String>();
                        ret[i].add(temp.toString());
                    }
                }
            }
        }
        return ret[s.length()];
    }
}