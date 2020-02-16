public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] array = str.split(" ");
        if (pattern.length() != array.length)  return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!array[i].equals(map.get(c)))   return false;
            } else {
                if (map.containsValue(array[i]))    return false;
                map.put(c, array[i]);
            }
        }
        return true;
    }
}