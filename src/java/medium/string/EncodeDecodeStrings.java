package src.java.medium.string;

import java.util.LinkedList;
import java.util.List;

public class EncodeDecodeStrings {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        if (strs == null)   return null;
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append('/');
            sb.append(s);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> ret = new LinkedList<>();
        while(str.length()>0) {
            String s = helper(str);
            ret.add(s);
            int len = s.length() + String.valueOf(s.length()).length() + 1;
            str = str.substring(len);
        }
        return ret;
    }
    
    private String helper(String str) {
        int start = 0;
        int end = str.indexOf("/");
        int len = Integer.parseInt(str.substring(start, end));
        return str.substring(end+1, end+len+1);
    }
}