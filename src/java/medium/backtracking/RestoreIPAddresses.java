package src.java.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    // Backtracking Solution
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if (s.length() > 3*4)
            return ret;
        restoreIpAddresses(s, 0, 1, new ArrayList<>(), ret);
        return ret;
    }
    
    private void restoreIpAddresses(String s, int start, int level, List<String> list, List<String> ret) {
        if (level == 4) {
            if (start >= s.length())
                return;
            String str = s.substring(start);
            int t = Integer.parseInt(str);
            if (str.startsWith("0") && (t!=0 || str.length()>1))
                return;
            if (t >= 0 && t <= 255) {
                list.add(str);
                ret.add(String.join(".", list));
                list.remove(list.size()-1);
            }
            return;
        }
        
        for (int i=1; i<4 && start+i<=s.length(); i++) {
            String str = s.substring(start, start+i);
            int t = Integer.parseInt(str);
            if (str.startsWith("0") && (t!=0 || str.length()>1))
                continue;
            if (t >= 0 && t <= 255) {
                list.add(str);
                restoreIpAddresses(s, start+i, level+1, list, ret);
                list.remove(list.size()-1);
            }
        }
    }

    // Greedy Solution
    public List<String> restoreIpAddresses2(String s) {
        List<String> ret = new ArrayList<String>();
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

