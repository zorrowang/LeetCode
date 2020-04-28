package src.java.easy.string;

class ReverseWordInStringIII {
    public String reverseWords(String s) {
        if (s==null || s.length()<=1)   return s;
        String[] array = s.split(" ");
        StringBuilder ret = new StringBuilder();
        for (int i=0; i<array.length; i++) {
            if (!array[i].isEmpty()) ret.append(reverse(array[i]));
            ret.append(' ');
        }
        return ret.toString().trim();
    }
    
    private char[] reverse(String s) {
        char[] array = s.toCharArray();
        int i=0, j=s.length()-1;
        while (i < j) {
            char t = array[i];
            array[i++] = array[j];
            array[j--] = t;
        }
        return array;
    }
}