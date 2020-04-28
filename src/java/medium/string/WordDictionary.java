package src.java.medium.string;

class WordDictionary {
    class TrieNode {
        char c;
        TrieNode[] nexts;
        boolean isWord;
        
        TrieNode(char c) {
            this.c = c;
            nexts = new TrieNode[256];
        }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int index = c-'A';
            if (cur.nexts[index] == null)
                cur.nexts[index] = new TrieNode(c);
            cur = cur.nexts[index];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    private boolean search(String word, int start, TrieNode root) {
        TrieNode cur = root;
        for (int i=start; i<word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                boolean ret = false;
                for (int j=0; j<cur.nexts.length; j++) {
                    if (cur.nexts[j]!=null && search(word, i+1, cur.nexts[j]))
                        ret = true;
                }
                return ret;
            } else {
                int index = c-'A';
                if (cur.nexts[index] == null)
                    return false;
                cur = cur.nexts[index];
            }
        }
        return cur.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */