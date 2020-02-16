public class Solution {
    // When using String.split(), it may result some empty strings.
	// Pay attention to gracefully handle them.
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (path==null || path.isEmpty())   return path;
        path = path.trim();
        String[] dirs = path.split("/");
        LinkedList<String> stack = new LinkedList<String>();
        
        for (int i=0; i<dirs.length; i++){
            if(dirs[i].trim().equals("..")){
                if (!stack.isEmpty())   
                    stack.pop();
            }
            else if (dirs[i].trim().equals("."))
                continue;
            else{
                if (!dirs[i].trim().isEmpty())
                    stack.push(dirs[i].trim());
            }
        }
        
        String ret = "";
        while(!stack.isEmpty()){
            ret = "/"+stack.pop()+ret;
        }
        return ret.isEmpty()?"/":ret;
    }
}