public class Solution {
    public String originalDigits(String s) {
        if (s == null) {
            return null;
        }
        int[] ret = new int[10];
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        // 0: Zero
        ret[0] = counts['z' - 'a'];
        // 2: tWo
        ret[2] = counts['w' - 'a'];
        // 4: foUr
        ret[4] = counts['u' - 'a'];
        // 6: siX
        ret[6] = counts['x' - 'a'];
        // 8: eiGht
        ret[8] = counts['g' - 'a'];
        // 1: One
        ret[1] = counts['o' - 'a'] - ret[0] - ret[2] - ret[4];
        // 3: tHree
        ret[3] = counts['h' - 'a'] - ret[8];
        // 5: Five
        ret[5] = counts['f' - 'a'] - ret[4];
        // 7: Seven
        ret[7] = counts['s' - 'a'] - ret[6];
        // 9: NiNe
        ret[9] = (counts['n' - 'a'] - ret[7] - ret[1]) / 2;
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ret.length; i++) {
            if (ret[i] != 0) {
                for (int j = 0; j < ret[i]; j++) {
                    builder.append(i);
                }
            }
        }
        return builder.toString();
    }
}