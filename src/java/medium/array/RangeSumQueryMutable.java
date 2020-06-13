package src.java.medium.array;

class NumArray {
    class Node {
        int start, end;
        int val;
        Node left, right;
        
        Node(int val) {
            this.val = val;
        }
        
        Node(int val, int start, int end) {
            this.val = val;
            this.start = start;
            this.end = end;
        }
    }
    
    class SegmentTree {
        Node root;
        SegmentTree(int[] nums) {
            root = build(nums, 0, nums.length-1);
        }
        
        private Node build(int[] nums, int start, int end) {
            if (start > end)    return null;
            if (start == end)   return new Node(nums[start], start, end);
            int mid = start + (end - start)/2;
            Node left = build(nums, start, mid);
            Node right = build(nums, mid+1, end);
            Node node = new Node(left.val+right.val, start, end);
            node.left = left;
            node.right = right;
            return node;
        }
        
        void update(int i, int val, Node node) {
            if (node.start==i && node.end==i) {
                node.val = val;
                return;
            }
            int mid = node.start + (node.end - node.start)/2;
            if (i <= mid)   update(i, val, node.left);
            else    update(i, val, node.right);
            node.val = node.left.val + node.right.val;
        }
        
        int sumRange(int i, int j, Node node) {
            if (node.start == i && node.end == j)   return node.val;
            int mid = node.start + (node.end - node.start)/2;
            if (mid >= j)    return sumRange(i, j, node.left);
            else if (mid < i)   return sumRange(i, j, node.right);
            else {
                return sumRange(i, mid, node.left) + sumRange(mid+1, j, node.right);
            }
        } 
        
        Node getRoot() {
            return this.root;
        }
        
    }
    
    SegmentTree st;
    Node root;
    public NumArray(int[] nums) {
        st = new SegmentTree(nums);
        root = st.getRoot();
    }
    
    public void update(int i, int val) {
        st.update(i, val, root);
    }
    
    public int sumRange(int i, int j) {
        return st.sumRange(i, j, root);
    }
}