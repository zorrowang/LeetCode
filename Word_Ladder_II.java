public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        HashSet<String> set = new HashSet<String>();
        HashSet<String> levelSet = new HashSet<String>();
        LinkedList<String> list1 = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        HashMap<String, HashSet<String>> path = new HashMap<String, HashSet<String>>();
        
        list1.add(start);
        levelSet.add(start);
        path.put(start, null);
        
        while(!list1.isEmpty()){
            String str = list1.poll();
            if (str.equals(end)){
                ret = buildPath(end, path);
                break;
            }
            
            for(int i=0; i<str.length(); i++){
                StringBuffer sb = new StringBuffer(str);
                for(int j=0; j<26; j++){
                    sb.setCharAt(i, (char)('a' + j));
                    String newStr = sb.toString();
                    
                    if (newStr.equals(str)) continue;
                    if (!set.contains(newStr) && dict.contains(newStr)){
                        if (!levelSet.contains(newStr)){
                            levelSet.add(newStr);
                            list2.offer(newStr);
                        }
                        if (path.containsKey(newStr))
                            path.get(newStr).add(str);
                        else{
                            HashSet<String> parent = new HashSet<String>();
                            parent.add(str);
                            path.put(newStr, parent);
                        }
                    }
                }
            }
            
            if (list1.isEmpty() && !list2.isEmpty()){
                list1 = list2;
                list2 = new LinkedList<String>();
                set.addAll(levelSet);
                levelSet = new HashSet<String>();
            }
        }
        
        return ret;
    }
    
    public ArrayList<ArrayList<String>> buildPath(String end, HashMap<String, HashSet<String>> path){
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        if (path.get(end)==null){
            ArrayList<String> list = new ArrayList<String>();
            list.add(end);
            ret.add(list);
            return ret;
        }
        HashSet<String> set = path.get(end);
        Iterator it = set.iterator();
        while (it.hasNext()){
            ArrayList<ArrayList<String>> temp = buildPath((String)it.next(), path);
            for(ArrayList<String> l : temp)
                l.add(end);
            ret.addAll(temp);
        }
        
        return ret;
    }
}