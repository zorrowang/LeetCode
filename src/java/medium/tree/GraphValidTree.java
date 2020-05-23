package src.java.medium.tree;

public class GraphValidTree {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (edges == null) return false;
        if (edges.length == 0)  return n<=1;
        UnionFind union = new UnionFind(n);
        for (int i=0; i<edges.length; i++) {
        	int p = edges[i][0];
        	int q = edges[i][1];
        	if (union.find(p, q))
        	    return false;
        	union.unite(p, q);
        }
        return union.verify();
    }
    
    class UnionFind {
    	int[] id;
    
    	UnionFind(int n) {
    		id = new int[n];
    		for (int i=0; i<n; i++)
    			id[i] = i;
    	}
    
    	public int root(int p) {
    		while(p != id[p]) {
    		    id[p] = id[id[p]];
    			p = id[p];
    		}
    		return p;
    	}
    
    	public boolean find(int p, int q) {
    		int i = root(p);
    		int j = root(q);
    		return i==j;
    	}
    
    	public void unite(int p, int q) {
    		int i = root(p);
    		int j = root(q);
    		id[i] = j;
    	}
        
        public boolean verify() {
            int pid = root(0);
            for (int i=0; i<id.length; i++)
    			if (pid != root(i))
    			    return false;
    	    return true;
        }
    }
}