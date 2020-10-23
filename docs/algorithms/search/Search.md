# Search

<!-- MarkdownTOC -->

- [Linear Search](#linear-search)
  - [Linear Search Algorithm](#linear-search-algorithm)
  - [Linear Search Implementation](#linear-search-implementation)
  - [Linear Search Analysis](#linear-search-analysis)
- [Binary Search](#binary-search)
  - [Binary Search Algorithm](#binary-search-algorithm)
    - [Iterative Method](#iterative-method)
    - [Recursive Method](#recursive-method)
  - [Binary Search Implementation](#binary-search-implementation)
  - [Binary Search Analysis](#binary-search-analysis)
- [Special Search Algorithms](#special-search-algorithms)
  - [Knuth–Morris–Pratt (KMP) Algorithm](#knuth–morris–pratt-kmp-algorithm)
    - [Problem Definition](#problem-definition)
    - [KMP Algorithm Workflow](#kmp-algorithm-workflow)

<!-- / MarkdownTOC -->

## Linear Search

Linear search is the simplest searching algorithm that searches for an element in a list in sequential order. We start at one end and check every element until the desired element is not found.

### Linear Search Algorithm

```python
LinearSearch(array, key)
  for each item in the array
    if item == value
      return its index
```

### Linear Search Implementation

```java
public static int linearSearch(int array[], int x) {
    int n = array.length;
    // Going through array sequentially
    for (int i = 0; i < n; i++) {
        if (array[i] == x)
        return i;
    }
    return -1;
}
```

### Linear Search Analysis

Time Complexity: O(n)
Space Complexity: O(1)

## Binary Search

Binary Search is a searching algorithm for finding an element's position in a **sorted** array.

### Binary Search Algorithm

#### Iterative Method

```python
do until the pointers low and high meet each other.
    mid = (low + high)/2
    if (x == arr[mid])
        return mid
    else if (x > A[mid]) // x is on the right side
        low = mid + 1
    else                       // x is on the left side
        high = mid - 1
```

#### Recursive Method

```python
do until the pointers low and high meet each other.
    mid = (low + high)/2
    if (x == arr[mid])
        return mid
    else if (x > A[mid]) // x is on the right side
        low = mid + 1
    else                       // x is on the left side
        high = mid - 1
```

### Binary Search Implementation

```java
int binarySearch(int array[], int x, int low, int high) {
    // Repeat until the pointers low and high meet each other
    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (array[mid] == x)
            return mid;

        if (array[mid] < x)
            low = mid + 1
        else
            high = mid - 1;
    }
    return -1;
}
```

### Binary Search Analysis

Time Complexity: O(log n)
Space Complexity: O(1)

## Special Search Algorithms

### Knuth–Morris–Pratt (KMP) Algorithm

Pattern searching is an important problem in computer science. When we do search for a string in notepad/word file or browser or database, pattern searching algorithms are used to show the search results.

Knuth–Morris–Pratt string-searching algorithm (or KMP algorithm) searches for occurrences of a "pattern" P within a main "text string" S by employing the observation that when a mismatch occurs, the word itself embodies sufficient information to determine where the next match could begin, thus bypassing re-examination of previously matched characters.

#### Problem Definition

Given a text _txt[0..n-1]_ and a pattern _pat[0..m-1]_, write a function _search(char pat[], char txt[])_ that prints all occurrences of _pat[]_ in _txt[]_. You may assume that _n > m_.

Example:

Input:  txt[] = "THIS IS A TEST TEXT", pat[] = "TEST"
Output: Pattern found at index 10

Input:  txt[] =  "AABAACAADAABAABA", pat[] =  "AABA"
Output: Pattern found at index 0, 9, 12

#### KMP Algorithm Workflow

Preprocessing:

- KMP algorithm preprocesses pat[] and constructs an auxiliary lps[] of size m (same as size of pattern) which is used to skip characters while matching.
- name lps indicates longest proper prefix which is also suffix.. A proper prefix is prefix with whole string not allowed. For example, prefixes of “ABC” are “”, “A”, “AB” and “ABC”. Proper prefixes are “”, “A” and “AB”. Suffixes of the string are “”, “C”, “BC” and “ABC”.
- We search for lps in sub-patterns. More clearly we focus on sub-strings of patterns that are either prefix and suffix.
- For each sub-pattern pat[0..i] where i = 0 to m-1, lps[i] stores length of the maximum matching proper prefix which is also a suffix of the sub-pattern pat[0..i].

```bash
lps[i] = the longest proper prefix of pat[0..i]
         which is also a suffix of pat[0..i].
```

Searching Algorithm:

- start comparison of pat[j] with j = 0 with characters of current window of text
- keep matching characters txt[i] and pat[j] and keep incrementing i and j while pat[j] and txt[i] keep matching. 
- When we see a mismatch

  - We know that characters pat[0..j-1] match with txt[i-j…i-1] (Note that j starts with 0 and increment it only when there is a match).
  - We also know (from above definition) that lps[j-1] is count of characters of pat[0…j-1] that are both proper prefix and suffix. From above two points, we can conclude that we do not need to match these lps[j-1] characters with txt[i-j…i-1] because we know that these characters will anyway match. Let us consider above example to understand this.

## References

- <https://www.programiz.com/dsa/linear-search>
- <https://www.programiz.com/dsa/binary-search>
- <https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/>
- <https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm>
