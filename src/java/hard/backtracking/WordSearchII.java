package src.java.hard.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    // Backtracking (DFS) + Trie
    // The benefit of using Trie here is it can find multiple words in the same path
    // (share the same prefix)
    class TrieNode {
        char val;
        TrieNode[] children;
        String leaf;
    
        TrieNode(char ch) {
            val = ch;
            children = new TrieNode[26];
            leaf = null;
        }
    }
    
    class Trie {
        TrieNode root;
    
        Trie() {
            root = new TrieNode(' ');
        }
    
        void insert(String word) {
            word = word.toLowerCase();
            TrieNode cur = root;
    
            for (int i=0; i<word.length(); i++) {
                char ch = word.charAt(i);
                if (cur.children[ch - 'a'] == null) {
                    TrieNode node = new TrieNode(ch);
                    cur.children[ch-'a'] = node;
                }
                cur = cur.children[ch-'a'];
            }
    
            cur.leaf = word;
        }
        
        public List<String> findWords(char[][] board, String[] words) {
            for (String w : words)  insert(w);
            Set<String> ret = new HashSet<>();
            Set<String> set = new HashSet<>();
            for (int i=0; i<board.length; i++) {
                for (int j=0; j<board[i].length; j++) {
                    String index = String.valueOf(i)+String.valueOf(j);
                    set.add(index);
                    dfs(board, i, j, root.children[board[i][j]-'a'], ret, set);
                    set.remove(index);
                }
            }
            return new ArrayList<>(ret);
        }
        
        private void dfs(char[][] board, int m, int n, TrieNode node, Set<String> list, Set<String> visited) {
            if (node == null)    return;
            if (node.leaf != null)  list.add(node.leaf);
            int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
            for (int i=0; i<4; i++) {
                int newM = m + dirs[i][0];
                int newN = n + dirs[i][1];
                if (newM>=0 && newM<board.length && newN>=0 && newN<board[0].length) {
                    String index = String.valueOf(newM)+String.valueOf(newN);;
                    if (visited.contains(index))    continue;
                    visited.add(index);
                    dfs(board, newM, newN, node.children[board[newM][newN]-'a'], list, visited);
                    visited.remove(index);
                }
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        return trie.findWords(board, words);
    }

    // Backtracking (DFS) - LTE
    public List<String> findWords2(char[][] board, String[] words) {
        List<String> ret = new ArrayList<>();
        for (String w : words)
            if (searchWord(board, w))
                ret.add(w);
        return ret;
    }
    
    private boolean searchWord(char[][] board, String word) {
        Set<String> set = new HashSet<>();
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                String index = String.valueOf(i)+String.valueOf(j);
                set.add(index);
                boolean ret = dfs(board, i, j, word, 0, set);
                set.remove(index);
                if (ret)    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int m, int n, String word, int start, Set<String> visited) {
        if (start >= word.length())   return true;
        if (word.charAt(start) != board[m][n])  return false;
        
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for (int i=0; i<4; i++) {
            int newM = m + dirs[i][0];
            int newN = n + dirs[i][1];
            if (newM>=0 && newM<board.length && newN>=0 && newN<board[0].length) {
                String index = String.valueOf(newM)+String.valueOf(newN);;
                if (visited.contains(index))    continue;
                visited.add(index);
                boolean ret = dfs(board, newM, newN, word, start+1, visited);
                visited.remove(index);
                if (ret)    return true;
            }
        }
        return start==word.length()-1;
    }
}