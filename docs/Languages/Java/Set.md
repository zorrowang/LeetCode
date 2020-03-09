# Set

<!-- MarkdownTOC -->

- [HashSet Class](#hashset-class)
  - [Constructor](#Constructor)
  - [Methods in HashSet](#methods-in-hashSet)
- [SortedSet Interface](#sortedset-interface)
  - [NavigableSet Interface](#navigableset-interface)
  - [TreeSet Class](#treeset-class)
- [Techniques in Interview](#techniques-in-nterview)
- [Reference](#reference)

<!-- /MarkdownTOC -->

Interface _Set_ in Java defines a collection that contains no duplicate elements. More formally, sets contain no pair of elements `e1` and `e2` such that `e1.equals(e2)`, and at most one `null` element. It inherits from the _Collection_ interface.

## HashSet Class

This class implements the _Set_ interface, backed by a hash table (actually a _HashMap_ instance). It makes no guarantees as to the iteration order of the set; in particular, it does **not** guarantee that the order will remain constant over time. This class permits the `null` element.

**Note that this implementation is not synchronized.** 

- This class offers **constant** time performance for the basic operations, including _add_, _remove_, _contains_, _isEmpty_ and _size_, assuming the hash function disperses the elements properly among the buckets. 

- Iterating over this set requires time proportional to the sum of the HashSet instance's size (the number of elements) plus the "capacity" of the backing HashMap instance (the number of buckets). Thus, it's very important not to set the initial capacity too high (or the load factor too low) if iteration performance is important.

### Constructor

```java
// Constructs a new, empty set; the backing HashMap instance has default initial capacity (16) and load factor (0.75).
HashSet set = new HashSet();

// Constructs a new set containing the elements in the specified collection.
HashSet set = new HashSet(Collection<? extends E> c);

// Constructs a new, empty set; the backing HashMap instance has the specified initial capacity and default load factor (0.75).
HashSet set = new HashSet(int initialCapacity);

// Constructs a new, empty set; the backing HashMap instance has the specified initial capacity and the specified load factor.
HashSet set = new HashSet(int initialCapacity, float loadFactor)
```

### Methods in HashSet

- _boolean add(E e)_: adds the specified element to this set if it is not already present.

- _void	clear()_: removes all of the elements from this set.

- _boolean contains(Object o)_: returns true if this set contains the specified element.

- _boolean isEmpty()_: returns true if this set contains no elements.

- _boolean remove(Object o)_: removes the specified element from this set if it is present.

- _int size()_: returns the number of elements in this set (its cardinality).

- _Iterator<E> iterator()_: returns an iterator over the elements in this set.

## SortedSet Interface

A _Set_ (inherits _Set_ interface) that further provides a total ordering on its elements. The elements are ordered using their natural ordering, or by a _Comparator_ typically provided at sorted set creation time. The set's iterator will traverse the set in ascending element order. Several additional operations are provided to take advantage of the ordering.

### NavigableSet Interface

A NavigableSet implementation based on a TreeMap. The elements are ordered using their natural ordering, or by a Comparator provided at set creation time, depending on which constructor is used.


### TreeSet Class



## Techniques in Interview

## Reference

- <https://docs.oracle.com/javase/7/docs/api/java/util/Set.html>
