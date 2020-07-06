# Java Concurrency (Multi-threading)

<!-- MarkdownTOC -->

- [Concurrency in Java](#concurrency-in-java)
  - [Processes and Threads](#processes-and-threads)
  - [Locks and thread synchronization](#locks-and-thread-synchronization)
  - [Volatile](#volatile)
- [Memory Model in Java](#memory-model-in-java)
  - [Overview](#overview)
  - [Atomic operation](#atomic-operation)
  - [Memory updates in synchronized code](#memory-updates-in-synchronized-code)
- [Immutability and Defensive Copies](#immutability-and-defensive-copies)
  - [Immutability](#immutability)
  - [Defensive Copies](#defensive-copies)
- [Threads in Java](#threads-in-java)
  - [Threads pools with the Executor Framework](#threads-pools-with-the-executor-framework)
- [CompletableFuture](#completableFuture)
- [Nonblocking algorithms](#nonblocking-algorithms)
- [Fork-Join in Java 7](#fork-join-in-java-7)
- [Deadlock](#deadlock)

<!-- / MarkdownTOC -->

## Concurrency in Java

### Processes and Threads

A Java program runs in its own process and by default in one thread. Java supports threads as part of the Java language via the Thread code. The Java application can create new threads via this class.

Java 1.5 also provides improved support for concurrency with the in the java.util.concurrent package.

### Locks and thread synchronization

Java provides locks to protect certain parts of the code to be executed by several threads at the same time. The simplest way of locking a certain method or Java class is to define the method or class with the **synchronized** keyword.

The synchronized keyword in Java ensures:

- that only a single thread can execute a block of code at the same time.
- that each thread entering a synchronized block of code sees the effects of all previous modifications that were guarded by the same lock.

Synchronization is necessary for mutually exclusive access to blocks of and for reliable communication between threads.

You can use the _synchronized_ keyword for the definition of a method. This would ensure that only one thread can enter this method at the same time. Another threads which is calling this method would wait until the first threads leaves this method.

```java
public synchronized void critial() {
    // do some thread critical stuff
}
```

You can also use the _synchronized_ keyword to protect blocks of code within a method. This block is guarded by a key, which can be either a string or an object. This key is called the **lock**.

For example the following data structure will ensure that only one thread can access the inner block of the add() and next() methods.

```java
import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<String> EmployeeNames
    private int current;

    public Company() {
        EmployeeNames = new ArrayList<String>();
        current = 0;
    }

    public void add(String name) {
        synchronized (this) {
            if (!EmployeeNames.contains(name)) {
                EmployeeNames.add(name);
            }
        }
    }

    public void payCurrentEmployee() {
        if (EmployeeNames.size() == 0) {
            return null;
        }
        synchronized (this) {
            if (EmployeeNames.size() > current) {
                pay(EmployeeNames.get(current));
                current++;
            }
        }
    }
}
```

### Volatile

If a variable is declared with the volatile keyword then it is guaranteed that any thread that reads the field will see the most recently written value. The volatile keyword will not perform any mutual exclusive lock on the variable.

As of Java 5 write access to a volatile variable will also update non-volatile variables which were modified by the same thread. This can also be used to update values within a reference variable, e.g. for a volatile variable person. In this case you must use a temporary variable person and use the setter to initialize the variable and then assign the temporary variable to the final variable. This will then make the address changes of this variable and the values visible to other threads.

## Memory Model in Java

### Overview

The _Java memory model_ describes the communication between the memory of the threads and the main memory of the application. It defines the rules how changes in the memory done by threads are propagated to other threads.

The _Java memory model_ also defines the situations in which a thread re-fresh its own memory from the main memory. It also describes which operations are atomic and the ordering of the operations.

### Atomic operation

An _atomic_ operation is an operation which is performed as a single unit of work without the possibility of interference from other operations.

The Java language specification guarantees that reading or writing a variable is an atomic operation(unless the variable is of type `long` or `double` ). Operations variables of type `long` or `double` are only atomic if they declared with the volatile keyword.

Assume `i` is defined as int. The `i++` (increment) operation it not an atomic operation in Java. This also applies for the other numeric types, e.g. long. etc).

The `i++` operation first reads the value which is currently stored in `i` (atomic operations) and then it adds one to it (atomic operation). But between the read and the write the value of `i` might have changed.

Since Java 1.5 the java language provides atomic variables, e.g. AtomicInteger or AtomicLong which provide methods like `getAndDecrement()`, `getAndIncrement()` and `getAndSet()` which are atomic.

### Memory updates in synchronized code

The Java memory model guarantees that each thread entering a synchronized block of code sees the effects of all previous modifications that were guarded by the same lock.

## Immutability and Defensive Copies

### Immutability

The simplest way to avoid problems with concurrency is to share only immutable data between threads. Immutable data is data which cannot changed.

To make a class immutable make

- all its fields final
- the class declared as final
- the this reference is not allowed to escape during construction
- Any fields which refer to mutable data objects are
- private
- have no setter method
- they are never directly returned of otherwise exposed to a caller
- if they are changed internally in the class this change is not visible and has no effect outside of the class

An immutable class may have some mutable data which is uses to manages its state but from the outside this class nor any attribute of this class can get changed.

For all mutable fields, e.g. Arrays, that are passed from the outside to the class during the construction phase, the class needs to make a defensive-copy of the elements to make sure that no other object from the outside still can change the data.

### Defensive Copies

You must protect your classes from calling code. Assume that calling code will do its best to change your data in a way you didn’t expect it. While this is especially true in case of immutable data it is also true for non-immutable data which you still not expect that this data is changed outside your class.

To protect your class against that you should copy data you receive and only return copies of data to calling code.

The following example creates a copy of a list (ArrayList) and returns only the copy of the list. This way the client of this class cannot remove elements from the list.

## Threads in Java

The base means for concurrency are is the `java.lang.Threads` class. A `Thread` executes an object of type `java.lang.Runnable`.

`Runnable` is an interface with defines the `run()` method. This method is called by the `Thread` object and contains the work which should be done. Therefore the "Runnable" is the task to perform. The `Thread` is the worker who is doing this task.

```java
public class MyRunnable implements Runnable {
    private final long countUntil;

    MyRunnable(long countUntil) {
        this.countUntil = countUntil;
    }

    @Override
    public void run() {
        long sum = 0;
        for (long i = 1; i < countUntil; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
```

The following example demonstrate the usage of the `Thread` and the `Runnable` class.

```java
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<Thread>();
        // Create 500 threads
        for (int i = 0; i < 500; i++) {
            Runnable task = new MyRunnable(10000000L + i);
            Thread worker = new Thread(task);
            // We can set the name of the thread
            worker.setName(String.valueOf(i));
            // Start the thread, never call method run() direct
            worker.start();
            // Remember the thread for later usage
            threads.add(worker);
        }
        int running = 0;
        do {
            running = 0;
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    running++;
                }
            }
            System.out.println("We have " + running + " running threads. ");
        } while (running > 0);

    }
}
```

Using the `Thread` class directly has the following disadvantages.

- Creating a new thread causes some performance overhead.
- Too many threads can lead to reduced performance, as the CPU needs to switch between these threads.
- You cannot easily control the number of threads, therefore you may run into out of memory errors due to too many- threads.

The `java.util.concurrent` package offers improved support for concurrency compared to the direct usage of Threads. This package is described in the next section.

## Threads pools with the Executor Framework

Thread pools manage a pool of worker threads. The thread pools contains a work queue which holds tasks waiting to get executed.

A thread pool can be described as a collection of `Runnable` objects, which contains work queue and a connections of running threads. These threads are constantly running and are checking the work query for new work. If there is new work to be done they execute this Runnable. The Thread class itself provides a method, e.g. _execute(Runnable r)_ to add a new `Runnable` object to the work queue.

The Executor framework provides example implementation of the `java.util.concurrent.Executor` interface, e.g. _Executors.newFixedThreadPool(int n)_ which will create n worker threads. The ExecutorService adds life cycle methods to the Executor, which allows to shutdown the Executor and to wait for termination.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NTHREDS = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        for (int i = 0; i < 500; i++) {
            Runnable worker = new MyRunnable(10000000L + i);
            executor.execute(worker);
        }
        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();
        // Wait until all threads are finish
        executor.awaitTermination();
        System.out.println("Finished all threads");
    }
}
```

In case the threads should return some value (result-bearing threads) then you can use the `java.util.concurrent.Callable` class.

## CompletableFuture

Any time consuming task should be preferable done asynchronously. Two basic approaches to asynchronous task handling are available to a Java application:

- application logic blocks until a task completes
- application logic is called once the task completes, this is called a non-blocking approach.

`CompletableFuture` which extends the Future interface supports asynchronous calls. It implements the CompletionStage interface. CompletionStage offers methods, that let you attach callbacks that will be executed on completion.

It adds standard techniques for executing application code when a task completes, including various ways to combine tasks. `CompletableFuture` support both blocking and non-blocking approaches, including regular callbacks.

This callback can be executed in another thread as the thread in which the `CompletableFuture` is executed.

The following example demonstrates how to create a basic `CompletableFuture`.

```java
CompletableFuture.supplyAsync(this::doSomething);
```

`CompletableFuture.supplyAsync` runs the task asynchronously on the default thread pool of Java. It has the option to supply your custom executor to define the `ThreadPool`.

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSimpleSnippet {
    public static void main(String[] args) {
        long started = System.currentTimeMillis();

        // configure CompletableFuture
        CompletableFuture<Integer> futureCount = createCompletableFuture();

            // continue to do other work
            System.out.println("Took " + (started - System.currentTimeMillis()) + " milliseconds" );

            // now its time to get the result
            try {
              int count = futureCount.get();
                System.out.println("CompletableFuture took " + (started - System.currentTimeMillis()) + " milliseconds" );

               System.out.println("Result " + count);
             } catch (InterruptedException | ExecutionException ex) {
                // Exceptions from the future should be handled here
            }
    }

    private static CompletableFuture<Integer> createCompletableFuture() {
        CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        // simulate long running task
                        Thread.sleep(5000);
                    } catch (InterruptedException e) { }
                    return 20;
                });
        return futureCount;
    }
}
```

The `thenApply` can be used to define a callback which is executed once the `CompletableFuture.supplyAsync` finishes. The usage of the `thenApply` method is demonstrated by the following code snippet.

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCallback {
    public static void main(String[] args) {
        long started = System.currentTimeMillis();

        CompletableFuture<String>  data = createCompletableFuture()
                .thenApply((Integer count) -> {
                    int transformedValue = count * 10;
                    return transformedValue;
                }).thenApply(transformed -> "Finally creates a string: " + transformed);

            try {
                System.out.println(data.get());
            } catch (InterruptedException | ExecutionException e) {

            }
    }

    public static CompletableFuture<Integer> createCompletableFuture() {
        CompletableFuture<Integer>  result = CompletableFuture.supplyAsync(() -> {
            try {
                // simulate long running task
                Thread.sleep(5000);
            } catch (InterruptedException e) { }
            return 20;
        });
        return result;
    }
}
```

You can also start a CompletableFuture delayed as of Java 9.

```java
CompletableFuture<Integer> future = new CompletableFuture<>();
 future.completeAsync(() -> {
       System.out.println("inside future: processing data...");
       return 1;
 }, CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS))
 .thenAccept(result -> System.out.println("accept: " + result));
```

## Nonblocking algorithms

Java 5.0 provides supports for additional atomic operations. This allows to develop algorithm which are non-blocking algorithm, e.g. which do not require synchronization, but are based on low-level atomic hardware primitives such as compare-and-swap (CAS). A compare-and-swap operation check if the variable has a certain value and if it has this value it will perform this operation.

Non-blocking algorithms are typically faster than blocking algorithms, as the synchronization of threads appears on a much finer level (hardware).

```java
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger value = new AtomicInteger();
    public int getValue(){
        return value.get();
    }
    public int increment(){
        return value.incrementAndGet();
    }

    // Alternative implementation as increment but just make the
    // implementation explicit
    public int incrementLongVersion(){
        int oldValue = value.get();
        while (!value.compareAndSet(oldValue, oldValue+1)){
             oldValue = value.get();
        }
        return oldValue+1;
    }
}
```

```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
        private static final int NTHREDS = 10;

        public static void main(String[] args) {
            final Counter counter = new Counter();
            List<Future<Integer>> list = new ArrayList<Future<Integer>>();

            ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
            for (int i = 0; i < 500; i++) {
                Callable<Integer> worker = new  Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        int number = counter.increment();
                        System.out.println(number );
                        return number ;
                    }
                };
                Future<Integer> submit= executor.submit(worker);
                list.add(submit);

            }

            // This will make the executor accept no new threads
            // and finish all existing threads in the queue
            executor.shutdown();
            // Wait until all threads are finish
            while (!executor.isTerminated()) {
            }
            Set<Integer> set = new HashSet<Integer>();
            for (Future<Integer> future : list) {
                try {
                    set.add(future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            if (list.size()!=set.size()){
                throw new RuntimeException("Double-entries!!!");
            }
        }
}
```

The interesting part is how the incrementAndGet() method is implemented. It uses a CAS operation.

```java
public final int incrementAndGet() {
    for (;;) {
        int current = get();
        int next = current + 1;
        if (compareAndSet(current, next))
            return next;
    }
}
```

The JDK itself makes more and more use of non-blocking algorithms to increase performance for every developer. Developing correct non-blocking algorithm is not a trivial task.

## Fork-Join in Java 7

Java 7 introduce a new parallel mechanism for compute intensive tasks, the fork-join framework. The fork-join framework allows you to distribute a certain task on several workers and then wait for the result.

```java
import java.util.Random;

public class Problem {
    private final int[] list = new int[2000000];

    public Problem() {
        Random generator = new Random(19580427);
        for (int i = 0; i < list.length; i++) {
            list[i] = generator.nextInt(500000);
        }
    }

    public int[] getList() {
        return list;
    }
}
```

Define now the `Solver` class as shown in the following example coding.

```java
import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class Solver extends RecursiveAction {
    private int[] list;
    public long result;

    public Solver(int[] array) {
        this.list = array;
    }

    @Override
    protected void compute() {
        if (list.length == 1) {
            result = list[0];
        } else {
            int midpoint = list.length / 2;
            int[] l1 = Arrays.copyOfRange(list, 0, midpoint);
            int[] l2 = Arrays.copyOfRange(list, midpoint, list.length);
            Solver s1 = new Solver(l1);
            Solver s2 = new Solver(l2);
            forkJoin(s1, s2);
            result = s1.result + s2.result;
        }
    }
}
```

## Deadlock

A concurrent application has the risk of a deadlock. A set of processes are deadlocked if all processes are waiting for an event which another process in the same set has to cause.

For example if thread A waits for a lock on object Z which thread B holds and thread B wait for a look on object Y which is hold be process A then these two processes are locked and cannot continue in their processing.

This can be compared to a traffic jam, where cars(threads) require the access to a certain street(resource), which is currently blocked by another car(lock).
