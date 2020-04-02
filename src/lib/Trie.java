package src.lib;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    char val;
    TrieNode[] children;
    boolean isLeaf;

    TrieNode(char ch) {
        val = ch;
        children = new TrieNode[26];
    }

    TrieNode(char ch, boolean isWord) {
        this(ch);
        isLeaf = isWord;
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

        cur.isLeaf = true;
    }

    boolean search(String word) {
        word = word.toLowerCase();
        TrieNode cur = root;

        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null)
                return false;
            cur = cur.children[ch-'a'];
        }
        return cur.isLeaf;
    }
}
