public class Solution {
    public String decodeString(String s) {
        if (!s.contains("[")) {
            return s;
        }
        int i = 0;
        int j = 0;
        StringBuilder builder = new StringBuilder();
        while (i < s.length()) {
            while(i < s.length() && !Character.isDigit(s.charAt(i))) {
                i++;
            }
            builder.append(s.substring(j, i));
            j = i;
            if (i == s.length()) {
                break;
            }
            while (s.charAt(i) != '[') {
                i++;
            }
            int num = Integer.parseInt(s.substring(j, i));
            j = ++i;
            int count = 1;
            while (count > 0) {
                if (s.charAt(i) == '[') {
                    count++;
                } else if (s.charAt(i) == ']') {
                    count--;
                }
                i++;
            }
            String str = decodeString(s.substring(j, --i));
            j = ++i;
            while(num > 0) {
                builder.append(str);
                num--;
            }
        }
        return builder.toString();
    }
}