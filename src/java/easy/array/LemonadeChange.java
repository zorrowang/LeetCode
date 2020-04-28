package src.java.easy.array;

class LemonadeChange {
  public boolean lemonadeChange(int[] bills) {
      int fives = 0, tens = 0;
      for (int i=0; i<bills.length; i++) {
          if (bills[i] == 5) {
              fives++;
          } else if (bills[i] == 10) {
              fives--;
              tens++;
          } else {
              fives--;
              if (tens > 0)
                 tens--;
              else
                  fives -= 2;
          }
          if (fives<0)    return false;
      }
      return true;
  }
}