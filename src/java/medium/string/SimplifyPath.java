package src.java.medium.string;

import java.util.LinkedList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path==null || path.isEmpty())   return path;
        String[] dirs = path.split("/");
        LinkedList<String> stack = new LinkedList<String>();
        
        for (int i=0; i<dirs.length; i++){
            String str = dirs[i].trim();
            if(str.equals("..")){
                if (!stack.isEmpty())   
                    stack.pop();
            }
            else if (str.isEmpty() || str.equals("."))
                continue;
            else
                stack.push(str);
        }
        
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty())   
            builder.insert(0, "/"+stack.pop());
        return builder.length()==0 ? "/" : builder.toString();
    }
}