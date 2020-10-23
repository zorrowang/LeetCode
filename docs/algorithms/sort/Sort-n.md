# Sort - _O(n)_ Solutions

<!-- MarkdownTOC -->

- [Bucket Sort](#bucket-sort)
  - [Bucket Sort Algorithm](#bucket-sort-algorithm)
  - [Bucket Sort Implementation](#bucket-sort-implementation)
  - [Bucket Sort Analysis](#bucket-sort-analysis)
- [Counting Sort](#countin-sort)
  - [Counting Sort Algorithm](#counting-sort-algorithm)
  - [Counting Sort Implementation](#counting-sort-implementation)
  - [Counting Sort Analysis](#counting-sort-analysis)
- [Radix Sort](#radix-sort)
  - [Radix Sort Algorithm](#radix-sort-algorithm)
  - [Radix Sort Implementation](#radix-sort-implementation)
  - [Radix Sort Analysis](#radix-sort-analysis)
- [References](#references)

<!-- / MarkdownTOC -->

## Bucket Sort

Bucket sort is a sorting algorithm that works by distributing the elements of an array into a number of buckets. Each bucket is then sorted individually, either using a different sorting algorithm, or by recursively applying the bucket sorting algorithm. It is a distribution sort, a generalization of pigeonhole sort, and is a cousin of radix sort in the most-to-least significant digit flavor. Bucket sort can be implemented with comparisons and therefore can also be considered a comparison sort algorithm. The computational complexity depends on the algorithm used to sort each bucket, the number of buckets to use, and whether the input is uniformly distributed. 

### Bucket Sort Algorithm

```python
bucketSort()
  create N buckets each of which can hold a range of values
  for all the buckets
    initialize each bucket with 0 values
  for all the buckets
    put elements into buckets matching the range
  for all the buckets
    sort elements in each bucket
  gather elements from each bucket
end bucketSort
```

### Bucket Sort Implementation

```java
public void bucketSort(float[] arr, int n) {
    if (n <= 0)
      return;
    ArrayList<Float>[] bucket = new ArrayList[n];

    // Create empty buckets
    for (int i = 0; i < n; i++)
      bucket[i] = new ArrayList<Float>();

    // Add elements into the buckets
    for (int i = 0; i < n; i++) {
      int bucketIndex = (int) arr[i] * n;
      bucket[bucketIndex].add(arr[i]);
    }

    // Sort the elements of each bucket
    for (int i = 0; i < n; i++) {
      Collections.sort((bucket[i]));
    }

    // Get the sorted array
    int index = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0, size = bucket[i].size(); j < size; j++) {
        arr[index++] = bucket[i].get(j);
      }
    }
  }
```

### Bucket Sort Analysis

- Worst Case Complexity: O(n2)
- Best Case Complexity: O(n+k)
- Average Case Complexity: O(n
- Auxiliary Space: O(n)
- Sorting In Place: No
- Stable: No

## Counting Sort

Counting sort is a sorting algorithm that sorts the elements of an array by counting the number of occurrences of each unique element in the array. The count is stored in an auxiliary array and the sorting is done by mapping the count as an index of the auxiliary array.

### Counting Sort Algorithm

```python
countingSort(array, size)
  max <- find largest element in array
  initialize count array with all zeros
  for j <- 0 to size
    find the total count of each unique element and
    store the count at jth index in count array
  for i <- 1 to max
    find the cumulative sum and store it in count array itself
  for j <- size down to 1
    restore the elements to array
    decrease count of each element restored by 1
```

### Counting Sort Implementation

```java
void countSort(int array[], int size) {
    int[] output = new int[size + 1];

    // Find the largest element of the array
    int max = array[0];
    for (int i = 1; i < size; i++) {
      if (array[i] > max)
        max = array[i];
    }
    int[] count = new int[max + 1];

    // Store the count of each element
    for (int i = 0; i < size; i++) {
      count[array[i]]++;
    }

    // Store the cummulative count of each array
    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }

    // Find the index of each element of the original array in count array, and
    // place the elements in output array
    for (int i = size - 1; i >= 0; i--) {
      output[count[array[i]] - 1] = array[i];
      count[array[i]]--;
    }

    // Copy the sorted elements into original array
    for (int i = 0; i < size; i++) {
      array[i] = output[i];
    }
  }
```

### Counting Sort Analysis

- Worst Case Complexity: O(n+k)
- Best Case Complexity: O(n+k)
- Average Case Complexity: O(n+k)
- Space Complexity: O(max)

## Radix Sort

Radix sort is a sorting technique that sorts the elements by first grouping the individual digits of the same place value. Then, sort the elements according to their increasing/decreasing order.

### Radix Sort Algorithm

```python
radixSort(array)
  d <- maximum number of digits in the largest element
  create d buckets of size 0-9
  for i <- 0 to d
    sort the elements according to ith place digits using countingSort

countingSort(array, d)
  max <- find largest element among dth place elements
  initialize count array with all zeros
  for j <- 0 to size
    find the total count of each unique digit in dth place of elements and
    store the count at jth index in count array
  for i <- 1 to max
    find the cumulative sum and store it in count array itself
  for j <- size down to 1
    restore the elements to array
    decrease count of each element restored by 1
```

### Radix Sort Implementation

```java
void countingSort(int array[], int size, int place) {
    int[] output = new int[size + 1];
    int max = array[0];
    for (int i = 1; i < size; i++) {
    if (array[i] > max)
        max = array[i];
    }
    int[] count = new int[max + 1];

    // Calculate count of elements
    for (int i = 0; i < size; i++)
        count[(array[i] / place) % 10]++;

    // Calculate cummulative count
    for (int i = 1; i < 10; i++)
        count[i] += count[i - 1];

    // Place the elements in sorted order
    for (int i = size - 1; i >= 0; i--) {
        output[count[(array[i] / place) % 10] - 1] = array[i];
        count[(array[i] / place) % 10]--;
    }

    for (int i = 0; i < size; i++)
    array[i] = output[i];
}

// Function to get the largest element from an array
int getMax(int array[], int n) {
    int max = array[0];
    for (int i = 1; i < n; i++)
        if (array[i] > max)
        max = array[i];
    return max;
}

// Main function to implement radix sort
void radixSort(int array[], int size) {
    // Get maximum element
    int max = getMax(array, size);

    // Apply counting sort to sort elements based on place value.
    for (int place = 1; max / place > 0; place *= 10)
        countingSort(array, size, place);
}
```

### Radix Sort Analysis

Time complexity: O(d(n+k)) (_d_ is the number cycle and _O(n+k)_ is the time complexity of counting sort)

## References

- <https://en.wikipedia.org/wiki/Bucket_sort>
- <https://www.geeksforgeeks.org/bucket-sort-2/>
- <https://www.programiz.com/dsa/counting-sort>
- <https://www.geeksforgeeks.org/counting-sort/>
- <https://www.geeksforgeeks.org/radix-sort/>
- <https://www.programiz.com/dsa/radix-sort>
