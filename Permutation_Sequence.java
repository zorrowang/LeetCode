public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder str = new StringBuilder();
        int permutation = 1;
        int[] nums = new int[n];
        
        for (int i=0; i<n; i++){
            nums[i] = i+1;
            permutation *= nums[i];
        }
        
        for (int i=n; i>0; i--){
            permutation /= i;
            int index = (k-1)/permutation;
            k = (k-1)%permutation+1;
            int num = nums[index];
            str.append(num);
            
            for (int j=index+1; j<n; j++)
                nums[j-1] = nums[j];
        }
        
        return str.toString();
    }
}

