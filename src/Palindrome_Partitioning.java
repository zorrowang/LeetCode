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


public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        if (s==null || s.isEmpty()) return ret;
        
        boolean[][] palin = new boolean[s.length()][s.length()];
        
        for (int i=s.length()-1; i>=0; i--){
            for (int j=i; j < s.length(); j++){
                if (s.charAt(i)==s.charAt(j) && (j-i<=1 || palin[i+1][j-1]))
                    palin[i][j] = true;
            }
        }
        
        return partition(s, 0, palin);
    }
    
    public ArrayList<ArrayList<String>> partition(String s, int start, boolean[][] palin) {        
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        
        if (s.length()==start){
            ret.add(new ArrayList<String>());
            return ret;
        }            
        for (int i=start; i < s.length(); i++){
            if (palin[start][i]){
                ArrayList<ArrayList<String>> temp = partition(s, i+1, palin);
                for (ArrayList<String> ls : temp){
                    ls.add(0, s.substring(start, i+1));
                }
                ret.addAll(temp);
            }
        }
        return ret;
    }
}