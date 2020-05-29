package src.java.medium.string;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] array = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i=array.length-1; i>=0; i--) {
            if (array[i].isEmpty()) continue;
            builder.append(array[i] + " ");
        }
        return builder.toString().trim();
    }
}