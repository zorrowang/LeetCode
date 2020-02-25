package src.easy.string;

import java.util.LinkedList;

class BackspaceStringCompare {
  public boolean backspaceCompare(String S, String T) {
      LinkedList<Character> stackS = new LinkedList<>();
      LinkedList<Character> stackT = new LinkedList<>();
      
      for (int i=0; i<S.length(); i++) {
          if (S.charAt(i) == '#') {
              if (!stackS.isEmpty())
                  stackS.pop();
          } else {
              stackS.push(S.charAt(i));
          }
          
      }
      for (int i=0; i<T.length(); i++) {
          if (T.charAt(i) == '#') {
              if (!stackT.isEmpty())
                  stackT.pop();
          } else {
              stackT.push(T.charAt(i));
          }
      }
      
      return String.valueOf(stackS).equals(String.valueOf(stackT));
  }
}