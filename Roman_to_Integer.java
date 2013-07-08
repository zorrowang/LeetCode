public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] nums = new int[256];
        nums['I'-'A'] = 1;
        nums['V'-'A'] = 5;
        nums['X'-'A'] = 10;
        nums['L'-'A'] = 50;
        nums['C'-'A'] = 100;
        nums['D'-'A'] = 500;
        nums['M'-'A'] = 1000;
        
        int ret = 0;
        while(!s.isEmpty()){
            int index = 1;
            char ch = s.charAt(0);
            // Case 9
            if(s.length()>=2 && nums[s.charAt(1)-'A']==10*nums[ch-'A']){
                index++;
                ret += (nums[ch-'A']*9);
            }
            // Case 4
            else if(s.length()>=2 && nums[s.charAt(1)-'A']==5*nums[ch-'A']){
                index++;
                ret += (nums[ch-'A']*4);
            }
            // Case >5
            else if(s.length()>=2 && nums[s.charAt(1)-'A']*5==nums[ch-'A']){
                index++;
                while(s.length()>=index+1 && nums[s.charAt(index)-'A']==nums[s.charAt(index-1)-'A'])
                    index++;
                ret += nums[ch-'A'];
                ret += (nums[s.charAt(index-1)-'A']*(index-1));
            }
            // Case 5 or <4
            else{
                while(s.length()>=index+1 && nums[s.charAt(index)-'A']==nums[s.charAt(index-1)-'A'])
                    index++;
                ret += (nums[s.charAt(index-1)-'A']*index);
            }
            s = s.substring(index);
        }
        return ret;
    }
}

