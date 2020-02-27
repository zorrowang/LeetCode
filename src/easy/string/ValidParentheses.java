package src.easy.string;

import java.util.LinkedList;

class ValidParentheses {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<Character> stack = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(isLeftParenthese(ch))    stack.push(ch);
            else{
                if(!stack.isEmpty() && isPair(stack.peek(), ch))    stack.pop();
                else    return false;
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isPair(char p, char q){
        if (p=='(' && q==')')   return true;
        if (p=='[' && q==']')   return true;
        if (p=='{' && q=='}')   return true;
        return false;
    }
    
    private boolean isLeftParenthese(char p){
        if (p=='(' || p=='[' || p=='{') return true;
        return false;
    }
}

