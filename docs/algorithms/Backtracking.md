# Backtracking

## Definition

Backtracking is a general algorithm for finding all (or some) solutions to some computational problems, notably constraint satisfaction problems, that incrementally builds candidates to the solutions, and abandons a candidate ("backtracks") as soon as it determines that the candidate cannot possibly be completed to a valid solution.

## Properties

To generalize the characters of backtracking:

- **No Repetition and Completion**: It is a systematic generating method that avoids repetitions and missing any possible right solution. This property makes it ideal for solving combinatorial problems such as combination and permutation which requires us to enumerate all possible solutions.

- **Search Pruning**: Because the final solution is built incrementally, in the process of working with partial solutions, we can evaluate the partial solution and prune branches that would never lead to the acceptable complete solution: either it is invalid configuration, or it is worse than known possible complete solution.

### Backtracking as Tree Search

![Backtracking](../images/backtracking-permute.png)

## Applications

## References

- <https://en.wikipedia.org/wiki/Backtracking>
- <https://medium.com/algorithms-and-leetcode/backtracking-e001561b9f28>
- <https://medium.com/algorithms-and-leetcode/backtracking-with-leetcode-problems-part-2-705c9cc70e52>
- <https://medium.com/algorithms-and-leetcode/in-depth-backtracking-with-leetcode-problems-part-3-b225f19e0d51>
