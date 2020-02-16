public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder ret = new StringBuilder();
        int length = 1;
        while(num/length>=10)
            length *= 10;
        
        while(num>0 && length>0){
            int cur = num/length;
            if(cur>0)
                ret.append(toRoman(cur, length));
            num %= length;
            length /= 10;
        }
        
        return ret.toString();
    }
    
    public String toRoman(int num, int pos){
        StringBuilder ret = new StringBuilder();
        char[] numerals = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int index=0;
        while(pos>(Math.pow(10, index)))
            index++;
        index *= 2;
        if (num<4){
            for(int i=0; i<num; i++)
                ret.append(numerals[index]);
        }
        else if (num==4){
            ret.append(numerals[index]);
            ret.append(numerals[index+1]);
        }
        else if (num>4 && num<9){
            ret.append(numerals[index+1]);
            for(int i=5; i<num; i++)
                ret.append(numerals[index]);
        }
        else{
            ret.append(numerals[index]);
            ret.append(numerals[index+2]);
        }
        return ret.toString();
    }
}

