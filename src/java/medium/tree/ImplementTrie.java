package src.java.medium.tree;

// Rewritten on 2021/01/25
class Trie {
    class Node {
        Node[] array;
        boolean isWord;
        
        Node() {
            array = new Node[256];
            isWord = false;
        }
        
        Node getNode(char c) {
            return array[c];
        }
        
        void setNode(char c) {
            array[c] = new Node();
        }
    }
    
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for (int i=0; i<word.length(); i++) {
            if (cur.getNode(word.charAt(i)) == null)
                cur.setNode(word.charAt(i));
            cur = cur.getNode(word.charAt(i));
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for (int i=0; i<word.length(); i++) {
            if (cur.getNode(word.charAt(i)) == null)
                return false;
            cur = cur.getNode(word.charAt(i));
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i=0; i<prefix.length(); i++) {
            if (cur.getNode(prefix.charAt(i)) == null)
                return false;
            cur = cur.getNode(prefix.charAt(i));
        }
        return true;
    }
}


class Trie2 {
    class Node {
        char ch;
        boolean isLeaf;
        Node[] leaves;
        Node(char ch) {
            this.ch = ch;
            leaves = new Node[26];
        }
    }
    
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            if (node.leaves[word.charAt(i)-'a'] == null) {
                Node n = new Node(word.charAt(i));
                node.leaves[word.charAt(i)-'a'] = n;
                node = n;
            } else {
                node = node.leaves[word.charAt(i)-'a'];
            }
        }
        node.isLeaf = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            if (node.leaves[word.charAt(i)-'a'] != null) {
                node = node.leaves[word.charAt(i)-'a'];
            } else {
                return false;   
            }
        }
        return node.isLeaf;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i=0; i<prefix.length(); i++) {
            if (node.leaves[prefix.charAt(i)-'a'] != null) {
                node = node.leaves[prefix.charAt(i)-'a'];
            } else {
                return false;   
            }
        }
        return true;
    }
}