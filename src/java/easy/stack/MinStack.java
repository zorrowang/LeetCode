package src.java.easy.stack;

import java.util.LinkedList;

public class MinStack {
    LinkedList<Integer> stack;
    LinkedList<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek()>x)
            min.push(x);
        else
            min.push(min.peek());
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}