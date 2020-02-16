public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s==null || s.isEmpty())    return 0;
        int[] ret = new int[s.length()];
        int max = 0;
        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Integer> index = new LinkedList<Integer>();
        
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (ch=='('){
                stack.push(ch);
                index.push(i);
            }
            else{
                if (stack.isEmpty())    continue;
                stack.pop();
                int in = index.pop();
                int length = i-in+1;
                if (in>0)   length += ret[in-1];
                ret[i] = length;
                max = Math.max(max, length);
            }
        }

        return max;
    }
}