# List

<!-- MarkdownTOC -->

- [List Interface](#list-interface)
  - [Positional Access](#positional-access)
  - [Search Element](#search-element)
  - [Special Iteration](#special-iteration)
  - [Range View](#range-view)
- [ArrayList Class](#arraylist-class)
  - [ArrayList Features](#arrayList-features)
  - [Constructor](#constructor)
  - [Special Methods in ArrayList](#special-methods-in-arraylist)
- [Techniques in Interview](#techniques-in-nterview)
- [Reference](#reference)

<!-- /MarkdownTOC -->

An ordered collection (also known as a sequence). The user of this interface has precise control over where in the list each element is inserted. The user can access elements by their integer index (position in the list), and search for elements in the list.

Some features in _List_ are:

- List typically allows duplicate elements.
- List typically allow multiple null elements if they allow null elements at all.
- List (like Java Array) is zero based.
- List provides the positional (indexed) access to the elements. The execution is in time proportional to the index value for some implementations.

**Note**, Vector and Stack classes basically fall in legacy classes.

## List Interface

![Java Collection](../../images/java-collection.jpg)

List Interface extends Collection, hence it supports all the operations of Collection Interface, along with following additional operations.

### Positional Access

- _void	add(int index, E element)_: Inserts the specified element at the specified position in this list (optional operation).

```java
List<Integer> l = new ArrayList<Integer>(); 
l.add(0, 1);  // adds 1 at 0 index 
l.add(1, 2);  // adds 2 at 1 index 
```

- _boolean addAll(int index, Collection c)_: Inserts all of the elements in the specified collection into this list at the specified position (optional operation).

```java
List<Integer> l1 = new ArrayList<Integer>(); 
l1.add(0, 1);
l1.add(1, 2);
List<Integer> l2 = new ArrayList<Integer>(); 
l2.add(1); 
l2.add(2); 
l2.add(3);
l1.addAll(1, l2);
```

- _E get(int index)_: Returns the element at the specified position in this list.

- _E remove(int index)_: Removes the element at the specified position in this list (optional operation).
  Note: it shifts any subsequent elements to the left (subtracts one from their indices).

- _E set(int index, E element)_: Replaces the element at the specified position in this list with the specified element (optional operation).

### Search Element

- _int indexOf(Object o)_: Returns the index of the **first** occurrence of the specified element in this list, or -1 if this list does not contain the element.
  Note: this is a linear (O(n)) operation.

```java
List<String> l = new ArrayList<>(); 
l.add("Leet");
l.add("Code");
lastIndexOf("Code");  // returns 1
lastIndexOf("dumb");  // returns -1
```

- _int lastIndexOf(Object o)_: Returns the index of the **last** occurrence of the specified element in this list, or -1 if this list does not contain the element.

### Special Iteration

- _ListIterator<E> listIterator()_ and _ListIterator<E> listIterator(int index)_: Returns a list iterator over the elements in this list (in proper sequence).
  The _ListIterator_ is an iterator for lists that allows the programmer to traverse the list in either direction, modify the list during iteration, and obtain the iterator's current position in the list.

### Range View

- _List<E> subList(int fromIndex, int toIndex)_: Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.

```java
List<Integer> l = new ArrayList<Integer>();
for (int i = 0; i < 10; i++)
  l.add(i * 10);
List<Integer> sub = new ArrayList<Integer>();
sub = l.subList(2, 6);  // return [20, 30, 40, 50]
```

## ArrayList Class

ArrayList class implements resizable-array under the List interface. The _size_, _isEmpty_, _get_, _set_, _iterator_, and _listIterator_ operations run in constant time. The _add_ operation runs in **amortized constant time**, that is, adding _n_ elements requires _O(n)_ time. All of the other operations run in linear time (roughly speaking).

**Note** that this implementation is not synchronized.

### ArrayList Features

- ArrayList instance has a capacity. The capacity is the size of the array used to store the elements in the list. It is always at least as large as the list size. The capacity can grow or shrink automatically.
- ArrayList can not be used for primitive types (it converts the primitive int data type into an Integer object).
- Since ArrayList can’t be created for primitive data types, members of ArrayList are always references to objects at different memory locations. Therefore in ArrayList, the actual objects are never stored at contiguous locations. References of the actual objects are stored at contiguous locations.
In array, it depends whether the arrays is of primitive type or object type. In case of primitive types, actual values are contiguous locations, but in case of objects, allocation is similar to ArrayList.
- ArrayList in Java can be seen as similar to vector in C++.

### Constructor

- _ArrayList()_: builds an empty ArrayList.
- _ArrayList(Collection c)_: builds an ArrayList initialized with the elements from collection c.
- _ArrayList(int capacity)_: builds an ArrayList with initial capacity being specified.

```java
List<Integer> l1 = new ArrayList<>();

List<Integer> l2 = new ArrayList<>(10);
for (int i = 0; i < 10; i++)
  l2. add(i);

List<Integer> l3 = new ArrayList<>(l2);
```

### Special Methods in ArrayList

- _void	ensureCapacity(int minCapacity)_: Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument.

- _void	forEach(Consumer<? super E> action)_: Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.

```java
List<Integer> l = new ArrayList<>();
l.add(10);
l.add(20);
l.add(30);
l.forEach((n) -> System.out.println(n)); 
```

- _E remove(int index)_: Removes the element at the specified position in this list.

- _boolean removeIf(Predicate<? super E> filter)_: Removes all of the elements of this collection that satisfy the given predicate.

```java
List<Integer> l = new ArrayList<>();
l.add(10);
l.add(20);
l.add(30);
l.removeIf(n -> (n % 3 == 0));  // {10, 20}
```

- _Object[]	toArray()_: Returns an array containing all of the elements in this list in proper sequence (from first to last element).

- _<T> T[] toArray(T[] a)_: Returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array.

Note: casting to array is hard to use (not well-implemented). I'd recommend to write a function to do so.

- _void trimToSize()_: Trims the capacity of this ArrayList instance to be the list's current size.

![Java LinkedList](../../images/ArrayList-trimtosize.png)

## Techniques in Interview

## References

- <https://docs.oracle.com/javase/8/docs/api/java/util/List.html>
- <https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html>

