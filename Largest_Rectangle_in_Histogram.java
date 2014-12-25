public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (height==null || height.length==0)   return 0;
        LinkedList<Integer> heightStack = new LinkedList<Integer>();
        LinkedList<Integer> indexStack = new LinkedList<Integer>();
        int ret=0;
        
        for (int i=0; i<height.length; i++){
            if (heightStack.isEmpty() || heightStack.peek()<height[i]){
                heightStack.push(height[i]);
                indexStack.push(i);
            }
            else if (heightStack.peek()>height[i]){
                int in = 0;
                while(!heightStack.isEmpty()){
                    in = indexStack.pop();
                    int temp = heightStack.pop()*(i-in);
                    ret = Math.max(ret, temp);
                }
                heightStack.push(height[i]);
                indexStack.push(in);
            }
        }
        
        while(!heightStack.isEmpty()){
            int temp = heightStack.pop()*(height.length-indexStack.pop());
            ret = Math.max(ret, temp);
        }
        
        return ret;
    }
}
