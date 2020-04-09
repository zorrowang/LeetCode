# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        add_on = 0
        head = ListNode(0)
        current = head
        while (l1 is not None or l2 is not None):
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            n = val1 + val2 + add_on
            current.next = ListNode(n%10)
            current = current.next
            add_on = n/10
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        if add_on:
            current.next = ListNode(add_on)
        return head.next