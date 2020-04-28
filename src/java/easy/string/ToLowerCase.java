package src.java.easy.string;

class ToLowerCase {
    public String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        for (int i=0; i<charArray.length; i++) {
            if (Character.isLetter(charArray[i]) && charArray[i]>='A' && charArray[i]<='Z')
                charArray[i] = (char)(charArray[i]-'A'+'a');
        }
        return String.valueOf(charArray);
    }
}