package src.java.medium.string;

public class SentenceScreenFitting {
    /**
     * @param sentence: a list of string
     * @param rows: an integer
     * @param cols: an integer
     * @return: return an integer, denote times the given sentence can be fitted on the screen
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        // Write your code here
        int curRow = 0, curCol = 0, curWord = 0;
        int cnt = 0;
        while (curRow < rows) {
            if (curWord == sentence.length) {
                cnt++;
                curWord = 0;
            }
            int len = sentence[curWord].length();
            if (len > cols)  return 0;
            else if (cols - curCol >= len) {
                curCol += len+1;
                curWord++;
            }
            else {
                curRow++;
                curCol = 0;
            }
        }
        return cnt;
    }
}