package src.java.medium.matrix;

import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {
    class Node {
        int row, col;
        Node (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]
        );
        
        int len = matrix.length;
        for (int i=0; i<len; i++)
            pq.offer(new Node(0, i));
        
        int cnt = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            if (++cnt == k)     return matrix[n.row][n.col];
            if (n.row<len-1)    pq.offer(new Node(n.row+1, n.col));
        }
        return 0;
    }
}