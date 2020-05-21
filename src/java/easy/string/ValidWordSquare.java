package src.java.easy.string;

public class ValidWordSquare {
    /**
     * @param words: a list of string
     * @return: a boolean
     */
    public boolean validWordSquare(String[] words) {
        // Write your code here
        if (words==null || words.length==0) return false;
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<words[i].length(); j++)
                if (words[i].charAt(j) != words[j].charAt(i))
                    return false;
        }
        return true;
    }
}