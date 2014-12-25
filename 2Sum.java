public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers==null || numbers.length<2)  return null;
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for (int i=0; i<numbers.length; i++){
            if (!map1.containsKey(numbers[i]))
                map1.put(numbers[i], i+1);
            else
                map2.put(numbers[i], i+1);
        }
        Arrays.sort(numbers);
        int i=0, j=numbers.length-1;
        while (i < j){
            int sum = numbers[i] + numbers[j];
            if (sum < target)
                i++;
            else if (sum > target)
                j--;
            else{
                int ret1 = map1.get(numbers[i]);
                int ret2 = map2.containsKey(numbers[i])?map2.get(numbers[j]):map1.get(numbers[j]);
                int[] ret = new int[2];
                if (ret1 < ret2){ 
                    ret[0] = ret1;
                    ret[1] = ret2;
                }
                else{
                    ret[0] = ret2;
                    ret[1] = ret1;
                }
                return ret;
            }
        }
        return null;
    }
}