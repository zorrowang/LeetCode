# Sort - _O(nlog)_ Solutions

## Quick Sort

## Merge Sort

Merge sort (also commonly spelled _mergesort_) is an efficient, general-purpose, comparison-based sorting algorithm. Most implementations produce a _stable sort_, which means that the order of equal elements is the same in the input and output. Merge sort is a _divide and conquer_ algorithm.

### Implementation

```
MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:  
             middle m = (l+r)/2
     2. Call mergeSort for first half:
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)
```

```
Merge

```

### Time Complexity

## References

- <https://www.geeksforgeeks.org/merge-sort/>
- <https://en.wikipedia.org/wiki/Merge_sort>
