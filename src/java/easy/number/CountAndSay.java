package src.java.easy.number;

import java.util.LinkedList;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n<=0)   return "";
        String ret = "1";
        for (int i=2; i<=n; i++)
            ret = transfer(ret);
        return ret;
    }
    
    public String transfer(String str){
        LinkedList<Integer> nums = new LinkedList<Integer>();
        LinkedList<Integer> counts = new LinkedList<Integer>();
        
        int num = str.charAt(0)-'0';
        int count = 1;
        for (int i=1; i<str.length(); i++){
            if (num == str.charAt(i)-'0')
                count++;
            else{
                nums.add(num);
                counts.add(count);
                num = str.charAt(i)-'0';
                count = 1;
            }
        }
        nums.add(num);
        counts.add(count);
        
        StringBuilder ret = new StringBuilder();
        for(int i=0; i<nums.size(); i++){
            ret.append(counts.get(i));
            ret.append(nums.get(i));
        }
        return ret.toString();
    }
}