// Solution 1: Not pass bc of TLE
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int[] heights = new int[n];
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i=0; i<n; i++) {
            map.put(i, new HashSet<Integer>());
        }
        for (int i=0; i<edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        int min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            heights[i] = bfs(i, map);
            min = Math.min(heights[i], min);
        }
        for (int i=0; i<n; i++) {
            if (heights[i] == min) {
                ret.add(i);
            }
        }
        return ret;
    }
    
    public int bfs(int root, HashMap<Integer, HashSet<Integer>> map) {
        int ret = 1;
        HashSet<Integer> set = map.get(root);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(root);
        visited.addAll(set);
        while(!set.isEmpty()) {
            HashSet<Integer> temp = new HashSet<>();
            for (Integer i : set) {
                Set<Integer> s = map.get(i);
                for (Integer j : s) {
                    if (!visited.contains(j)) {
                        temp.add(j);
                        visited.add(j);
                    }
                }
            }
            set = temp;
            ret += 1;
        }
        return ret;
    }
}

// Solution 2
// Reference: https://discuss.leetcode.com/topic/30572/share-some-thoughts/2
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int[] heights = new int[n];
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i=0; i<n; i++) {
            map.put(i, new HashSet<Integer>());
        }
        for (int i=0; i<edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        
        for (int i=0; i<n; i++) {
            if (map.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        int count = leaves.size();
        while (count < n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int l : leaves) {
                int i = map.get(l).iterator().next();
                map.get(i).remove(l);
                if (map.get(i).size() == 1) {
                    temp.add(i);
                }
            }
            count += temp.size();
            leaves = temp;
        }
        return leaves;
    }
}