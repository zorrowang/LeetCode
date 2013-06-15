public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
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
            }
        }
        int ret = 0;
        for(int i : map.values())
            ret = Math.max(i, ret);
        return ret;
    }
}