package src.easy.string;

class ReverseStringII {
    public String reverseStr(String s, int k) {
        if (s==null || s.isEmpty() || k<=0) return s;
        char[] array = s.toCharArray();
        for (int i=0; i<array.length; i+=2*k)
            reverse(array, i, Math.min(i+k-1, s.length()-1));
        return String.valueOf(array);
    }
    
    public void reverse(char[] array, int i, int j) {
        while (i < j) {
            char c = array[i];
            array[i++] = array[j];
            array[j--] = c;
        }
    }
}