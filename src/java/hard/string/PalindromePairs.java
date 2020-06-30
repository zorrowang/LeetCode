package src.java.hard.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {
    class Node {
        int index;
        char c;
        Node[] children;
        
        Node(char ch) {
            c = ch;
            children = new Node[26];
            index = -1;
        }
    }
    
    class Trie {
        Node root;
        Trie() {
            root = new Node(' ');
        }
        
        void addWord(String word, int index) {
            Node cur = root;
            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c-'a'] == null)
                    cur.children[c-'a'] = new Node(c);
                cur = cur.children[c-'a'];
            }
            cur.index = index;
        }
        
        List<Integer> searchPal(String word) {
            List<Integer> ret = new ArrayList<>();
            Node cur = root;
            if (cur.index != -1 && isPal(word, 0))
                ret.add(cur.index);
            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                cur = cur.children[c-'a'];
                if (cur == null)    return ret;
                if (cur.index != -1 && isPal(word, i+1))
                    ret.add(cur.index);
            }
            for (int i=0; i<cur.children.length; i++)
                getPalIndex(cur.children[i], new StringBuilder(), ret);
            return ret;
        }
        
        boolean isPal(String word, int start) {
            int end = word.length()-1;
            while(start < end) {
                if (word.charAt(start++) != word.charAt(end--))
                    return false;
            }
            return true;
        }
        
        void getPalIndex(Node node, StringBuilder sb, List<Integer> ret) {
            if (node == null)   return;
            sb.append(node.c);
            if (node.index != -1 && isPal(sb.toString(), 0))
                ret.add(node.index);
            for (int i=0; i<node.children.length; i++) {
                getPalIndex(node.children[i], sb, ret);
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        Trie trie = new Trie();
        for (int i=0; i<words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            trie.addWord(sb.reverse().toString(), i);
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i=0; i<words.length; i++) {
            List<Integer> indexes = trie.searchPal(words[i]);
            for (Integer index : indexes)
                if (index != i)
                    ret.add(new ArrayList<>(Arrays.asList(i, index)));
        }
        return ret;
    }
}