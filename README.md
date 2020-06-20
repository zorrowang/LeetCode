# Software Engineer Interview

Author: zorrowanghw@gmail.com

## Table of Contents

<!-- MarkdownTOC -->

- [Interview Preparation](#interview-preparation)
- [Languages and Data Structures](#languages-and-data-structures)
  - [Java](#java)
    - [Java Overview and Features](#java-overview-and-features)
    - [Data Structures in Java](#data-structures-in-java)
  - [Python](#python)
    - [Python Overview and Features](#python-overview-and-features)
    - [Data Structures in Python](#data-structures-in-python)
  - [Go](#go)
    - [Go Overview and Features](#go-overview-and-features)
    - [Data Structures in Go](#data-structures-in-go)
- [Algorithms](#algorithms)
  - [Computational Complexity](#computational-complexity)
  - [Basic Algorithms](#basic-algorithms)
    - [Backtracking](./docs/algorithms/basic/Backtracking.md)
    - [Divide and Conquer](./docs/algorithms/basic/Divide-Conquer.md)
    - [Dynamic Programming](./docs/algorithms/basic/DynamicProgramming.md)
    - [Greedy](./docs/algorithms/basic/Greedy.md)
    - [Enumeration](./docs/algorithms/basic/Enumeration.md)
  - [Sort Algorithms](#sort-algorithms)
    - [O(n^2) Solutions](#on2-solutions)
    - [O(nlogn) Solutions](#onlogn-solutions)
    - [O(n) Solutions](#on-solutions)
  - [Search Algorithms](#search-algorithms)
    - [Graph Search](#graph-search)
    - [Linear List Search](#linear-list-search)
    - [Search Tree](#search-tree)
  - [Other Algorithms](#other-algorithms)
  - [More Readings](#more-readings)
- [System Design](#system-design)
- [Coding Preparation](#coding-preparation)
  - [LeetCode Current Status](#leetcode-current-status)
  - [LintCode Current Status](#lintcode-current-status)
  - [Easy Questions](#easy-questions)
  - [Medium Questions](#medium-questions)
  - [Hard Questions](#hard-questions)

<!-- /MarkdownTOC -->

## Interview Preparation

The hiring workflow for software engineer role is

- resume screening
- recruiter call
- technical phone screening
- onsite interview
- hiring committee debrief
- decision call

In general, the more we prepare, the better result we could get.

- [Mindset for Interview](./docs/tech-interview/Mindset.md)
- [Self-Introduction](./docs/tech-interview/SelfIntroduction.md)
- [Phone Screening](./docs/tech-interview/PhoneScreen.md)
- [Whiteboard Coding Workflow and Best Practice](./docs/tech-interview/WhiteboardCoding.md)

## Languages and Data Structures

### Java

Java is a general-purpose programming language that is class-based, object-oriented, and designed to have as few implementation dependencies as possible. It is intended to let application developers write once, run anywhere, meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.

#### Java Overview and Features

- [Java Introduction](./docs/Languages/Java/Java.md)
- [Java Virtual Machine (JVM)](./docs/Languages/Java/JVM.md)
- [Garbage Collection](./docs/Languages/Java/GC.md)
- Generics in Java
- Concurrency in Java
- I/O in Java
- [Lambda in Java](./docs/Languages/Java/Lambda.md)

#### Data Structures in Java

- [Array](./docs/Languages/Java/data-structure/Array.md)
- [String](./docs/Languages/Java/data-structure/String.md)
- [Collection](./docs/Languages/Java/data-structure/Collection.md)
  - [Set](./docs/Languages/Java/data-structure/Set.md)
    - [Union Find (Disjoint Set)](./docs/Languages/Java/data-structure/Set.md#union-find-disjoint-set)
  - [List](./docs/Languages/Java/data-structure/List.md)
    - [ArrayList](./docs/Languages/Java/data-structure/List.md#arraylist-class)
    - [LinkedList](./docs/Languages/Java/data-structure/LinkedList.md)
  - [Stack](./docs/Languages/Java/data-structure/Stack.md)
  - [Queue](./docs/Languages/Java/data-structure/Queue.md)
    - [PriorityQueue](./docs/Languages/Java/data-structure/Queue.md#priorityqueue-class)
    - [Deque](./docs/Languages/Java/data-structure/Queue.md#deque-interface)
  - [Map](./docs/Languages/Java/data-structure/Map.md)
    - [HashMap](./docs/Languages/Java/data-structure/Map.md#hashmap-class)
    - [HashTable](./docs/Languages/Java/data-structure/Map.md#hashtable-class)
    - [TreeMap](./docs/Languages/Java/data-structure/Map.md#treemap-class)
- [Tree](./docs/Languages/Java/data-structure/Tree.md)
  - [Binary Search Tree](./docs/Languages/Java/data-structure/Tree.md#binary-search-tree)
  - [Segment Tree](./docs/Languages/Java/data-structure/Tree.md#segment-tree)
  - [Trie](./docs/Languages/Java/data-structure/Tree.md#trie-prefix-tree)
- [Graph](./docs/Languages/Java/data-structure/Graph.md)
  - [Breadth-First Search](./docs/Languages/Java/data-structure/Graph.md#bfs)
  - [Depth-First Search](./docs/Languages/Java/data-structure/Graph.md#dfs)
  - [Topological Sort](./docs/Languages/Java/data-structure/Graph.md#topological-sort)
  - [Shortest Path](./docs/Languages/Java/data-structure/Graph.md#shortest-path)
  
### Python

Python is an interpreted, high-level, general-purpose programming language. Python's design philosophy emphasizes code readability with its notable use of significant whitespace (indentation). Python is dynamically typed and garbage-collected.

#### Python Overview and Features

#### Data Structures in Python

- Array and Sequence
  - Range
  - String
  - List
  - Tuple
- Linked List
  - Singly Linked List
  - Doubly Linked List
- Stack And Queue
  - Deque
- Priority Queue
- Hash Table
- Tree
- Graph

### Go

Go is a statically typed, compiled programming language designed at Google. Go is syntactically similar to C, but with memory safety, garbage collection, structural typing, and CSP-style concurrency.

#### Go Overview and Features

#### Data Structures in Go

- Basic Data Structures
  - Array
  - Slice
  - Map
  - Struct
- Linked List
- Queue
- Stack
- Set
- Tree
- Graph

## Algorithms

Algorithm is one of core parts in computer science. This section covers the algorithms in tech interviews.

An algorithm must possess the following five properties:

- **input**: an algorithm has zero or more inputs, taken from a specified set of objects.
- **output**: an algorithm has one or more outputs, which have a specified relation to the inputs.
- **finiteness**: the algorithm must always terminate after a finite number of steps.
- **definiteness**: Each step must be precisely defined; the actions to be carried out must be rigorously and unambiguously specified for each case.
- **effectiveness**: all operations to be performed must be sufficiently basic that they can be done exactly and in finite length.

As the restriction of whiteboard coding and the properties of algorithm, most of interview questions can be resolved in ~50 lines of code.

### Computational Complexity

- [Time Complexity](./docs/algorithms/Complexity.md#time-complexity)
- [Space Complexity](./docs/algorithms/Complexity.md#space-complexity)

### Basic Algorithms

- [Backtracking](./docs/algorithms/basic/Backtracking.md)
- [Divide and Conquer](./docs/algorithms/basic/DivideConquer.md)
- [Dynamic Programming](./docs/algorithms/basic/DynamicProgramming.md)
- [Greedy](./docs/algorithms/basic/Greedy.md)
- [Enumeration](./docs/algorithms/basic/Enumeration.md)

### Sort Algorithms

#### O(n^2) Solutions

- [Bubble Sort](./docs/algorithms/sort/Sort-n-square.md#bubble-sort)
- [Insertion Sort](./docs/algorithms/sort/Sort-n-square.md#insert-sort)
- [Selection Sort](./docs/algorithms/sort/Sort-n-square.md#selection-sort)
- [Shell Sort](./docs/algorithms/sort/Sort-n-square.md#shell-sort)

#### O(nlogn) Solutions

- [Quick Sort](./docs/algorithms/sort/Sort-nlogn.md#quick-sort)
- [Merge Sort](./docs/algorithms/sort/Sort-nlogn.md#merge-sort)
- [Heap Sort](./docs/algorithms/sort/Sort-nlogn.md#heap-sort)
- [Tree Sort](./docs/algorithms/sort/Sort-nlogn.md#tree-sort)

#### O(n) Solutions

- [Bucket Sort](./docs/algorithms/sort/Sort-n.md#bucket-sort)
- [Counting Sort](./docs/algorithms/sort/Sort-n.md#counting-sort)
- [Radix Sort](./docs/algorithms/sort/Sort-n.md#radix-sort)

### Search Algorithms

#### Graph Search

- [Depth-First Search](./docs/Languages/Java/data-structure/Graph.md#dfs)
- [Breadth-First Search](./docs/Languages/Java/data-structure/Graph.md#bfs)
- A-Star(A*) Search

#### Linear List Search

- Linear Search
  - Knuth–Morris–Pratt (KMP) Algorithm
- Binary Search

#### Search Tree

- Binary Search Tree
- B-tree
- (a,b)-tree

### Other Algorithms

It is very rare to see bit or math questions in real interviews. So we don't need to spend lots of time here.

- [Bit Manipulation](./docs/algorithms/BitManipulation.md)
- [Math](./docs/algorithms/Math.md)

### More Readings

- [Introduction to Algorithms](https://mitpress.mit.edu/books/introduction-algorithms-third-edition)
- [MIT 6.006 Introduction to Algorithms](https://www.youtube.com/playlist?list=PLUl4u3cNGP61Oq3tWYp6V_F-5jb5L2iHb)

## System Design

- System Design Foundation
- Distributed System
- Cluster
- Message Queue
- Database
  - SQL
  - NoSQL
  - Cache
- Networking
  - Networking Foundation
  - HTTP
  - RESTful API
  - Socket

## Coding Preparation

[How to use LeetCode](./docs/Leetcode.md)

### LeetCode Current Status

- **Total**:  414/1485
  - &#x1F4D7;[Easy](#easy-questions):   152
  - &#x1F4D8;[Medium](#medium-questions): 210
  - &#x1F4D9;[Hard](#hard-questions):   52

### LintCode Current Status

- **Total**:  44
  - &#x1F4D7;[Easy](#easy-questions):   11
  - &#x1F4D8;[Medium](#medium-questions): 29
  - &#x1F4D9;[Hard](#hard-questions):   4

### Notes

- I use LintCode as the supplement of LeetCode for the locked questions.
- I usually skip the `hard` math questions, since it is almost impossible to see them in a real interview.

### Easy Questions

| # | Name | Solution | Algorithm | Note |
|:-:|:----:|:--------:|:---------:|:----:|
|1|[Two Sum](https://leetcode.com/problems/two-sum/)|[Java](./src/java/easy/array/TwoSum.java) [Python](./src/python/array/2sum.py)| HashMap |
|7|[Reverse Integer](https://leetcode.com/problems/reverse-integer/)|[Java](./src/java/easy/number/ReverseInteger.java)| Number |
|9|[Palindrome Number](https://leetcode.com/problems/palindrome-number/)|[Java](./src/java/easy/number/PalindromeNumber.java)| Number |
|13|[Roman to Integer](https://leetcode.com/problems/roman-to-integer/)|[Java](./src/java/easy/string/RomanToInteger.java)| Map |
|14|[Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)|[Java](./src/java/easy/array/LongestCommonPrefix.java)| Loop | More [solutions](https://leetcode.com/problems/longest-common-prefix/solution/)|
|20|[Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)|[Java](./src/java/easy/string/ValidParentheses.java) [Python](./src/python/string/valid_parentheses.py)| Stack |
|21|[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)|[Java](./src/java/easy/linkedlist/MergeTwoSortedLists.java)| Loop |
|26|[Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)|[Java](./src/java/easy/array/RemoveDuplicatesSortedArray.java)| Two-Pointer |
|27|[Remove Element](https://leetcode.com/problems/remove-element/)|[Java](./src/java/easy/array/RemoveElement.java)| Single Pointer |
|28|[Implement strStr()](https://leetcode.com/problems/implement-strstr/)|[Java](./src/java/easy/string/StrStr.java)| String |
|35|[Search Insert Position](https://leetcode.com/problems/search-insert-position/)|[Java](./src/java/easy/array/SearchInsertPosition.java)| String |
|38|[Count and Say](https://leetcode.com/problems/count-and-say/)|[Java](./src/java/easy/math/CountPrimes.java)| Number |
|53|[Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)|[Java](./src/java/easy/dp/MaximumSubarray.java)| DP |
|58|[Length of Last Word](https://leetcode.com/problems/length-of-last-word/)|[Java](./src/java/easy/string/LengthLastWord.java)| String |
|66|[Plus One](https://leetcode.com/problems/plus-one/)|[Java](./src/java/easy/array/PlusOne.java)| Loop |
|67|[Add Binary](https://leetcode.com/problems/add-binary/)|[Java](./src/java/easy/string/AddBinary.java)| Loop |
|69|[Sqrt(x)](https://leetcode.com/problems/sqrtx/)|[Java](./src/java/easy/math/Sqrt.java)| Math | Apply [Newton's Method](https://pages.mtu.edu/~shene/COURSES/cs201/NOTES/chap06/sqrt-1.html) |
|70|[Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)|[Java](./src/java/easy/dp/ClimbingStairs.java)| 1D DP |
|83|[Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)|[Java](./src/java/easy/linkedlist/RemoveDuplicatesSortedList.java)| Two-Pointer |
|88|[Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)|[Java](./src/java/easy/array/MergeSortedArray.java)| Two-Pointer |
|100|[Same Tree](https://leetcode.com/problems/same-tree/)|[Java](./src/java/easy/tree/SameTree.java)| Recursion |
|101|[Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)|[Java](./src/java/easy/tree/SymmetricTree.java)| Recursion |
|104|[Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)|[Java](./src/java/easy/tree/MaximumDepthBinaryTree.java)| DFS |
|107|[Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)|[Java](./src/java/easy/tree/BinaryTreeLevelOrderTraversalII.java)| DFS + BFS |
|108|[Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)|[Java](./src/java/easy/tree/ConvertSortedArrayBST.java)| Recursion |
|110|[Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)|[Java](./src/java/easy/tree/BalancedBinaryTree.java)| DFS |
|111|[Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)|[Java](./src/java/easy/tree/MinimumDepthBinaryTree.java)| DFS |
|112|[Path Sum](https://leetcode.com/problems/path-sum/)|[Java](./src/java/easy/tree/PathSum.java)| DFS |
|118|[Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)|[Java](./src/java/easy/math/PascalTriangle.java)| Array |
|119|[Pascal's Triangle II](https://leetcode.com/problems/pascals-triangle-ii/)|[Java](./src/java/easy/math/PascalTriangleII.java)| 1D DP |
|121|[Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)|[Java](./src/java/easy/array/BestTimeBuySellStock.java)| DP |
|122|[Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)|[Java](./src/java/easy/array/BestTimeBuySellStockII.java)| Greedy |
|125|[Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)|[Java](./src/java/easy/string/ValidPalindrome.java)| Two-Pointer |
|136|[Single Number](https://leetcode.com/problems/single-number/)|[Java](./src/java/easy/bit/SingleNumber.java)| Bit |
|141|[Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)|[Java](./src/java/easy/linkedlist/LinkedListCycle.java)| LinkedList |
|155|[Min Stack](https://leetcode.com/problems/min-stack/)|[Java](./src/java/easy/stack/MinStack.java)| Stack |
|157|[Read N Characters Given Read4](https://leetcode.com/problems/read-n-characters-given-read4)|[Java](./src/java/easy/stream/ReadNCharactersGivenRead4.java)| Stream |
|160|[Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)|[Java](./src/java/easy/linkedlist/IntersectionTwoLinkedLists.java)| LinkedList |
|167|[Two Sum II - Input array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)|[Java](./src/java/easy/array/TwoSumII.java)| Two-Pointer |
|168|[Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title/)|[Java](./src/java/easy/number/ExcelSheetColumnTitle.java)| Math |
|169|[Majority Element](https://leetcode.com/problems/majority-element/)|[Java](./src/java/easy/array/MajorityElement.java)| Array | [Moore's voting algorithm](https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm) |
|170|[Two Sum III - Data structure design](https://leetcode.com/problems/two-sum-iii-data-structure-design/)|[Java](./src/java/easy/array/TwoSumIII.java)| HashMap |
|171|[Excel Sheet Column Number](https://leetcode.com/problems/excel-sheet-column-number/)|[Java](./src/java/easy/number/ExcelSheetColumnNumber.java)| Math |
|172|[Factorial Trailing Zeroes](https://leetcode.com/problems/factorial-trailing-zeroes/)|[Java](./src/java/easy/math/FactorialTrailingZeroes.java)| Math |
|189|[Rotate Array](https://leetcode.com/problems/rotate-array/)|[Java](./src/java/easy/array/RotateArray.java)| Array |
|190|[Reverse Bits](https://leetcode.com/problems/reverse-bits/)|[Java](./src/java/easy/bit/ReverseBits.java)| Bit |
|191|[Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits)|[Java](./src/java/easy/bit/NumberOneBits.java)| Bit |
|198|[House Robber](https://leetcode.com/problems/house-robber/)|[Java](./src/java/easy/dp/HouseRobber.java)| 1D DP |
|202|[Happy Number](https://leetcode.com/problems/happy-number/)|[Java](./src/java/easy/number/HappyNumber.java)| Set |
|203|[Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/)|[Java](./src/java/easy/linkedlist/RemoveLinkedListElements.java)| LinkedList |
|204|[Count Primes](https://leetcode.com/problems/count-primes/)|[Java](./src/java/easy/math/CountPrimes.java)| Math | [Sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes) |
|205|[Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/)|[Java](./src/java/easy/string/IsomorphicStrings.java)| Map |
|206|[Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)|[Java](./src/java/easy/linkedlist/ReverseLinkedList.java)| LinkedList |
|217|[Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)|[Java](./src/java/easy/array/ContainsDuplicate.java)| Set |
|219|[Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/)|[Java](./src/java/easy/array/ContainsDuplicateII.java)| Two-Pointer |
|225|[Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)|[Java](./src/java/easy/stack/ImplementStackUsingQueues.java)| Queue |
|226|[Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)|[Java](./src/java/easy/tree/InvertBinaryTree.java)| DFS |
|231|[Power of Two](https://leetcode.com/problems/power-of-two/)|[Java](./src/java/easy/number/PowerOfTwo.java)| Bit Manipulation |
|234|[Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | [Java](./src/java/easy/linkedlist/PalindromeLinkedList.java)| Two-Pointer | [Reversing a list is not considered "O(1) space"](https://leetcode.com/problems/palindrome-linked-list/discuss/64493/Reversing-a-list-is-not-considered-%22O(1)-space%22) |
|235|[Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)|[Java](./src/java/easy/tree/LowestCommonAncestorBST.java)| DFS |
|237|[Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/)|[Java](./src/java/easy/linkedlist/DeleteNode.java)| LinkedList | This is a stupid question |
|242|[Valid Anagram](https://leetcode.com/problems/valid-anagram/)|[Java](./src/java/easy/string/ValidAnagram.java)| Counting Sort |
|243|[Shortest Word Distance](https://leetcode.com/problems/shortest-word-distance)|[Java](./src/java/easy/array/ShortestWordDistance.java)| Greedy | LintCode [924](https://www.lintcode.com/problem/shortest-word-distance/description) |
|246|[Strobogrammatic Number](https://leetcode.com/problems/strobogrammatic-number)|[Java](./src/java/easy/string/StrobogrammaticNumber.java)| Two-Pointer | LintCode [644](https://www.lintcode.com/problem/strobogrammatic-number/description) |
|252|[Meeting Rooms](https://leetcode.com/problems/meeting-rooms)|[Java](./src/java/easy/list/MeetingRooms.java)| Sort | LintCode [920](https://www.lintcode.com/problem/meeting-rooms/description) |
|256|[Paint House](https://leetcode.com/problems/paint-house)|[Java](./src/java/easy/dp/PaintHouse.java)| 1D DP | LintCode [515](https://www.lintcode.com/problem/paint-house/description) as `medium` |
|257|[Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/)|[Java](./src/java/easy/tree/BinaryTreePaths.java)| DFS |
|258|[Add Digits](https://leetcode.com/problems/add-digits/)|[Java](./src/java/easy/number/AddDigits.java)| Number |
|263|[Ugly Number](https://leetcode.com/problems/ugly-number/)|[Java](./src/java/easy/number/UglyNumber.java)| Math |
|266|[Palindrome Permutation](https://leetcode.com/problems/palindrome-permutation)|[Java](./src/java/easy/string/PalindromePermutation.java)| Counting | LintCode [916](https://www.lintcode.com/problem/palindrome-permutation/description) |
|268|[Missing Number](https://leetcode.com/problems/missing-number/)|[Java](./src/java/easy/array/MissingNumber.java)| Counting | Bit manipulation solution using XOR is [here](https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination) |
|270|[Closest Binary Search Tree Value](https://leetcode.com/problems/closest-binary-search-tree-value)|[Java](./src/java/easy/tree/ClosestBinarySearchTreeValue.java)| DFS | LintCode [900](https://www.lintcode.com/problem/closest-binary-search-tree-value/description) |
|276|[Paint Fence](https://leetcode.com/problems/paint-fence)|[Java](./src/java/easy/dp/PaintFence.java)| 1D DP | LintCode [514](https://www.lintcode.com/problem/paint-fence/description) |
|278|[First Bad Version](https://leetcode.com/problems/first-bad-version/)|[Java](./src/java/easy/array/FirstBadVersion.java)| Binary Search |
|283|[Move Zeroes](https://leetcode.com/problems/move-zeroes/)|[Java](./src/java/easy/array/MoveZeroes.java)| Two-Pointer |
|290|[Word Pattern](https://leetcode.com/problems/word-pattern/)|[Java](./src/java/easy/string/WordPattern.java)| HashMap |
|292|[Nim Game](https://leetcode.com/problems/nim-game/)|[Java](./src/java/easy/number/NimGame.java)| Minimax |
|293|[Flip Game](https://leetcode.com/problems/flip-game)|[Java](./src/java/easy/string/FlipGame.java)| Loop | LintCode [914](https://www.lintcode.com/problem/flip-game/description) |
|299|[Bulls and Cows](https://leetcode.com/problems/bulls-and-cows/)|[Java](./src/java/easy/string/BullsCows.java)| Counting |
|303|[Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/)|[Java](./src/java/easy/array/RangeSumQuery.java)| Segment Tree |
|326|[Power of Three](https://leetcode.com/problems/power-of-three/)|[Java](./src/java/easy/math/PowerOfThree.java)| Math |
|337|[House Robber III](https://leetcode.com/problems/house-robber-iii/)|[Java](./src/java/medium/backtracking/HouseRobberIII.java)| Backtracking (DFS) |
|344|[Reverse String](https://leetcode.com/problems/reverse-string/)|[Java](./src/java/easy/array/ReverseString.java)| Two Pointer |
|346|[Moving Average from Data Stream](https://leetcode.com/problems/moving-average-from-data-stream)|[Java](./src/java/easy/stream/MovingAverage.java)| Sliding Window | LintCode [642](https://www.lintcode.com/problem/moving-average-from-data-stream/description) |
|367|[Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)|[Java](./src/java/easy/math/ValidPerfectSquare.java)| Math |
|374|[Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/)|[Java](./src/java/easy/number/GuessNumber.java)| Binary Search |
|383|[Ransom Note](https://leetcode.com/problems/ransom-note/)|[Java](./src/java/easy/string/RansomNote.java)| Letter Count |
|401|[Binary Watch](https://leetcode.com/problems/binary-watch/)|[Java](./src/java/easy/bit/BinaryWatch.java)| bit |
|408|[Valid Word Abbreviation](https://leetcode.com/problems/valid-word-abbreviation)|[Java](./src/java/easy/string/ValidWordAbbreviation.java)| String | LintCode [637](https://www.lintcode.com/problem/valid-word-abbreviation/description) |
|409|[Longest Palindrome](https://leetcode.com/problems/longest-palindrome/)|[Java](./src/java/easy/string/LongestPalindrome.java)| String |
|419|[Battleships in a Board](https://leetcode.com/problems/battleships-in-a-board/)|[Java](./src/java/medium/matrix/BattleshipsBoard.java)| Greedy | Should be as `easy` |
|422|[Valid Word Square](https://leetcode.com/problems/valid-word-square)|[Java](src/java/easy/string/ValidWordSquare.java)| String | LintCode [888](https://www.lintcode.com/problem/valid-word-square/description) |
|437|[Path Sum III](https://leetcode.com/problems/path-sum-iii/)|[Java](./src/java/easy/tree/PathSumIII.java)| DFS | Deserve as `medium`|
|443|[String Compression](https://leetcode.com/problems/string-compression/)|[Java](./src/java/easy/array/StringCompression.java)| Two-Pointer |
|485|[Max Consecutive Ones](https://leetcode.com/problems/max-consecutive-ones/)|[Java](./src/java/easy/dp/MaxConsecutiveOnes.java)| 1D DP |
|530|[Minimum Absolute Difference in BST](https://leetcode.com/problems/minimum-absolute-difference-in-bst/)|[Java](./src/java/easy/tree/MinimumAbsoluteDifference.java)| In-order Traversal |
|541|[Reverse String II](https://leetcode.com/problems/reverse-string-ii/)|[Java](./src/java/easy/string/ReverseStringII.java)| Two Pointer |
|551|[Student Attendance Record I](https://leetcode.com/problems/student-attendance-record-i/)|[Java](./src/java/easy/array/StudentAttendanceRecord.java)| Array |
|557|[Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/)|[Java](./src/java/easy/string/ReverseWordInStringIII.java)| Two Pointer |
|561|[Array Partition I](https://leetcode.com/problems/array-partition-i/)|[Java](./src/java/easy/array/ArrayPartitionI.java)| Math |
|572|[Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/)|[Java](./src/java/easy/tree/SubtreeOfAnotherTree.java)| Recursion | [Converting to string](https://leetcode.com/problems/subtree-of-another-tree/solution/) is a brilliant idea |
|575|[Distribute Candies](https://leetcode.com/problems/distribute-candies/)|[Java](./src/java/easy/array/DistributeCandies.java)| Greedy |
|594|[Longest Harmonious Subsequence](https://leetcode.com/problems/longest-harmonious-subsequence/)|[Java](./src/java/easy/array/LongestHarmoniousSubsequence.java)| HashMap |
|628|[Maximum Product of Three Numbers](https://leetcode.com/problems/maximum-product-of-three-numbers/)|[Java](./src/java/easy/array/MaximumProductThreeNumbers.java)| Greedy? |
|680|[Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/)|[Java](./src/java/easy/string/ValidPalindromeII.java)| String |
|700|[Search in a Binary Search Tree](https://leetcode.com/problems/search-in-a-binary-search-tree/)|[Java](./src/java/easy/tree/SearchBinarySearchTree.java)| BinarySearch |
|703|[Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)|[Java](./src/java/easy/array/KthLargestElementInStream.java)| MinQueue |
|704|[Binary Search](https://leetcode.com/problems/binary-search/)|[Java](./src/java/easy/array/BinarySearch.java)| BinarySearch |
|709|[To Lower Case](https://leetcode.com/problems/to-lower-case/)|[Java](./src/java/easy/string/ToLowerCase.java)| String |
|720|[Longest Word in Dictionary](https://leetcode.com/problems/longest-word-in-dictionary/)|[Java](./src/java/easy/string/LongestWordDictionary.java)| HashSet |
|724|[Find Pivot Index](https://leetcode.com/problems/find-pivot-index/)|[Java](./src/java/easy/array/FindPivotIndex.java)| Prefix/Suffix Sum |
|728|[Self Dividing Numbers](https://leetcode.com/problems/self-dividing-numbers/)|[Java](./src/java/easy/number/SelfDividingNumbers.java)| Math |
|733|[Flood Fill](https://leetcode.com/problems/flood-fill/)|[Java](./src/java/easy/matrix/FloodFill.java)| DFS |
|748|[Shortest Completing Word](https://leetcode.com/problems/shortest-completing-word/)|[Java](./src/java/easy/string/ShortestCompletingWord.java)| String |
|746|[Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)|[Java](./src/java/easy/array/MinCostClimbingStairs.java)| 1D DP |
|766|[Toeplitz Matrix](https://leetcode.com/problems/matrix-block-sum/)|[Java](./src/java/easy/matrix/ToeplitzMatrix.java)| Matrix |
|771|[Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)|[Java](./src/java/easy/string/JewelsStones.java)| Set |
|783|[Minimum Distance Between BST Nodes](https://leetcode.com/problems/minimum-distance-between-bst-nodes/)|[Java](./src/java/easy/tree/MinimumDistanceBSTNodes.java)| DFS |
|788|[Rotated Digits](https://leetcode.com/problems/rotated-digits/)|[Java](./src/java/easy/dp/RotatedDigits.java)| DP | There is O(lgn) [solution](https://leetcode.com/problems/rotated-digits/discuss/264282/Java-O(logN)-0ms-100), but very tricky! |
|796|[Rotate String](https://leetcode.com/problems/rotate-string/)|[Java](./src/java/easy/string/RotateString.java)| String | The [rolling hash](https://leetcode.com/problems/rotate-string/solution/) solution is great! |
|821|[Shortest Distance to a Character](https://leetcode.com/problems/shortest-distance-to-a-character/)|[Java](./src/java/easy/array/ShortestDistanceCharacter.java)| MinArray |
|852|[Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/)|[Java](./src/java/easy/array/PeakIndexInMountainArray.java)| BinarySearch |
|844|[Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/)|[Java](./src/java/easy/string/BackspaceStringCompare.java)| Stack | Two pointers starting from the end is better in term of space performance |
|849|[Maximize Distance to Closest Person](https://leetcode.com/problems/maximize-distance-to-closest-person/)|[Java](./src/java/easy/dp/MaximizeDistanceClosestPerson.java)| DP |
|859|[Buddy Strings](https://leetcode.com/problems/buddy-strings/)|[Java](./src/java/easy/string/BuddyStrings.java)| StringLoop/LetterCount |
|860|[Lemonade Change](https://leetcode.com/problems/lemonade-change/)|[Java](./src/java/easy/array/LemonadeChange.java)| Greedy |
|867|[Transpose Matrix](https://leetcode.com/problems/transpose-matrix/)|[Java](./src/java/easy/matrix/TransposeMatrix.java)| Loop |
|872|[Leaf-Similar Trees](https://leetcode.com/problems/leaf-similar-trees/)|[Java](./src/java/easy/tree/LeafSimilarTrees.java)| DFS |
|876|[Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)|[Java](./src/java/easy/linked-list/MiddleLinkedList.java)| LinkedList |
|884|[Uncommon Words from Two Sentences](https://leetcode.com/problems/uncommon-words-from-two-sentences/)|[Java](./src/string/UncommonWordsTwoSentences.java)| String |
|905|[Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/)|[Java](./src/java/easy/array/SortArrayByParity.java)| Array |
|908|[Smallest Range I](https://leetcode.com/problems/smallest-range-i/)|[Java](./src/java/easy/math/SmallestRangeI.java)| Math |
|917|[Reverse Only Letters](https://leetcode.com/problems/reverse-only-letters/)|[Java](./src/java/easy/string/ReverseOnlyLetters.java)| Two-Pointer |
|922|[Sort Array By Parity II](https://leetcode.com/problems/sort-array-by-parity-ii/)|[Java](./src/java/easy/array/SortArrayParityII.java)| Read/Write Head |
|994|[Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)|[Java](./src/java/easy/matrix/RottingOranges.java)| BFS |
|1022|[Sum of Root To Leaf Binary Numbers](https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/)|[Java](./src/java/easy/tree/SumRootLeafBinaryNumbers.java)| DFS |
|1025|[Divisor Game](https://leetcode.com/problems/divisor-game/)|[Java](src/java/easy/dp/DivisorGame.java)| 1D DP | [Solution](https://leetcode.com/problems/divisor-game/discuss/274566/just-return-N-2-0-(proof)) with constant time
|1047|[Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)|[Java](./src/java/easy/string/RemoveAllAdjacentDuplicatesString.java)| Stack |
|1281|[Subtract the Product and Sum of Digits of an Integer](https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/)|[Java](./src/java/easy/number/SubtractProductSumDigitsInteger.java)| Number |
|1337|[The K Weakest Rows in a Matrix](https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/)|[Java](./src/java/easy/matrix/KWeakestRowsInMatrix.java)| MaxQueue |

### Medium Questions

| # | Name | Solution | Algorithm | Note |
|:-:|:----:|:--------:|:---------:|:----:|
|2|[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)|[Java](./src/java/medium/linkedlist/AddTwoNumbers.java) [Python](./src/python/linkedlist/add-two-numbers.py)| Linked List |
|3|[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)|[Java](./src/java/medium/string/LongestSubstringWithoutRepeatingCharacters.java)| Two-Pointer |
|5|[Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)|[Java](./src/java/medium/dp/LongestPalindromicSubstring.java)| 2D DP | [Manacher's Algorithm](https://en.wikipedia.org/wiki/Longest_palindromic_substring#Manacher's_algorithm) is the optimal solution |
|6|[ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/)|[Java](./src/java/medium/string/ZigZagConversion.java)| String |
|8|[String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi)|[Java](./src/java/medium/string/StringToIngeter.java)| String |
|11|[Container With Most Water](https://leetcode.com/problems/container-with-most-water/)|[Java](./src/java/medium/greedy/ContainerWithMostWater.java)| Two-Pointer/Greedy |
|12|[Integer to Roman](https://leetcode.com/problems/integer-to-roman/)|[Java](./src/java/medium/number/IntegerToRoman.java)| Number |
|15|[Three Sum](https://leetcode.com/problems/3sum/)|[Java](./src/java/medium/array/ThreeSum.java) [Python](./src/python/array/3sum.py)| Two-Pointer |
|16|[3Sum Closest](https://leetcode.com/problems/3sum-closest/)|[Java](./src/java/medium/array/ThreeSumClosest.java) [Python](./src/python/array/three-sum-closest.py)| Two-Pointer |
|17|[Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)|[Java](./src/java/medium/string/LetterCombinationsPhoneNumber.java)| Backtracking (DFS) |
|18|[4Sum](https://leetcode.com/problems/4sum/)|[Java](./src/java/medium/array/FourSum.java)| Two-Pointer |
|19|[Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)|[Java](./src/java/medium/linkedlist/RemoveNthNodeFromEndList.java)| Two-Pointer |
|22|[Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)|[Java](./src/java/medium/backtracking/GenerateParentheses.java)| Backtracking (DFS) |
|24|[Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)|[Java](./src/java/medium/linkedlist/SwapNodesPairs.java)| Recursion |
|29|[Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)|[Java](./src/java/medium/bit/DivideTwoInteger.java)| Bit |
|31|[Next Permutation](https://leetcode.com/problems/next-permutation/)|[Java](./src/java/medium/math/NextPermutation.java)| Math |
|33|[Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)|[Java](./src/java/medium/array/SearchRotatedSortedArray.java)| Binary Search |
|34|[Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)|[Java](./src/java/medium/array/FindFirstLastPositionElementSortedArray.java)| Binary Search |
|36|[Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)|[Java](./src/java/medium/matrix/ValidSudoku.java)| Matrix |
|39|[Combination Sum](https://leetcode.com/problems/combination-sum/)|[Java](./src/java/medium/backtracking/CombinationSum.java)| Backtracking (DFS) |
|40|[Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)|[Java](./src/java/medium/backtracking/CombinationSumII.java)| Backtracking (DFS) |
|43|[Multiply Strings](https://leetcode.com/problems/multiply-strings/) | [Java](./src/java/medium/string/MultiplyStrings.java)| Loop |
|46|[Permutations](https://leetcode.com/problems/permutations/)|[Java](./src/java/medium/array/Permutations.java)| Backtracking (BFS & DFS) |
|47|[Permutations II](https://leetcode.com/problems/permutations-ii/)|[Java](./src/java/medium/array/PermutationsUnique.java)| Backtracking (BFS & DFS) |
|48|[Rotate Image](https://leetcode.com/problems/rotate-image)|[Java](./src/java/medium/matrix/RotateImage.java)| Matrix |
|49|[Group Anagrams](https://leetcode.com/problems/group-anagrams/)|[Java](./src/java/medium/string/GroupAnagrams.java)| HashMap/String Signature |
|50|[Pow(x, n)](https://leetcode.com/problems/powx-n/)|[Java](./src/java/medium/math/Pow.java)| Math |
|54|[Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)|[Java](./src/java/medium/matrix/SpiralMatrix.java)| Matrix |
|55|[Jump Game](https://leetcode.com/problems/jump-game/)|[Java](./src/java/medium/greedy/JumpGame.java)| Greedy |
|56|[Merge Intervals](https://leetcode.com/problems/merge-intervals/)|[Java](./src/java/medium/array/MergeIntervals.java)| Sort |
|59|[Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/)|[Java](./src/java/medium/matrix/SpiralMatrixII.java)| Matrix |
|60|[Permutation Sequence](https://leetcode.com/problems/permutation-sequence/)|[Java](./src/java/medium/math/PermutationSequence.java)| Math |
|61|[Rotate List](https://leetcode.com/problems/rotate-list/)|[Java](./src/java/medium/linkedlist/RotateList.java)| LinkedList |
|62|[Unique Paths](https://leetcode.com/problems/unique-paths/)|[Java](./src/java/medium/dp/UniquePaths.java)| 2D DP |
|63|[Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)|[Java](./src/java/medium/dp/UniquePathsII.java)| 2D DP |
|64|[Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)|[Java](./src/java/medium/matrix/MinPathSum.java)| 2D DP |
|71|[Simplify Path](https://leetcode.com/problems/simplify-path/)|[Java](./src/java/medium/string/SimplifyPath.java)| Stack |
|73|[Set Matrix Zeros](https://leetcode.com/problems/combinations/)|[Java](./src/java/medium/matrix/SetMatrixZeros.java)| Matrix |
|74|[Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)|[Java](./src/java/medium/matrix/SearchMatrix.java)| Binary Search |
|75|[Sort Colors](https://leetcode.com/problems/sort-colors/)|[Java](./src/java/medium/array/SortColors.java)| Two-Pointer |
|77|[Combinations](https://leetcode.com/problems/combinations/)|[Java](./src/java/medium/backtracking/Combinations.java)| Backtracking (DFS) |
|78|[Subsets](https://leetcode.com/problems/subsets/)|[Java](./src/java/medium/array/Subsets.java)| Backtracking (BFS & DFS) |
|79|[Word Search](https://leetcode.com/problems/word-search/)|[Java](./src/java/medium/backtracking/WordSearch.java)| Backtracking (DFS) |
|80|[Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)|[Java](./src/java/medium/array/RemoveDuplicatesSortedArrayII.java)| Two-Pointer |
|81|[Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)|[Java](./src/java/medium/array/SearchRotatedSortedArrayII.java)| Binary Search |
|82|[Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)|[Java](./src/java/medium/linkedlist/RemoveDuplicatesSortedListII.java)| LinkedList |
|86|[Partition List](https://leetcode.com/problems/partition-list/)|[Java](./src/java/medium/linkedlist/PartitionList.java)| LinkedList |
|89|[Gray Code](https://leetcode.com/problems/gray-code/)|[Java](./src/java/medium/bit/GrayCode.java)| Bit |
|90|[Subsets II](https://leetcode.com/problems/subsets-ii/)|[Java](./src/java/medium/array/SubsetsII.java)| Backtracking (BFS & DFS) |
|91|[Decode Ways](https://leetcode.com/problems/decode-ways/)|[Java](./src/java/medium/dp/DecodeWays.java)| 1D DP |
|92|[Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/)|[Java](./src/java/medium/linkedlist/ReverseLinkedListII.java)| LinkedList |
|93|[Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/)|[Java](./src/java/medium/backtracking/RestoreIPAddresses.java)| Backtracking & Greedy |
|94|[Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)|[Java](./src/java/medium/tree/BinaryTreeInorderTraversal.java)| Tree Traversal |
|95|[Unique Binary Search Trees II](https://leetcode.com/problems/unique-binary-search-trees-ii/)|[Java](./src/java/medium/tree/UniqueBinarySearchTreeII.java)| DFS |
|96|[Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees/)|[Java](./src/java/medium/dp/UniqueBinarySearchTree.java)| 1D DP | Optimized from 2D to 1D |
|98|[Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)|[Java](./src/java/medium/tree/ValidateBinarySearchTree.java)| DFS |
|102|[Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)|[Java](./src/java/medium/tree/BinaryTreeLevelOrderTraversal.java)| DFS & BFS |
|103|[Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)|[Java](./src/java/medium/tree/BinaryTreeLevelOrderTraversal.java)| DFS & BFS |
|105|[Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)|[Java](./src/java/medium/tree/ConstructBinaryTreeFromPreorderInorderTraversal.java)| Recursion |
|106|[Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)|[Java](./src/java/medium/tree/ConstructBinaryTreeFromInorderPostorderTraversal.java)| Recursion |
|109|[Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)|[Java](./src/java/medium/tree/ConvertSortedListBST.java)| D&C |
|113|[Path Sum II](https://leetcode.com/problems/path-sum-ii/)|[Java](./src/java/medium/tree/PathSumII.java)| Backtracking (DFS) |
|114|[Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)|[Java](./src/java/medium/tree/FlattenBinaryTreeLinkedList.java)| BFS & DFS |
|116|[Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)|[Java](./src/java/medium/tree/PopulatingNextRightPointers.java)| Loop |
|117|[Populating Next Right Pointers in Each Node II](https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/)|[Java](./src/java/medium/tree/PopulatingNextRightPointersII.java)| Loop |
|120|[Triangle](https://leetcode.com/problems/triangle/)|[Java](./src/java/medium/dp/Triangle.java)| 1D DP |
|127|[Word Ladder](https://leetcode.com/problems/word-ladder/)|[Java](./src/java/medium/string/WordLadder.java)| Backtracking (BFS & DFS) | LeetCode needs some [optimization](https://leetcode.com/problems/word-ladder/solution/) to pass TLE, which I think is an overkill|
|129|[Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/)|[Java](./src/java/medium/tree/SumRootToLeafNumbers.java)| DFS |
|130|[Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)|[Java](./src/java/medium/matrix/SurroundedRegions.java)| BFS & DFS | Union Find [solution](https://leetcode.com/problems/surrounded-regions/discuss/41617/Solve-it-using-Union-Find) |
|131|[Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)|[Java](./src/java/medium/string/PalindromePartitioning.java)| Backtracking (DFS) + DP + Recursion |
|133|[Clone Graph](https://leetcode.com/problems/clone-graph/)|[Java](./src/java/medium/graph/CloneGraph.java)| DFS + BFS |
|134|[Gas Station](https://leetcode.com/problems/gas-station/)|[Java](./src/java/medium/greedy/GasStation.java)| Greedy |
|137|[Single Number II](https://leetcode.com/problems/single-number-ii/)|[Java](./https://github.com/zorrowang/LeetCode/blob/fc8974ce5468606e2d330fc7640d08751709413e/src/java/medium/bit/SingleNumberII.java)| Bit + Set | Great explanation of this type of questions is [here](https://leetcode.com/problems/single-number-ii/discuss/43295/Detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers) |
|138|[Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)|[Java](./src/java/medium/linkedlist/CopyListWithRandomPointer.java)| HashMap | Space complexity can be optimized to O(1) as [here](https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)) |
|139|[Word Break](https://leetcode.com/problems/word-break/)|[Java](./src/java/medium/dp/WordBreak.java)| 1D DP |
|142|[Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)|[Java](./src/java/medium/linkedlist/LinkedListCycleII.java)| LinkedList |
|143|[Reorder List](https://leetcode.com/problems/reorder-list/)|[Java](./src/java/medium/linkedlist/ReorderList.java)| LinkedList |
|144|[Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/)|[Java](./src/java/medium/tree/BinaryTreePreorderTraversal.java)| Stack |
|146|[LRU Cache](https://leetcode.com/problems/lru-cache/)|[Java](./src/java/medium/linkedlist/LRUCache.java)| HashMap & DoublyLinkedList | Deserve as `hard` |
|147|[Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/)|[Java](./src/java/medium/linkedlist/InsertionSortList.java)| LinkedList |
|148|[Sort List](https://leetcode.com/problems/sort-list/)|[Java](./src/java/medium/linkedlist/SortList.java)| LinkedList |
|150|[Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)|[Java](./src/java/medium/array/EvaluateReversePolishNotation.java)| Stack |
|151|[Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/)|[Java](./src/java/medium/string/ReverseWordsInString.java)| String | Should be an `easy` one |
|152|[Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)|[Java](./src/java/medium/array/MaximumProductSubarray.java)| 1D DP |
|153|[Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)|[Java](./src/java/medium/array/FindMinimumRotatedSortedArray.java)| Binary Search |
|156|[Binary Tree Upside Down](https://leetcode.com/problems/binary-tree-upside-down)|[Java](./src/java/medium/tree/BinaryTreeUpsideDown.java)| Stack | LintCode [649](https://www.lintcode.com/problem/binary-tree-upside-down/description) |
|159|[Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters)|[Java](./src/java/medium/string/LongestSubstringAtMostTwoDistinctCharacters.java)| Two-Pointer | LintCode [928](https://www.lintcode.com/problem/longest-substring-with-at-most-two-distinct-characters/description) as `Hard` |
|161|[One Edit Distance](https://leetcode.com/problems/one-edit-distance)|[Java](./src/java/medium/string/OneEditDistance.java)| String | LintCode [640](https://www.lintcode.com/problem/one-edit-distance/description) |
|162|[Find Peak Element](https://leetcode.com/problems/find-peak-element/)|[Java](./src/java/medium/array/FindPeakElement.java)| BinarySearch |
|163|[Missing Ranges](https://leetcode.com/problems/missing-ranges/)|[Java](./src/java/medium/array/MissingRanges.java)| Loop | LintCode [641](https://www.lintcode.com/problem/missing-ranges/description) |
|165|[Compare Version Numbers](https://leetcode.com/problems/compare-version-numbers/)|[Java](./src/java/medium/string/CompareVersionNumbers.java)| String |
|166|[Fraction to Recurring Decimal](https://leetcode.com/problems/fraction-to-recurring-decimal/)|[Java](./src/java/medium/number/FractionToRecurringDecimal.java)| HashMap | Should be as `hard` |
|173|[Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/)|[Java](./src/java/medium/tree/BSTIterator.java)| BFS+Stack |
|179|[Largest Number](https://leetcode.com/problems/largest-number/)|[Java](./src/java/medium/string/LargestNumber.java)| Sort |
|186|[Reverse Words in a String II](https://leetcode.com/problems/reverse-words-in-a-string-ii)|[Java](./src/java/medium/array/ReverseWordsStringII.java)| Two-Pointer | LintCode [927](https://www.lintcode.com/problem/reverse-words-in-a-string-ii/description) |
|187|[Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/)|[Java](./src/java/medium/string/RepeatedDNASequences.java)| HashMap |
|199|[Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)|[Java](./src/java/medium/tree/BinaryTreeRightSideView.java)| DFS & BFS |
|200|[Number of Islands](https://leetcode.com/problems/number-of-islands/)|[Java](./src/java/medium/matrix/NumberOfIslands.java)| DFS & BFS |
|201|[Bitwise AND of Numbers Range](https://leetcode.com/problems/bitwise-and-of-numbers-range/)|[Java](./src/java/medium/bit/BitwiseANDNumbersRange.java)| Bit |
|207|[Course Schedule](https://leetcode.com/problems/course-schedule/)|[Java](./src/java/medium/graph/CourseSchedule.java)| Topological Sort |
|208|[Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)|[Java](./src/java/medium/tree/ImplementTrie.java)| Trie |
|209|[Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)|[Java](./src/java/medium/array/MinimumSizeSubarraySum.java)| Sliding Window |
|210|[Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)|[Java](./src/java/medium/graph/CourseScheduleII.java)| Topological Sort |
|211|[Add and Search Word - Data structure design](https://leetcode.com/problems/add-and-search-word-data-structure-design/)|[Java](./src/java/medium/string/WordDictionary.java)| Trie+Backtracking |
|213|[House Robber II](https://leetcode.com/problems/house-robber-ii/)|[Java](./src/java/medium/dp/HouseRobberII.java)| 1D DP |
|215|[Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)|[Java](./src/java/medium/array/KthLargestElement.java)| Heap Sort | A better [solution](https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained) uses Selection algorithm with shuffling |
|216|[Combination Sum III](https://leetcode.com/problems/combination-sum-iii/)|[Java](./src/java/medium/backtracking/CombinationSumIII.java)| Backtracking (DFS) |
|220|[Contains Duplicate III](https://leetcode.com/problems/contains-duplicate-iii/) | [Java](./src/java/medium/array/ContainsDuplicateIII.java)| TreeMap | TLE on LeetCode OJ (it's a boring question) |
|221|[Maximal Square](https://leetcode.com/problems/maximal-square/) | [Java](./src/java/medium/matrix/MaximalSquare.java)| DP |
|222|[Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/) | [Java](./src/java/medium/tree/CountCompleteTreeNodes.java)| DFS |
|223|[Rectangle Area](https://leetcode.com/problems/rectangle-area/) | [Java](./src/java/medium/math/RectangleArea.java)| Math |
|227|[Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/) | [Java](./src/java/medium/string/BasicCalculatorII.java)| Deque | A better [solution](https://leetcode.com/problems/basic-calculator-ii/discuss/63003/Share-my-java-solution) uses a single stack |
|228|[Summary Ranges](https://leetcode.com/problems/summary-ranges/) | [Java](./src/java/medium/array/SummaryRanges.java)| Two-Pointer |
|229|[Majority Element II](https://leetcode.com/problems/majority-element-ii/) | [Java](./src/java/medium/array/MajorityElementII.java)| Boyer-Moore Majority Voting Algorithm |
|230|[Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | [Java](./src/java/medium/tree/KthSmallestElementInBST.java)| DFS |
|236|[Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)|[Java](./src/java/medium/tree/LowestCommonAncestorBinaryTree.java)| DFS |
|238|[Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)|[Java](./src/java/medium/array/ProductOfArrayExceptSelf.java)| 1D DP | This [solution](https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space) uses O(1) space |
|240|[Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/)|[Java](./src/java/medium/matrix/Search2DMatrixII.java)| Divide and Conquer |
|241|[Different Ways to Add Parentheses](https://leetcode.com/problems/different-ways-to-add-parentheses/)|[Java](./src/java/medium/string/DifferentWaysAddParentheses.java)| Recursion |
|247|[Strobogrammatic Number II](https://leetcode.com/problems/strobogrammatic-number-ii)|[Java](./src/java/medium/number/StrobogrammaticNumberII.java)| Recursion | LintCode [776](https://www.lintcode.com/problem/strobogrammatic-number-ii/description) |
|250|[Count Univalue Subtrees](https://leetcode.com/problems/count-univalue-subtrees)|[Java](./src/java/medium/tree/CountUnivalueSubtrees.java)| DFS | LintCode [921](https://www.lintcode.com/problem/count-univalue-subtrees/description) |
|251|[Flatten 2D Vector](https://leetcode.com/problems/flatten-2d-vector) | [Java](./src/java/medium/list/Vector2D.java)| Two-Pointer | LintCode [601](https://www.lintcode.com/problem/flatten-2d-vector/description) |
|253|[Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii)|[Java](./src/java/medium/list/MeetingRoomsII.java)| Greedy | LintCode [919](https://www.lintcode.com/problem/meeting-rooms-ii/description) |
|254|[Factor Combinations](https://leetcode.com/problems/factor-combinations)|[Java](./src/java/medium/backtracking/FactorCombinations.java)| Backtracking (DFS) | LintCode [1308](https://www.lintcode.com/problem/factor-combinations/description) |
|255|[Verify Preorder Sequence in Binary Search Tree](https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree)|[Java](./src/java/medium/tree/VerifyPreorderSequenceBinarySearchTree.java)| Divide and Conquer | LintCode [1307](https://www.lintcode.com/problem/verify-preorder-sequence-in-binary-search-tree/description) |
|259|[3Sum Smaller](https://leetcode.com/problems/3sum-smaller)|[Java](./src/java/medium/array/3SumSmaller.java)| Two-Pointer | LintCode [918](https://www.lintcode.com/problem/3sum-smaller/description) |
|260|[Single Number III](https://leetcode.com/problems/single-number-iii/)|[Java](./src/java/medium/bit/SingleNumberIII.java)| Bit | It's a hard question to achieve _Space O(1)_ |
|261|[Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree)|[Java](./src/java/medium/tree/GraphValidTree.java)| UnionFind | LintCode [178](https://www.lintcode.com/problem/graph-valid-tree/description) |
|264|[Ugly Number II](https://leetcode.com/problems/ugly-number-ii/)|[Java](./src/java/medium/dp/UglyNumberII.java)| 1D DP |
|267|[Palindrome Permutation II](https://leetcode.com/problems/palindrome-permutation-ii)|[Java](./src/java/medium/backtracking/PalindromePermutationII.java)| Backtracking (DFS) | LintCode [917](https://www.lintcode.com/problem/palindrome-permutation-ii/description) |
|271|[Encode and Decode Strings](https://leetcode.com/problems/encode-and-decode-strings) | [Java](./src/java/medium/string/EncodeDecodeStrings.java)| String | LintCode [659](https://www.lintcode.com/problem/encode-and-decode-strings/description) |
|274|[H-Index](https://leetcode.com/problems/h-index/) | [Java](./src/java/medium/array/HIndex.java)| Sort & Map |
|275|[H-Index II](https://leetcode.com/problems/h-index-ii/) | [Java](./src/java/medium/array/HIndexII.java)| BinarySearch |
|277|[Find the Celebrity](https://leetcode.com/problems/find-the-celebrity) | [Java](./src/java/medium/array/FindTheCelebrity.java)| Two-Pointer & Stack & Graph | LintCode [645](https://www.lintcode.com/problem/find-the-celebrity/description) |
|279|[Perfect Squares](https://leetcode.com/problems/perfect-squares/) | [Java](./src/java/medium/dp/PerfectSquares.java)| 1D DP |
|280|[Wiggle Sort](https://leetcode.com/problems/wiggle-sort) | [Java](./src/java/medium/array/WiggleSort.java)| Greedy | LintCode [508](https://www.lintcode.com/problem/wiggle-sort/description) |
|281|[Zigzag Iterator](https://leetcode.com/problems/zigzag-iterator) | [Java](./src/java/medium/list/ZigzagIterator.java)| List | LintCode [540](https://www.lintcode.com/problem/zigzag-iterator/description) |
|284|[Peeking Iterator](https://leetcode.com/problems/peeking-iterator/) | [Java](./src/java/medium/array/PeekIterator.java)| Design |
|285|[Inorder Successor in BST](https://leetcode.com/problems/inorder-successor-in-bst) | [Java](./src/java/medium/tree/InorderSuccessorBST.java)| DFS | LintCode [448](https://www.lintcode.com/problem/inorder-successor-in-bst/description) |
|286|[Walls and Gates](https://leetcode.com/problems/walls-and-gates) | [Java](src/java/medium/matrix/WallsAndGates.java)| BFS | LintCode [663](https://www.lintcode.com/problem/walls-and-gates/description) |
|287|[Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) | [Java](./src/java/medium/array/FindDuplicateNumber.java)| Two-Pointer |
|288|[Unique Word Abbreviation](https://leetcode.com/problems/unique-word-abbreviation) | [Java](./src/java/medium/string/UniqueWordAbbreviation.java)| HashMap | LintCode [648](https://www.lintcode.com/problem/unique-word-abbreviation/description) |
|289|[Game of Life](https://leetcode.com/problems/game-of-life/) | [Java](./src/java/medium/matrix/GameOfLife.java)| Bit |
|294|[Flip Game II](https://leetcode.com/problems/flip-game-ii)|[Java](./src/java/medium/backtracking/FlipGameII.java)| Backtracking (DFS) | LintCode [913](https://www.lintcode.com/problem/flip-game-ii/description) |
|298|[Binary Tree Longest Consecutive Sequence](https://leetcode.com/problems/binary-tree-longest-consecutive-sequence)|[Java](./src/java/medium/tree/BinaryTreeLongestConsecutiveSequence.java)| DFS | LintCode [595](https://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence/description) |
|300|[Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) | [Java](./src/java/medium/dp/LongestIncreasingSubsequence.java)| 1D DP | Binary search [solution](https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation) is more optimal |
|304|[Range Sum Query 2D - Immutable](https://leetcode.com/problems/range-sum-query-2d-immutable/) | [Java](./src/java/medium/matrix/RangeSumQuery2D.java)| Matrix |
|306|[Additive Number](https://leetcode.com/problems/additive-number/) | [Java](./src/java/medium/backtracking/AdditiveNumber.java)| Backtracking (DFS) |
|307|[Range Sum Query - Mutable](https://leetcode.com/problems/range-sum-query-mutable/) | [Java](./src/java/medium/array/RangeSumQueryMutable.java)| Segment Tree |
|309|[Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | [Java](./src/java/medium/dp/BestTimeBuySellStockWithCooldown.java)| 1D DP |
|310|[Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/) | [Java](./src/java/medium/tree/MinimumHeightTrees.java)| BFS |
|311|[Sparse Matrix Multiplication](https://leetcode.com/problems/sparse-matrix-multiplication) | [Java](./src/java/medium/matrix/SparseMatrixMultiplication.java)| List | LintCode [654](https://www.lintcode.com/problem/sparse-matrix-multiplication/description) |
|314|[Binary Tree Vertical Order Traversal](https://leetcode.com/problems/binary-tree-vertical-order-traversal) | [Java](./src/java/medium/tree/BinaryTreeVerticalOrderTraversal.java)| DFS + HashMap | LintCode [651](https://www.lintcode.com/problem/binary-tree-vertical-order-traversal/description) (LintCode OJ is incorrect) |
|318|[Maximum Product of Word Lengths](https://leetcode.com/problems/maximum-product-of-word-lengths/) | [Java](./src/java/medium/bit/MaximumProductWordLengths.java)| Bit-Manipulation |
|319|[Bulb Switcher](https://leetcode.com/problems/bulb-switcher/) | [Java](./src/java/medium/math/BulbSwitcher.java)| Math |
|320|[Generalized Abbreviation](https://leetcode.com/problems/generalized-abbreviation) | [Java](./src/java/medium/backtracking/GeneralizedAbbreviation.java)| Backtracking (DFS) | LintCode [779](https://www.lintcode.com/problem/generalized-abbreviation/description) |
|322|[Coin Change](https://leetcode.com/problems/coin-change/) | [Java](./src/java/medium/dp/CoinChange.java)| 1D DP |
|331|[Verify Preorder Serialization of a Binary Tree](https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/) | [Java](./src/java/medium/tree/VerifyPreorderSerializationBinaryTree.java)| DFS | Non-cursive [solution](https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution) based on graph theory |
|332|[Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary/) | [Java](./src/java/medium/greedy/ReconstructItinerary.java)| Greedy |
|341|[Flatten Nested List Iterator](https://leetcode.com/problems/flatten-nested-list-iterator/) | [Java](./src/java/medium/list/FlattenNestedListIterator.java)| Recursion |
|357|[Count Numbers with Unique Digits](https://leetcode.com/problems/count-numbers-with-unique-digits/) | [Java](./src/java/medium/math/CountNumbersUniqueDigits.java)| Math |
|361|[Bomb Enemy](https://leetcode.com/problems/bomb-enemy) | [Java](./src/java/medium/matrix/BombEnemy.java)| DP | LintCode [553](https://www.lintcode.com/problem/bomb-enemy/description) |
|366|[Find Leaves of Binary Tree](https://leetcode.com/problems/find-leaves-of-binary-tree) | [Java](./src/java/medium/tree/FindLeavesBinaryTree.java)| DFS | LintCode [650](https://www.lintcode.com/problem/find-leaves-of-binary-tree/description) |
|369|[Plus One Linked List](https://leetcode.com/problems/plus-one-linked-list) | [Java](./src/java/medium/linkedlist/PlusOneLinkedList.java)| Recursion | LintCode [904](https://www.lintcode.com/problem/plus-one-linked-list/description) |
|370|[Range Addition](https://leetcode.com/problems/range-addition) | [Java](./src/java/medium/array/RangeAddition.java)| Array | LintCode [903](https://www.lintcode.com/problem/range-addition/description) |
|376|[Wiggle Subsequence](https://leetcode.com/problems/wiggle-subsequence/) | [Java](./src/java/medium/dp/WiggleSubsequence.java)| 1D DP |
|377|[Combination Sum IV](https://leetcode.com/problems/combination-sum-iv/) | [Java](./src/java/medium/dp/CombinationSumIV.java)| 1D DP |
|378|[Kth Smallest Element in a Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/) | [Java](./src/java/medium/matrix/KthSmallestElementSortedMatrix.java)| Min Heap |
|380|[Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/) | [Java](./src/java/medium/map/RandomizedSet.java)| HashMap |
|382|[Linked List Random Node](https://leetcode.com/problems/linked-list-random-node/) | [Java](./src/java/medium/linkedlist/LinkedListRandomNode.java)| LinkedList | It's essentially a math question ([Reservoir Sampling](https://leetcode.com/problems/linked-list-random-node/discuss/85659/Brief-explanation-for-Reservoir-Sampling)). |
|386|[Lexicographical Numbers](https://leetcode.com/problems/lexicographical-numbers/) | [Java](./src/java/medium/backtracking/LexicographicalNumbers.java)| DFS |
|394|[Decode String](https://leetcode.com/problems/decode-string/) | [Java](./src/java/medium/string/DecodeString.java)| Stack & DFS | Deserve as `hard` |
|397|[Integer Replacement](https://leetcode.com/problems/integer-replacement/) | [Java](./src/java/medium/bit/IntegerReplacement.java)| Bit |
|416|[Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/) | [Java](./src/java/medium/dp/PartitionEqualSubsetSum.java)| DP | [Knapsack Model](./docs/algorithms/basic/DynamicProgramming.md#knapsack-model) |
|417|[Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/) | [Java](./src/java/medium/matrix/PacificAtlanticWaterFlow.java)| BFS |
|424|[Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)|[Java](./src/java/medium/string/LongestRepeatingCharacterReplacement.java)| Two-Pointer |
|430|[Flatten a Multilevel Doubly Linked List](https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/)|[Java](./src/java/medium/linkedlist/FlattenMultilevelDoublyLinkedList.java)| Recursion |
|433|[Minimum Genetic Mutation](https://leetcode.com/problems/minimum-genetic-mutation/)|[Java](./src/java/medium/backtracking/MinimumGeneticMutation.java)| Backtracking (DFS) |
|435|[Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/) | [Java](./src/java/medium/matrix/NonOverlappingIntervals.java)| Sort + 1D DP | Greedy [solution](https://leetcode.com/problems/non-overlapping-intervals/discuss/91713/Java%3A-Least-is-Most) can optimize to _O(nlogn)_ |
|474|[Ones and Zeroes](https://leetcode.com/problems/ones-and-zeroes/) | [Java](./src/java/medium/array/OnesAndZeroes.java)| 3D DP | [Knapsack Model](./docs/algorithms/basic/DynamicProgramming.md#knapsack-model) |
|477|[Total Hamming Distance](https://leetcode.com/problems/total-hamming-distance/) | [Java](./src/java/medium/bit/TotalHammingDistance.java)| Bit |
|491|[Increasing Subsequences](https://leetcode.com/problems/increasing-subsequences/) | [Java](./src/java/medium/backtracking/IncreasingSubsequences.java)| Backtracking (DFS) |
|495|[Teemo Attacking](https://leetcode.com/problems/teemo-attacking/) | [Java](./src/java/medium/array/TeemoAttacking.java)| Greedy |
|516|[Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/) | [Java](./src/java/medium/dp/LongestPalindromicSubsequence.java)| 2D DP |
|542|[01 Matrix](https://leetcode.com/problems/01-matrix/) | [Java](./src/java/medium/matrix/ZeroOneMatrix.java)| Stack |
|678|[Valid Parenthesis String](https://leetcode.com/problems/valid-parenthesis-string/) | [Java](./src/java/medium/string/ValidParenthesisString.java)| Greedy + Backtracking | It can be solved by DP, greedy and backtracking! |
|725|[Split Linked List in Parts](https://leetcode.com/problems/split-linked-list-in-parts/) | [Java](./src/java/medium/linkedlist/SplitLinkedListParts.java)| LinkedList |
|739|[Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) | [Java](./src/java/medium/array/DailyTemperatures.java)| Stack |
|856|[Score of Parentheses](https://leetcode.com/problems/score-of-parentheses/) | [Java](./src/java/medium/string/ScoreParentheses.java)| Stack |
|870|[Advantage Shuffle](https://leetcode.com/problems/advantage-shuffle/) | [Java](./src/java/medium/array/AdvantageShuffle.java)| Greedy + BinarySearch |
|881|[Boats to Save People](https://leetcode.com/problems/boats-to-save-people/) | [Java](./src/java/medium/greedy/BoatsSavePeople.java)| Greedy + Two-Pointer |
|916|[Word Subsets](https://leetcode.com/problems/word-subsets/) | [Java](./src/java/medium/string/WordSubsets.java)| String Signature |
|921|[Minimum Add to Make Parentheses Valid](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/) | [Java](./src/java/medium/string/MinimumAddParenthesesValid.java)| Greedy |
|1048|[Longest String Chain](https://leetcode.com/problems/longest-string-chain/) | [Java](./src/java/medium/string/LongestStringChain.java)| 1D DP |
|1110|[Delete Nodes And Return Forest](https://leetcode.com/problems/delete-nodes-and-return-forest/) | [Java](./src/java/medium/tree/DeleteNodesAndReturnForest.java)| DFS |
|1249|[Minimum Remove to Make Valid Parentheses](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/) | [Java](./src/java/medium/string/MinimumRemoveValidParentheses.java)| Greedy |
|1302|[Deepest Leaves Sum](https://leetcode.com/problems/deepest-leaves-sum/) | [Java](./src/java/medium/tree/DeepestLeavesSum.java)| DFS |
|1306|[Jump Game III](https://leetcode.com/problems/jump-game-iii/) | [Java](./src/java/medium/array/JumpGameIII.java)| Backtracking (DFS) |
|1315|[Sum of Nodes with Even-Valued Grandparent](https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/) | [Java](./src/java/medium/tree/SumOfNodesEvenValuedGrandparent.java)| DFS |
|1339|[Maximum Product of Splitted Binary Tree](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/) | [Java](./src/java/medium/tree/MaximumProductSplittedBinaryTree.java)| DFS |
|1423|[Maximum Points You Can Obtain from Cards](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/) | [Java](./src/java/medium/array/MaximumPointsFromCards.java)| DP & Sliding Window |

### Hard Questions

| # | Name | Solution | Algorithm | Note |
|:-:|:----:|:--------:|:---------:|:----:|
|2|[Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/) | [Java](./src/java/hard/array/MedianTwoSortedArrays.java)| Binary Search |
|10|[Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/) | [Java](./src/java/hard/string/RegularExpressionMatching.java)| Backtracking |
|23|[Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) | [Java](./src/java/hard/linkedlist/MergeSortedLists.java)| HeapSort |
|25|[Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | [Java](./src/java/hard/linkedlist/ReverseNodesKGroup.java)| LinkedList |
|30|[Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/) | [Java](./src/java/hard/string/SubstringWithConcatenation.java) | HashMap |
|32|[Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/) | [Java](./src/java/hard/stack/LongestValidParentheses.java)| Stack + 1D DP |
|37|[Sudoku Solver](https://leetcode.com/problems/sudoku-solver/) | [Java](./src/java/hard/matrix/SudokuSolver.java)| Backtracking |
|41|[First Missing Positive](https://leetcode.com/problems/first-missing-positive/) | [Java](./src/java/hard/array/FirstMissingPositive.java)| Array |
|42|[Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) | [Java](./src/java/medium/greedy/TrappingRainWater.java)| Greedy/Two-Pointer |
|44|[Wildcard Matching](https://leetcode.com/problems/wildcard-matching/) | [Java](./src/java/hard/string/WildcardMatching.java)| Backtracking/Two-Pointer |
|45|[Jump Game II](https://leetcode.com/problems/jump-game-ii/) | [Java](./src/java/hard/dp/JumpGameII.java)| 1D DP/Greedy |
|51|[N-Queens](https://leetcode.com/problems/n-queens/) | [Java](./src/java/hard/backtracking/NQueens.java)| Backtracking (DFS) |
|52|[N-Queens II](https://leetcode.com/problems/n-queens-ii/) | [Java](./src/java/hard/backtracking/NQueensII.java)| Backtracking (DFS) |
|57|[Insert Interval](https://leetcode.com/problems/insert-interval/) | [Java](./src/java/hard/array/InsertInterval.java)| Sort |
|65|[Valid Number](https://leetcode.com/problems/valid-number/) | [Java](./src/java/hard/string/ValidNumber.java)| String |
|68|[Text Justification](https://leetcode.com/problems/text-justification/) | [Java](./src/java/hard/string/TextJustification.java)| String |
|72|[Edit Distance](https://leetcode.com/problems/edit-distance/) | [Java](./src/java/hard/dp/EditDistance.java)| 2D DP |
|76|[Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | [Java](./src/java/hard/string/MinimumWindowSubstring.java)| Sliding Window |
|84|[Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) | [Java](./src/java/hard/stack/LargestRectangleHistogram.java)| Stack |
|85|[Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/) | [Java](./src/java/hard/matrix/MaximalRectangle.java)| 2D DP |
|87|[Scramble String](https://leetcode.com/problems/scramble-string/) | [Java](./src/java/hard/backtracking/ScrambleString.java)| Backtracking |
|97|[Interleaving String](https://leetcode.com/problems/interleaving-string/) | [Java](./src/java/hard/dp/InterleavingString.java)| 2D DP |
|99|[Recover Binary Search Tree](https://leetcode.com/problems/recover-binary-search-tree/) | [Java](./src/java/hard/tree/RecoverBinarySearchTree.java)| Morris Traversal |
|115|[Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/) | [Java](./src/java/hard/dp/DistinctSubsequences.java)| 2D DP |
|123|[Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/) | [Java](./src/java/hard/dp/BestTimeBuySellStockIII.java)| DP |
|124|[Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | [Java](./src/java/medium/tree/BinaryTreeMaximumPathSum.java)| DFS |
|126|[Word Ladder II](https://leetcode.com/problems/word-ladder-ii/) | [Java](./src/java/hard/backtracking/WordLadderII.java)| Backtracking (DFS + BFS) | Both DFS and BFS fail as TLE in OJ |
|128|[Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) | [Java](./src/java/hard/array/LongestConsecutiveSequence.java)| UnionFind + HashMap |
|132|[Palindrome Partitioning II](https://leetcode.com/problems/palindrome-partitioning-ii/) | [Java](./src/java/hard/dp/PalindromePartitioningII.java)| 2D DP |
|135|[Candy](https://leetcode.com/problems/candy/) | [Java](./src/java/hard/greedy/Candy.java)| Greedy |
|140|[Word Break II](https://leetcode.com/problems/word-break-ii/) | [Java](./src/java/hard/string/WordBreakII.java)| 1D DP + DFS |
|145|[Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/) | [Java](./src/java/hard/tree/BinaryTreePostorderTraversal.java)| Stack & Set |
|149|[Max Points on a Line](https://leetcode.com/problems/max-points-on-a-line/) | [Java](./src/java/hard/math/MaxPoints.java)| HashMap | Using `double` as key in hashmap is generally not a good practice |
|154|[Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/) | [Java](./src/java/hard/array/FindMinimumRotatedSortedArrayII.java)| Binary Search |
|164|[Maximum Gap](https://leetcode.com/problems/maximum-gap/) | [Java](./src/java/hard/array/MaximumGap.java)| BucketSort |
|174|[Dungeon Game](https://leetcode.com/problems/dungeon-game/)|[Java](./src/java/hard/matrix/DungeonGame.java)| Backtracking (DFS) & DP| Backtracking - TLE |
|212|[Word Search II](https://leetcode.com/problems/word-search-ii/) | [Java](./src/java/hard/backtracking/WordSearchII.java)| Backtracking (DFS) & Trie |
|214|[Shortest Palindrome](https://leetcode.com/problems/shortest-palindrome/) | [Java](./src/java/hard/string/ShortestPalindrome.java)| String |
|224|[Basic Calculator](https://leetcode.com/problems/basic-calculator/) | [Java](./src/java/hard/string/BasicCalculator.java)| Stack |
|239|[Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | [Java](./src/java/hard/deque/SlidingWindowMaximum.java)| Deque |
|265|[Paint House II](https://leetcode.com/problems/paint-house-ii) | [Java](./src/java/hard/dp/PaintHouseII.java)| 2D DP | LintCode [516](https://www.lintcode.com/problem/paint-house-ii/description) |
|269|[Alien Dictionary](https://leetcode.com/problems/alien-dictionary) | [Java](./src/java/hard/graph/AlienDictionary.java)| Topological Sort | LintCode [892](https://www.lintcode.com/problem/alien-dictionary/description) - OJ on LintCode is incorrect |
|273|[Integer to English Words](https://leetcode.com/problems/integer-to-english-words/) | [Java](./src/java/hard/string/IntegerToEnglishWords.java)| String |
|282|[Expression Add Operators](https://leetcode.com/problems/expression-add-operators/) | [Java](./src/java/hard/backtracking/ExpressionAddOperators.java)| Backtracking (DFS) |
|291|[Word Pattern II](https://leetcode.com/problems/word-pattern-ii) | [Java](./src/java/hard/backtracking/WordPatternII.java)| Backtracking (DFS) | LintCode [829](https://www.lintcode.com/problem/word-pattern-ii/description) |
|295|[Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/) | [Java](./src/java/hard/heap/FindMedianDataStream.java)| Heap | Solution for follow-ups: <br/> 1. counting sort between 0 and 100 <br/> 2. count numbers, which is > 100 and < 0 |
|297|[Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | [Java](./src/java/hard/tree/SerializeDeserializeBinaryTree.java)| Tree/DFS/Queue |
|301|[Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/) | [Java](./src/java/hard/backtracking/RemoveInvalidParentheses.java)| Backtracking (DFS) |
|305|[Number of Islands II](https://leetcode.com/problems/number-of-islands-ii) | [Java](./src/java/hard/matrix/NumberOfIslandsII.java)| UnionFind | LintCode [434](https://www.lintcode.com/problem/number-of-islands-ii/description) |
|316|[Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/) | [Java](./src/java/hard/greedy/RemoveDuplicateLetters.java)| Greedy |
|329|[Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/) | [Java](./src/java/hard/backtracking/LongestIncreasingPathMatrix.java)| Backtracking (DFS) | DFS with cache |
|381|[Insert Delete GetRandom O(1) - Duplicates allowed](https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/) | [Java](./src/java/hard/map/RandomizedCollection.java)| HashMap |
|546|[Remove Boxes](https://leetcode.com/problems/remove-boxes/) | [Java](./src/java/hard/array/RemoveBoxes.java)| Backtracking (DFS) | Backtracking is TLE. 3D DP solution is [here](https://leetcode.com/problems/remove-boxes/discuss/101310/Java-top-down-and-bottom-up-DP-solutions) |
|778|[Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/) | [Java](./src/java/hard/matrix/SwimRisingWater.java)| Backtracking (DFS) + UnionFind |
|815|[Bus Routes](https://leetcode.com/problems/bus-routes/) | [Java](./src/java/hard/graph/BusRoutes.java)| Graph Traversal (BFS + DFS) |
|980|[Unique Paths III](https://leetcode.com/problems/unique-paths-iii/) | [Java](./src/java/hard/matrix/UniquePathsIII.java)| Backtracking (DFS) |
