package src.java.medium.string;

import java.util.LinkedList;

public class DecodeString {
    // Stack solution
    public String decodeString(String s) {
        String ret = "";
        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<String> strs = new LinkedList<>();
        int cur = 0;
        while (cur < s.length()) {
            if (Character.isDigit(s.charAt(cur))) {
                int num = 0;
                while(Character.isDigit(s.charAt(cur))) {
                    num = num*10 + (s.charAt(cur) - '0');
                    cur++;
                }
                nums.push(num);
            } else if (s.charAt(cur) == '[') {
                strs.push(ret);
                ret = "";
                cur++;
            } else if (s.charAt(cur) == ']') {
                StringBuilder builder = new StringBuilder(strs.pop());
                int n = nums.pop();
                for (int i=0; i<n; i++)
                    builder.append(ret);
                ret = builder.toString();
                cur++;
            } else
                ret += s.charAt(cur++);
        }
        return ret;
    }

    // DFS solution
    public String decodeStringRec(String s) {
        if (!s.contains("[")) {
            return s;
        }
        int i = 0, j = 0;
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