# Collection

A Collection is a group of individual objects, known as its elements, represented as a single unit. Java provides Collection Framework which defines several classes and interfaces to represent a group of objects as a single unit. Interface *Collection* (_java.util.Collection_) and *Map* (_java.util.Map_) are the root interfaces in the collection hierarchy.

## Hierarchy of Collection Framework

![Java collection 1](../../images/java-collection.jpg)

- Set
A collection that contains no duplicate elements. The implementations of Set interface contain HashSet (Hashing based) and TreeSet (balanced BST based). 
Note: that TreeSet implements SortedSet.

- List
An ordered collection (also known as a sequence). The implementations contain LinkedList (linked list based) and ArrayList (dynamic array based).

- Queue
A collection designed for holding elements prior to processing, which typically follows FIFO order. The implementations contain LinkedList (linked list based) and PriorityQueue (heap based).

- Deque
A linear collection that supports element insertion and removal at both ends. The implementations contain ArrayDeque （dynamic array based) and LinkedList (linked list based).

## Methods in Collection

- _boolean add(E e)_: ensures that this collection contains the specified element.

- _boolean addAll(Collection<? extends E> c)_: adds all of the elements in the specified collection to this collection.

- _void	clear()_: removes all of the elements from this collection.

- _boolean contains(Object o)_: returns true if this collection contains the specified element.

- _boolean containsAll(Collection<?> c)_: returns true if this collection contains all of the elements in the specified collection.

- _boolean isEmpty()_: returns true if this collection contains no elements.

- _Iterator<E> iterator()_: returns an iterator over the elements in this collection.

- _boolean remove(Object o)_: removes a single instance of the specified element from this collection, if it is present.

- _boolean removeAll(Collection<?> c)_: removes all of this collection's elements that are also contained in the specified collection.

- _boolean retainAll(Collection<?> c)_: retains only the elements in this collection that are contained in the specified collection.

- _int size()_: returns the number of elements in this collection.

- _Object[]	toArray()_: returns an array containing all of the elements in this collection.

## Reference 

- <https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html>
