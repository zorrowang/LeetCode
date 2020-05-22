package src.java.medium.tree;

import src.java.lib.TreeNode;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

// Since Java can't pass in the reference of reference, the head pointer of list can't change
// So we use the pair of linked list node and tree node to keep track of the correct position of head
// Reference: http://gongxuns.blogspot.com/2012/12/leetcodeconvert-sorted-list-to-binary.html
public class ConvertSortedListBST {
    public class Pair{
        public TreeNode treeNode;
        public ListNode listNode;
        public Pair(TreeNode t, ListNode l){
            treeNode = t;
            listNode = l;
        }
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        return (sortedListToBST(head, 0, len-1)).treeNode;
    }
    
    private Pair sortedListToBST(ListNode head, int start, int end){
        if(start>end)   return new Pair(null, head);
        Pair left = sortedListToBST(head, start, (start+end)/2-1);
        head = left.listNode;
        TreeNode node = new TreeNode(head.val);
        node.left = left.treeNode;
        head = head.next;
        Pair right = sortedListToBST(head, (start+end)/2+1, end);
        node.right = right.treeNode;
        return new Pair(node, right.listNode);
    }
}

