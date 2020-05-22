package src.java.easy.array;

public class ShortestWordDistance {
     /**
     * @param words: a list of words
     * @param word1: a string
     * @param word2: a string
     * @return: the shortest distance between word1 and word2 in the list
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        // Write your code here
        int ret = Integer.MAX_VALUE;
        int w1 = -1, w2 = -1;
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) w1 = i;
            if (words[i].equals(word2)) w2 = i;
            if (w1!=-1 && w2!=-1)   ret = Math.min(ret, Math.abs(w1-w2));
        }
        return ret;
    }
}