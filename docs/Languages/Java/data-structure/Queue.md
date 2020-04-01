# Queue

<!-- MarkdownTOC -->
- [Queue Interface](#queue-interface)
  - [Special Methods in Queue Interface](#special-methods-in-queue-interface)
  - [LinkedList Class](#linkedlist-class)
- [PriorityQueue Class](#priorityqueue-class)
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

## Queue Interface

The _Queue_ interface extends the _Collection_ interface and provides extra operations. 

### Special Methods in _Queue_ Interface

- _boolean offer(E e)_: Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.

- _E peek()_: Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.

- _E poll()_: Retrieves and removes the head of this queue, or returns null if this queue is empty.

### LinkedList Class

_LinkedList_ class implements standard _Queue_ interface.

```java
Queue<String> q = new LinkedList<String>();

q.offer("element 1");
q.offer("element 2");
q.offer("element 3");

String s = q.poll();    // "element 1"
s = q.peek();           // "element 2"
```

## PriorityQueue Class

_PriorityQueue_ class in Java is an _unbounded_ priority queue based on a **priority heap**, which also implements _Queue_ interface. The elements of the priority queue are ordered according to their natural ordering, or by a Comparator provided at queue construction time. So, a priority queue does not permit _null_ elements or _non-comparable_ objects.

The head of this queue is the least element with respect to the specified ordering. If multiple elements are tied for least value, the head is one of those elements -- ties are broken arbitrarily.

Note that this implementation is not synchronized.

The time complexity of operations in _PriorityQueue_ class in _big-O_ notation is 

| Operation | Average | Worst case |
|:---------:|:-------:|:----------:|
| _offer_ | _O(log(n))_ | _O(log(n))_ |
| _poll_ | _O(log(n))_ | _O(log(n))_ |
| _remove_ | _O(log(n))_ | _O(log(n))_ |
| _add_ | _O(log(n))_ | _O(log(n))_ |
| _remove_ | _O(n)_ | _O(n)_ |
| _contains_ | _O(n)_ | _O(n)_ |
| _peek_ | _O(1)_ | _O(1)_ |
| _size_ | _O(1)_ | _O(1)_ |

### Constructor

- _PriorityQueue()_: Creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their **natural ordering**.

- _PriorityQueue(Collection<? extends E> c)_: Creates a PriorityQueue containing the elements in the specified collection.

- _PriorityQueue(Comparator<? super E> comparator)_: Creates a PriorityQueue with the default initial capacity and whose elements are ordered according to the specified comparator.

- _PriorityQueue(int initialCapacity)_: Creates a PriorityQueue with the specified initial capacity that orders its elements according to their **natural ordering**.

- _PriorityQueue(int initialCapacity, Comparator<? super E> comparator)_: Creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.

- _PriorityQueue(PriorityQueue<? extends E> c)_: Creates a PriorityQueue containing the elements in the specified priority queue.

- _PriorityQueue(SortedSet<? extends E> c)_: Creates a PriorityQueue containing the elements in the specified sorted set.

### Special Methods in PriorityQueue

_PriorityQueue_ class implements the interface of _Queue_, _Collection_ and _Iterable_.

```java
// Min queue as default
PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(); 
  
pQueue.add(10); 
pQueue.add(20); 
pQueue.add(15); 

System.out.println(pQueue.peek()); // 10
System.out.println(pQueue.poll()); // 10
System.out.println(pQueue.peek()); // 15
```

```java
// Max queue
PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((x, y) -> y - x); 
  
pQueue.add(10); 
pQueue.add(20); 
pQueue.add(15); 

System.out.println(pQueue.peek()); // 20
System.out.println(pQueue.poll()); // 20
System.out.println(pQueue.peek()); // 15
```

### Applications of PriorityQueue

TODO

## Deque Interface

_Deque_ is a linear collection that supports element insertion and removal at both ends. The name "deque" is short for "double ended queue" and is usually pronounced "deck".

### Special Methods in Deque

Summary of Deque methods

|   | First Element (Head) | Last Element (Tail) |
|:-:|:-------:|:----------:|:--------:|:--------:|
|Insert|addFirst(e)|offerFirst(e)|addLast(e)|offerLast(e)|

- _boolean add(E e)_: Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque) if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.

- _void	addFirst(E e)_: Inserts the specified element at the front of this deque if it is possible to do so immediately without violating capacity restrictions, throwing an IllegalStateException if no space is currently available.

- _void	addLast(E e)_: Inserts the specified element at the end of this deque if it is possible to do so immediately without violating capacity restrictions, throwing an IllegalStateException if no space is currently available.

- _E getFirst()_: Retrieves, but does not remove, the first element of this deque.

- _E getLast()_: Retrieves, but does not remove, the last element of this deque.

- _boolean offer(E e)_: Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque) if it is possible to do so immediately without violating capacity restrictions, returning true upon success and false if no space is currently available.

- _boolean offerFirst(E e)_: Inserts the specified element at the front of this deque unless it would violate capacity restrictions.

- _boolean offerLast(E e)_: Inserts the specified element at the end of this deque unless it would violate capacity restrictions.

- _E peek()_: Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.

- _E peekFirst()_: Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.

- _E peekLast()_: Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.

- _E poll()_: Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.

- _E pollFirst()_: Retrieves and removes the first element of this deque, or returns null if this deque is empty.

- _E pollLast()_: Retrieves and removes the last element of this deque, or returns null if this deque is empty.

- _E remove()_: Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque).

- _E removeFirst()_: Retrieves and removes the first element of this deque.

- _E removeLast()_: Retrieves and removes the last element of this deque.

- _Iterator<E> descendingIterator()_: Returns an iterator over the elements in this deque in reverse sequential order.

Note: I'd rather use the function with _First_ or _Last_ suffix to avoid confusion.

### LinkedList Class

_LinkedList_ class implements standard _Deque_ interface.

```java
Deque<String> q = new LinkedList<String>();
```

### ArrayDeque Class

## BlockingQueue Interface

**Note**, _PriorityQueue_ is not multi-threading safe. _PriorityBlockingQueue_ or _ArrayBlockingQueue_ class are the alternative implementation if thread safe implementation is needed.
