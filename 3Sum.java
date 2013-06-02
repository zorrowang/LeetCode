public class Solution {
    
    // Key point: have to ensure if the element is duplicate has been checked before
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (num==null || num.length<3) return ret;
        
        Arrays.sort(num);
        
        for(int i=0; i<num.length-2; i++){
            if (i>0&&num[i]==num[i-1])  continue;
            int temp = 0-num[i];
            int j=i+1, k=num.length-1;
            while(j<k){
                int n = num[j]+num[k];
                if (n>temp) k--;
                else if(n<temp) j++;
                else{
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[j++]);
                    list.add(num[k--]);
                    ret.add(list);
                    while (num[j-1]==num[j]&&j<k)
                        j++;
                    while (num[k+1]==num[k]&&j<k)
                        k--;
                }
            }
        }
        
        return ret;
    }
}

