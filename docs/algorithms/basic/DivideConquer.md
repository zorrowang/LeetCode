# Divide And Conquer

<!-- MarkdownTOC -->
- [Introduction](#introduction)
- [Common Divide-and-Conquer Algorithms](#common-divide-and-conquer-algorithms)
- [Divide-and-Conquer vs Dynamic Programming](#divide-and-conquer-vs-dynamic-programming)
- [References](#references)
<!-- /MarkdownTOC -->

A divide-and-conquer algorithm works by recursively breaking down a problem into two or more sub-problems of the same or related type, until these become simple enough to be solved directly. The solutions to the sub-problems are then combined to give a solution to the original problem.

## Introduction

This technique can be divided into the following three parts:

- **Divide**: This involves dividing the problem into some sub problem.
- **Conquer**: Sub problem by calling recursively until sub problem solved.
- **Combine**: The Sub problem Solved so that we will get find problem solution.

The pseudo-code of a  divide-and-conquer algorithm is

```
DAC(a, i, j) {
    if(small(a, i, j))
      return(Solution(a, i, j))
    else
      m = divide(a, i, j)               // f1(n)
      b = DAC(a, i, mid)                 // T(n/2)
      c = DAC(a, mid+1, j)            // T(n/2)
      d = combine(b, c)                 // f2(n)
   return(d)
}
```

The recurrence relation for above program is

```
T(n) = f1(n) + 2T(n/2) + f2(n)
```

## Common Divide-and-Conquer Algorithms

- Binary Search
- Quicksort
- Merge Sort

## Divide-and-Conquer vs Dynamic Programming

Both paradigms (D&C and DP) divide the given problem into subproblems and solve them. The differences are

- The subproblems in Divide and Conquer are **not** overlapping with each other.
- The same subproblem in Divide and Conquer is **not** evaluated many times.

## References

- <https://en.wikipedia.org/wiki/Divide-and-conquer_algorithm>
- <https://www.geeksforgeeks.org/divide-and-conquer-algorithm-introduction/>
