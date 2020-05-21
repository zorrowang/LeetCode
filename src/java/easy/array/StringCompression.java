package src.java.easy.array;

public class StringCompression {
    public int compress(char[] chars) {
        int cur = 0;
        int i = 0, j = 1;
        while(i < chars.length) {
            chars[cur++] = chars[i];
            int count = 1;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
                count++;
            };
            if (count > 1) {
                char[] t = String.valueOf(count).toCharArray();
                for (int s=0; s<t.length; s++)
                    chars[cur++] = t[s];
            }
            i = j++;
        }
        return cur;
    }
}