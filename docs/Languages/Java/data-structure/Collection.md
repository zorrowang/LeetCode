# Collection

<!-- MarkdownTOC -->

- [Hierarchy of Collection Framework](#hierarchy-of-collection-framework)
- [Methods in Collection](#methods-in-collection)
- [Collections Class](#collections-class)
  - [Util Methods in Collections Class](#util-ethods-in-collections-class)

<!-- /MarkdownTOC -->

A Collection is a group of individual objects, known as its elements, represented as a single unit. Java provides Collection Framework which defines several classes and interfaces to represent a group of objects as a single unit. Interface *Collection* (_java.util.Collection_) and *Map* (_java.util.Map_) are the root interfaces in the collection hierarchy.

## Hierarchy of Collection Framework

![Java collection 1](../../../images/java-collection.jpg)

- *Set*: a collection that contains no duplicate elements. The implementations of Set interface contain HashSet (Hashing based) and TreeSet (balanced BST based). 
Note: that TreeSet implements SortedSet.

- *List*: an ordered collection (also known as a sequence). The implementations contain LinkedList (linked list based) and ArrayList (dynamic array based).

- *Queue*: a collection designed for holding elements prior to processing, which typically follows FIFO order. The implementations contain LinkedList (linked list based) and PriorityQueue (heap based).

- *Deque*: a linear collection that supports element insertion and removal at both ends. The implementations contain ArrayDeque （dynamic array based) and LinkedList (linked list based).

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

## Collections Class

This class consists exclusively of static methods that operate on or return collections. It directly inherits from `Object` class.

This class

- supports the **polymorphic algorithms** that operate on collections. (In general, an algorithm is called _polymorphic_ if it can achieve the same functionality using different data structures.)

- throws a `NullPointerException` if the collections or class objects provided to them are `null`.

### Util Methods in Collections Class

- _static <T> void fill(List<? super T> list, T obj)_: Replaces all of the elements of the specified list with the specified element.

```java
List<String> arrlist = new ArrayList<>();
for (int i = 0; i < 10; i++)
  arrlist.add(String.valueOf(i));       // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Collections.fill(arrlist, "A");         // [A, A, A, A, A, A, A, A, A, A]
```

- _static void reverse(List<?> list)_: Reverses the order of the elements in the specified list.

```java
List<String> arrlist = new ArrayList<>();
for (int i = 0; i < 10; i++)
  arrlist.add(String.valueOf(i));     // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Collections.reverse(arrlist);         // [9, 8, 7, 6, 5, 4, 3, 2, 1, 0] 
```

- _static <T> int	binarySearch(List<? extends Comparable<? super T>> list, T key)_ and _static <T> int	binarySearch(List<? extends T> list, T key, Comparator<? super T> c)_: Searches the specified list for the specified object using the binary search algorithm.

```java
List<String> arrlist = new ArrayList<>();
for (int i = 0; i < 10; i++)
  arrlist.add(String.valueOf(i));               // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Collections.binarySearch(arrlist, "2");         // 2
Collections.binarySearch(arrlist, "-10");       // -1
```

- _static <T> void copy(List<? super T> dest, List<? extends T> src)_: Copies all of the elements from one list into another.

Note, the dest list will point to a new object, so they do not share the same one.

```java
List<String> arrlist1 = new ArrayList<>(10);
List<String> arrlist2 = new ArrayList<>(10);
for (int i = 0; i < 10; i++) {
  arrlist1.add(String.valueOf(i));        // arrlist1 = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
  arrlist2.add(String.valueOf(i*10));     // arrlist2 = [0, 10, 20, 30, 40, 50, 60, 70, 80, 90]
}
Collections.copy(arrlist2, arrlist1);     // arrlist2 = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] 
```

- _static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)_ and _static <T> T	max(Collection<? extends T> coll, Comparator<? super T> comp)_: Returns the maximum element of the given collection, according to the natural ordering of its elements and the order induced by the specified comparator.

```java
List<String> arrlist = new ArrayList<>();
for (int i = 0; i < 10; i++)
  arrlist.add(String.valueOf(i));               // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Collections.max(arrlist);                       // 9
Collections.max(arrlist, (x, y) -> Integer.parseInt(y) - Integer.parseInt(x));  // 0
```

- _static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll)_ and _static <T> T	min(Collection<? extends T> coll, Comparator<? super T> comp)_: Returns the minimum element of the given collection, according to the natural ordering of its elements and the order induced by the specified comparator.

```java
List<String> arrlist = new ArrayList<>();
for (int i = 0; i < 10; i++)
  arrlist.add(String.valueOf(i));               // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Collections.min(arrlist);                       // 0
```

- _static <T> boolean	replaceAll(List<T> list, T oldVal, T newVal)_: Replaces all occurrences of one specified value in a list with another.

```java
List<String> arrlist = new ArrayList<>();
for (int i = 0; i < 10; i++)
  if (i % 2 == 0) arrlist.add(String.valueOf(i));
  else arrlist.add(String.valueOf("LC"));
// Before [0, LC, 2, LC, 4, LC, 6, LC, 8, LC]
Collections.replaceAll(arrlist, "LC", "10");
// After [0, 10, 2, 10, 4, 10, 6, 10, 8, 10]
```

- _static <T extends Comparable<? super T>> void sort(List<T> list)_ and _static <T> void	sort(List<T> list, Comparator<? super T> c)_

```java
List<String> arrlist = new ArrayList<>();
for (int i = 10; i > 0; i--)
    arrlist.add(String.valueOf(i));     // [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Collections.sort(arrlist);              // [1, 10, 2, 3, 4, 5, 6, 7, 8, 9]
```

- _static void swap(List<?> list, int i, int j)_: Swaps the elements at the specified positions in the specified list.

```java
List<String> arrlist = new ArrayList<>();
for (int i = 10; i > 0; i--)
    arrlist.add(String.valueOf(i));     // [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Collections.swap(arrlist, 2, 8);        // [10, 9, 2, 7, 6, 5, 4, 3, 8, 1]
```

- _static void shuffle(List<?> list)_ and _static void shuffle(List<?> list, Random rnd)_: Randomly permutes the specified list using a default or specific source of randomness.

```java
List<String> arrlist = new ArrayList<>();
for (int i = 10; i > 0; i--)
    arrlist.add(String.valueOf(i));     // [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Collections.shuffle(arrlist);           // one possibility is [9, 6, 10, 2, 8, 4, 1, 3, 7, 5]
```

- _static void rotate(List<?> list, int distance)_: Rotates the elements in the specified list by the specified distance.

```java
List<String> arrlist = new ArrayList<>();
for (int i = 10; i > 0; i--)
    arrlist.add(String.valueOf(i));       // [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Collections.rotate(arrlist, 3);           // [3, 2, 1, 10, 9, 8, 7, 6, 5, 4]
```

- _static <T> List<T>	emptyList()_: Returns the empty list (**immutable**).

- _static <K,V> Map<K,V> emptyMap()_: Returns the empty map (**immutable**).

- _static <T> Set<T> emptySet()_: Returns the empty set (**immutable**).

## Reference 

- <https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html>
- <https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html>
- <https://www.geeksforgeeks.org/collections-in-java-2/>
- <https://www.baeldung.com/java-collections-interview-questions>
