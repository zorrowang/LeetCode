public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null || s.length()<=1)    return 0;
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        int[] ret = new int[s.length()+1];
        
        for(int i=0; i<s.length(); i++)
            ret[i] = s.length()-i;
        
        for (int i=s.length()-1; i>=0; i--){
            for (int j=i; j<s.length(); j++){
                if (s.charAt(i)==s.charAt(j)&&(j-i<=1||palindrome[i+1][j-1])){
                    palindrome[i][j]=true;
                    ret[i] = Math.min(ret[i], ret[j+1]+1);
                }
            }
        }
        
        return ret[0]-1;
    }
}

