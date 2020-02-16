// Algorithm:
// #1: from right to left, find the first number which violates the incremental sequence and mark as number 'j'
// #2: from right to left, find the first number which is larger than number 'j', and mark as number 'i'
// #3: swap number i and j
// #4: reverse from i+1 to the end (here I use sort cuz I am too lazy to refactor reverse method)
public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null || num.length<2)   return;
        int i=num.length-1, j=num.length-2;
        while(j>=0 && num[i]<=num[j]){
            i--;
            j--;
        }
        
        if(j<0)
            reverse(num);
        else{
            i=num.length-1;
            while(i>j && num[i]<=num[j])
                i--;
            swap(num, i, j);
            Arrays.sort(num, j+1, num.length);
        }
            
    }
    
    private void reverse(int[] num){
        int i=0, j=num.length-1;
        while(i<j){
            int temp = num[i];
            num[i++] = num[j];
            num[j--] = temp;
        }
    }
    
    private void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}

