package src.java.medium.string;

import java.util.LinkedList;

public class BasicCalculatorII {
    public int calculate(String s) {
        if (s==null || s.trim().isEmpty()) return 0;
        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<Character> operators = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ')   i++;
            else if (Character.isDigit(c)) {
                int t = i;
                while (i<s.length() && Character.isDigit(s.charAt(i)))
                    i++;
                int n = Integer.parseInt(s.substring(t, i));
                nums.offer(n);
            } else {
                operators.offer(c);
                i++;
            }
        }
        
        LinkedList<Integer> nums2 = new LinkedList<>();
        LinkedList<Character> operators2 = new LinkedList<>();
        nums2.offer(nums.poll());
        while(!operators.isEmpty()) {
            int n1 = nums.poll();
            char op = operators.poll();
            if (op == '*')  nums2.offer(n1*nums2.pollLast());
            else if (op == '/')  nums2.offer(nums2.pollLast()/n1);
            else {
                nums2.offer(n1);
                operators2.offer(op);
            }
        }
        
        int ret = nums2.poll();
        while (!operators2.isEmpty()) {
            int n1 = nums2.poll();
            char op = operators2.poll();
            if (op == '+')  ret += n1;
            else if (op == '-') ret -= n1;
        }
        return ret;
    }
}