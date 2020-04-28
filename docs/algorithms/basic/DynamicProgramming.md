# Dynamic Programming

<!-- MarkdownTOC -->

- [Introduction](#introduction)
- [Steps to Solve Dynamic Programming Problem](#steps-to-solve-dynamic-programming-problem)
- [References](#references)

<!-- /MarkdownTOC -->

**Dynamic programming** is a computer programming method, that simplifies a complicated problem by breaking it down into simpler sub-problems in a recursive manner.

## Introduction

There are two key attributes that a problem must have in order for dynamic programming to be applicable

- **optimal substructure**: an optimal solution can be constructed from optimal solutions of its subproblems.
- **overlapping sub-problems**: the problem can be broken down into subproblems which are reused several times or a recursive algorithm for the problem solves the same subproblem over and over rather than always generating new subproblems

If a problem can be solved by combining optimal solutions to non-overlapping sub-problems, the strategy is called "[Divide and Conquer](./DivideConquer.md)" instead. This is why merge sort and quick sort are not classified as dynamic programming problems.

![Fibonacci numbers](../../images/Fibonacchi-Recursion.png)

This can be achieved in either of two ways

- *Top-down approach*: This is the direct fall-out of the recursive formulation of any problem. If the solution to any problem can be formulated recursively using the solution to its sub-problems, and if its sub-problems are overlapping, then one can easily memoize or store the solutions to the sub-problems in a table.
- *Bottom-up approach*: Once we formulate the solution to a problem recursively as in terms of its sub-problems, we can try reformulating the problem in a bottom-up fashion: try solving the sub-problems first and use their solutions to build-on and arrive at solutions to bigger sub-problems.

So any problems, that can be solved by dynamic programming (bottom-up approach), can be also solved by recursion with memoization (top-down approach). However, recursive solution needs to take extra space to store recursion stack, which makes it less optimal.

**Dynamic programming** amounts to breaking down an optimization problem into simpler sub-problems, and storing the solution to each sub-problem so that each sub-problem is only solved once.

## Steps to Solve Dynamic Programming Problem

## References

- <https://en.wikipedia.org/wiki/Dynamic_programming>
- <https://www.geeksforgeeks.org/dynamic-programming/>
- <https://dev.to/nikolaotasevic/dynamic-programming--7-steps-to-solve-any-dp-interview-problem-3870>
- <https://www.freecodecamp.org/news/demystifying-dynamic-programming-3efafb8d4296/>
