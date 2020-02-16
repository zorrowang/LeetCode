public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String>();
        if(n<=0)    return ret;
        generateParenthesisHelper(n*2, 0, 0, "", ret);
        return ret;
    }
    
    public void generateParenthesisHelper(int n, int left, int right, 
        String str, ArrayList<String> ret){
            
        if(left<right || left+right>n)  return;
        
        if(left==right && left+right==n){
            ret.add(str);
            return;
        }
        
        generateParenthesisHelper(n, left+1, right, str+'(', ret);
        generateParenthesisHelper(n, left, right+1, str+')', ret);
    }
}

