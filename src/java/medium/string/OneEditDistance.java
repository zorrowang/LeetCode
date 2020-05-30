package src.java.medium.string;

public class OneEditDistance {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // write your code here
        if (s==null || t==null) return false;
        int n=s.length(), m=t.length();
        if (Math.abs(n-m)>1)    return false;
        int i=0, j=0;
        int cnt = 0;
        while(i<n && j<m) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
            } else {
                cnt++;
                if (cnt > 1)    return false;
                if (n>m) i++;
                else if (n<m)   j++;
                else {
                    i++;
                    j++;
                }
            }
        }
        
        if (cnt==1)
            return i==n && j==m;
        else
            return (i==n && j==m-1) || (i==n-1 && j==m);
    }
}