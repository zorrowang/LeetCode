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

- **input**: an algorithm has zero or more inputs, taken from a specified set of objects.
- **output**: an algorithm has one or more outputs, which have a specified relation to the inputs.
- **finiteness**: the algorithm must always terminate after a finite number of steps.
- **definiteness**: Each step must be precisely defined; the actions to be carried out must be rigorously and unambiguously specified for each case.
- **effectiveness**: all operations to be performed must be sufficiently basic that they can be done exactly and in finite length.

As the restriction of whiteboard coding and the properties of algorithm, most of interview questions can be resolved in ~50 lines of code.

### Algorithm Complexity

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

- **Total**:  312/1406
  - &#x1F4D7;Easy:   142
  - &#x1F4D8;Medium: 145
  - &#x1F4D9;Hard:   25

### Easy Questions

| # | Name | Solution | Algorithm | Note |
|:-:|:----:|:--------:|:---------:|:----:|
|1|[Two Sum](https://leetcode.com/problems/two-sum/)|[Java](./src/java/easy/array/TwoSum.java) [Python](./src/python/array/2sum.py)| HashMap |
|7|[Reverse Integer](https://leetcode.com/problems/reverse-integer/)|[Java](./src/java/easy/number/ReverseInteger.java)| Number |
|9|[Palindrome Number](https://leetcode.com/problems/palindrome-number/)|[Java](./src/java/easy/number/PalindromeNumber.java)| Number |
|13|[Roman to Integer](https://leetcode.com/problems/roman-to-integer/)|[Java](./src/java/easy/string/RomanToInteger.java)| BruteForce |
|14|[Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)|[Java](./src/java/easy/array/LongestCommonPrefix.java)| BruteForce | More [solutions](https://leetcode.com/problems/longest-common-prefix/solution/)|
|20|[Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)|[Java](./src/java/easy/string/ValidParentheses.java) [Python](./src/python/string/valid-parentheses.py)| Stack |
|21|[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)|[Java](./src/java/easy/linkedlist/MergeTwoSortedLists.java)| BruteForce |
|26|[Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)|[Java](./src/java/easy/array/RemoveDuplicatesSortedArray.java)| Two-Pointer |
|27|[Remove Element](https://leetcode.com/problems/remove-element/)|[Java](./src/java/easy/array/RemoveElement.java)| BruteForce |
|53|[Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)|[Java](./src/java/easy/dp/MaximumSubarray.java)| DP |
|58|[Length of Last Word](https://leetcode.com/problems/length-of-last-word/)|[Java](./src/java/easy/string/LengthLastWord.java)| String |
|66|[Plus One](https://leetcode.com/problems/plus-one/)|[Java](./src/java/easy/array/PlusOne.java)| BruteForce |
|67|[Add Binary](https://leetcode.com/problems/add-binary/)|[Java](./src/java/easy/string/AddBinary.java)| BruteForce |
|69|[Sqrt(x)](https://leetcode.com/problems/sqrtx/)|[Java](./src/java/easy/math/Sqrt.java)| Math | Apply [Newton's Method](https://pages.mtu.edu/~shene/COURSES/cs201/NOTES/chap06/sqrt-1.html) |
|70|[Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)|[Java](./src/java/easy/dp/ClimbingStairs.java)| 1D DP |
|83|[Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)|[Java](./src/java/easy/linkedlist/RemoveDuplicatesSortedList.java)| Two-Pointer |
|88|[Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)|[Java](./src/java/easy/array/MergeSortedArray.java)| Two-Pointer |
|100|[Same Tree](https://leetcode.com/problems/same-tree/)|[Java](./src/java/easy/tree/SameTree.java)| Recursion |
|101|[Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)|[Java](./src/java/easy/tree/SymmetricTree.java)| Recursion |
|108|[Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)|[Java](./src/java/easy/tree/ConvertSortedArrayBST.java)| Recursion |
|110|[Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)|[Java](./src/java/easy/tree/BalancedBinaryTree.java)| DFS |
|111|[Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)|[Java](./src/java/easy/tree/MinimumDepthBinaryTree.java)| DFS |
|112|[Path Sum](https://leetcode.com/problems/path-sum/)|[Java](./src/java/easy/tree/PathSum.java)| DFS |
|118|[Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)|[Java](./src/java/easy/math/PascalTriangle.java)| BruteForce |
|119|[Pascal's Triangle II](https://leetcode.com/problems/pascals-triangle-ii/)|[Java](./src/java/easy/math/PascalTriangleII.java)| 1D DP |
|121|[Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)|[Java](./src/java/easy/array/BestTimeBuySellStock.java)| DP |
|122|[Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)|[Java](./src/java/easy/array/BestTimeBuySellStockII.java)| Greedy |
|125|[Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)|[Java](./src/java/easy/string/ValidPalindrome.java)| Two-Pointer |
|155|[Min Stack](https://leetcode.com/problems/min-stack/)|[Java](./src/java/easy/stack/MinStack.java)| Stack |
|167|[Two Sum II - Input array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)|[Java](./src/java/easy/array/TwoSumII.java)| Two-Pointer |
|168|[Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title/)|[Java](./src/java/easy/number/ExcelSheetColumnTitle.java)| Math |
|171|[Excel Sheet Column Number](https://leetcode.com/problems/excel-sheet-column-number/)|[Java](./src/java/easy/number/ExcelSheetColumnNumber.java)| Math |
|198|[House Robber](https://leetcode.com/problems/house-robber/)|[Java](./src/java/easy/dp/HouseRobber.java)| 1D DP |
|213|[House Robber II](https://leetcode.com/problems/house-robber-ii/)|[Java](./src/java/medium/dp/HouseRobberII.java)| 1D DP |
|231|[Power of Two](https://leetcode.com/problems/power-of-two/)|[Java](./src/java/easy/number/PowerOfTwo.java)| Bit Manipulation |
|234|[Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | [Java](./src/java/easy/linkedlist/PalindromeLinkedList.java)| Two-Pointer | [Reversing a list is not considered "O(1) space"](https://leetcode.com/problems/palindrome-linked-list/discuss/64493/Reversing-a-list-is-not-considered-%22O(1)-space%22) |
|242|[Valid Anagram](https://leetcode.com/problems/valid-anagram/)|[Java](./src/java/easy/string/ValidAnagram.java)| Counting Sort |
|263|[Ugly Number](https://leetcode.com/problems/ugly-number/)|[Java](./src/java/easy/number/UglyNumber.java)| Brute-Force |
|278|[First Bad Version](https://leetcode.com/problems/first-bad-version/)|[Java](./src/java/easy/array/FirstBadVersion.java)| Binary Search |
|283|[Move Zeroes](https://leetcode.com/problems/move-zeroes/)|[Java](./src/java/easy/array/MoveZeroes.java)| Two-Pointer |
|337|[House Robber III](https://leetcode.com/problems/house-robber-iii/)|[Java](./src/java/medium/backtracking/HouseRobberIII.java)| Backtracking (DFS) |
|367|[Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)|[Java](./src/java/easy/math/ValidPerfectSquare.java)| Math |
|383|[Ransom Note](https://leetcode.com/problems/ransom-note/)|[Java](./src/java/easy/string/RansomNote.java)| Letter Count |
|437|[Path Sum III](https://leetcode.com/problems/path-sum-iii/)|[Java](./src/java/easy/tree/PathSumIII.java)| DFS | Deserve as `medium`|
|541|[Reverse String II](https://leetcode.com/problems/reverse-string-ii/)|[Java](./src/java/easy/string/ReverseStringII.java)| BruteForce |
|551|[Student Attendance Record I](https://leetcode.com/problems/student-attendance-record-i/)|[Java](./src/java/easy/array/StudentAttendanceRecord.java)| Array |
|557|[Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/)|[Java](./src/java/easy/string/ReverseWordInStringIII.java)| BruteForce |
|561|[Array Partition I](https://leetcode.com/problems/array-partition-i/)|[Java](./src/java/easy/array/ArrayPartitionI.java)| Math |
|572|[Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/)|[Java](./src/java/easy/tree/SubtreeOfAnotherTree.java)| Recursion | [Converting to string](https://leetcode.com/problems/subtree-of-another-tree/solution/) is a brilliant idea |
|575|[Distribute Candies](https://leetcode.com/problems/distribute-candies/)|[Java](./src/java/easy/array/DistributeCandies.java)| Greedy |
|594|[Longest Harmonious Subsequence](https://leetcode.com/problems/longest-harmonious-subsequence/)|[Java](./src/java/easy/array/LongestHarmoniousSubsequence.java)| HashMap |
|628|[Maximum Product of Three Numbers](https://leetcode.com/problems/maximum-product-of-three-numbers/)|[Java](./src/java/easy/array/MaximumProductThreeNumbers.java)| Greedy? |
|700|[Search in a Binary Search Tree](https://leetcode.com/problems/search-in-a-binary-search-tree/)|[Java](./src/java/easy/tree/SearchBinarySearchTree.java)| BinarySearch |
|703|[Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)|[Java](./src/java/easy/array/KthLargestElementInStream.java)| MinQueue |
|704|[Binary Search](https://leetcode.com/problems/binary-search/)|[Java](./src/java/easy/array/BinarySearch.java)| BinarySearch |
|709|[To Lower Case](https://leetcode.com/problems/to-lower-case/)|[Java](./src/java/easy/string/ToLowerCase.java)| String |
|720|[Longest Word in Dictionary](https://leetcode.com/problems/longest-word-in-dictionary/)|[Java](./src/java/easy/string/LongestWordDictionary.java)| HashSet |
|724|[Find Pivot Index](https://leetcode.com/problems/find-pivot-index/)|[Java](./src/java/easy/array/FindPivotIndex.java)| Prefix/Suffix Sum |
|728|[Self Dividing Numbers](https://leetcode.com/problems/self-dividing-numbers/)|[Java](./src/java/easy/number/SelfDividingNumbers.java)| BruteForce |
|733|[Flood Fill](https://leetcode.com/problems/flood-fill/)|[Java](./src/java/easy/matrix/FloodFill.java)| DFS |
|748|[Shortest Completing Word](https://leetcode.com/problems/shortest-completing-word/)|[Java](./src/java/easy/string/ShortestCompletingWord.java)| String |
|746|[Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)|[Java](./src/java/easy/array/MinCostClimbingStairs.java)| 1D DP |
|766|[Toeplitz Matrix](https://leetcode.com/problems/matrix-block-sum/)|[Java](./src/java/easy/matrix/ToeplitzMatrix.java)| Matrix |
|771|[Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)|[Java](./src/java/easy/string/JewelsStones.java)| Set |
|783|[Minimum Distance Between BST Nodes](https://leetcode.com/problems/minimum-distance-between-bst-nodes/)|[Java](./src/java/easy/tree/MinimumDistanceBSTNodes.java)| DFS |
|788|[Rotated Digits](https://leetcode.com/problems/rotated-digits/)|[Java](./src/java/easy/dp/RotatedDigits.java)| DP | There is O(lgn) [solution](https://leetcode.com/problems/rotated-digits/discuss/264282/Java-O(logN)-0ms-100), but very tricky! |
|796|[Rotate String](https://leetcode.com/problems/rotate-string/)|[Java](./src/java/easy/string/RotateString.java)| String/BruteForce | The [rolling hash](https://leetcode.com/problems/rotate-string/solution/) solution is great! |
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
|11|[Container With Most Water](https://leetcode.com/problems/container-with-most-water/)|[Java](./ssrc/java/medium/greedy/ContainerWithMostWater.java)| Two-Pointer/Greedy |
|15|[Three Sum](https://leetcode.com/problems/3sum/)|[Java](./src/java/medium/array/ThreeSum.java) [Python](./src/python/array/3sum.py)| Two-Pointer |
|16|[3Sum Closest](https://leetcode.com/problems/3sum-closest/)|[Java](./src/java/medium/array/ThreeSumClosest.java) [Python](./src/python/array/three-sum-closest.py)| Two-Pointer |
|18|[4Sum](https://leetcode.com/problems/4sum/)|[Java](./src/java/medium/array/FourSum.java)| Two-Pointer |
|31|[Next Permutation](https://leetcode.com/problems/next-permutation/)|[Java](./src/java/medium/math/NextPermutation.java)| Math |
|36|[Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)|[Java](./src/java/medium/matrix/ValidSudoku.java)| Matrix |
|39|[Combination Sum](https://leetcode.com/problems/combination-sum/)|[Java](./src/java/medium/backtracking/CombinationSum.java)| Backtracking (DFS) |
|40|[Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)|[Java](./src/java/medium/backtracking/CombinationSumII.java)| Backtracking (DFS) |
|43|[Multiply Strings](https://leetcode.com/problems/multiply-strings/) | [Java](./src/java/medium/string/MultiplyStrings.java)| Brute-Force |
|46|[Permutations](https://leetcode.com/problems/permutations/)|[Java](./src/java/medium/array/Permutations.java)| Backtracking (BFS & DFS) |
|47|[Permutations II](https://leetcode.com/problems/permutations-ii/)|[Java](./src/java/medium/array/PermutationsUnique.java)| Backtracking (BFS & DFS) |
|49|[Group Anagrams](https://leetcode.com/problems/group-anagrams/)|[Java](./src/java/medium/string/GroupAnagrams.java)| HashMap/String Signature |
|50|[Pow(x, n)](https://leetcode.com/problems/powx-n/)|[Java](./src/java/medium/math/Pow.java)| Math |
|55|[Jump Game](https://leetcode.com/problems/jump-game/)|[Java](./src/java/medium/greedy/JumpGame.java)| Greedy |
|62|[Unique Paths](https://leetcode.com/problems/unique-paths/)|[Java](./src/java/medium/dp/UniquePaths.java)| 2D DP |
|63|[Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)|[Java](./src/java/medium/dp/UniquePathsII.java)| 2D DP |
|64|[Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)|[Java](./src/java/medium/matrix/MinPathSum.java)| 2D DP |
|73|[Set Matrix Zeros](https://leetcode.com/problems/combinations/)|[Java](./src/java/medium/matrix/SetMatrixZeros.java)| Matrix |
|77|[Combinations](https://leetcode.com/problems/combinations/)|[Java](./src/java/medium/backtracking/Combinations.java)| Backtracking (DFS) |
|78|[Subsets](https://leetcode.com/problems/subsets/)|[Java](./src/java/medium/array/Subsets.java)| Backtracking (BFS & DFS) |
|79|[Word Search](https://leetcode.com/problems/word-search/)|[Java](./src/java/medium/backtracking/WordSearch.java)| Backtracking (DFS) |
|90|[Subsets II](https://leetcode.com/problems/subsets-ii/)|[Java](./src/java/medium/array/SubsetsII.java)| Backtracking (BFS & DFS) |
|91|[Decode Ways](https://leetcode.com/problems/decode-ways/)|[Java](./src/java/medium/dp/DecodeWays.java)| 1D DP |
|93|[Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/)|[Java](./src/java/medium/backtracking/RestoreIPAddresses.java)| Backtracking & Greedy |
|94|[Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)|[Java](./src/java/medium/tree/BinaryTreeInorderTraversal.java)| Tree Traversal |
|96|[Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees/)|[Java](./src/java/medium/dp/UniqueBinarySearchTree.java)| 1D DP | Optimized from 2D to 1D |
|98|[Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)|[Java](./src/java/medium/tree/ValidateBinarySearchTree.java)| DFS |
|102|[Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)|[Java](./src/java/medium/tree/BinaryTreeLevelOrderTraversal.java)| DFS & BFS |
|103|[Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)|[Java](./src/java/medium/tree/BinaryTreeLevelOrderTraversal.java)| DFS & BFS |
|113|[Path Sum II](https://leetcode.com/problems/path-sum-ii/)|[Java](./src/java/medium/tree/PathSumII.java)| Backtracking (DFS) |
|114|[Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)|[Java](./src/java/medium/tree/FlattenBinaryTreeLinkedList.java)| BFS & DFS |
|120|[Triangle](https://leetcode.com/problems/triangle/)|[Java](./src/java/medium/dp/Triangle.java)| 1D DP |
|127|[Word Ladder](https://leetcode.com/problems/word-ladder/)|[Java](./src/java/medium/string/WordLadder.java)| Backtracking (BFS & DFS) | LeetCode needs some [optimization](https://leetcode.com/problems/word-ladder/solution/) to pass TLE, which I think is an overkill|
|139|[Word Break](https://leetcode.com/problems/word-break/)|[Java](./src/java/medium/dp/WordBreak.java)| 1D DP |
|162|[Find Peak Element](https://leetcode.com/problems/find-peak-element/)|[Java](./src/java/medium/array/FindPeakElement.java)| BinarySearch |
|163|[Missing Ranges](https://leetcode.com/problems/missing-ranges)|[Java](./src/java/medium/array/MissingRanges.java)| Brute-Force | LintCode [641](https://www.lintcode.com/problem/missing-ranges/description) |
|211|[Add and Search Word - Data structure design](https://leetcode.com/problems/add-and-search-word-data-structure-design/)|[Java](./src/java/medium/string/WordDictionary.java)| Trie+Backtracking |
|216|[Combination Sum III](https://leetcode.com/problems/combination-sum-iii/)|[Java](./src/java/medium/backtracking/CombinationSumIII.java)| Backtracking (DFS) |
|229|[Majority Element II](https://leetcode.com/problems/majority-element-ii/) | [Java](./src/java/medium/array/MajorityElementII.java)| Boyer-Moore Majority Voting Algorithm |
|230|[Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | [Java](./src/java/medium/tree/KthSmallestElementInBST.java)| DFS |
|274|[H-Index](https://leetcode.com/problems/h-index/) | [Java](./src/java/medium/array/HIndex.java)| Sort & Map |
|279|[Perfect Squares](https://leetcode.com/problems/perfect-squares/) | [Java](./src/java/medium/dp/PerfectSquares.java)| 1D DP |
|322|[Coin Change](https://leetcode.com/problems/coin-change/) | [Java](./src/java/medium/dp/CoinChange.java)| 1D DP |
|376|[Wiggle Subsequence](https://leetcode.com/problems/wiggle-subsequence/) | [Java](./src/java/medium/dp/WiggleSubsequence.java)| 1D DP |
|377|[Combination Sum IV](https://leetcode.com/problems/combination-sum-iv/) | [Java](./src/java/medium/dp/CombinationSumIV.java)| 1D DP |
|416|[Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/) | [Java](./src/java/medium/dp/PartitionEqualSubsetSum.java)| DP ([Knapsack Model](./docs/algorithms/basic/DynamicProgramming.md#knapsack-model)) |
|739|[Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) | [Java](./src/java/medium/array/DailyTemperatures.java)| Stack |
|1110|[Delete Nodes And Return Forest](https://leetcode.com/problems/delete-nodes-and-return-forest/) | [Java](./src/java/medium/tree/DeleteNodesAndReturnForest.java)| DFS |
|1302|[Deepest Leaves Sum](https://leetcode.com/problems/deepest-leaves-sum/) | [Java](./src/java/medium/tree/DeepestLeavesSum.java)| DFS |
|1306|[Jump Game III](https://leetcode.com/problems/jump-game-iii/) | [Java](./src/java/medium/array/JumpGameIII.java)| Backtracking (DFS) |
|1339|[Maximum Product of Splitted Binary Tree](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/) | [Java](./src/java/medium/tree/MaximumProductSplittedBinaryTree.java)| DFS |
|1423|[Maximum Points You Can Obtain from Cards](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/) | [Java](./src/java/medium/array/MaximumPointsFromCards.java)| DP & Sliding Window |

### Hard Questions

| # | Name | Solution | Algorithm | Note |
|:-:|:----:|:--------:|:---------:|:----:|
|10|[Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/) | [Java](./src/java/hard/string/RegularExpressionMatching.java)| Backtracking |
|37|[Sudoku Solver](https://leetcode.com/problems/sudoku-solver/) | [Java](./src/java/hard/matrix/SudokuSolver.java)| Backtracking |
|44|[Wildcard Matching](https://leetcode.com/problems/wildcard-matching/) | [Java](./src/java/hard/string/WildcardMatching.java)| Backtracking/Two-Pointer |
|45|[Jump Game II](https://leetcode.com/problems/jump-game-ii/) | [Java](./src/java/hard/dp/JumpGameII.java)| 1D DP/Greedy |
|51|[N-Queens](https://leetcode.com/problems/n-queens/) | [Java](./src/java/hard/backtracking/NQueens.java)| Backtracking (DFS) |
|52|[N-Queens II](https://leetcode.com/problems/n-queens-ii/) | [Java](./src/java/hard/backtracking/NQueensII.java)| Backtracking (DFS) |
|76|[Minimum Window Substring](https://leetcode.com/problems/jump-game-ii/) | [Java](./src/java/hard/string/MinimumWindowSubstring.java)| Sliding Window |
|84|[Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) | [Java](./src/java/hard/stack/LargestRectangleHistogram.java)| Stack |
|85|[Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/) | [Java](./src/java/hard/matrix/MaximalRectangle.java)| 2D DP |
|123|[Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/) | [Java](./src/java/hard/dp/BestTimeBuySellStockIII.java)| 1D DP |
|135|[Candy](https://leetcode.com/problems/candy/) | [Java](./src/java/hard/greedy/Candy.java)| Greedy |
|140|[Word Break II](https://leetcode.com/problems/word-break-ii/) | [Java](./src/java/hard/string/WordBreakII.java)| 1D DP + DFS |
|239|[Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | [Java](./src/java/hard/deque/SlidingWindowMaximum.java)| Deque |
|297|[Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | [Java](./src/java/hard/tree/SerializeDeserializeBinaryTree.java)| Tree/DFS/Queue |
|980|[Unique Paths III](https://leetcode.com/problems/unique-paths-iii/) | [Java](./src/java/hard/matrix/UniquePathsIII.java)| Backtracking (DFS) |
