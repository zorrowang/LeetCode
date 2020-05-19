package src.java.hard.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WordLadderII {
    // Backtracking (DFS) - TLE
    int shortest = Integer.MAX_VALUE;
    public List<List<String>> findLaddersDfs(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ret = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(beginWord, endWord, wordList, list, new HashSet<>(), ret, 1);
        return ret;
    }
    
    private void dfs(String beginWord, String endWord, List<String> wordList, List<String> list, 
        HashSet<String> set, List<List<String>> ret, int len) {
        if (len > shortest) return;
        if (beginWord.equals(endWord)) {
            if (shortest == len)
                ret.add(new ArrayList<>(list));
            else if (shortest > len) {
                ret.clear();
                ret.add(new ArrayList<>(list));
                shortest = len;
            }
            return;
        }
        for (int i=0; i<wordList.size(); i++) {
            String s = wordList.get(i);
            if (set.contains(s))    continue;
            if (transfer(beginWord, s)) {
                set.add(s);
                list.add(wordList.get(i));
                dfs(s, endWord, wordList, list, set, ret, len+1);
                set.remove(s);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean transfer(String s1, String s2) {
        int diff = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i)!=s2.charAt(i)) {
                diff++;
            }
        }
        return diff==1;
    }

    // Backtracking (BFS) - TLE
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ret = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        HashSet<String> levelSet = new HashSet<>();
        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();
        HashMap<String, HashSet<String>> path = new HashMap<>();
        
        list1.add(beginWord);
        levelSet.add(beginWord);
        path.put(beginWord, null);
        
        while(!list1.isEmpty()){
            String str = list1.poll();
            if (str.equals(endWord)){
                ret = buildPath(endWord, path);
                break;
            }
            
            for(int i=0; i<str.length(); i++){
                StringBuffer sb = new StringBuffer(str);
                for(int j=0; j<26; j++){
                    sb.setCharAt(i, (char)('a' + j));
                    String newStr = sb.toString();
                    
                    if (newStr.equals(str)) continue;
                    if (!set.contains(newStr) && wordList.contains(newStr)){
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
    
    public List<List<String>> buildPath(String end, HashMap<String, HashSet<String>> path){
        List<List<String>> ret = new ArrayList<>();
        if (path.get(end)==null){
            ArrayList<String> list = new ArrayList<String>();
            list.add(end);
            ret.add(list);
            return ret;
        }
        HashSet<String> set = path.get(end);
        Iterator it = set.iterator();
        while (it.hasNext()){
            List<List<String>> temp = buildPath((String)it.next(), path);
            for(List<String> l : temp)
                l.add(end);
            ret.addAll(temp);
        }
        
        return ret;
    }
}
