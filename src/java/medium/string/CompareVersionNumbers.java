package src.java.medium.string;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int i=0, j=0;
        for (; i<strs1.length && j<strs2.length; i++, j++) {
            int v1 = Integer.parseInt(strs1[i]);
            int v2 = Integer.parseInt(strs2[j]);
            if (v1 > v2)    return 1;
            else if (v1 < v2)   return -1;
        }
        
        for (; i<strs1.length; i++)
            if (Integer.parseInt(strs1[i]) > 0)
                return 1;
         for (; j<strs2.length; j++)
            if (Integer.parseInt(strs2[j]) > 0)
                return -1;
        return 0;
    }
}