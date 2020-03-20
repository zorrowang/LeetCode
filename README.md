# LeetCode

Author: zorrowanghw@gmail.com

The repo is the summary for technical interview based on my experience and knowledge.

<!-- MarkdownTOC -->

- [Interview Preparation](#interview-preparation)
- [Languages and Data Structures](#languages-and-data-structures)
  - [Java](#java)
    - [Language Overview and Features](#language-overview-and-features)
    - [Data Structures in Java](#data-structures-in-java)
- [Algorithms](#algorithms)
- [System Design](#system-design)
- [LeetCode Preparation](#leetcode-preparation)
  - [Easy Questions](#easy-questions)
  - [Medium Questions](#medium-questions)
  - [Hard Questions](#hard-questions)

<!-- /MarkdownTOC -->

## Interview Preparation

The hiring flow is, resume screening -> recruiter call -> technical phone screening -> onsite -> hiring committee debrief -> decision call. In general, the more we prepare, the better offer we could get.

- [Mindset](./docs/tech-interview/Mindset.md)
- [Self Introduction](./docs/tech-interview/SelfIntroduction.md)
- [Phone Screen](./docs/tech-interview/PhoneScreen.md)
- [Whiteboard Coding Workflow and Best Practice](./docs/tech-interview/WhiteboardCoding.md)

## Languages and Data Structures

### Java 

Java is a general-purpose programming language that is class-based, object-oriented, and designed to have as few implementation dependencies as possible. It is intended to let application developers write once, run anywhere, meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.

#### Language Overview and Features

- [Java Introduction](./docs/Languages/Java/Java.md)
- [Java Virtual Machine (JVM)](./docs/Languages/Java/JVM.md)
- [Garbage Collection](./docs/Languages/Java/GC.md)
- [Lambda in Java](./docs/Languages/Java/Lambda.md)

#### Data Structures in Java

- [Array](./docs/Languages/Java/Array.md)
- [String](./docs/Languages/Java/String.md)
- [Collection](./docs/Languages/Java/Collection.md)
  - [Set](./docs/Languages/Java/Set.md)
  - [List](./docs/Languages/Java/List.md)
    - [Linked List](./docs/Languages/Java/LinkedList.md)
  - [Queue](./docs/Languages/Java/Queue.md)
    - [Deque](./docs/Languages/Java/Deque.md)
  - [Map](./docs/Languages/Java/Map.md)
    - [HashMap](./docs/Languages/Java/Deque.md#hashmap)
    - [TreeMap](./docs/Languages/Java/Deque.md#treemap)
- [Tree](./docs/Languages/Java/Tree.md)
  - [Trie](./docs/Languages/Java/Map.md#trie)
- [Graph](./docs/Languages/Java/Graph.md)


## Algorithms

This section covers the algorithms in tech interviews. Given the restriction of whiteboard coding, most of questions can be solved in ~50 lines of code. So I'd like to summarize most of the patterns in the tech interview.

This book, [Introduction to Algorithms](https://mitpress.mit.edu/books/introduction-algorithms-third-edition), and their class, [MIT 6.006 Introduction to Algorithms](https://www.youtube.com/playlist?list=PLUl4u3cNGP61Oq3tWYp6V_F-5jb5L2iHb), are very helpful and comprehensive if you want to learn algorithm and data structure.

(Still working on the list)

- Bit Manipulation
- Sort
- Search
- Recursion
- Memorization
- Dynamic Programming
- Greedy

## System Design

- [System Design Workflow](./docs/system-design/SystemDesignWorkflow.md)
- System Design Patterns

## LeetCode Preparation

### Easy Questions

| # | Name | Solution | Algorithm | Note |
|:-:|:----:|:--------:|:---------:|:----:|
|1|[Two Sum](https://leetcode.com/problems/two-sum/)|[Java](./src/easy/array/TwoSum.java)| Array |
|13|[Roman to Integer](https://leetcode.com/problems/roman-to-integer/)|[Java](./src/easy/string/RomanToInteger.java)| BruteForce |
|14|[Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)|[Java](./src/easy/array/LongestCommonPrefix.java)| BruteForce | More [solutions](https://leetcode.com/problems/longest-common-prefix/solution/)|
|20|[Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)|[Java](./src/easy/string/ValidParentheses.java)| Stack |
|21|[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)|[Java](./src/easy/linkedlist/MergeTwoSortedLists.java)| BruteForce |
|26|[Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)|[Java](./src/easy/array/RemoveDuplicatesSortedArray.java)| TwoPointer |
|27|[Remove Element](https://leetcode.com/problems/remove-element/)|[Java](./src/easy/array/RemoveElement.java)| BruteForce |
|66|[Plus One](https://leetcode.com/problems/plus-one/)|[Java](./src/easy/array/PlusOne.java)| BruteForce |
|67|[Add Binary](https://leetcode.com/problems/add-binary/)|[Java](./src/easy/string/AddBinary.java)| BruteForce |
|69|[Sqrt(x)](https://leetcode.com/problems/sqrtx/)|[Java](./src/easy/math/Sqrt.java)| Math | Apply [Newton's Method](https://pages.mtu.edu/~shene/COURSES/cs201/NOTES/chap06/sqrt-1.html) |
|83|[Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)|[Java](./src/easy/linkedlist/RemoveDuplicatesSortedList.java)| TwoPointer |
|88|[Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)|[Java](./src/easy/array/MergeSortedArray.java)| TwoPointer |
|108|[Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)|[Java](./src/easy/tree/ConvertSortedArrayBST.java)| Recursion |
|118|[Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)|[Java](./src/easy/math/PascalTriangle.java)| BruteForce |
|119|[Pascal's Triangle II](https://leetcode.com/problems/pascals-triangle-ii/)|[Java](./src/easy/math/PascalTriangleII.java)| 1D DP |
|283|[Move Zeroes](https://leetcode.com/problems/move-zeroes/)|[Java](./src/easy/array/MoveZeroes.java)| TODO |
|367|[Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)|[Java](./src/easy/math/ValidPerfectSquare.java)| Math |
|541|[Reverse String II](https://leetcode.com/problems/reverse-string-ii/)|[Java](./src/easy/string/ReverseStringII.java)| BruteForce |
|551|[Student Attendance Record I](https://leetcode.com/problems/student-attendance-record-i/)|[Java](./src/easy/array/StudentAttendanceRecord.java)| Array |
|557|[Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/)|[Java](./src/easy/string/ReverseWordInStringIII.java)| BruteForce |
|572|[Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/)|[Java](./src/easy/tree/SubtreeOfAnotherTree.java)| Recursion | [Converting to string](https://leetcode.com/problems/subtree-of-another-tree/solution/) is a brilliant idea |
|700|[Search in a Binary Search Tree](https://leetcode.com/problems/search-in-a-binary-search-tree/)|[Java](./src/easy/tree/SearchBinarySearchTree.java)| BinarySearch |
|703|[Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)|[Java](./src/easy/array/KthLargestElementInStream.java)| MinQueue |
|704|[Binary Search](https://leetcode.com/problems/binary-search/)|[Java](./src/easy/array/BinarySearch.java)| BinarySearch |
|709|[To Lower Case](https://leetcode.com/problems/to-lower-case/)|[Java](./src/easy/string/ToLowerCase.java)| String |
|720|[Longest Word in Dictionary](https://leetcode.com/problems/longest-word-in-dictionary/)|[Java](./src/easy/string/LongestWordDictionary.java)| Memorization/Trie |
|724|[Find Pivot Index](https://leetcode.com/problems/find-pivot-index/)|[Java](./src/easy/array/FindPivotIndex.java)| Prefix/Suffix Sum |
|728|[Self Dividing Numbers](https://leetcode.com/problems/self-dividing-numbers/)|[Java](./src/easy/number/SelfDividingNumbers.java)| BruteForce |
|733|[Flood Fill](https://leetcode.com/problems/flood-fill/)|[Java](./src/easy/matrix/FloodFill.java)| DFS |
|748|[Shortest Completing Word](https://leetcode.com/problems/shortest-completing-word/)|[Java](./src/easy/string/ShortestCompletingWord.java)| String |
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
|274|[H-Index](https://leetcode.com/problems/h-index/) | [Java](./src/medium/array/HIndex.java)| Array/Sort/Map |
|739|[Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) | [Java](./src/DailyTemperatures.java)| Heap/MaxQueue |
|1110|[Delete Nodes And Return Forest](https://leetcode.com/problems/delete-nodes-and-return-forest/) | [Java](./src/DeleteNodesAndReturnForest.java)| Tree/Recursion/DFS |
|1302|[Deepest Leaves Sum](https://leetcode.com/problems/deepest-leaves-sum/) | [Java](./src/DeepestLeavesSum.java)| Tree/Recursion/DFS |
|1339|[Maximum Product of Splitted Binary Tree](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/) | [Java](./src/medium/tree/MaximumProductSplittedBinaryTree.java)| Tree/Recursion |

### Hard Questions

| # | Name | Solution | Algorithm | Note |
|:-:|:----:|:--------:|:---------:|:----:|
|84|[Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) | [Java](./src/hard/stack/LargestRectangleHistogram.java)| Stack |
