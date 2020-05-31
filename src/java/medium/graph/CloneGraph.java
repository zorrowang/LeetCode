package src.java.medium.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    // DFS
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }
    
    private Node dfs(Node node, Map<Integer, Node> map) {
        if (node == null)   return null;
        if (map.containsKey(node.val))
            return map.get(node.val);
        Node n = new Node(node.val);
        map.put(n.val, n);
        for (Node t : node.neighbors) {
            n.neighbors.add(dfs(t, map));
        }
        return n;
    }

    // BFS
    public Node cloneGraph2(Node node) {
        if (node == null)   return null;
        Queue<Node> origin = new LinkedList<>(), copy = new LinkedList<>();
        Map<Integer, Node> visited = new HashMap<>();
        Map<Integer, Node> copyVisited = new HashMap<>();
        
        Node copyRoot = new Node(node.val);
        origin.offer(node);
        copy.offer(copyRoot);
        visited.put(node.val, node);
        copyVisited.put(copyRoot.val, copyRoot);
        
        while (!origin.isEmpty()) {
            Node cur = origin.poll();
            Node copyCur = copy.poll();
            
            for (Node n : cur.neighbors) {
                if (!visited.containsKey(n.val)) {
                    Node t = new Node(n.val);
                    copyCur.neighbors.add(t);
                    visited.put(n.val, n);
                    copyVisited.put(t.val, t);
                    origin.offer(n);
                    copy.offer(t);
                } else {
                    copyCur.neighbors.add(copyVisited.get(n.val));
                }
            }
        }
        return copyRoot;
    }
}