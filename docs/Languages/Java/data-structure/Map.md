# Map

<!-- MarkdownTOC -->

- [Definition](#definition)
- [HashTable Implementations](#hashtable-implementations)
  - [Hash Function](#hash-function)
  - [Collision](#collision)
- [HashTable Class](#hashtable-class)
- [HashMap Class](#hashmap-class)
- [Tree Implementations](#tree-implementations)
- [TreeMap](#TreeMap)
- [References](#references)

<!-- /MarkdownTOC -->

## Definition

Map, also known as dictionary or associative array, is a collection of _(key, value)_ pairs, such that each possible key appears at most once in the collection.

![Map](../../../images/map.png)

Operations associated with this data type allow:

- Add or insert: add a new _(key,value)_ pair to the collection, mapping the new key to its new value.
- Reassign: replace the value in one of the _(key,value)_ pairs that are already in the collection, mapping an old key to a new value.
- Remove or delete: remove a _(key,value)_ pair from the collection, unmapping a given key from its value.
- Lookup: find the value (if any) that is bound to a given key.

## HashTable Implementations

![HashTable](../../../images/hash_table.png)

The most frequently used general purpose implementation of an associative array or map is with a hash table: an array combined with a _hash function_ that separates each key into a separate "bucket" of the array. The basic idea behind a hash table is that accessing an element via its index is a simple, constant-time operation. Therefore, the average overhead of an operation for a hash table is only the computation of the key's hash, combined with accessing the corresponding bucket within the array. As such, hash tables usually perform in **O(1)** time, and outperform alternatives in most situations.

### Hash Function

Hash function is a function that can be used to map data of arbitrary size to fixed-size values.

```
index = f(key, array_size)
```

A critical statistic for a hash table is the load factor, defined as

```
load_factor = the number of entries occupied in the hash table / the number of buckets
```

As the load factor grows larger, the hash table becomes slower, and it may even fail to work (depending on the method used). The expected constant time property of a hash table assumes that the load factor be kept below some bound.

### Collision

Hash tables need to be able to handle **collisions**: when the hash function maps two different keys to the same bucket of the array. The two most widespread approaches to this problem are separate chaining and open addressing.

![HashTable Separate Chaining](../../../images/hash_table_separate_chaining.png)

Separate chaining with linked lists makes each cell of hash table point to a linked list of records that have same hash function value. Chaining is simple, but requires additional memory outside the table.

Some chaining implementations store the first record of each chain in the slot array itself, known as separate chaining with list head cells.

![HashTable Open Addressing](../../../images/hash_table_open_addressing.png)

Open addressing stores all elements in the hash table itself. Each table entry contains either a record or NIL. When searching for an element, it examines table slots until the desired element is found or it is clear that the element is not in the table.

A drawback of all these open addressing schemes is that the number of stored entries cannot exceed the number of slots in the bucket array.

## HashTable Class

This class implements a hash table, which maps keys to values. Any non-null object can be used as a key or as a value. To successfully store and retrieve objects from a hash table, the objects used as keys must implement the hashCode method and the equals method.

## HashMap Class

## Tree Implementations

## TreeMap Class

## References

- <https://en.wikipedia.org/wiki/Associative_array>
- <https://en.wikipedia.org/wiki/Hash_table>
