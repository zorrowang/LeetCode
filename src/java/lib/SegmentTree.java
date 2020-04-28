package src.java.lib;

import java.util.LinkedList;

class Node {
  int val, rangeLeft, rangeRight;
  Node left, right;

  public Node(int val, int rangeLeft, int rangeRight) {
      this.val = val;
      this.rangeLeft = rangeLeft;
      this.rangeRight = rangeRight;
      left = right = null;
  }
}

public class SegmentTree {
    Node root;

    SegmentTree(int[] nums) {
      this.root = build(nums);
    }

    private Node build(int[] nums) {
        return buildRec(nums, 0, nums.length - 1);
    }

    private Node buildRec(int[] nums, int i, int j) {
        if (i == j) 
            return new Node(nums[i], i, j);
        
        int mid = (i + j) / 2;
        Node left = buildRec(nums, i, mid);
        Node right = buildRec(nums, mid+1, j);
        
        Node root = new Node(left.val + right.val, i, j);
        root.left = left;
        root.right = right;
        
        return root;
    }

    // Query a Sum of Given Range
    int sum(int left, int right) {
        return sumRec(this.root, left, right);
    }

    private int sumRec(Node cur, int left, int right) {
        if (cur.rangeLeft >= left && cur.rangeRight <= right)
            return cur.val;
        if (right < cur.rangeLeft || left > cur.rangeRight)
            return 0;
        return sumRec(cur.left, left, right) + sumRec(cur.right, left, right);
    }

    void update(int val, int pos) {
        update(root, val, pos);
    }

    private void update(Node node, int val, int pos) {
        if (node.rangeLeft == pos && node.rangeRight == pos) {
            node.val = val;
            return;
        }

        int mid = (node.rangeLeft + node.rangeRight) / 2;
        if (pos <= mid)
            update(node.left, val, pos);
        else 
            update(node.right, val, pos);
        
        node.val = node.left.val + node.right.val;
    }

    void printLevel() {
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Node> temp = new LinkedList<>();
        queue.offer(this.root);

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            System.out.print(n.val + "[" + n.rangeLeft + "," + n.rangeRight + "]");
            System.out.print(" ");

            if (n.left != null) temp.offer(n.left);
            if (n.right != null)  temp.offer(n.right);

            if (queue.isEmpty() && !temp.isEmpty()) {
                System.out.println();
                queue = temp;
                temp = new LinkedList<>();
            }
        }
    }
}