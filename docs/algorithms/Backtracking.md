# Backtracking

<!-- MarkdownTOC -->

- [Definition](#definition)
- [Properties](#properties)
- [Backtracking as Tree Search](#backtracking-as-tree-search)
  - [Permutation](#permutation)
    - [Implicit Tree](#implicit-tree)
    - [Backtracking Traversal](#backtracking-traversal)
    - [Time Complexity](#time-complexity)
  - [Combination](#combination)
    - [Implementation](#implementation)
- [Search Pruning](#search-pruning)
  - [Symmetry](#symmetry)
  - [Sudoku](#sudoku)
  - [Where is to Prune](#where-is-to-prune)
- [Applications](#applications)
- [References](#references)

<!-- /MarkdownTOC -->

## Definition

Backtracking is a general algorithm for finding all (or some) solutions to some computational problems, notably [constraint satisfaction problems](https://en.wikipedia.org/wiki/Constraint_satisfaction_problem), that _incrementally_ builds candidates to the solutions, and abandons a candidate ("_backtracks_") as soon as it determines that the candidate cannot possibly be completed to a valid solution.

## Properties

To generalize the characters of backtracking:

- **No Repetition**: It is a systematic generating method that avoids repetitions and missing any possible right solution. This property makes it ideal for solving combinatorial problems such as combination and permutation which requires us to enumerate all possible solutions.

- **Search Pruning**: Because the final solution is built incrementally, in the process of working with partial solutions, we can evaluate the partial solution and prune branches that would never lead to the acceptable complete solution: either it is invalid configuration, or it is worse than known possible complete solution.

## Backtracking as Tree Search

### Permutation

 Given a set of integers {1, 2, 3}, enumerate all possible permutations using all items from the set without repetition. A permutation describes an arrangement or ordering of items. It is trivial to figure out that we can have the following six permutations: [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], and [3, 2, 1].

![Backtracking Permutation](../images/backtracking-permute.png)

To construct the final solution, we can start from an empty ordering shown at the first level, [ ]. Then we try to add one item where we have three choices :1, 2, and 3. We get three partial solutions [1], [2], [3] at the second level. Next, for each of these partial solutions, we have two choices, for [1], we can either put 2 or 3 first. Similarly, for [2], we can do either 1 and 3, and so on. Given _n_ distinct items, the number of possible permutations are _n*(n-1)*…*1 = n!_.

#### Implicit Tree

In the tree structure of backtracking, each node represents a partial or final solution. For permutation problem, the internal node is a partial solution and all leaves are final solutions. One edge represents generating the next solution based on the current solution. As the vertices and edges are generated in fly, the steps reaching the end are implicitly defined as **tree** structure.

#### Backtracking Traversal

The implementation of the state transfer we can use either **BFS** or **DFS** on the implicit vertices. DFS is preferred because theoretically it took _O(log n!)_ space used by stack (as the longest path from the root to any leaf), while if use BFS, the number of vertices saved in the queue can be close to _n!_ (all internal nodes have to be stored).

We can generalize Permutation, Permutations refer to the permutation of n things taken kat a time without repetition, the math formula is A_{n}^{k} = n *(n-1)*(n-2)*…*k. In Fig.1, we can see from each level kshows all the solution of A_{n}^{k}. The generation of A_{n}^{k} is shown in the following Python Code:

```python
def A_n_k(a, n, k, depth, used, curr, ans):
  '''
  Implement permutation of k items out  of n items
  depth: start from 0, and represent the depth of the search
  used: track what items are  in the partial solution from the set of n
  curr: the current partial solution
  ans: collect all the valid solutions
  '''
  if depth == k: #end condition
    ans.append(curr[::]) # use deepcopy because curr is tracking all partial solution, it eventually become []
    return
  
  for i in range(n):
    if not used[i]:
      # generate the next solution from curr
      curr.append(a[i])
      used[i] = True
      print(curr)
      # move to the next solution
      A_n_k(a, n, k, depth+1, used, curr, ans)

      #backtrack to previous partial state
      curr.pop()
      print('backtrack: ', curr)
      used[i] = False
  return
```

#### Time Complexity

In the example of permutation, we can see that backtracking only visit each state once. The complexity of this is similar to the graph traversal of _O(|V|+|E|)_, where *|V| =sum_{i=0}^{n}{A_{n}^{k}}*, because it is a tree structure, |E| = |v|-1. This actually makes the permutation problem _NP-hard_.

### Combination

Given a set of distinct integers {1, 2, 3}, enumerate all possible subsets (the power set). A combination describes an arrangement of items without ordering. It is trivial to figure out that we can have the following six combinations: [1], [2], [3], [1, 2], [1, 3], and [3, 2, 1].

![Backtracking Combination](../images/backtracking-combination.png)

#### Implementation

The process is the similar to the implementation of permutation, except that we have one different variable, start. start is used to track the start index of the next candidate instead of use the used array to track the state of each item in the _curr_ solution. _curr.pop()_ is the soul for showing it is a backtracking algorithm!

```python
def C_n_k(a, n, k, start, depth, curr, ans):
  '''
  Implement combination of k items out  of n items
  start: the start of candidate
  depth: start from 0, and represent the depth of the search
  curr: the current partial solution
  ans: collect all the valid solutions
  '''
  if depth == k: #end condition
    ans.append(curr[::])
    return
  
  for i in range(start, n):
    # generate the next solution from curr
    curr.append(a[i])
    # move to the next solution
    C_n_k(a, n, k, i+1, depth+1, curr, ans)

    #backtrack to previous partial state
    curr.pop()
  return
```

## Search Pruning

For some problems, such as CSP, backtracking can be optimized with search pruning. As we are at level 2 with state *s=(s_0, s_1)*, and if we know that this state will never lead to a valid solution, we do not need to traverse through this branch but backtrack to previous state at level one. This will end up pruning half of all nodes in the search tree.

### Symmetry

Exploiting symmetry is another avenue for reducing combinatorial search, pruning away partial solutions identical to those previously considered requires recognizing underlying symmetries in the search space.

### Sudoku

Given a partially filled grid of size n*n, completely fill the grid with number between 1 and n. The constraint is defined as:

- Each row has all numbers form 1 to _n_
- Each column has all numbers form 1 to _n_
- Each sub-grid (_√(n)×√(n)_) has all numbers form 1 to _n_

![Backtracking Sudoku](../images/backtracking-sudoku-1.png) ![Backtracking Sudoku](../images/backtracking-sudoku.png)

Only all constraint are satisfied can we have a valid candidate. How many possible candidates here? Suppose we have an empty table, the brute force is to try 1 to n at each grid, we have possible solution space of nⁿ². How many of them are valid solutions? We can get closer by permuting numbers from 1 to 9 at each row, with 9!⁹ possible search space. This is already a lot better than the first. How to know the exact possible solutions? This site demonstrates that the actual N=6670903752021072936960 which is approximately 6.671×1⁰²¹ possible solutions. This shows that sudo problem is actually NP-hard problem.

```python
from copy import deepcopy
class Sudoku():
  def __init__(self, board):
    self.org_board = deepcopy(board)
    self.board = deepcopy(board)

  def init(self):
    self.A = set([i for i in range(1,10)])
    self.row_state = [set() for i in range(9)]
    self.col_state = [set() for i in range(9)]
    self.block_state = [[set() for i in range(3)] for i in range(3)]
    self.unfilled = []

    for i in range(9):
      for j in range(9):
          c = self.org_board[i][j]
          if c == 0:
              self.unfilled.append((i, j))
          else:
              self.row_state[i].add(c)
              self.col_state[j].add(c)
              self.block_state[i//3][j//3].add(c)
  
  def set_state(self, i, j, c):
    self.board[i][j] = c
    self.row_state[i].add(c)
    self.col_state[j].add(c)
    self.block_state[i//3][j//3].add(c)

  def reset_state(self, i, j, c):
    self.board[i][j] = 0
    self.row_state[i].remove(c)
    self.col_state[j].remove(c)
    self.block_state[i//3][j//3].remove(c)

  def _ret_len(self, args):
    i, j = args
    option = self.A - (self.row_state[i] | self.col_state[j] | self.block_state[i//3 ][j//3])
    return len(option)

  def solve(self):
    '''implement solver restricted spot selection and look ahead'''
    if len(self.unfilled) == 0:
      return True
    i, j = min(self.unfilled, key = self._ret_len)
    option = self.A - (self.row_state[i] | self.col_state[j] | self.block_state[i//3 ][j//3])
    #print(option)
    if len(option) == 0:
      return False
    self.unfilled.remove((i, j))
    for c in option:
      self.set_state(i, j, c)
      if self.solve():
        return True
      else:
        self.reset_state(i, j, c)
    # no candidate is valid, backtrack
    self.unfilled.append((i, j))
    return False
  
  def naive_solve(self):
    '''implement native solver without restricted spot selection or look ahead'''
    if len(self.unfilled) == 0:
      return True
    i, j = self.unfilled.pop()
    option = self.A - (self.row_state[i] | self.col_state[j] | self.block_state[i//3 ][j//3])
    for c in option:
      self.set_state(i, j, c)
      if self.naive_solve():
        return True
      else:
        self.reset_state(i, j, c)
    # no candidate is valid, backtrack
    self.unfilled.append((i, j))
    return False
```

### Where is to Prune

If there is only one path that can lead to the final valid answer, this means for other paths, the earlier we find out that it is invalid and backtrack the better. What techniques we have been used here? We could have visit the empty spots in arbitrary ordering instead of each time in our code to choose the spot that has least candidate.

## Applications

LeetCoe examples

- [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/)
- [Subsets](https://leetcode.com/problems/subsets/description/)

## References

- <https://en.wikipedia.org/wiki/Backtracking>
- <https://medium.com/algorithms-and-leetcode/backtracking-e001561b9f28>
- <https://medium.com/algorithms-and-leetcode/backtracking-with-leetcode-problems-part-2-705c9cc70e52>
- <https://medium.com/algorithms-and-leetcode/in-depth-backtracking-with-leetcode-problems-part-3-b225f19e0d51>
