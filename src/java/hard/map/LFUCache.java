package src.java.hard.map;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    class Node {
        Node prev, next;
        int val, key, freq;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }
    
    Node head, tail;
    int cap, cnt;
    Map<Integer, Node> map, freqMap;
    
    public LFUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        cap = capacity;
        cnt = 0;
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key))  return -1;
        Node n = map.get(key);
        n.freq++;
        updateFreq(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.val = value;
            n.freq++;
            updateFreq(n);
        } else {
            if (cap == 0)   return;
            if (cnt == cap) {
                Node n = head.next;
                map.remove(n.key);
                if (freqMap.get(n.freq) == n)
                    freqMap.remove(n.freq);
                head.next = n.next;
                n.next.prev = head;
            } else {
                cnt++;
            }
            Node n = new Node(key, value);
            map.put(key, n);
            if (freqMap.containsKey(n.freq)) {
                // insert the node at the head of this freq
                Node node = freqMap.get(n.freq);
                Node next = node.next;
                node.next = n;
                n.prev = node;
                n.next = next;
                next.prev = n;
                // update freq map
                freqMap.put(n.freq, n);
            } else {
                freqMap.put(n.freq, n);
                insertHead(n);
            }
        }
    }
    
    private void insertHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
    
    private void updateFreq(Node n) {
        if (freqMap.containsKey(n.freq) || freqMap.get(n.freq-1) != n) {
            Node prev = n.prev;
            // delete node
            n.prev.next = n.next;
            n.next.prev = n.prev;
            // insert the node at the head of this freq
            Node node = null;
            if (freqMap.containsKey(n.freq))
                node = freqMap.get(n.freq);
            else 
                node = freqMap.get(n.freq-1);
            Node next = node.next;
            node.next = n;
            n.prev = node;
            n.next = next;
            next.prev = n;
            // update freq map
            freqMap.put(n.freq, n);
            Node freqHeads = freqMap.get(n.freq-1);
            if (freqHeads == n && prev.freq == n.freq-1 && prev != head)
                freqMap.put(prev.freq, prev);
            else if (freqHeads == n && (prev.freq != n.freq-1 || prev == head))
                freqMap.remove(n.freq-1);
        } else if (freqMap.get(n.freq-1) == n) {
             // when node is head of current freq, just update freq map
            Node prev = n.prev;
            freqMap.put(n.freq, n);
            Node freqHeads = freqMap.get(n.freq-1);
            if (freqHeads == n && prev.freq == n.freq-1 && prev != head)
                freqMap.put(prev.freq, prev);
            else if (freqHeads == n && (prev.freq != n.freq-1 || prev == head))
                freqMap.remove(n.freq-1);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */