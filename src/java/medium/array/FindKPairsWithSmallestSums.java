package src.java.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class FindKPairsWithSmallestSums {
    // Heap solution
    class Pair {
        int val1, val2, sum;  // pair values
        int cur1, cur2;       // pair indexes
        Pair(int val1, int cur1, int val2, int cur2) {
            this.val1 = val1;
            this.val2 = val2;
            this.cur1 = cur1;
            this.cur2 = cur2;
            this.sum = val1 + val2;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.sum - p2.sum);
        List<List<Integer>> ret = new ArrayList<>();
        if (nums1==null || nums1.length==0 || nums2==null || nums2.length==0)
            return ret;
        for (int i=0; i<nums1.length; i++)
            pq.offer(new Pair(nums1[i], i, nums2[0], 0));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.cur2 < nums2.length-1)
                pq.offer(new Pair(p.val1, p.cur1, nums2[p.cur2+1], p.cur2+1));
            ret.add(Arrays.asList(p.val1, p.val2));
            if (ret.size()==k)  break;
        }
        return ret;
    }


    // Legacy Solution
    class Node implements Comparable<Node> {
    int key;
    int val;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }

    @Override
    public int compareTo(Node node) {
      return val - node.val;
    }
  }
    
    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<>();
        if (nums1==null || nums1.length==0 || nums2==null || nums2.length==0)
            return ret;
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
    
        for (int i = 0; i < nums1.length; i++) {
          map.put(i, new LinkedList<>(Arrays.stream(nums2).boxed().collect(Collectors.toList())));
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
          LinkedList<Integer> stack = map.get(i);
          int val = stack.pop();
          Node node = new Node(i, nums1[i] + val);
          queue.offer(node);
        }
        while (k > 0 && !queue.isEmpty()) {
          Node node = queue.poll();
          ret.add(new int[] {nums1[node.key], node.val - nums1[node.key]});
          int key = node.key;
          if (!map.get(key).isEmpty()) {
            int val = map.get(key).poll();
            Node next = new Node(key, nums1[key] + val);
            queue.offer(next);
          }
          k--;
        }
        return ret;
    }
}