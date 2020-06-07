package src.java.medium.tree;

public class VerifyPreorderSequenceBinarySearchTree {
    /**
     * @param preorder: List[int]
     * @return: return a boolean
     */
    public boolean verifyPreorder(int[] preorder) {
        // write your code here
        return verify(preorder, 0, preorder.length-1, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    private boolean verify(int[] preorder, int start, int end, int max, int min) {
        for (int i=start; i<=end; i++)
            if (preorder[i]<=min || preorder[i]>= max)
                return false;
        if (start>=end) return true;
        
        if (preorder[start] > preorder[start+1]) {
            int mid = start+1;
            while(mid <= end && preorder[start] > preorder[mid])
                mid++;
            return verify(preorder, start+1, mid-1, preorder[start], min) && verify(preorder, mid, end, max, preorder[start]);
        } else {
            return verify(preorder, start+1, end, max, preorder[start]);
        }
    }
}