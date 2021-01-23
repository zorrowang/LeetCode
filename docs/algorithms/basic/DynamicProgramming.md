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
    - [0-1 Knapsack](#0-1-knapsack)
    - [Complete Knapsack](#complete-knapsack)
  - [State Compressing Model](#state-compressing-model)
  - [Tree Model](#tree-model)
- [Common State Transition Formula](#common-state-transition-formula)
- [Optimization for Dynamic Programming](#optimization-for-dynamic-programming)
  - [Rolling Array](#rolling-array)
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

Linear model is the most common one to solve DP problems. `Linear` here means the states are distributed as linear, and the tabulation is usually an array.

Take this problem, *People on a Rickety Bridge*, as an example.

*Question*: _N_ (_N_ <= 50) people need to cross a rickety bridge at night. Unfortunately, they have one torch and the bridge is to dangerous to cross without a torch. The bridge can support only two people at a time. All the people don’t take the same time to cross the bridge. Time for _i-th_ person is _T[i]_. What is the shortest time needed for all four of them to cross the bridge?

The initial solution most people will think of is to use the fastest person as an usher to guide everyone across (greedy algorithm). So the total time is

```shell
T = minPTime * (N-2) + (totalSum-minPTime)
```

Let's verify this by some real data. There are 4 people, time for each one is 1, 2, 5, 10. The time based on this formula is **19**. However, the correct answer is **17**. The process is

- 1 and 2 go cross     - 2 mins
- 2 comes back         - 2 mins
- 5 and 10 go across   - 10 mins
- 1 comes back         - 1 mins
- 1 and 2 go across    - 2 mins

So, the initial greedy solution cannot reach the optimal state.

Before solving this problem, we need to sort the time per person. The least time of first _i_ people go cross the bright is _opt[i]_. If _i-1_ people have crossed,

```shell
opt[i] = opt[i-1] + a[1] + a[i]
```

If less than _i-1_ people have crossed,

```shell
opt[i] = opt[i-2] + a[1] + a[i] + 2*a[2]
```

Finally

```shell
opt[i] = min{opt[i-1] + a[1] + a[i] , opt[i-2] + a[1] + a[i] + 2*a[2] }
```

### Interval Model

Interval model is commonly defined as _dp[i][j]_, which specifies the optimal solution between state _i_ and state _j_. The transition is based on _dp[i-1][j]_ and/or _dp[i][j-1]_. The final optimal will be _dp[1][len]_.

*Question*: Given a string A, which length _n_ is less than _1000_, find the min cost of converting it to be a palindrome by inserting letter each time.

*State*: _dp[i][j]_ is the min cost of converting the substring A[i...j]

*Base Case*: _dp[i][i]_ = 0, _dp[i][i+1]_ = 0 if A[i] = A[i+1]

*Transition*:

- If _A[i] = A[j]_, _dp[i][j]_ = _dp[i-1][j-1]_
- If _A[i] != A[j]_, _dp[i][j]_ = mim{_dp[i][j-1]_ (add A[j] before A[i]), _dp[i-1][j]_ (add A[i] after A[j])} + 1

### Knapsack Model

Knapsack problem is one of most famous problems in dynamic programming.

#### 0-1 Knapsack

*Question*: Given weights and values of _n_ items (every item has and only has one copy), put these items in a knapsack of capacity _W_ to get the maximum total value in the knapsack.

*State*: _f[i][v]_ specifies the max value putting _i-th_ item to the knapsack of capacity _v_

*Base Case*: _f[0][v]_ = 0, _f[i][0]_ = 0

*Transition*: _f[i][v] = max{ f[i-1][v], f[i-1][v - C[i]] + W[i] }_

#### Complete Knapsack

*Question*: Given weights and values of _n_ items (every item has infinite copies), put these items in a knapsack of capacity _W_ to get the maximum total value in the knapsack.

*State*: _f[i][v]_ specifies the max value putting _i-th_ item to the knapsack of capacity _v_

*Base Case*: _f[0][v]_ = 0, _f[i][0]_ = 0

*Transition*: _f[i][v] = max{ f[i-1][v], f[i-1][v - k * C[i]] + k * W[i] | | 0 <= k <= v/Ci }_

### State Compressing Model

State compressing model is used to handle the dynamic programming problem with small data set. It can optimize storage by converting states to binary.

It is usually too hard for a coding interview. I will add more details later.

### Tree Model

Tree model specifies the state as node in a tree and all transitions happen there.

## Common State Transition Formula

There are three major factors for dynamic programming

- the tabulation of all subproblems
- the dependencies between subproblems, which is essentially a graph
- the order of filling out tabulation (the topological order of graph)

The common state transition formula includes

- _d[i] = opt{ d[j] + w(j, i) | 0 <= i < j } (1 <= i <= n)_
- _d[i][j] = opt{ d[i-1][j] + xi, d[i][j-1] + yj, d[i-1][j-1] + zij }     (1<= i, j <= n)_
- _d[i][j] = w(i, j) + opt{ d[i][k-1] + d[k][j] }, (1 <= i < j <= n)_
- _d[i][j] = opt{ d[i'][j'] + w(i', j', i, j) |  0 <= i' < i, 0 <= j' < j}_

## Optimization for Dynamic Programming

### Rolling Array

Take the example as the palindrome problem in [Interval Model](#interval-model) again.

The transition is defined as

- If _A[i] = A[j]_, _dp[i][j]_ = _dp[i-1][j-1]_
- If _A[i] != A[j]_, _dp[i][j]_ = mim{_dp[i][j-1]_ (add A[j] before A[i]), _dp[i-1][j]_ (add A[i] after A[j])} + 1

_dp[i][j]_ is a 2D matrix, and the result at _i-th_ row is only based _(i-1)-th_ and _(i+1)-th_ rows. So we only need a matrix as _dp[2][N]_ to store all states. As the result, the space complexity is optimized from O(n^2) to O(n).

## References

- <https://en.wikipedia.org/wiki/Dynamic_programming>
- <https://en.wikipedia.org/wiki/Knapsack_problem#0-1_knapsack_problem>
- <https://www.geeksforgeeks.org/dynamic-programming/>
- <https://dev.to/nikolaotasevic/dynamic-programming--7-steps-to-solve-any-dp-interview-problem-3870>
- <https://www.freecodecamp.org/news/demystifying-dynamic-programming-3efafb8d4296/>
- <http://cppblog.com/menjitianya/archive/2015/10/23/212084.html>
