package src.java.easy.string;

public class ValidWordAbbreviation {
    /**
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return: true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        // write your code here
        int i = 0, j = 0;
        while (i < word.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                int count = 0;
                while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    count = count*10 + (abbr.charAt(j++) - '0');
                    if (count == 0) return false;
                }
                i += count;
            } else {
                if (word.charAt(i++) != abbr.charAt(j++))
                    return false;
            }
        }
        return i==word.length() && j==abbr.length();
    }
}