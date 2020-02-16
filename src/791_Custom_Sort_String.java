class Solution {
    public String customSortString(String S, String T) {
        char[] ret = new char[T.length()];
        int[] count = new int[26];
        int[] index = new int[26];
        Arrays.fill(index, -1);
        
        for(int i=0; i<T.length(); i++) {
            count[T.charAt(i)-'a'] += 1;
        }
        
        int current = 0;
        for(int i=0; i<S.length(); i++) {
            if (count[S.charAt(i)-'a']==0) continue;
            index[S.charAt(i)-'a'] = current;
            current += count[S.charAt(i)-'a'];
        }
        
        for(int i=0; i<T.length(); i++) {
            char ch = T.charAt(i);
            if (index[ch-'a'] == -1)    ret[current++] = ch;
            else    ret[index[ch-'a']++] = ch;
        }
        
        return String.valueOf(ret);
    }
}