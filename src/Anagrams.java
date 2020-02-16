// String signature
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String>();
        HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
        
        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String temp = new String(array);
            if(map.containsKey(temp))
                map.get(temp).add(str);
            else{
                LinkedList<String> list = new LinkedList<String>();
                list.add(str);
                map.put(temp, list);
            }
        }
        
        for(String key : map.keySet()){
            if(map.get(key).size()>1)
                ret.addAll(map.get(key));
        }
        
        return ret;
    }
}

