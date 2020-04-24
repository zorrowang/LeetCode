# LeetCode

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
- [System Design](#system-design)
- [LeetCode Preparation](#leetcode-preparation)
  - [Current Status](#current-status)
  - [Easy Questions](#easy-questions)
  - [Medium Questions](#medium-questions)
  - [Hard Questions](#hard-questions)

<!-- /MarkdownTOC -->

The repo is the summary for technical interview based on my experience and knowledge.

## Interview Preparation

The hiring flow is, resume screening -> recruiter call -> technical phone screening -> onsite -> hiring committee debrief -> decision call. In general, the more we prepare, the better offer we could get.

- [Mindset](./docs/tech-interview/Mindset.md)
- [Self Introduction](./docs/tech-interview/SelfIntroduction.md)
- [Phone Screen](./docs/tech-interview/PhoneScreen.md)
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

This section covers the algorithms in tech interviews. Given the restriction of whiteboard coding, most of questions can be solved in ~50 lines of code. So I'd like to summarize most of the patterns in the tech interview.

This book, [Introduction to Algorithms](https://mitpress.mit.edu/books/introduction-algorithms-third-edition), and their class, [MIT 6.006 Introduction to Algorithms](https://www.youtube.com/playlist?list=PLUl4u3cNGP61Oq3tWYp6V_F-5jb5L2iHb), are very helpful and comprehensive if you want to learn algorithm and data structure.

- [Backtracking](./docs/algorithms/Backtracking.md)
- [Bit Manipulation](./docs/algorithms/BitManipulation.md)
- [Dynamic Programming](./docs/algorithms/DynamicProgramming.md)
  - [Memorization](./docs/algorithms/Memorization.md)
- [Greedy](./docs/algorithms/Greedy.md)
- [Math](./docs/algorithms/Math.md)
- [Sort](./docs/algorithms/Sort.md)
- [Search](./docs/algorithms/Search.md)
  - Binary Search
- [Recursion](./docs/algorithms/Recursion.md)
  - Divide and Conquer

## System Design

- [System Design Workflow](./docs/system-design/SystemDesignWorkflow.md)
- System Design Patterns

## LeetCode Preparation

[How to use LeetCode](./docs/Leetcode.md)

### Current Status

- **Total**:  281/1406
  - &#x1F4D7;Easy:   139
  - &#x1F4D8;Medium: 123
  - &#x1F4D9;Hard:   19

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
|83|[Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)|[Java](./src/easy/linkedlist/RemoveDuplicatesSortedList.java)| TwoPointer |
|88|[Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)|[Java](./src/easy/array/MergeSortedArray.java)| TwoPointer |
|108|[Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)|[Java](./src/easy/tree/ConvertSortedArrayBST.java)| Recursion |
|112|[Path Sum](https://leetcode.com/problems/path-sum/)|[Java](./src/easy/tree/PathSum.java)| DFS |
|118|[Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)|[Java](./src/easy/math/PascalTriangle.java)| BruteForce |
|119|[Pascal's Triangle II](https://leetcode.com/problems/pascals-triangle-ii/)|[Java](./src/easy/math/PascalTriangleII.java)| 1D DP |
|139|[Word Break](https://leetcode.com/problems/word-break/)|[Java](./src/medium/dp/WordBreak.java)| 1D DP |
|231|[Power of Two](https://leetcode.com/problems/power-of-two/)|[Java](./src/easy/number/PowerOfTwo.java)| Bit Manipulation |
|283|[Move Zeroes](https://leetcode.com/problems/move-zeroes/)|[Java](./src/easy/array/MoveZeroes.java)| TODO |
|367|[Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)|[Java](./src/easy/math/ValidPerfectSquare.java)| Math |
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
|852|[Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/)|[Java](./src/PeakIndexInMountainArray.java)| Array/BinarySearch |
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
|36|[Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)|[Java](./src/medium/matrix/ValidSudoku.java)| Matrix |
|46|[Permutations](https://leetcode.com/problems/permutations/)|[Java](./src/medium/array/Permutations.java)| Backtracking (BFS & DFS) |
|47|[Permutations II](https://leetcode.com/problems/permutations-ii/)|[Java](./src/medium/array/PermutationsUnique.java)| Backtracking (BFS & DFS) |
|78|[Subsets](https://leetcode.com/problems/subsets/)|[Java](./src/medium/array/Subsets.java)| Backtracking (BFS & DFS) |
|90|[Subsets II](https://leetcode.com/problems/subsets-ii/)|[Java](./src/medium/array/SubsetsII.java)| Backtracking (BFS & DFS) |
|91|[Decode Ways](https://leetcode.com/problems/decode-ways/)|[Java](./src/medium/dp/DecodeWays.java)| 1D DP |
|96|[Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees/)|[Java](./src/medium/dp/UniqueBinarySearchTree.java)| 1D DP | Optimized from 2D to 1D |
|127|[Word Ladder](https://leetcode.com/problems/word-ladder/)|[Java](./src/medium/string/WordLadder.java)| Backtracking (BFS & DFS) | LeetCode needs some [optimization](https://leetcode.com/problems/word-ladder/solution/) to pass TLE, which I think is an overkill|
|229|[Majority Element II](https://leetcode.com/problems/majority-element-ii/) | [Java](./src/medium/array/MajorityElementII.java)| Boyer-Moore Majority Voting Algorithm |
|230|[Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | [Java](./src/medium/tree/KthSmallestElementInBST.java)| BST/DFS |
|274|[H-Index](https://leetcode.com/problems/h-index/) | [Java](./src/medium/array/HIndex.java)| Array/Sort/Map |
|739|[Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) | [Java](./src/DailyTemperatures.java)| Heap/MaxQueue |
|1110|[Delete Nodes And Return Forest](https://leetcode.com/problems/delete-nodes-and-return-forest/) | [Java](./src/DeleteNodesAndReturnForest.java)| Tree/Recursion/DFS |
|1302|[Deepest Leaves Sum](https://leetcode.com/problems/deepest-leaves-sum/) | [Java](./src/DeepestLeavesSum.java)| Tree/Recursion/DFS |
|1339|[Maximum Product of Splitted Binary Tree](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/) | [Java](./src/medium/tree/MaximumProductSplittedBinaryTree.java)| Tree/Recursion |

### Hard Questions

| # | Name | Solution | Algorithm | Note |
|:-:|:----:|:--------:|:---------:|:----:|
|10|[Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/) | [Java](./src/hard/string/RegularExpressionMatching.java)| Backtracking |
|37|[Sudoku Solver](https://leetcode.com/problems/sudoku-solver/) | [Java](./src/hard/matrix/SudokuSolver.java)| Backtracking |
|44|[Wildcard Matching](https://leetcode.com/problems/wildcard-matching/) | [Java](./src/hard/string/WildcardMatching.java)| Backtracking/Two-Pointer |
|84|[Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) | [Java](./src/hard/stack/LargestRectangleHistogram.java)| Stack |
|85|[Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/) | [Java](./src/hard/matrix/MaximalRectangle.java)| 2D DP |
|140|[Word Break II](https://leetcode.com/problems/word-break-ii/) | [Java](./src/hard/string/WordBreakII.java)| 1D DP + DFS |
|239|[Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | [Java](./src/hard/deque/SlidingWindowMaximum.java)| Deque |
|297|[Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | [Java](./src/hard/tree/SerializeDeserializeBinaryTree.java)| Tree/DFS/Queue |
