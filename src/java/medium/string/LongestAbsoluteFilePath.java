package src.java.medium.string;

import java.util.LinkedList;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        int len = 0, max = 0, curTab = 0;
        if (input==null || input.isEmpty()) return max;
        LinkedList<String> stack = new LinkedList<>();
        String[] arr = input.split("\n");
        for (String s : arr) {
            if (!s.startsWith("\t") && !s.contains(".")) {
                while (!stack.isEmpty())
                    stack.pop();
                stack.push(s);
                len = s.length()+1;
            } else {
                curTab = 0;
                while(s.startsWith("\t")) {
                    s = s.substring(1);
                    curTab++;
                }
                while (stack.size() > curTab)
                    len -= stack.pop().length()+1;
                if (s.contains(".")) {
                    max = Math.max(len+s.length(), max);
                } else {
                    stack.push(s);
                    len += s.length()+1;
                }
            }
        }
        return max;
    }
}