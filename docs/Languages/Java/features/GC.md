# Garbage Collection

In computer science, garbage collection (GC) is a form of automatic memory management. The _garbage collector_, or just _collector_, attempts to reclaim garbage, or memory occupied by objects that are no longer in use by the program.

## Introduction to Garbage Collection

In simple words, GC works in two simple steps known as Mark and Sweep:

**Mark** – it is where the garbage collector identifies which pieces of memory are in use and which are not
**Sweep** – this step removes objects identified during the “mark” phase

### Advantages

- No manual memory allocation/deallocation handling because unused memory space is automatically handled by GC
- No overhead of handling Dangling Pointer
- Automatic Memory Leak management (GC on its own can't guarantee the full proof solution to memory leaking, however, it takes care of a good portion of it)

### Disadvantages

- Since JVM has to keep track of object reference creation/deletion, this activity requires more CPU power besides the original application. It may affect the performance of requests which required large memory
- Programmers have no control over the scheduling of CPU time dedicated to freeing objects that are no longer needed
- Using some GC implementations might result in application stopping unpredictably
- Automatized memory management will not be as efficient as the proper manual memory allocation/deallocation

## Fragmenting and Compacting

Whenever sweeping takes place, the JVM has to make sure the areas filled with unreachable objects can be reused. This can (and eventually will) lead to memory fragmentation which, similarly to disk fragmentation, leads to two problems:

- Write operations become more time-consuming as finding the next free block of sufficient size is no longer a trivial operation.

- When creating new objects, JVM is allocating memory in contiguous blocks. So if fragmentation escalates to a point where no individual free fragment is large enough to accommodate the newly created object, an allocation error occurs.

To avoid such problems, the JVM is making sure the fragmenting does not get out of hand. So instead of just marking and sweeping, a _memory defrag_ process also happens during garbage collection. This process relocates all the reachable objects next to each other, eliminating (or reducing) the fragmentation.

## Generational Hypothesis

As we have mentioned before, doing a garbage collection entails stopping the application completely. It is also quite obvious that the more objects there are the longer it takes to collect all the garbage. But what if we would have a possibility to work with smaller memory regions? Investigating the possibilities, a group of researchers has observed that most allocations inside applications fall into two categories:

- Most of the objects become unused quickly
- The ones that do not usually survive for a (very) long time

These observations come together in the Weak Generational Hypothesis. Based on this hypothesis, the memory inside the VM is divided into what is called the **Young Generation** and the **Old Generation**. The latter is sometimes also called **Tenured**.

![Generational Hypothesis](../../../images/object-age-based-on-GC-generation-generational-hypothesis.png)

## Memory Pools

The following division of memory pools within the heap should be familiar. What is not so commonly understood is how Garbage Collection performs its duties within the different memory pools. Notice that in different GC algorithms some implementation details might vary but, again, the concepts remain effectively the same.

![Generational Hypothesis](../../../java-heap-eden-survivor-old.png)

## Minor GC vs Major GC vs Full GC

## Reference

- <https://en.wikipedia.org/wiki/Garbage_collection_(computer_science)>
