package src.medium.dp;

public class UniqueBinarySearchTree {
    public int numTrees(int n) {
        // dp{i, j} = bst {i -> j}
        // dp{i, j} = sum(bst(i, s-1) * bst(s+1, j))
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) {
            dp[i][i] = 1;
            if (i<n-1)
                dp[i][i+1] = 2;
        }
        
        for (int i=2; i<n; i++) {
            int count = 0;
            for (int j=0; j<=i; j++) {
                if (j==0 || j==i) 
                    count += dp[1][i];
                else
                    count += dp[0][j-1] * dp[j+1][i];
            }
            for (int j=0; j+i<n; j++)
                dp[j][j+i] = count;
        }
        return dp[0][n-1];
    }

    // Optimize to be 1D DP, since bst(0, 2) = bst(1, 3)
    // Time complexity is the same as O(n^2)
    // Space complexity is optimized from O(n^2) to O(n)
    public int numTrees1(int n) {
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

