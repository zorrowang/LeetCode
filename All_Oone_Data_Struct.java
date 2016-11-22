public class AllOne {
    
    HashMap<String, Integer> keyMap;
    HashMap<Integer, HashSet<String>> valueMap;
    HashMap<Integer, ListNode> nodeMap;
    ListNode maxNode;
    ListNode minNode;
    
    private class ListNode {
        int val;
        ListNode left;
        ListNode right;
        ListNode(int x) { val = x; }
    }
    

    /** Initialize your data structure here. */
    public AllOne() {
        keyMap = new HashMap<>();
        valueMap = new HashMap<>();
        nodeMap = new HashMap<>();
        ListNode maxNode = null;
        ListNode minNode = null;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        keyMap.put(key, keyMap.getOrDefault(key, 0) + 1);
        int value = keyMap.get(key);
        if (valueMap.containsKey(value)){
            HashSet set = valueMap.get(value);
            set.add(key);
            valueMap.put(value, set);
        } else {
            valueMap.put(value, new HashSet<String>(Arrays.asList(key)));
            ListNode newNode = new ListNode(value);
            if (value > 1) {
                newNode.left = nodeMap.get(value-1);
                newNode.right = nodeMap.get(value-1).right;
                nodeMap.get(value-1).right = newNode;
                if (newNode.right != null)
                    newNode.right.left = newNode;
                else
                    maxNode = newNode;
            } else {
                if (maxNode == null)
                   maxNode = newNode;
                if (minNode == null)
                    minNode = newNode;
                else {
                    newNode.right = minNode;
                    minNode.left = newNode;
                    minNode = newNode;
                }
            }
            nodeMap.put(value, newNode);
        }
        if (value > 1) {
            HashSet<String> set = valueMap.get(--value);
            set.remove(key);
            if (set.size() == 0) {
                valueMap.remove(value);
                ListNode node = nodeMap.get(value);
                if (node.left == null) {
                    minNode = node.right;
                } else {
                    node.left.right = node.right;
                }
                node.right.left = node.left;
                nodeMap.remove(value);
            } else {
                valueMap.put(value, set);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyMap.containsKey(key)) {
            int value = keyMap.get(key);
            keyMap.put(key, value-1);
            if (valueMap.containsKey(value-1)) {
                HashSet set = valueMap.get(value-1);
                set.add(key);
                valueMap.put(value-1, set);
            } else {
                // Add a new node with - 1
                if (value > 1) {
                    valueMap.put(value-1, new HashSet<String>(Arrays.asList(key)));
                    ListNode newNode = new ListNode(value-1);
                    newNode.left = nodeMap.get(value).left;
                    newNode.right = nodeMap.get(value);
                    nodeMap.get(value).left = newNode;
                    if (newNode.left == null) {
                        minNode = newNode;
                    } else {
                        newNode.left.right = newNode;
                    }
                    nodeMap.put(value-1, newNode);
                }
            }
            // Remove the existing node if necessary
            HashSet<String> set = valueMap.get(value);
            set.remove(key);
            if (set.size() == 0) {
                valueMap.remove(value);
                ListNode node = nodeMap.get(value);
                if (node.left == null) {
                    minNode = node.right;
                } else {
                    node.left.right = node.right;
                }
                if (node.right == null) {
                    maxNode = node.left;
                } else {
                    node.right.left = node.left;
                }
                nodeMap.remove(value);
            } else {
                valueMap.put(value, set);
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (maxNode == null) {
            return "";
        } else {
            ArrayList<String> list = new ArrayList(valueMap.get(maxNode.val));
            return list.get(0);
        }
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (minNode == null) {
            return "";
        } else {
            ArrayList<String> list = new ArrayList(valueMap.get(minNode.val));
            return list.get(0);
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */