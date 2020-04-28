package src.java.easy.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

class LongestWordDictionary {
  public String longestWord(String[] words) {
      Arrays.sort(words, Comparator.comparingInt(String::length));
      HashSet<String> set = new HashSet<>();
      ArrayList<String> current = new ArrayList<>();
      
      for (int i=0; i<words.length; i++) {
          String s = words[i];
          if (s.length()==1) {
              current.add(s);
              set.add(s);
          }
          else if (set.contains(s.substring(0, s.length()-1))) {
              set.add(s);
              if (current.get(0).length() < s.length()) {
                  current = new ArrayList<>();
              }
              current.add(s);
          }
      }
      
      Collections.sort(current);
      return current.get(0);
  }
}