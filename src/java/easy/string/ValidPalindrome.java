package src.java.easy.string;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s==null)    return true;
        int i=0, j=s.length()-1;
        
        while(i<j){
            while(!Character.isLetterOrDigit(s.charAt(i)) && i<j) i++;
            while(!Character.isLetterOrDigit(s.charAt(j)) && i<j) j--;
            char ch1 = s.charAt(i++);
            char ch2 = s.charAt(j--);
            if(Character.toLowerCase(ch1)!=Character.toLowerCase(ch2))
                return false;
        }
        
        return true;
    }
}

