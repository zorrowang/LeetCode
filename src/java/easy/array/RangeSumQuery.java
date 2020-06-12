package src.java.easy.array;


// Segment Tree Solution
class NumArray {
    
    class Node {
        int sum, rangeLeft, rangeRight;
        Node left, right;
        Node(int sum, int rangeLeft, int rangeRight) {
            this.sum = sum;
            this.rangeLeft = rangeLeft;
            this.rangeRight = rangeRight;
            left = null;
            right = null;
        }
    }
    
    class SegmentTree {
        Node root;
        SegmentTree(int[] nums) {
            root = build(nums, 0, nums.length-1);
        }
        
        private Node build(int[] nums, int start, int end) {
            if (start==end) return new Node(nums[start], start, end);
            if (start>end)  return null;
            int mid = start+(end-start)/2;
            Node left = build(nums, start, mid);
            Node right = build(nums, mid+1, end);
            Node root = new Node(left.sum+right.sum, start, end);
            root.left = left;
            root.right = right;
            return root;
        }
        
        int sum(int start, int end) {
            return sumRec(root, start, end);
        }
        
        private int sumRec(Node root, int start, int end) {
            if (root.rangeLeft >= start && root.rangeRight <= end)
                return root.sum;
            else if (root.rangeLeft > end || root.rangeRight < start)
                return 0;
            else
                return sumRec(root.left, start, end) + sumRec(root.right, start, end);
        }
    }

    SegmentTree st;
    public NumArray(int[] nums) {
        st = new SegmentTree(nums);
    }
    
    public int sumRange(int i, int j) {
        return st.sum(i, j);
    }
}


// Legacy solution
class NumArray2 {
    int sum;
    int[] leftToRight;
    int[] rightToLeft;

    public NumArray2(int[] nums) {
        leftToRight = new int[nums.length];
        rightToLeft = new int[nums.length];
        if (nums.length > 0) {
            leftToRight[0] = nums[0];
            rightToLeft[nums.length-1] = nums[nums.length-1];
            
            for(int i=1; i<nums.length; i++) {
                leftToRight[i] = leftToRight[i-1] + nums[i];
                rightToLeft[nums.length-i-1] = rightToLeft[nums.length-i] + nums[nums.length-i-1];
            }
            sum = leftToRight[nums.length-1];
        } else {
            sum = 0;
        }
    }

    public int sumRange(int i, int j) {
        int left = i<=0 ? 0 : leftToRight[i-1];
        int right = j>=rightToLeft.length-1 ? 0 : rightToLeft[j+1];
        return sum - left - right;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);