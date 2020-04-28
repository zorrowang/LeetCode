package src.java.easy.string;

class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] plateCounts = transfer(licensePlate);        
        String ret = null;
        for (String word : words) {
            int[] counts = transfer(word);
            boolean match = true;
            for (int i=0; i<plateCounts.length; i++) {
                if (plateCounts[i] == 0)    continue;
                else if (plateCounts[i] > counts[i]) {
                    match = false;
                    break;
                }
            }
            if (match && (ret==null || ret.length() > word.length()))
                ret = word;
        }
        return ret;
    }
    
    private int[] transfer(String str) {
        str = str.toLowerCase();
        int[] counts = new int[26];
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c))
                counts[c-'a']++;
        }
        return counts;
    }
}