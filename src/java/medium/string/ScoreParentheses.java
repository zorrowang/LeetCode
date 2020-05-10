package src.java.medium.string;

import java.util.LinkedList;

public class ScoreParentheses {
    public int scoreOfParentheses(String S) {
        if (S==null || S.isEmpty())     return 0;
        
        LinkedList<Integer> indexes = new LinkedList<>();
        LinkedList<Integer> scores = new LinkedList<>();
        LinkedList<Integer> scoreIndexes = new LinkedList<>();
        
        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                indexes.push(i);
            }
            else {
                int index = indexes.pop();
                if (index+1 == i) {
                    scores.push(1);
                    scoreIndexes.push(index);
                } else {
                    int sum = 0;
                    while(!scoreIndexes.isEmpty() && scoreIndexes.peek()>index) {
                        sum += scores.pop();
                        scoreIndexes.pop();
                    }
                    scores.push(sum*2);
                    scoreIndexes.push(index);
                }
            }
        }
        int ret = 0;
        while(!scores.isEmpty())    ret += scores.pop();
        return ret;
    }
}