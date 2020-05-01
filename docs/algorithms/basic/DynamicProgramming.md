# Dynamic Programming

<!-- MarkdownTOC -->

- [Introduction](#introduction)
  - [Top-down vs Bottom-up](#top-down-vs-bottom-up)
  - [Definition](#definition)
- [Steps to Solve Dynamic Programming Problem](#steps-to-solve-dynamic-programming-problem)
  - [Recognize a DP Problem](#recognize-a-dp-problem)
  - [Identify States with Least Variables](#identify-states-with-least-variables)
  - [Formulating State Transition](#formulating-state-transition)
  - [Adding Memoization or Tabulation](#adding-memoization-or-tabulation)
  - [Further Optimize](#further-optimize)
- [Classic Models of Dynamic Programming](#classic-models-of-dynamic-programming)
  - [Linear Model](#linear-model)
  - [Interval Model](#interval-model)
  - [Knapsack Model](#knapsack-model)
  - [State Compressing Model](#state-compressing-model)
  - [Tree Model](#tree-model)
- [Common Formula of State Transition](#common-formula-of-state-transition)
  - [1-Dimension](#1-dimension)
  - [2-Dimension](#2-dimension)
- [References](#references)

<!-- /MarkdownTOC -->

## Introduction

**Dynamic programming** is a computer programming method, that simplifies a complicated problem by breaking it down into simpler sub-problems in a recursive manner.

There are two key attributes that a problem must have in order for dynamic programming to be applicable

- **optimal substructure**: an optimal solution can be constructed from optimal solutions of its subproblems.
- **overlapping sub-problems**: the problem can be broken down into subproblems which are reused several times or a recursive algorithm for the problem solves the same subproblem over and over rather than always generating new subproblems

If a problem can be solved by combining optimal solutions to non-overlapping sub-problems, the strategy is called "[Divide and Conquer](./DivideConquer.md)" instead. This is why merge sort and quick sort are not classified as dynamic programming problems.

### Top-down vs Bottom-up

Let's use [Fibonacci number](https://en.wikipedia.org/wiki/Fibonacci_number) as an example. This can be resolved in either of two ways

![Fibonacci numbers](../../images/Fibonacchi-Recursion.png)

**Top-down approach** is the direct fall-out of the recursive formulation of any problem. If the solution to any problem can be formulated recursively using the solution to its sub-problems, and if its sub-problems are overlapping, then one can easily memoize or store the solutions to the sub-problems in a table. This approach is usually used to solve the problem with tree structure, which starts with the root node and finds all sub-problems in siblings.

```java
int fibonacci(int n, int[] f) {
    if(n == 0) {
        f[0] = 1;
        return f[0]
    }
    if(n == 1) {
        f[1] = 1;
        return f[1];
    }
    if(f[n] != 0) { // 0 means the state is not calculated yet
        return f[n];
    } else {
        f[n] = fibonacci(n-1, f) + fibonacci(n-2, f);
        return f[n];
    }
}
```

**Memoization** method is used to store the most recent state values, so that if next time calling from the same state, it can be simply returned from the memory.

- *Bottom-up approach*: Once we formulate the solution to a problem recursively as in terms of its sub-problems, we can try reformulating the problem in a bottom-up fashion: try solving the sub-problems first and use their solutions to build-on and arrive at solutions to bigger sub-problems.

```java
int fibonacci(int n) {
    if(n == 0) return 0;
    if(n == 1) return 1;
    int[] dp = new int[n+1];
    dp[0] = 0;
    dp[1] = 1;
    for(int i = 2; i <=n ; ++i) {
        dp[i] = dp[i-1]+dp[i-2];
    }
    return dp[n];
}
```

To solve this problem, as destination state _n_, we need to start with the base state as state _0_. **Tabulation** method focuses on filling the entries of the cache, until the target value has been reached.

![Top-down vs Bottom-up](../../images/Tabulation-vs-Memoization.png)

In general, tabulation usually outperforms memoization by a constant factor. This is because tabulation has no overhead for recursion.

### Definition

**Dynamic programming** amounts to breaking down an optimization problem into simpler sub-problems, and storing the solution to each sub-problem so that each sub-problem is only solved once.

## Steps to Solve Dynamic Programming Problem

Generally, I will go through the following steps to solve any DP problem

- Recognize a DP Problem
- Identify States with Least Variables
- Formulating State Transition
- Adding Memoization or Tabulation for States
- Further Optimize

### Recognize a DP Problem

DP is essentially an optimization technique. It solves problem by breaking it down into a collection of simpler subproblems, solving each of those subproblems just once, and storing their solutions. So any problems can be split to multiple steps and each step can be used more than once, they can be solved and optimized by DP solution.

- Typically, all the problems that require to maximize or minimize certain quantity or counting problems that say to count the arrangements under certain condition or certain probability problems can be solved by using Dynamic Programming.
- All dynamic programming problems satisfy the overlapping subproblems property and most of the classic dynamic problems also satisfy the optimal substructure property. Once, we observe these properties in a given problem, be sure that it can be solved using DP.

### Identify State with Least Variables

DP problems are all about **states** and their **transition**.

This is the most basic step which must be done very carefully because the state transition depends on the choice of state definition we make. So, let’s see what do we mean by the term “state”. **State** can be defined as the set of parameters that can uniquely identify a certain position or standing in the given problem. This set of parameters should be as small as possible to reduce state space.

For example: in the famous Knapsack problem, we define our state by two parameters index and weight i.e _DP[index][weight]_. Here _DP[index][weight]_ tells us the maximum profit it can make by taking items from range 0 to index having the capacity of sack to be weight. Therefore, here the parameters index and weight together can uniquely identify a subproblem for the knapsack problem.

### Formulating State Transition

The hardest part in DP is how to formulate the state transition and identify the base state. It requires a lot of intuition, observation and practice. Most of problems can be applied by certain model of dynamic programming. They will be introduced in [Classic Models of Dynamic Programming](#classic-models-of-dynamic-programming).

### Adding Memoization or Tabulation

Once the state transition is well formulated, adding storage (memoization or tabulation) is trivial. It just needs to be aligned with state definition.

### Further Optimize

A DP solution can be, sometimes, further optimized in term of space complexity.

## Classic Models of Dynamic Programming

### Linear Model

### Interval Model

### Knapsack Model

### State Compressing Model

### Tree Model

## Common Formula of State Transition

### 1-Dimension

### 2-Dimension

## References

- <https://en.wikipedia.org/wiki/Dynamic_programming>
- <https://www.geeksforgeeks.org/dynamic-programming/>
- <https://dev.to/nikolaotasevic/dynamic-programming--7-steps-to-solve-any-dp-interview-problem-3870>
- <https://www.freecodecamp.org/news/demystifying-dynamic-programming-3efafb8d4296/>
- <http://cppblog.com/menjitianya/archive/2015/10/23/212084.html>
