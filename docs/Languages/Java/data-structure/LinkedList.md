# Linked List

<!-- MarkdownTOC -->

- [Basic Concepts](#basic-concepts)
  - [Singly Linked List](#singly-linked-list)
  - [Doubly Linked List](#doubly-linked-list)
  - [Circular Linked List](#circular-linked-list)
- [LinkedList Class](#linkedlist-class)
  - [LinkedList Features](#linkedlist-features)
  - [LinkedList Constructor](#linkedlist-contructor)
  - [Special Methods in LinkedList](#special-methods-in-linkedList)
- [Techniques in Interview](#techniques-in-nterview)
- [Reference](#reference)

  <!-- /MarkdownTOC -->

Linked list is a linear collection of data elements, whose order is not given by their physical placement in memory. Instead, each element points to the next.

## Basic Concepts

Each record of a linked list is often called an _element_ or _node_. The field of each node that contains the address of the next node is usually called the _next link_ or _next pointer_. The remaining fields are known as the _data_ or _information_.

### Singly Linked List

Singly linked lists contain nodes which have a _data_ field as well as _next_ field, which points to the next node in line of nodes. Operations that can be performed on singly linked lists include insertion, deletion and traversal.

![Singly linked list](../../../images/Singly-linked-list.png)

```java
class SinglyLinkedList {
    Node head; // head of the list

    /* Singly linked list Node */
    class Node {
        int val;
        Node next;
        Node(int v) { val = v; }
        Node(int v, Node n) {
          val = v;
          next = n;
        }
    }
}
```

### Doubly Linked List

Each node contains, besides the next-node link, a second link field pointing to the _previous_ node in the sequence. The two links may be called 'forward('s') and 'backwards', or 'next' and 'prev'('previous').

![Doubly linked list](../../../images/Doubly-linked-list.png)

```java
class DoublyLinkedList {
    Node head; // head of the list

    /* Doubly linked list Node */
    class Node {
        int val;
        Node next, pre;
        Node(int v) { val = v; }
        Node(int v, Node n, Node p) {
          val = v;
          next = n;
          pre = p;
        }
    }
}
```

### Circular Linked List

In the last node of a list, the link field often contains a _null_ reference, a special value is used to indicate the lack of further nodes.

![Circularly linked list](../../../images/Circularly-linked-list.png)

## LinkedList Class

_LinkedList_ class implements doubly-linked list based on the _List_, _Queue_ and _Deque_ interfaces.

### LinkedList Features

| Comparison | ArrayList | LinkedList |
|:----------:|:---------:|:----------:|
| Internal structure | array | doubly linked list |
| Insert performance | amortized O(1) | O(1) |
| Search performance | O(1) | O(n) |
| Memory overhead | array and element	 | two pointers and element |

- ArrayList has O(n) time complexity for arbitrary indices of add/remove, but amortized O(1) for the operation at the end of the list.
- LinkedList has O(n) time complexity for arbitrary indices of add/remove, but O(1) for operations at end/beginning of the List.

### LinkedList Constructor

- _LinkedList()_: Constructs an empty list.
- _LinkedList(Collection<? extends E> c)_: Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator.

```java
List<Integer> l1 = new LinkedList<>();

List<Integer> l2 = new ArrayList<>(10);
for (int i = 0; i < 10; i++)
  l2. add(i);

List<Integer> l3 = new LinkedList<>(l2);
```

### Special Methods in LinkedList

- _void	addFirst(E e)_: Inserts the specified element at the beginning of this list.

- _void	addLast(E e)_: Appends the specified element to the end of this list.

- _E getFirst()_: Returns the first element in this list.

- _E getLast()_: Returns the last element in this list.

- _E removeFirst()_: Removes and returns the first element from this list.

- _E removeLast()_: Removes and returns the last element from this list.

**Note**, _LinkedList_ also implements the _Queue_ and _Deque_ interfaces. Their methods are introduced in separate docs.

## Techniques in Interview



## References
- <https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html>
- <https://en.wikipedia.org/wiki/Linked_list>
