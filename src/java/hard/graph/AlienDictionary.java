package src.java.hard.graph;

import java.util.Arrays;
import java.util.LinkedList;

public class AlienDictionary {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        // Write your code here
        boolean[][] matrix = new boolean[26][26];
        int[] degree = new int[26];
        Arrays.fill(degree, -2);
        
        for (String w : words)  
            for (int i=0; i<w.length(); i++)
                degree[w.charAt(i)-'a'] = -1;
        for (int i=0; i<words.length; i++) {
            for (int j=i+1; j<words.length; j++) {
                gen(matrix, degree, words[i], words[j]);
            }
        }
        
        StringBuilder builder = new StringBuilder();
        LinkedList<Integer> index = new LinkedList<>();
        for (int i=0; i<degree.length; i++)
            if (degree[i] == 0) index.offer(i);
        while(!index.isEmpty()) {
            int i = index.poll();
            builder.append((char)(i+'a'));
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j]) {
                    matrix[i][j] = false;
                    degree[j]--;
                    if (degree[j] == 0)
                        index.offer(j);
                }
            }
        }
        for (int i=0; i<degree.length; i++) {
            if (degree[i] == -1)    
                builder.append((char)(i+'a'));
        }
        return builder.toString();
    }
    
    private void gen(boolean[][] matrix, int[] degree, String w1, String w2) {
        int i=0, j=0;
        while (i < w1.length() && j < w2.length()) {
            int m = w1.charAt(i)-'a';
            int n = w2.charAt(j)-'a';
            if (m != n) {
                if (!matrix[m][n]) {
                    matrix[m][n] = true;
                    if (degree[n]<1)  degree[n] = 1;
                    else    degree[n]++;
                    if (degree[m]==-1) degree[m] = 0;
                }
                return;
            }
            i++;
            j++;
        }
    }
}