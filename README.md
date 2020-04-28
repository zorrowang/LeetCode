# Software Engineer Interview

Author: zorrowanghw@gmail.com

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
  - [Algorithm Complexity](#algorithm-complexity)
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
- [LeetCode Preparation](#leetcode-preparation)
  - [Current Status](#current-status)
  - [Easy Questions](#easy-questions)
  - [Medium Questions](#medium-questions)
  - [Hard Questions](#hard-questions)

<!-- /MarkdownTOC -->

The repo is the summary for software engineer interview based on my experience and knowledge.

## Interview Preparation

The hiring flow for software engineer role is

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

- **finiteness**: the algorithm must always terminate after a finite number of steps.
- **definiteness**: Each step must be precisely defined; the actions to be carried out must be rigorously and unambiguously specified for each case.
- **input**: an algorithm has zero or more inputs, taken from a specified set of objects.
- **output**: an algorithm has one or more outputs, which have a specified relation to the inputs.
- **effectiveness**: all operations to be performed must be sufficiently basic that they can be done exactly and in finite length.

As the restriction of whiteboard coding and the properties of algorithm, most of interview questions can be resolved in ~50 lines of code.

### Algorithm Complexity

- [Time Complexity](./docs/algorithms/Complexity.md#time-complexity)
- [Space Complexity](./docs/algorithms/Complexity.md#space-complexity)

### Basic Algorithms

- [Backtracking](./docs/algorithms/basic/Backtracking.md)
- [Divide and Conquer](./docs/algorithms/basic/Divide-Conquer.md)
- [Dynamic Programming](./docs/algorithms/basic/DynamicProgramming.md)
  - [Memorization](./docs/algorithms/basic/DynamicProgramming.md#memorization)
- [Greedy](./docs/algorithms/basic/Greedy.md)
- [Enumeration](./docs/algorithms/basic/Enumeration.md)

### Sort Algorithms

#### O(n^2) Solutions

- Bubble Sort
- Insertion Sort
- Selection sort
- Shell Sort

#### O(nlogn) Solutions

- Quick Sort
- Merge Sort
- Heap Sort
- Tree Sort

#### O(n) Solutions

- Bucket Sort
- Counting Sort
- Radix Sort

### Search Algorithms

#### Graph Search

- Depth-First Search
- Breadth-First Search
- A-Star(A*) Search

#### Linear List Search

- Linear Search
- Binary Search

#### Search Tree

- Binary Search Tree
- B-tree
- (a,b)-tree

### Other Algorithms

- [Bit Manipulation](./docs/algorithms/BitManipulation.md)
- [Math](./docs/algorithms/Math.md)

### More Readings

- [Introduction to Algorithms](https://mitpress.mit.edu/books/introduction-algorithms-third-edition)
- [MIT 6.006 Introduction to Algorithms](https://www.youtube.com/playlist?list=PLUl4u3cNGP61Oq3tWYp6V_F-5jb5L2iHb)

## System Design

- [System Design Workflow](./docs/system-design/SystemDesignWorkflow.md)
- System Design Patterns

## LeetCode Preparation

[How to use LeetCode](./docs/Leetcode.md)

### Current Status

- **Total**:  307/1406
  - &#x1F4D7;Easy:   142
  - &#x1F4D8;Medium: 141
  - &#x1F4D9;Hard:   24

### Easy Questions

| # | Name | Solution | Algorithm | Note |
|:-:|:----:|:--------:|:---------:|:----:|
|1|[Two Sum](https://leetcode.com/problems/two-sum/)|[Java](./src/easy/array/TwoSum.java) [Python](./src/python/array/2sum.py)| Array/HashMap |
|2|[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)|[Java](./src/medium/linkedlist/AddTwoNumbers.java) [Python](./src/python/linkedlist/add-two-numbers.py)| Linked List |
|7|[Reverse Integer](https://leetcode.com/problems/reverse-integer/)|[Java](./src/easy/number/ReverseInteger.java)| Number |
|9|[Palindrome Number](https://leetcode.com/problems/palindrome-number/)|[Java](./src/easy/number/PalindromeNumber.java)| Number |
|13|[Roman to Integer](https://leetcode.com/problems/roman-to-integer/)|[Java](./src/easy/string/RomanToInteger.java)| BruteForce |
|14|[Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)|[Java](./src/easy/array/LongestCommonPrefix.java)| BruteForce | More [solutions](https://leetcode.com/problems/longest-common-prefix/solution/)|
|15|[Three Sum](https://leetcode.com/problems/3sum/)|[Java](./src/medium/array/ThreeSum.java) [Python](./src/python/array/3sum.py)| Array/Two-Pointer |
|16|[3Sum Closest](https://leetcode.com/problems/3sum-closest/)|[Java](./src/medium/array/ThreeSumClosest.java) [Python](./src/python/array/three-sum-closest.py)| Array/Two-Pointer |
|20|[Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)|[Java](./src/easy/string/ValidParentheses.java) [Python](./src/python/string/valid-parentheses.py)| Stack |
|21|[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)|[Java](./src/easy/linkedlist/MergeTwoSortedLists.java)| BruteForce |
|26|[Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)|[Java](./src/easy/array/RemoveDuplicatesSortedArray.java)| TwoPointer |
|27|[Remove Element](https://leetcode.com/problems/remove-element/)|[Java](./src/easy/array/RemoveElement.java)| BruteForce |
|66|[Plus One](https://leetcode.com/problems/plus-one/)|[Java](./src/easy/array/PlusOne.java)| BruteForce |
|67|[Add Binary](https://leetcode.com/problems/add-binary/)|[Java](./src/easy/string/AddBinary.java)| BruteForce |
|69|[Sqrt(x)](https://leetcode.com/problems/sqrtx/)|[Java](./src/easy/math/Sqrt.java)| Math | Apply [Newton's Method](https://pages.mtu.edu/~shene/COURSES/cs201/NOTES/chap06/sqrt-1.html) |
|70|[Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)|[Java](./src/easy/dp/ClimbingStairs.java)| 1D DP |
|83|[Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)|[Java](./src/easy/linkedlist/RemoveDuplicatesSortedList.java)| TwoPointer |
|88|[Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)|[Java](./src/easy/array/MergeSortedArray.java)| TwoPointer |
|100|[Same Tree](https://leetcode.com/problems/same-tree/)|[Java](./src/easy/tree/SameTree.java)| Recursion |
|101|[Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)|[Java](./src/easy/tree/SymmetricTree.java)| Recursion |
|108|[Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)|[Java](./src/easy/tree/ConvertSortedArrayBST.java)| Recursion |
|110|[Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)|[Java](./src/easy/tree/BalancedBinaryTree.java)| DFS |
|111|[Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)|[Java](./src/easy/tree/MinimumDepthBinaryTree.java)| DFS |
|112|[Path Sum](https://leetcode.com/problems/path-sum/)|[Java](./src/easy/tree/PathSum.java)| DFS |
|118|[Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)|[Java](./src/easy/math/PascalTriangle.java)| BruteForce |
|119|[Pascal's Triangle II](https://leetcode.com/problems/pascals-triangle-ii/)|[Java](./src/easy/math/PascalTriangleII.java)| 1D DP |
|121|[Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)|[Java](./src/easy/array/BestTimeBuySellStock.java)| DP |
|122|[Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)|[Java](./src/easy/array/BestTimeBuySellStockII.java)| Greedy |
|139|[Word Break](https://leetcode.com/problems/word-break/)|[Java](./src/medium/dp/WordBreak.java)| 1D DP |
|231|[Power of Two](https://leetcode.com/problems/power-of-two/)|[Java](./src/easy/number/PowerOfTwo.java)| Bit Manipulation |
|242|[Valid Anagram](https://leetcode.com/problems/valid-anagram/)|[Java](./src/easy/string/ValidAnagram.java)| Counting Sort |
|263|[Ugly Number](https://leetcode.com/problems/ugly-number/)|[Java](./src/easy/number/UglyNumber.java)| Brute-Force |
|278|[First Bad Version](https://leetcode.com/problems/first-bad-version/)|[Java](./src/easy/array/FirstBadVersion.java)| Binary Search |
|283|[Move Zeroes](https://leetcode.com/problems/move-zeroes/)|[Java](./src/easy/array/MoveZeroes.java)| Two-Pointer |
|367|[Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)|[Java](./src/easy/math/ValidPerfectSquare.java)| Math |
|383|[Ransom Note](https://leetcode.com/problems/ransom-note/)|[Java](./src/easy/string/RansomNote.java)| Letter Count |
|437|[Path Sum III](https://leetcode.com/problems/path-sum-iii/)|[Java](./src/easy/tree/PathSumIII.java)| DFS | Deserve as `medium`|
|541|[Reverse String II](https://leetcode.com/problems/reverse-string-ii/)|[Java](./src/easy/string/ReverseStringII.java)| BruteForce |
|551|[Student Attendance Record I](https://leetcode.com/problems/student-attendance-record-i/)|[Java](./src/easy/array/StudentAttendanceRecord.java)| Array |
|557|[Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/)|[Java](./src/easy/string/ReverseWordInStringIII.java)| BruteForce |
|561|[Array Partition I](https://leetcode.com/problems/array-partition-i/)|[Java](./src/easy/array/ArrayPartitionI.java)| Math |
|572|[Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/)|[Java](./src/easy/tree/SubtreeOfAnotherTree.java)| Recursion | [Converting to string](https://leetcode.com/problems/subtree-of-another-tree/solution/) is a brilliant idea |
|575|[Distribute Candies](https://leetcode.com/problems/distribute-candies/)|[Java](./src/easy/array/DistributeCandies.java)| Greedy |
|594|[Longest Harmonious Subsequence](https://leetcode.com/problems/longest-harmonious-subsequence/)|[Java](./src/easy/array/LongestHarmoniousSubsequence.java)| HashMap |
|700|[Search in a Binary Search Tree](https://leetcode.com/problems/search-in-a-binary-search-tree/)|[Java](./src/easy/tree/SearchBinarySearchTree.java)| BinarySearch |
|703|[Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)|[Java](./src/easy/array/KthLargestElementInStream.java)| MinQueue |
|704|[Binary Search](https://leetcode.com/problems/binary-search/)|[Java](./src/easy/array/BinarySearch.java)| BinarySearch |
|709|[To Lower Case](https://leetcode.com/problems/to-lower-case/)|[Java](./src/easy/string/ToLowerCase.java)| String |
|720|[Longest Word in Dictionary](https://leetcode.com/problems/longest-word-in-dictionary/)|[Java](./src/easy/string/LongestWordDictionary.java)| HashSet |
|724|[Find Pivot Index](https://leetcode.com/problems/find-pivot-index/)|[Java](./src/easy/array/FindPivotIndex.java)| Prefix/Suffix Sum |
|728|[Self Dividing Numbers](https://leetcode.com/problems/self-dividing-numbers/)|[Java](./src/easy/number/SelfDividingNumbers.java)| BruteForce |
|733|[Flood Fill](https://leetcode.com/problems/flood-fill/)|[Java](./src/easy/matrix/FloodFill.java)| DFS |
|748|[Shortest Completing Word](https://leetcode.com/problems/shortest-completing-word/)|[Java](./src/easy/string/ShortestCompletingWord.java)| String |
|746|[Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)|[Java](./src/easy/array/MinCostClimbingStairs.java)| 1D DP |
|766|[Toeplitz Matrix](https://leetcode.com/problems/matrix-block-sum/)|[Java](./src/easy/matrix/ToeplitzMatrix.java)| Matrix |
|771|[Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)|[Java](./src/easy/string/JewelsStones.java)| Set |
|783|[Minimum Distance Between BST Nodes](https://leetcode.com/problems/minimum-distance-between-bst-nodes/)|[Java](./src/easy/tree/MinimumDistanceBSTNodes.java)| DFS |
|788|[Rotated Digits](https://leetcode.com/problems/rotated-digits/)|[Java](./src/easy/dp/RotatedDigits.java)| Array/DP | There is O(lgn) [solution](https://leetcode.com/problems/rotated-digits/discuss/264282/Java-O(logN)-0ms-100), but very tricky! |
|796|[Rotate String](https://leetcode.com/problems/rotate-string/)|[Java](./src/easy/string/RotateString.java)| String/BruteForce | The [rolling hash](https://leetcode.com/problems/rotate-string/solution/) solution is great! |
|821|[Shortest Distance to a Character](https://leetcode.com/problems/shortest-distance-to-a-character/)|[Java](./src/easy/array/ShortestDistanceCharacter.java)| MinArray |
|852|[Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/)|[Java](./src/easy/array/PeakIndexInMountainArray.java)| Array/BinarySearch |
|844|[Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/)|[Java](./src/easy/string/BackspaceStringCompare.java)| Stack | Two pointers starting from the end is better in term of space performance |
|849|[Maximize Distance to Closest Person](https://leetcode.com/problems/maximize-distance-to-closest-person/)|[Java](./src/easy/dp/MaximizeDistanceClosestPerson.java)| DP |
|859|[Buddy Strings](https://leetcode.com/problems/buddy-strings/)|[Java](./src/easy/string/BuddyStrings.java)| StringLoop/LetterCount |
|860|[Lemonade Change](https://leetcode.com/problems/lemonade-change/)|[Java](./src/easy/array/LemonadeChange.java)| Greedy |
|867|[Transpose Matrix](https://leetcode.com/problems/transpose-matrix/)|[Java](./src/easy/matrix/TransposeMatrix.java)| Loop |
|872|[Leaf-Similar Trees](https://leetcode.com/problems/leaf-similar-trees/)|[Java](./src/easy/tree/LeafSimilarTrees.java)| DFS |
|876|[Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)|[Java](./src/easy/linked-list/MiddleLinkedList.java)| LinkedList |
|884|[Uncommon Words from Two Sentences](https://leetcode.com/problems/uncommon-words-from-two-sentences/)|[Java](./src/string/UncommonWordsTwoSentences.java)| String |
|905|[Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/)|[Java](./src/easy/array/SortArrayByParity.java)| Array |
|908|[Smallest Range I](https://leetcode.com/problems/smallest-range-i/)|[Java](./src/easy/math/SmallestRangeI.java)| Math |
|917|[Reverse Only Letters](https://leetcode.com/problems/reverse-only-letters/)|[Java](./src/easy/string/ReverseOnlyLetters.java)| String/TwoPointer |
|922|[Sort Array By Parity II](https://leetcode.com/problems/sort-array-by-parity-ii/)|[Java](./src/easy/array/SortArrayParityII.java)| Read/Write Head |
|994|[Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)|[Java](./src/easy/matrix/RottingOranges.java)| BFS |
|1022|[Sum of Root To Leaf Binary Numbers](https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/)|[Java](./src/easy/tree/SumRootLeafBinaryNumbers.java)| DFS |
|1047|[Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)|[Java](./src/easy/string/RemoveAllAdjacentDuplicatesString.java)| Stack |
|1281|[Subtract the Product and Sum of Digits of an Integer](https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/)|[Java](./src/easy/number/SubtractProductSumDigitsInteger.java)| Number |
|1337|[The K Weakest Rows in a Matrix](https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/)|[Java](./src/easy/matrix/KWeakestRowsInMatrix.java)| MaxQueue |

### Medium Questions

| # | Name | Solution | Algorithm | Note |
|:-:|:----:|:--------:|:---------:|:----:|
|3|[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)|[Java](./src/medium/string/LongestSubstringWithoutRepeatingCharacters.java)| Two-Pointer |
|5|[Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)|[Java](./src/medium/dp/LongestPalindromicSubstring.java)| DP |
|6|[ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/)|[Java](./src/medium/string/ZigZagConversion.java)| String |
|8|[String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi)|[Java](./src/medium/string/StringToIngeter.java)| String |
|18|[4Sum](https://leetcode.com/problems/4sum/)|[Java](./src/medium/array/FourSum.java)| Two-Pointer |
|31|[Next Permutation](https://leetcode.com/problems/next-permutation/)|[Java](./src/medium/math/NextPermutation.java)| Math |
|36|[Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)|[Java](./src/medium/matrix/ValidSudoku.java)| Matrix |
|39|[Combination Sum](https://leetcode.com/problems/combination-sum/)|[Java](./src/medium/backtracking/CombinationSum.java)| Backtracking (DFS) |
|40|[Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)|[Java](./src/medium/backtracking/CombinationSumII.java)| Backtracking (DFS) |
|46|[Permutations](https://leetcode.com/problems/permutations/)|[Java](./src/medium/array/Permutations.java)| Backtracking (BFS & DFS) |
|47|[Permutations II](https://leetcode.com/problems/permutations-ii/)|[Java](./src/medium/array/PermutationsUnique.java)| Backtracking (BFS & DFS) |
|49|[Group Anagrams](https://leetcode.com/problems/group-anagrams/)|[Java](./src/medium/string/GroupAnagrams.java)| HashMap/String Signature |
|50|[Pow(x, n)](https://leetcode.com/problems/powx-n/)|[Java](./src/medium/math/Pow.java)| Math |
|55|[Jump Game](https://leetcode.com/problems/jump-game/)|[Java](./src/medium/greedy/JumpGame.java)| Greedy |
|62|[Unique Paths](https://leetcode.com/problems/unique-paths/)|[Java](./src/medium/dp/UniquePaths.java)| 2D DP |
|63|[Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)|[Java](./src/medium/dp/UniquePathsII.java)| 2D DP |
|64|[Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)|[Java](./src/medium/matrix/MinPathSum.java)| 2D DP |
|77|[Combinations](https://leetcode.com/problems/combinations/)|[Java](./src/medium/backtracking/Combinations.java)| Backtracking (DFS) |
|78|[Subsets](https://leetcode.com/problems/subsets/)|[Java](./src/medium/array/Subsets.java)| Backtracking (BFS & DFS) |
|90|[Subsets II](https://leetcode.com/problems/subsets-ii/)|[Java](./src/medium/array/SubsetsII.java)| Backtracking (BFS & DFS) |
|91|[Decode Ways](https://leetcode.com/problems/decode-ways/)|[Java](./src/medium/dp/DecodeWays.java)| 1D DP |
|94|[Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)|[Java](./src/medium/tree/BinaryTreeInorderTraversal.java)| Tree Traversal |
|96|[Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees/)|[Java](./src/medium/dp/UniqueBinarySearchTree.java)| 1D DP | Optimized from 2D to 1D |
|102|[Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)|[Java](./src/medium/tree/BinaryTreeLevelOrderTraversal.java)| DFS & BFS |
|103|[Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)|[Java](./src/medium/tree/BinaryTreeLevelOrderTraversal.java)| DFS & BFS |
|113|[Path Sum II](https://leetcode.com/problems/path-sum-ii/)|[Java](./src/medium/tree/PathSumII.java)| Backtracking (DFS) |
|120|[Triangle](https://leetcode.com/problems/triangle/)|[Java](./src/medium/dp/Triangle.java)| 1D DP |
|127|[Word Ladder](https://leetcode.com/problems/word-ladder/)|[Java](./src/medium/string/WordLadder.java)| Backtracking (BFS & DFS) | LeetCode needs some [optimization](https://leetcode.com/problems/word-ladder/solution/) to pass TLE, which I think is an overkill|
|211|[Add and Search Word - Data structure design](https://leetcode.com/problems/add-and-search-word-data-structure-design/)|[Java](./src/medium/string/WordDictionary.java)| Trie+Backtracking |
|216|[Combination Sum III](https://leetcode.com/problems/combination-sum-iii/)|[Java](./src/medium/backtracking/CombinationSumIII.java)| Backtracking (DFS) |
|229|[Majority Element II](https://leetcode.com/problems/majority-element-ii/) | [Java](./src/medium/array/MajorityElementII.java)| Boyer-Moore Majority Voting Algorithm |
|230|[Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | [Java](./src/medium/tree/KthSmallestElementInBST.java)| BST/DFS |
|234|[Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | [Java](./src/easy/linkedlist/PalindromeLinkedList.java)| Two-Pointer | [Reversing a list is not considered "O(1) space"](https://leetcode.com/problems/palindrome-linked-list/discuss/64493/Reversing-a-list-is-not-considered-%22O(1)-space%22) |
|274|[H-Index](https://leetcode.com/problems/h-index/) | [Java](./src/medium/array/HIndex.java)| Array/Sort/Map |
|322|[Coin Change](https://leetcode.com/problems/coin-change/) | [Java](./src/medium/dp/CoinChange.java)| 1D DP |
|376|[Wiggle Subsequence](https://leetcode.com/problems/wiggle-subsequence/) | [Java](./src/medium/dp/WiggleSubsequence.java)| 1D DP |
|377|[Combination Sum IV](https://leetcode.com/problems/combination-sum-iv/) | [Java](./src/medium/dp/CombinationSumIV.java)| 1D DP |
|739|[Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) | [Java](./src/medium/array/DailyTemperatures.java)| Stack |
|1110|[Delete Nodes And Return Forest](https://leetcode.com/problems/delete-nodes-and-return-forest/) | [Java](./src/DeleteNodesAndReturnForest.java)| Tree/Recursion/DFS |
|1302|[Deepest Leaves Sum](https://leetcode.com/problems/deepest-leaves-sum/) | [Java](./src/medium/tree/DeepestLeavesSum.java)| DFS |
|1306|[Jump Game III](https://leetcode.com/problems/jump-game-iii/) | [Java](./src/medium/array/JumpGameIII.java)| Recursion |
|1339|[Maximum Product of Splitted Binary Tree](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/) | [Java](./src/medium/tree/MaximumProductSplittedBinaryTree.java)| Tree/Recursion |

### Hard Questions

| # | Name | Solution | Algorithm | Note |
|:-:|:----:|:--------:|:---------:|:----:|
|10|[Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/) | [Java](./src/hard/string/RegularExpressionMatching.java)| Backtracking |
|37|[Sudoku Solver](https://leetcode.com/problems/sudoku-solver/) | [Java](./src/hard/matrix/SudokuSolver.java)| Backtracking |
|43|[Multiply Strings](https://leetcode.com/problems/multiply-strings/) | [Java](./src/medium/string/MultiplyStrings.java)| Brute-Force |
|44|[Wildcard Matching](https://leetcode.com/problems/wildcard-matching/) | [Java](./src/hard/string/WildcardMatching.java)| Backtracking/Two-Pointer |
|45|[Jump Game II](https://leetcode.com/problems/jump-game-ii/) | [Java](./src/hard/dp/JumpGameII.java)| 1D DP/Greedy |
|76|[Minimum Window Substring](https://leetcode.com/problems/jump-game-ii/) | [Java](./src/hard/string/MinimumWindowSubstring.java)| Sliding Window |
|84|[Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) | [Java](./src/hard/stack/LargestRectangleHistogram.java)| Stack |
|85|[Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/) | [Java](./src/hard/matrix/MaximalRectangle.java)| 2D DP |
|123|[Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/) | [Java](./src/easy/array/BestTimeBuySellStockII.java)| 1D DP |
|135|[Candy](https://leetcode.com/problems/candy/) | [Java](./src/hard/greedy/Candy.java)| Greedy |
|140|[Word Break II](https://leetcode.com/problems/word-break-ii/) | [Java](./src/hard/string/WordBreakII.java)| 1D DP + DFS |
|239|[Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | [Java](./src/hard/deque/SlidingWindowMaximum.java)| Deque |
|297|[Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | [Java](./src/hard/tree/SerializeDeserializeBinaryTree.java)| Tree/DFS/Queue |
|980|[Unique Paths III](https://leetcode.com/problems/unique-paths-iii/) | [Java](./src/hard/matrix/UniquePathsIII.java)| Backtracking (DFS) |
