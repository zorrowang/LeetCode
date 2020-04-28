package src.java.easy.string;

class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        if (S==null || S.isEmpty()) return S;
        int i=0, j=S.length()-1;
        char[] array = S.toCharArray();
        while(i < j) {
            if (!Character.isLetter(array[i])) {
                i++;    continue;
            }
            if (!Character.isLetter(array[j])) {
                j--;    continue;
            }
            char t = array[i];
            array[i++] = array[j];
            array[j--] = t;
        }
        return String.valueOf(array);
    }
}