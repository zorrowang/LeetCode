# Computational Complexity in Algorithms

When an algorithm is designed, there is always a question arising -

_Does this algorithm provide a satisfactory solution to a problem?_

- One measure of efficiency is the time used by a computer to solve a problem using the algorithm, when input values are of a specified size.

- Another measure is the amount of computer memory required to implement the algorithm when input values are of a specified size.

Questions such as these involve the computational complexity of the algorithm. An analysis of the time required to solve a problem of a particular size involves the time complexity of the algorithm. An analysis of the computer memory required involves the space complexity of the algorithm.

## Asymptotic Notations

_Asymptotic Notations_ are languages that allow us to analyze an algorithm’s running time by identifying its behavior as the input size for the algorithm increases. This is also known as an algorithm’s growth rate.

The following 3 asymptotic notations are mostly used to represent time complexity of algorithms:

### Big Oh (O)

Big Oh is often used to describe the worst-case of an algorithm by taking the highest order of a polynomial function and ignoring all the constants value since they aren’t too influential for sufficiently large input.

### Big Omega (Ω)

Big Omega is the opposite of Big Oh, if Big Oh was used to describe the upper bound (worst-case) of a asymptotic function, Big Omega is used to describe the lower bound of a asymptotic function. In analysis algorithm, this notation is usually used to describe the complexity of an algorithm in the best-case, which means the algorithm will not be better than its best-case.

### Big Theta (Θ)

When an algorithm has a complexity with lower bound = upper bound, say that an algorithm has a complexity O(n log n) and Ω(n log n), it’s actually has the complexity Θ(n log n), which means the running time of that algorithm always falls in n log n in the best-case and worst-case.

## Time Complexity

There are some common time complexities with simple definitions as following.

- _O(1)_ — Constant Time: Given an input of size n, it only takes a single step for the algorithm to accomplish the task.
- _O(log n)_ — Logarithmic time: given an input of size n, the number of steps it takes to accomplish the task are decreased by some factor with each step.
- _O(n)_ — Linear Time: Given an input of size n, the number of of steps required is directly related (1 to 1)
- _O(n²)_ — Quadratic Time: Given an input of size n, the number of steps it takes to accomplish a task is square of n.
- _O(C^n)_ — Exponential Time: Given an input of size n, the number of steps it takes to accomplish a task is a constant to the n power (pretty large number).

## Space Complexity

_Space complexity_ deals with finding out how much (extra)space would be required by the algorithm with change in the input size. For e.g. it considers criteria of a data structure used in algorithm as _Array_ or _linked list_.

## References

- <https://en.wikipedia.org/wiki/Time_complexity>
- <https://en.wikipedia.org/wiki/Space_complexity>
- <https://medium.com/free-code-camp/time-is-complex-but-priceless-f0abd015063c>
- <https://codeburst.io/algorithms-i-searching-and-sorting-algorithms-56497dbaef20>
