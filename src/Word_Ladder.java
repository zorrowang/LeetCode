public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<String> set = new HashSet<String>();
        LinkedList<String> list1 = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        
        int length = 1;
        boolean flag = false;
        list1.add(start);
        set.add(start);
        
        while(!list1.isEmpty()){
            String str = list1.poll();
            if (str.equals(end)){
                flag = true;
                break;
            }
            
            for(int i=0; i<str.length(); i++){
                String str1 = str.substring(0, i);
                String str2 = str.substring(i+1);
                for(int j=0; j<26; j++){
                    char ch = (char)('a'+j);
                    String newStr = str1+ch+str2;
                    if (!set.contains(newStr) && dict.contains(newStr)){
                        set.add(newStr);
                        list2.offer(newStr);
                    }
                }
            }
            
            if (list1.isEmpty() && !list2.isEmpty()){
                list1 = list2;
                list2 = new LinkedList<String>();
                length++;
            }
        }
        
        return flag?length:0;
    }
}