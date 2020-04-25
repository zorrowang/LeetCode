package src.easy.array;

class FindPivotIndex {
  public int pivotIndex(int[] nums) {
      int[] left = new int[nums.length];
      int[] right = new int[nums.length];
      
      for (int i=1; i<nums.length; i++) {
          left[i] = nums[i-1] + left[i-1];
          right[nums.length-i-1] = nums[nums.length-i] + right[nums.length-i];
      }
      
      for (int i=0; i<nums.length; i++)
          if (left[i] == right[i])
              return i;
      return -1;
  }
}