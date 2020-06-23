package src.java.medium.array;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] temp = new int[nums.length*2];
        for(int i=0,j=nums.length; i<nums.length; i++) {
            temp[i] = nums[i];
            temp[j+i] = nums[i];
        }
        
        LinkedList<Integer> nStack = new LinkedList<>();
        LinkedList<Integer> pStack = new LinkedList<>();
        
        int[] tempRet = new int[nums.length*2];
        for(int i=0; i<temp.length; i++) {
            while(!nStack.isEmpty() && nStack.peek() < temp[i]) {
                nStack.pop();
                int p = pStack.pop();
                tempRet[p] = temp[i];
            }
            nStack.push(temp[i]);
            pStack.push(i);
        }
        while(!pStack.isEmpty()) {
            tempRet[pStack.pop()] = -1;
        }
        int[] ret = new int[nums.length];
        System.arraycopy(tempRet, 0, ret, 0, ret.length);
        return ret;
    }
}