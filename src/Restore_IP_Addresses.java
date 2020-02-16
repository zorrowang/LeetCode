public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String>();
        if(s.length()>12 || s.length()<4)   return ret;
        
        for(int i=1; i<4&&i<s.length(); i++){
            for(int j=i+1; j<i+4&&j<s.length(); j++){
                for(int t=j+1; t<j+4&&t<s.length(); t++){
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, t);
                    String s4 = s.substring(t);
                    if(validate(s1)&&validate(s2)&&validate(s3)&&validate(s4)){
                        String str = s1+'.'+s2+'.'+s3+'.'+s4;
                        ret.add(str);
                    }
                }
            }
        }
        
        return ret;
    }
    
    public boolean validate(String s){
        if(s.length()<1 || s.length()>3)    return false;
        if(s.length()>1 && s.charAt(0)=='0')    return false;
        int n = Integer.parseInt(s);
        return n>=0&&n<256;
    }
}

