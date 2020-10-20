# Garbage Collection

<!-- MarkdownTOC -->

- [Introduction to Garbage Collection](#introduction-to-garbage-collection)
  - [Advantages](advantages)
  - [Disadvantages](#disadvantages)
- [Fragmenting and Compacting](#fragmentin-and-compacting)
- [Generational Hypothesis](#generational-hypothesis)
- [Memory Pools](#memory-pools)
  - [Eden](#eden)
  - [Survivor Spaces](#survivor-spaces)
  - [Old Generation](#old-generation)
  - [PermGen (deprecated from Java 8)](#permgen-deprecated-from-java-8)
  - [Metaspace](#metaspace)
- [Minor GC vs Major GC vs Full GC](#minor-gc-vs-major-gc-vs-full-gc)
  - [Minor GC](#minor-gc)
  - [Major GC vs Full GC](#major-gc-vs-full-gc)
- [References](#references)

<!-- / MarkdownTOC -->

In computer science, garbage collection (GC) is a form of automatic memory management. The _garbage collector_, or just _collector_, attempts to reclaim garbage, or memory occupied by objects that are no longer in use by the program.

## Introduction to Garbage Collection

In simple words, GC works in two simple steps known as Mark and Sweep:

- **Mark** – it is where the garbage collector identifies which pieces of memory are in use and which are not
- **Sweep** – this step removes objects identified during the “mark” phase

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

![Memory Pools](../../../images/java-heap-eden-survivor-old.png)

### Eden

Eden is the region in memory where the objects are typically allocated when they are created. As there are typically multiple threads creating a lot of objects simultaneously, Eden is further divided into one or more **Thread Local Allocation Buffer** (TLAB for short) residing in the Eden space. These buffers allow the JVM to allocate most objects within one thread directly in the corresponding TLAB, avoiding the expensive synchronization with other threads.

When allocation inside a TLAB is not possible (typically because there’s not enough room there), the allocation moves on to a shared Eden space. If there’s not enough room in there either, a garbage collection process in Young Generation is triggered to free up more space. If the garbage collection also does not result in sufficient free memory inside Eden, then the object is allocated in the Old Generation.

When Eden is being collected, GC walks all the reachable objects from the roots and marks them as alive.

We have previously noted that objects can have cross-generational links so a straightforward approach would have to check all the references from other generations to Eden. Doing so would unfortunately defeat the whole point of having generations in the first place. The JVM has a trick up its sleeve: _card-marking_. Essentially, the JVM just marks the rough location of ‘dirty’ objects in Eden that may have links to them from the Old Generation.

![TLAB used in Eden](../../../images/TLAB-in-Eden-memory.png)

After the marking phase is completed, all the live objects in Eden are copied to one of the Survivor spaces. The whole Eden is now considered to be empty and can be reused to allocate more objects. Such an approach is called as, **Mark and Copy**, the live objects are marked, and then copied (not moved) to a survivor space.

### Survivor Spaces

Next to the Eden space reside two **Survivor** spaces called _from_ and _to_. It is important to notice that one of the two Survivor spaces is always empty.

The empty Survivor space will start having residents next time the Young generation gets collected. All of the live objects from the whole of the Young generation (that includes both the Eden space and the non-empty _'from'_ Survivor space) are copied to the _'to'_ survivor space. After this process has completed, _'to'_ now contains objects and _'from'_ does not. Their roles are switched at this time.

![Survivor Spaces](../../../images/how-java-garbage-collection-works2.png)

This process of copying the live objects between the two Survivor spaces is repeated several times until some objects are considered to have matured and are 'old enough'. Based on the generational hypothesis, objects which have survived for some time are expected to continue to be used for very long time.

Such 'tenured' objects can thus be promoted to the Old Generation. When this happens, objects are not moved from one survivor space to another but instead to the Old space, where they will reside until they become unreachable.

To determine whether the object is 'old enough' to be considered ready for propagation to Old space, GC tracks the number of collections a particular object has survived. After each generation of objects finishes with a GC, those still alive have their age incremented. Whenever the age exceeds a certain tenuring threshold the object will be promoted to Old space.

The actual tenuring threshold is dynamically adjusted by the JVM, but specifying _-XX:+MaxTenuringThreshold_ sets an upper limit on it. Setting _-XX:+MaxTenuringThreshold=0_ results in immediate promotion without copying it between Survivor spaces. By default, this threshold on modern JVMs is set to 15 GC cycles. This is also the maximum value in HotSpot.

Promotion may also happen prematurely if the size of the Survivor space is not enough to hold all of the live objects in the Young generation.

### Old Generation

The implementation for the Old Generation memory space is much more complex. Old Generation is usually significantly larger and is occupied by objects that are less likely to be garbage.

GC in the Old Generation happens less frequently than in the Young Generation. Also, since most objects are expected to be alive in the Old Generation, there is no Mark and Copy happening. Instead, the objects are moved around to minimize fragmentation. The algorithms cleaning the Old space are generally built on different foundations. In principle, the steps taken go through the following:

- Mark reachable objects by setting the marked bit next to all objects accessible through GC roots
- Delete all unreachable objects
- Compact the content of old space by copying the live objects contiguously to the beginning of the Old space

As you can see from the description, GC in Old Generation has to deal with explicit compacting to avoid excessive fragmentation.

### PermGen (deprecated from Java 8)

Prior to Java 8 there existed a special space called the 'Permanent Generation'. This is where the metadata such as classes would go. Also, some additional things like internalized strings were kept in Permgen. It actually used to create a lot of trouble to Java developers, since it is quite hard to predict how much space all of that would require.

### Metaspace

As predicting the need for metadata was a complex and inconvenient exercise, the Permanent Generation was removed in Java 8 in favor of the Metaspace. From this point on, most of the miscellaneous things were moved to regular Java heap.

The class definitions, however, are now loaded into something called Metaspace. It is located in the native memory and does not interfere with the regular heap objects. By default, Metaspace size is only limited by the amount of native memory available to the Java process. This saves developers from a situation when adding just one more class to the application results in the _java.lang.OutOfMemoryError: Permgen space_. Notice that having such seemingly unlimited space does not ship without costs – letting the Metaspace to grow uncontrollably you can introduce heavy swapping and/or reach native allocation failures instead.

In case you still wish to protect yourself for such occasions you can limit the growth of Metaspace similar to following, limiting Metaspace size to 256 MB:

```bash
java -XX:MaxMetaspaceSize=256m MyApp
```

## Minor GC vs Major GC vs Full GC

The Garbage Collection events cleaning out different parts inside heap memory are often called Minor, Major and Full GC events. In this section we cover the differences between these events. Along the way we can hopefully see that this distinction is actually not too relevant.

What typically is relevant is whether the application meets its SLAs, and to see that you monitor your application for latency or throughput. And only then are GC events linked to the results. What is important about these events is whether they stopped the application and how long it took.

But as the terms Minor, Major and Full GC are widely used and without a proper definition, let us look into the topic in a bit more detail.

### Minor GC

Collecting garbage from the Young space is called Minor GC. This definition is both clear and uniformly understood. But there are still some interesting takeaways you should be aware of when dealing with Minor Garbage Collection events:

- Minor GC is always triggered when the JVM is unable to allocate space for a new object, e.g. Eden is getting full. So the higher the allocation rate, the more frequently Minor GC occurs.
- During a Minor GC event, Tenured Generation is effectively ignored. References from Tenured Generation to Young Generation are considered to be GC roots. References from Young Generation to Tenured Generation are simply ignored during the mark phase.
- Against common belief, Minor GC does trigger stop-the-world pauses, suspending the application threads. For most applications, the length of the pauses is negligible latency-wise if most of the objects in the Eden can be considered garbage and are never copied to Survivor/Old spaces. If the opposite is true and most of the newborn objects are not eligible for collection, Minor GC pauses start taking considerably more time.

So defining Minor GC is easy – Minor GC cleans the Young Generation.

### Major GC vs Full GC

It should be noted that there are no formal definitions for those terms – neither in the JVM specification nor in the Garbage Collection research papers. But on the first glance, building these definitions on top of what we know to be true about Minor GC cleaning Young space should be simple:

- Major GC is cleaning the Old space.
- Full GC is cleaning the entire Heap – both Young and Old spaces.

Unfortunately it is a bit more complex and confusing. To start with – many Major GCs are triggered by Minor GCs, so separating the two is impossible in many cases. On the other hand – modern garbage collection algorithms like G1 perform partial garbage cleaning so, again, using the term 'cleaning' is only partially correct.

This leads us to the point where instead of worrying about whether the GC is called Major or Full GC, you should focus on finding out whether the GC at hand stopped all the application threads or was able to progress concurrently with the application threads.

## Reference

- <https://en.wikipedia.org/wiki/Garbage_collection_(computer_science)>
- <https://plumbr.io/handbook/garbage-collection-in-java>
