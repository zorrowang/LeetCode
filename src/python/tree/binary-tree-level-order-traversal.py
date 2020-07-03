
# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of lists of integers
    def levelOrder(self, root):
        ret = []
        cur_node_list= []
        
        if root is not None:
            cur_node_list.append(root)
        while cur_node_list:
            curRet = []
            child_node_list = []
            for node in cur_node_list:
                curRet.append(node.val)
                if node.left:
                    child_node_list.append(node.left)
                if node.right:
                    child_node_list.append(node.right)
            ret.append(curRet)
            cur_node_list = child_node_list
        return ret