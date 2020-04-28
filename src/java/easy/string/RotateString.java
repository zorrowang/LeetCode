package src.java.easy.string;

class RotateString {
    // Brute-force
    public boolean rotateString(String A, String B) {
        if (A==null || B==null) return false;
        if (A.length()<=1)  return A.equals(B);
        for(int i=1; i<A.length(); i++) {
            String str = A.substring(i) + A.substring(0, i);
            if (str.equals(B))  return true;
        }
        return false;
    }

    // Simple check 
    class Solution {
        public boolean rotateString(String A, String B) {
            if (A==null || B==null) return false;
            return A.length() == B.length() && (A + A).contains(B);
        }
    }
}