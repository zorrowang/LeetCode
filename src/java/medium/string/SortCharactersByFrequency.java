package src.java.medium.string;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        int[] cnt = new int[256];
        for (int i=0; i<s.length(); i++)
            cnt[s.charAt(i)-' ']++;
        StringBuilder builder = new StringBuilder();
        while(builder.length() < s.length()) {
            int index = 0;
            for (int i=0; i<256; i++)
                if (cnt[i] > cnt[index])
                    index = i;
            char c = (char)(index+' ');
            for (int i=0; i<cnt[index]; i++)    
                builder.append(c);
            cnt[index] = 0;
        }
        return builder.toString();
    }
}