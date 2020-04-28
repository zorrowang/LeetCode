package src.java.easy.dp;

class MaximizeDistanceClosestPerson {
  public int maxDistToClosest(int[] seats) {
      int[] left = new int[seats.length];
      int[] right = new int[seats.length];        
      int max = 0;
      
      for(int i=0; i<seats.length; i++) {
          if (seats[i] == 0) {
              if (i == 0 || seats[i-1]==1)
                  left[i] = 1;
              else
                  left[i] = left[i-1]+1;
          }
          if (seats[seats.length-i-1] == 0) {
              if (i == 0 || seats[seats.length-i]==1)
                  right[seats.length-i-1] = 1;
              else
                  right[seats.length-i-1] = right[seats.length-i] + 1;
          }
      }
              
      for (int i=0; i<seats.length; i++) {
          int dis = Math.min(left[i], right[i]);
          if (i == 0 && left[i] == 1) dis = right[i];
          if (i == seats.length-1 && right[i] == 1) dis = left[i];
          max = Math.max(max, dis);
      }   
      
      return max;
  }
}