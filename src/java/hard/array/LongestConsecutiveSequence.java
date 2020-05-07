package src.java.hard.array;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    class UnionFind {
        int[] roots;
        UnionFind(int n) {
            roots = new int[n];
            for (int i=0; i<n; i++)
                roots[i] = i;
        }
        
        int find(int n) {
            while(roots[n] != n)
                n = roots[n];
            return n;
        }
        
        void union(int s, int t) {
            int r1 = find(s);
            int r2 = find(t);
            roots[r1] = r2;
        }
        
        int getMaxCount() {
            int ret = 0;
            int[] counts = new int[roots.length];
            for(int i=0; i<roots.length; i++) {
                int r = find(i);
                counts[r]++;
                ret = Math.max(ret, counts[r]);
            }
            return ret;
        }
    }

    public int longestConsecutive(int[] nums) {
        if (nums==null || nums.length==0)   return 0;
        int len = nums.length;
        UnionFind uf = new UnionFind(len);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<len; i++) {
            if (map.containsKey(nums[i]))   continue;
            map.put(nums[i], i);
            if(nums[i]<Integer.MAX_VALUE && map.containsKey(nums[i]+1)){
                uf.union(i, map.get(nums[i]+1));
            }
            if(nums[i]>Integer.MIN_VALUE && map.containsKey(nums[i]-1)){
                uf.union(i,map.get(nums[i]-1));
            }
        }
        return uf.getMaxCount();
    }

    public int longestConsecutive2(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ret = 0;
        for(int i=0; i<num.length; i++){
            if (!map.containsKey(num[i])){
                int left=0, right=0;
                if(map.containsKey(num[i]-1))
                    left = map.get(num[i]-map.get(num[i]-1));
                if(map.containsKey(num[i]+1))
                    right = map.get(num[i]+map.get(num[i]+1));
                map.put(num[i], left+right+1);
                if (left!=0)  map.put(num[i]-map.get(num[i]-1), left+right+1);
                if (right!=0) map.put(num[i]+map.get(num[i]+1), left+right+1);
                ret = Math.max(ret, left+right+1);
            }
        }
        return ret;
    }
}
