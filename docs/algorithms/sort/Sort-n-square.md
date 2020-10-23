# Sort - _O(n^2)_ Solutions

<!-- MarkdownTOC -->

- [Bubble Sort](#Bubble-sort)
  - [Bubble Sort Implementation](#bubble-sort-implementation)
  - [Optimized Implementation](#optimized-implementation)
  - [Bubble Sort Analysis](#bubble-sort-analysis)
- [Insertion Sort](#Insertion-sort)
  - [Insertion Sort Implementation](#insertion-sort-implementation)
  - [Insertion Sort Analysis](#insertion-sort-analysis)
- [Selection Sort](#selection-sort)
  - [Selection Sort Implementation](#selection-sort-implementation)
  - [Selection Sort Analysis](#selection-sort-analysis)
- [ShellSort](#shellsort)
  - [ShellSort Implementation](#shellsort-implementation)
  - [ShellSort Analysis](#shellsort-analysis)

<!-- /MarkdownTOC -->

## Bubble Sort

Bubble Sort is a simple algorithm which is used to sort a given set of n elements provided in form of an array with n number of elements. Bubble Sort compares all the element one by one and sort them based on their values.

If the given array has to be sorted in ascending order, then bubble sort will start by comparing the first element of the array with the second element, if the first element is greater than the second element, it will swap both the elements, and then move on to compare the second and the third element, and so on.

If we have total n elements, then we need to repeat this process for n-1 times.

![Bubble Sort](../../images/bubble-sort.png)

### Bubble Sort Implementation

Following are the steps involved in bubble sort(for sorting a given array in ascending order):

- Starting with the first element(index = 0), compare the current element with the next element of the array.
- If the current element is greater than the next element of the array, swap them.
- If the current element is less than the next element, move to the next element. Repeat Step 1.

```java
void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n-1; i++)
        for (int j = 0; j < n-i-1; j++)
            if (arr[j] > arr[j+1]) {
                // swap arr[j+1] and arr[j]
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
}
```

### Optimized Implementation

The algorithm above always runs O(n^2) time even if the array is sorted. It can be optimized by stopping the algorithm if inner loop didn’t cause any swap.

```java
void bubbleSort(int arr[], int n) {
    int i, j, temp;
    boolean swapped;
    for (i = 0; i < n - 1; i++) {
        swapped = false;
        for (j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // swap arr[j] and arr[j+1]
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }

        // IF no two elements were  
        // swapped by inner loop, then break
        if (swapped == false)
            break;
    }
}
```

### Bubble Sort Analysis

Worst and Average Case Time Complexity: O(n^2). Worst case occurs when array is reverse sorted.

Best Case Time Complexity: O(n). Best case occurs when array is already sorted.

Auxiliary Space: O(1)

Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.

Sorting In Place: Yes

Stable: Yes

## Insertion Sort

Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands. The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and placed at the correct position in the sorted part.

![Insertion Sort](../../images/insertion-sort.png)

### Insertion Sort Implementation

To sort an array of size n in ascending order:

- Iterate from arr[1] to arr[n] over the array.
- Compare the current element (key) to its predecessor.
- If the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements one position up to make space for the swapped element.

```java
void sort(int arr[], int n) {
    for (int i = 1; i < n; ++i) {
        int key = arr[i];
        int j = i - 1;

        // Move elements of arr[0..i-1], that are greater than key,
        // to one position ahead of their current position
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}
```

### Insertion Sort Analysis

Time Complexity: O(n^2)

Auxiliary Space: O(1)

Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order. And it takes minimum time (Order of n) when elements are already sorted.

Sorting In Place: Yes

Stable: Yes

## Selection Sort

The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two sub-arrays in a given array.

- The sub-array which is already sorted.
- Remaining sub-array which is unsorted.

In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted sub-array is picked and moved to the sorted sub-array.

### Selection Sort Implementation

```java
void sort(int arr[], int n) {
    // One by one move boundary of unsorted sub-array
    for (int i = 0; i < n-1; i++) {
        // Find the minimum element in unsorted array
        int min_idx = i;
        for (int j = i+1; j < n; j++)
            if (arr[j] < arr[min_idx])
                min_idx = j;

        // Swap the found minimum element with the first element
        int temp = arr[min_idx];
        arr[min_idx] = arr[i];
        arr[i] = temp;
    }
}
```

### Selection Sort Analysis

Time Complexity: O(n^2)

Auxiliary Space: O(1)

Boundary Cases: Selection sort takes max time regardless elements are sorted or not.

Sorting In Place: Yes

Stable: No

## ShellSort

ShellSort is mainly a variation of Insertion Sort. In insertion sort, we move elements only one position ahead. When an element has to be moved far ahead, many movements are involved. The idea of shellSort is to allow exchange of far items. In shellSort, we make the array h-sorted for a large value of h. We keep reducing the value of h until it becomes 1. An array is said to be h-sorted if all sublists of every h’th element is sorted.

### ShellSort Implementation

```java
int shellSort(int arr[], int n) {
    // Start with a big gap, then reduce the gap
    for (int gap = n/2; gap > 0; gap /= 2) {
        // Do a gapped insertion sort for this gap size.
        // The first gap elements a[0..gap-1] are already in gapped order
        // keep adding one more element until the entire array is gap sorted
        for (int i = gap; i < n; i += 1) {
            // add a[i] to the elements that have been gap sorted
            // save a[i] in temp and make a hole at position i
            int temp = arr[i];
  
            // shift earlier gap-sorted elements up until the correct  
            // location for a[i] is found
            int j;
            for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                arr[j] = arr[j - gap];

            //  put temp (the original a[i]) in its correct location
            arr[j] = temp
        }
    }
    return 0;
}
```

### ShellSort Analysis

Time Complexity: O(n^2)

Auxiliary Space: O(1)

Sorting In Place: Yes

Stable: No

## References

- <https://www.geeksforgeeks.org/bubble-sort/>
- <https://www.geeksforgeeks.org/insertion-sort/>
- <https://www.geeksforgeeks.org/selection-sort/>
- <https://www.geeksforgeeks.org/shellsort/>
