package src.java.easy.string;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public int numJewelsInStones(String J, String S) {
      if (J==null || S==null || J.isEmpty() || S.isEmpty()) return 0;
      Set<Character> m = new HashSet<>();
      for (int i=0; i<J.length(); i++)
          m.add(J.charAt(i));
      int ret = 0;
      for (int i=0; i<S.length(); i++)
          if (m.contains(S.charAt(i)))
              ret++;
      return ret;
  }
}