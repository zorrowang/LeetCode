/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Since Java can't pass in the reference of reference, the head pointer of list can't change
// So we use the pair of linked list node and tree node to keep track of the correct position of head
// Reference: http://gongxuns.blogspot.com/2012/12/leetcodeconvert-sorted-list-to-binary.html
public class Solution {
    public class Pair{
        public TreeNode treeNode;
        public ListNode listNode;
        public Pair(TreeNode t, ListNode l){
            treeNode = t;
            listNode = l;
        }
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode temp = head;
        int length = 0;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        return (sortedListToBST(head, 0, length-1)).treeNode;
    }
    
    public Pair sortedListToBST(ListNode head, int start, int end){
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

