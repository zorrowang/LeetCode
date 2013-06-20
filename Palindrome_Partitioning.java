public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        if (s==null || s.isEmpty()) return ret;
        
        for (int i=0; i<s.length(); i++){
            if (isPalindrome(s.substring(0, i+1))){
                ArrayList<ArrayList<String>> list = partition(s.substring(i+1, s.length()));
                if (list.isEmpty()){
                     ArrayList<String> temp = new  ArrayList<String>();
                     temp.add(s.substring(0, i+1));
                     ret.add(temp);
                }
                else{
                    for (ArrayList<String> l : list){
                        ArrayList<String> temp = (ArrayList<String>)l.clone();
                        temp.add(0, s.substring(0, i+1));
                        ret.add(temp);
                    }
                }
            }
        }
        
        return ret;
    }
    
    public boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if (s.charAt(i++)!=s.charAt(j--))
                return false;
        }
        return true;
    }
}