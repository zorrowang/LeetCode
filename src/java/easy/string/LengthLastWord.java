package src.java.easy.string;

public class LengthLastWord {
    public int lengthOfLastWord(String s) {
        if(s==null || s.isEmpty())  return 0;
        s = s.trim();
        int i=s.length()-1;
        
        while(i>=0 && Character.isLetter(s.charAt(i))){
            i--;
        }
        return s.length()-i-1;
    }
}

