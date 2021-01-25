package src.java.medium.string;

import java.util.Arrays;

public class CustomSortString {
    // Rewritten on 2021/01/25
    public String customSortString(String S, String T) {
        int[] cnt = new int[256];
        for (int i=0; i<T.length(); i++)
            cnt[T.charAt(i)]++;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<S.length(); i++) {
            for (int j=0; j<cnt[S.charAt(i)]; j++) {
                sb.append(S.charAt(i));
            }
            cnt[S.charAt(i)]=0;
        }
        for (int i=0; i<256; i++) {
            for (int j=0; j<cnt[i]; j++) {
                sb.append((char)i);
            }
        }
        return sb.toString();
    }

    public String customSortString2(String S, String T) {
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