public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n<=0)   return 0;
        int[] ret = new int[n+1];
	
	// An empty node can only construct one subtree - empty tree
        ret[0] = 1;
        
	// The outer loop is to check the total number of trees constructed as root node i (1...n)
	// The inner loop is to check how many trees can be constructed based on root node i
        for (int i=1; i<=n; i++){
            for (int j=0; j<i; j++){
		// ret[j] means number of left subtrees
		// ret[i-j-1] means number of right subtrees
                ret[i] += ret[j]*ret[i-j-1];
            }
        }
        
        return ret[n];
    }
}

