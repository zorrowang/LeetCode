package src.java.easy.string;

/*
 * There are two cases that strings are buddy
 * 1. they are the same, and one letter exists at least twice
 * 2. they are different on two positions, and the count of each letter is the same 
 */
class BuddyStrings {
  public boolean buddyStrings(String A, String B) {
      if (A==null || B==null) return false;
      if (A.length() != B.length())   return false;
      
      int[] countA = new int[26];
      int[] countB = new int[26];
      int diff = 0;
      for (int i=0; i<A.length(); i++) {
          countA[A.charAt(i)-'a']++;
          countB[B.charAt(i)-'a']++;
          if (A.charAt(i) != B.charAt(i))
              diff++;
      }
      
      if (diff == 0) {
          for (int i=0; i<26; i++)
              if (countA[i] > 1)
                  return true;
          return false;
      } else if (diff == 2) {
          for (int i=0; i<26; i++)
              if (countA[i] != countB[i])
                  return false;
          return true;
      } else {
          return false;
      }
  }
}
