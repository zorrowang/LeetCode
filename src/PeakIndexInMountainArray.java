package src;

class PeakIndexInMountainArray {
  // O(n) solution
  public int peakIndexInMountainArray(int[] A) {
      int maxIndex = 0;
      for (int i=1; i<A.length; i++) {
          if (A[maxIndex] < A[i])
              maxIndex = i;
          else
              break;
      }
      return maxIndex;
  }
}
