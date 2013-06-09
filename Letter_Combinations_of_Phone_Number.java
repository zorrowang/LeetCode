public class Solution {
    // Recursive solution
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String>();
        if(digits==null || digits.isEmpty()) {   
            ret.add("");
            return ret;
        }
        
        String[] DIGIT = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int index = Integer.parseInt(digits.substring(0, 1));
        ArrayList<String> list = letterCombinations(digits.substring(1));
        for (int i=0; i<DIGIT[index].length(); i++){
            for (int j=0; j<list.size(); j++){
                ret.add(DIGIT[index].charAt(i)+list.get(j));
            }
        }
        
        return ret;
    }

    // Iterative solution
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String>();
        ret.add("");
        if(digits==null || digits.isEmpty())  
            return ret;
        
        String[] DIGIT = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i=digits.length()-1; i>=0; i--){
            int index = Integer.parseInt(digits.substring(i, i+1));
            ArrayList<String> list = new ArrayList<String>();
            for (int j=0; j < DIGIT[index].length(); j++){
                for (int k=0; k<ret.size(); k++)
                    list.add(DIGIT[index].charAt(j)+ret.get(k));
            }
            ret = list;
        }
        
        return ret;
    }
    
}
