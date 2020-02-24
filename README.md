# LeetCode

Author: zorrowanghw@gmail.com

The repo is the summary for technical interview based on my experience and knowledge.

## Interview Preparation

The hiring flow is, resume screening -> recruiter call -> technical phone screening -> onsite -> hiring committee debrief -> decision call. In general, the more we prepare, the better offer we could get.

[Mindset](./docs/tech-interview/Mindset.md)

[Self Introduction](./docs/tech-interview/SelfIntroduction.md)

[Phone Screen](./docs/tech-interview/PhoneScreen.md)

[Whiteboard Coding Workflow and Best Practice](./docs/tech-interview/WhiteboardCoding.md)

## Algorithm and Data Structure

This section covers the algorithm and data structure in tech interviews. Given the restriction of whiteboard coding, most of questions can be solved in ~50 lines of code. So I'd like to summarize most of the patterns in the tech interview.

This book, [Introduction to Algorithms](https://mitpress.mit.edu/books/introduction-algorithms-third-edition), and their class, [MIT 6.006 Introduction to Algorithms](https://www.youtube.com/playlist?list=PLUl4u3cNGP61Oq3tWYp6V_F-5jb5L2iHb), are very helpful and comprehensive if you want to learn algorithm and data structure.

(Still working on the list)

* [Array](./docs/algorithm-and-data-structure/Array.md)
* String
* Linked List
* Heap
* Queue
* Stack
* Bit Manipulation
* DP

## Languages

* [Java](./docs/Languages/Java.md)

## System Design

* [System Design Workflow](./docs/system-design/SystemDesignWorkflow.md)
* System Design Patterns

## Leetcode Prep

### Hard Questions

| # | Name | Solution | Algorithm | Note |
|:-:|:----:|:--------:|:---------:|:----:|
|84|[Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) | [Java](./src/hard/stack/LargestRectangleHistogram.java)| Stack |

### Medium Questions

| # | Name | Solution | Algorithm | Note |
|:-:|:----:|:--------:|:---------:|:----:|
|274|[H-Index](https://leetcode.com/problems/h-index/) | [Java](./src/medium/array/HIndex.java)| Array/Sort/Map |
|739|[Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) | [Java](./src/DailyTemperatures.java)| Heap/MaxQueue |
|1110|[Delete Nodes And Return Forest](https://leetcode.com/problems/delete-nodes-and-return-forest/) | [Java](./src/DeleteNodesAndReturnForest.java)| Tree/Recursion/DFS |
|1302|[Deepest Leaves Sum](https://leetcode.com/problems/deepest-leaves-sum/) | [Java](./src/DeepestLeavesSum.java)| Tree/Recursion/DFS |
|1339|[Maximum Product of Splitted Binary Tree](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/) | [Java](./src/medium/tree/MaximumProductSplittedBinaryTree.java)| Tree/Recursion |

### Easy Questions

| # | Name | Solution | Algorithm | Note |
|:-:|:----:|:--------:|:---------:|:----:|
|1|[Two Sum](https://leetcode.com/problems/two-sum/)|[Java](./src/easy/array/TwoSum.java)| Array |
|572|[Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/)|[Java](./src/easy/tree/SubtreeOfAnotherTree.java)| Recursion | [Converting to string](https://leetcode.com/problems/subtree-of-another-tree/solution/) is a brilliant idea |
|700|[Search in a Binary Search Tree](https://leetcode.com/problems/search-in-a-binary-search-tree/)|[Java](./src/easy/tree/SearchBinarySearchTree.java)| BinarySearch |
|703|[Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)|[Java](./src/easy/array/KthLargestElementInStream.java)| MinQueue |
|704|[Binary Search](https://leetcode.com/problems/binary-search/)|[Java](./src/easy/array/BinarySearch.java)| BinarySearch |
|709|[To Lower Case](https://leetcode.com/problems/to-lower-case/)|[Java](./src/easy/string/ToLowerCase.java)| String |
|748|[Shortest Completing Word](https://leetcode.com/problems/shortest-completing-word/)|[Java](./src/easy/string/ShortestCompletingWord.java)| String |
|766|[Toeplitz Matrix](https://leetcode.com/problems/matrix-block-sum/)|[Java](./src/easy/matrix/ToeplitzMatrix.java)| Matrix |
|788|[Rotated Digits](https://leetcode.com/problems/rotated-digits/)|[Java](./src/easy/dp/RotatedDigits.java)| Array/DP | There is O(logn) [solution](https://leetcode.com/problems/rotated-digits/discuss/264282/Java-O(logN)-0ms-100), but I don't understand |
|852|[Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/)|[Java](./src/PeakIndexInMountainArray.java)| Array/BinarySearch |
|876|[Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)|[Java](./src/easy/linked-list/MiddleLinkedList.java)| LinkedList |
|884|[Uncommon Words from Two Sentences](https://leetcode.com/problems/uncommon-words-from-two-sentences/)|[Java](./src/string/UncommonWordsTwoSentences.java)| String |
|905|[Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/)|[Java](./src/easy/array/SortArrayByParity.java)| Array |
|994|[Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)|[Java](./src/easy/matrix/PeakIndexInMountainArray.java)| BFS |
|1337|[The K Weakest Rows in a Matrix](https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/)|[Java](./src/easy/matrix/KWeakestRowsInMatrix.java)| MaxQueue |
