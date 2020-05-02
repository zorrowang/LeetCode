package src.java.medium.bit;

public class MaximumProductWordLengths {
    public int maxProduct(String[] words) {
        int[] masks = new int[words.length];
        int ret = 0;
        for (int i=0; i<words.length; i++) {
            String s = words[i];
            for (int j=0; j<s.length(); j++)
                masks[i] |= (1<<(s.charAt(j)-'a'));
        }
        
        for (int i=0; i<masks.length-1; i++) {
            for (int j=i+1; j<masks.length; j++) {
                if ((masks[i] & masks[j]) == 0)
                    ret = Math.max(ret, words[i].length()*words[j].length());
            }
        }
        return ret;
    }
}