# Queue

<!-- MarkdownTOC -->
- [Queue Interface](#queue-interface)
  - [Special Methods in Queue Interface](#special-methods-in-queue-interface)
  - [PriorityQueue Class](#priorityqueue)
  - [LinkedList Class](#linkedlist-class)
- [Deque Interface](#deque-interface)
  - [ArrayDeque Class](#arraydeque-class)
- [BlockingQueue Interface](#blockingqueue-interface)

<!-- /MarkdownTOC -->

A **queue** is a data structure maintaining a collection of entities in a sequence, which usually follow first-in-first-out (FIFO) order. 

![Queue](../../../images/Queue.jpg)

Time complexity in _big-O_ notation is 

| Algorithm | Average | Worst case |
|:---------:|:-------:|:----------:|
| Space | _O(n)_ | _O(n)_ |
| Search | _O(n)_ | _O(n)_ |
| Insert | _O(1)_ | _O(1)_ |
| Delete | _O(1)_ | _O(1)_ |

## _Queue_ Interface

The _Queue_ interface extends the _Collection_ interface and provides extra operations. 

### Special Methods in _Queue_ Interface

- _boolean offer(E e)_: Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.

- _E peek()_: Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.

- _E poll()_: Retrieves and removes the head of this queue, or returns null if this queue is empty.

### _PriorityQueue_ Class

_PriorityQueue_ in Java is an unbounded priority queue based on a **priority heap**.

### _LinkedList_ Class

## _Deque_ Interface

### _ArrayDeque_ Class

## _BlockingQueue_ Interface

**Note**, _PriorityQueue_ is not multi-threading safe. _PriorityBlockingQueue_ or _ArrayBlockingQueue_ class are the alternative implementation if thread safe implementation is needed.
