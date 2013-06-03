public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String>();
        if(n <= 0)  return ret;
        
        ArrayList<String> list = generateParenthesis(n-1);
        if(list.isEmpty())  ret.add("()");
        else {
            for (String str : list){
                ret.add("("+str+")");
                String str1 = "()"+str;
                String str2 = str+"()";
                if (str1.equals(str2))  ret.add(str1);
                else{
                    ret.add(str1);
                    ret.add(str2);
                }
            }
        }
        
        return ret;
    }
}

