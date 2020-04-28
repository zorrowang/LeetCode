package src.java.easy.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        int i = 0, j = list.size()-1;
        while(i < j) {
            if (!list.get(i).equals(list.get(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }
}