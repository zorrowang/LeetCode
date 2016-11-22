public class Solution {
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
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
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