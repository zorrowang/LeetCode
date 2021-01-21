package src.java.medium.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {
    // Rewritten on 2021/01/21
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits==null || digits.isEmpty())   return ret;
        Map<Character, String> map = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(digits, 0, "", map, ret);
        return ret;
    }
    
    private void dfs(String digits, int pos, String str, Map<Character, String> map, List<String> ret) {
        if (pos == digits.length()) {
            ret.add(str);
            return;
        }
        String s = map.get(digits.charAt(pos));
        for (int i=0; i<s.length(); i++)
            dfs(digits, pos+1, str+s.charAt(i), map, ret);
    }

    // DFS
    public List<String> letterCombinations2(String digits) {
        if (digits == null || digits.isEmpty())
            return new ArrayList<>();
        
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        
        List<String> ret = new ArrayList<>();
        dfs(digits, 0, map, new ArrayList<>(), ret);
        return ret;
    }
    
    void dfs(String digits, int cur, Map<Character, List<Character>> map, List<Character> list, List<String> ret) {
        if (cur == digits.length()) {
            StringBuilder builder = new StringBuilder();
            for (int i=0; i<list.size(); i++)
                builder.append(list.get(i));
            ret.add(builder.toString());
            return;
        }
        List<Character> l = map.get(digits.charAt(cur));
        for (int i=0; i<l.size(); i++) {
            list.add(l.get(i));
            dfs(digits, cur+1, map, list, ret);
            list.remove(list.size()-1);
        }
    }


    // Legacy solutions
    // Recursive solution
    public ArrayList<String> letterCombinations3(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String>();
        if(digits==null || digits.isEmpty()) {   
            ret.add("");
            return ret;
        }
        
        String[] DIGIT = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int index = Integer.parseInt(digits.substring(0, 1));
        ArrayList<String> list = letterCombinations2(digits.substring(1));
        for (int i=0; i<DIGIT[index].length(); i++){
            for (int j=0; j<list.size(); j++){
                ret.add(DIGIT[index].charAt(i)+list.get(j));
            }
        }
        
        return ret;
    }

    // Iterative solution
    public ArrayList<String> letterCombinations4(String digits) {
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
