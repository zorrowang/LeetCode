# Sort - _O(nlogn)_ Solutions

<!-- MarkdownTOC -->

- [Quick Sort](#quick-sort)
- [Merge Sort](#merge-sort)
- [Heap Sort](#heap-sort)
- [Tree Sort](#tree-sort)

<!-- /MarkdownTOC -->

## Quick Sort

## Merge Sort

Merge sort (also commonly spelled _mergesort_) is an efficient, general-purpose, comparison-based sorting algorithm. Most implementations produce a _stable sort_, which means that the order of equal elements is the same in the input and output. Merge sort is a _divide and conquer_ algorithm.

### Merge Sort Workflow

Keep dividing the unsorted list into n sub-lists until each one only comprises 1 element (a list of 1 element is supposed sorted).

![Merge sort divide](../../images/merge-sort-divide.png)

Repeatedly merge sublists to produce newly sorted sublists until there is only 1 sublist remaining. This will be the sorted list

![Merge sort conquer](../../images/merge-sort-conquer.png)

### Implementation

#### Top-down implementation

```java
void mergeSort(int Arr[], int start, int end) {
    if(start < end) {
        int mid = (start + end) / 2;
        mergeSort(Arr, start, mid);
        mergeSort(Arr, mid+1, end);
        merge(Arr, start, mid, end);
    }
}

void merge(int Arr[], int start, int mid, int end) {

    // create a temp array
    int temp[] = new int[end - start + 1];

    // crawlers for both intervals and for temp
    int i = start, j = mid+1, k = 0;

    // traverse both arrays and in each iteration add smaller of both elements in temp
    while(i <= mid && j <= end) {
        if(Arr[i] <= Arr[j]) {
            temp[k] = Arr[i];
            k += 1; i += 1;
        }
        else {
            temp[k] = Arr[j];
            k += 1; j += 1;
        }
    }

    // add elements left in the first interval
    while(i <= mid) {
        temp[k] = Arr[i];
        k += 1; i += 1;
    }

    // add elements left in the second interval
    while(j <= end) {
        temp[k] = Arr[j];
        k += 1; j += 1;
    }

    // copy temp to original interval
    for(i = start; i <= end; i += 1) {
        Arr[i] = temp[i - start]
    }
}
```

#### Bottom-up implementation

TODO

### Time Complexity

In sorting n objects, merge sort has an average and worst-case performance of O(_nlogn_). If the running time of merge sort for a list of length n is T(n), then the recurrence _T(n) = 2T(n/2) + n_ follows from the definition of the algorithm.

## Heap Sort

## Tree Sort

## References

- <https://www.geeksforgeeks.org/merge-sort/>
- <https://en.wikipedia.org/wiki/Merge_sort>
