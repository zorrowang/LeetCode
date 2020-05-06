package src.java.lib;

public class UnionFind {
    private int[] parent;  // parent[i] = parent of i
    private int count;     // number of sets

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];  // path compression by halving
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        parent[rootQ] = rootP;
        count--;
    }
    
    public int count() {
        return count;
    }
}