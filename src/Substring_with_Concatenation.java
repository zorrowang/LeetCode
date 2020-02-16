public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int length = L[0].length()*L.length; 
        for (int i=0; i<L.length; i++){
            if (map.containsKey(L[i]))
                map.put(L[i], map.get(L[i])+1);
            else{
                map.put(L[i], 1);
            }
        }
        StringBuilder sb = new StringBuilder(S);    
            
        for (int i=0; i+length<=sb.length(); i++){
            if (isMatching(sb.substring(i, i+length), map, length/L.length))
                ret.add(i);
        }
        return ret;
    }
    
    public boolean isMatching(String s, HashMap<String, Integer> map, int l){
        StringBuilder sb = new StringBuilder(s); 
        HashMap<String, Integer> tmp = new HashMap<String, Integer>();
        for (int i=0; i+l<=sb.length(); i+=l){
            String str = sb.substring(i, i+l);
            if (map.containsKey(str)){
                if (tmp.containsKey(str)){
                    if (tmp.get(str)>=map.get(str))    return false;
                    else    tmp.put(str, tmp.get(str)+1);        
                }
                else
                    tmp.put(str, 1);
            }
            else
                return false;
        }
        
        return true;
    }
}