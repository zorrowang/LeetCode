public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (numbers == null || numbers.length==0)   return null;
        int[] ret = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<numbers.length; i++)
            map.put(numbers[i], i);
            
        for (int i=0; i<numbers.length; i++){
            int temp = target-numbers[i];
            if (map.containsKey(temp) && map.get(temp)!=i){
                ret[0] = i+1;
                ret[1] = map.get(temp)+1;
                break;
            }
        }
        
        return ret;
    }
}

