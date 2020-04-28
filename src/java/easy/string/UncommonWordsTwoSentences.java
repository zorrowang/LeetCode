package src.java.easy.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UncommonWordsTwoSentences {
  public String[] uncommonFromSentences(String A, String B) {
      Map<String, Integer> map = new HashMap<>();
      String[] arrayA = A.split(" ");
      String[] arrayB = B.split(" ");
      for (String s : arrayA) {
          if (map.containsKey(s))
              map.put(s, map.get(s)+1);
          else
              map.put(s, 1);
      }
      for (String s : arrayB) {
          if (map.containsKey(s))
              map.put(s, map.get(s)+1);
          else
              map.put(s, 1);
      }
      
      ArrayList<String> list = new ArrayList<>();
      for (Map.Entry<String, Integer> entry : map.entrySet())
          if (entry.getValue() == 1)
              list.add(entry.getKey());
      String[] ret = new String[list.size()];
      for (int i=0; i<list.size(); i++)
          ret[i] = list.get(i);
      return ret;
  }

  // Coding optimization
  public String[] uncommonFromSentencesUpdated(String A, String B) {
      Map<String, Integer> map = new HashMap<>();
      for (String s : A.split(" "))
          map.put(s, map.getOrDefault(s, 0)+1);
      for (String s : B.split(" "))
          map.put(s, map.getOrDefault(s, 0)+1);
    
      List<String> ret = new ArrayList<>();
      for (Map.Entry<String, Integer> entry : map.entrySet())
          if (entry.getValue() == 1)
              ret.add(entry.getKey());

      return ret.toArray(new String[ret.size()]);
  }
}