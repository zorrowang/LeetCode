package src.java.medium.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class ListNode {
        ListNode pre, next;
        int key, val;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            pre = next = null;
        }
        ListNode(int key, int val, ListNode pre, ListNode next) {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    int cap, cnt;
    ListNode head, tail;
    Map<Integer, ListNode> map;
    public LRUCache(int capacity) {
        this.cap = capacity;
        cnt = 0;
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            if (cnt==cap) {
                removeFromTail();
                cnt--;
            }
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            ListNode n = head.next;
            head.next = node;
            node.pre = head;
            n.pre = node;
            node.next = n;
            cnt++;
        }
    }
    
    private void moveToHead(ListNode node) {
        if (node == head.next)  return;
        // Remove node
        node.pre.next = node.next;
        node.next.pre = node.pre;
        // Insert node after head
        ListNode n = head.next;
        head.next = node;
        node.pre = head;
        n.pre = node;
        node.next = n;
    }
    
    private void removeFromTail() {
        if (tail.pre == head)   return;
        ListNode node = tail.pre;
        map.remove(node.key);
        node.pre.next = tail;
        tail.pre = node.pre;
    }
}