public class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int ret = 0;
        if (tokens==null || tokens.length==0)
            return ret;
        for (int i=0; i<tokens.length; i++){
            try{
                int s = Integer.parseInt(tokens[i]);
                ret = s;
                stack.push(s);
            }
            catch(NumberFormatException e){
                int num2=stack.pop(), num1=stack.pop();
                switch(tokens[i].charAt(0)) {
                    case '+': ret = num1+num2; break;
                    case '-': ret = num1-num2; break;
                    case '*': ret = num1*num2; break;
                    case '/': ret = num1/num2; break;
                }
                stack.push(ret);
            }
        }
        return ret;
    }
}