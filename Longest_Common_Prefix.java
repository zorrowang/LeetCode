public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (strs==null || strs.length==0) return "";
        int i=0;
        boolean flag = false;
        while(true){
            for (int j=0; j<strs.length; j++){
                if (i>= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)){
                    flag = true;
                    break;
                }
            }
            if (flag)   break;
            i++;
        }
        
        if (i==0)
            return "";
        else
            return strs[0].substring(0, i);
    }
}


//Revised solution to be more precise
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0)
            return "";
        int i=0;
        while(true){
            for (int j=0; j<strs.length; j++){
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
            i++;
        }
    }
}