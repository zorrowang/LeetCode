package src.java.medium.string;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    // Backtracking - DFS
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), ret);
        return ret;
    }
    
    private void dfs(String s, int start, List<String> list, List<List<String>> ret) {
        if (start == s.length()) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i=start; i<s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i+1));
                dfs(s, i+1, list, ret);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start) != s.charAt(end))   return false;
            start++;
            end--;
        }
        return true;
    }

    // Recursion
    public List<List<String>> partition2(String s) {
        List<List<String>> ret = new ArrayList<>();
        if (s==null || s.isEmpty()) return ret;
        
        for (int i=0; i<s.length(); i++){
            if (isPalindrome(s.substring(0, i+1))){
                List<List<String>> list = partition2(s.substring(i+1, s.length()));
                if (list.isEmpty()){
                     ArrayList<String> temp = new  ArrayList<String>();
                     temp.add(s.substring(0, i+1));
                     ret.add(temp);
                }
                else{
                    for (List<String> l : list){
                        ArrayList<String> temp = new ArrayList<String>(l);
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

    // DP solution - O(n^2)
    public List<List<String>> partition3(String s) {
        List<List<String>> ret = new ArrayList<>();
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
    
    public List<List<String>> partition(String s, int start, boolean[][] palin) {        
        List<List<String>> ret = new ArrayList<>();
        
        if (s.length()==start){
            ret.add(new ArrayList<String>());
            return ret;
        }            
        for (int i=start; i < s.length(); i++){
            if (palin[start][i]){
                List<List<String>> temp = partition(s, i+1, palin);
                for (List<String> ls : temp){
                    ls.add(0, s.substring(start, i+1));
                }
                ret.addAll(temp);
            }
        }
        return ret;
    }
}