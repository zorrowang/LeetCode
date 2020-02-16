public class Solution {
    public int majorityElement(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : num) {
            if (map.containsKey(i)){
                if (map.get(i)+1 > num.length/2)   return i;
                map.put(i, map.get(i)+1);
            }
            else{
                map.put(i, 1);
            }
        }
        return num[0];
    }
}

//Moore's voting algorithm
public class Solution {
    public int majorityElement(int[] num) {
        int major_index = 0;
        int count = 1;
        for (int i=1; i<num.length; i++){
            if (num[i] == num[major_index])
                count++;
            else 
                count--;
            if (count == 0){
                major_index = i;
                count = 1;
            }
        }
        return num[major_index];
    }
}