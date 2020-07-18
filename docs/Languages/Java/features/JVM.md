# Java Virtual Machine (JVM) & its Architecture

<!-- MarkdownTOC -->

- [What is JVM](#what-is-jvm)
- [JVM Architecture](#jvm-architecture)
  - [ClassLoader](#classloader)
    - [Built-in Class Loaders](#built-in-class-loaders)
    - [How Class Loader Works](#How-class-loader-works)
    - [Linking](#linking)
    - [Initialization](#initialization)
  - [Runtime Data Area](#runtime-data-area)
    - [Method Area](#method-area)
    - [Heap Area](#heap-area)
      - [Key Features of Java Heap Memory](#key-features-of-heap-memory)
    - [Stack Area](#stack-area)
      - [Key Features of Java Stack Memory](#key-features-of-stack-memory)
      - [Stack and Heap in Example](#stack-and-heap-in-example)
      - [Stack vs Heap](#stack-vs-heap)
    - [Program Counter (PC) Register](#program-counter-pc-egister)
    - [Native Method Stacks](#native-method-stacks)
  - [Execution Engine](#execution-engine)
- [How Java Code is Executed in JVM](#how-java-code-is-executed-in-jvm)
  - [Compiling](#compiling)
  - [Executing](#executing)
  - [Why Java is Slow](#why-java-is-slow)
- [References](#references)

<!-- /MarkdownTOC -->

## What is JVM

**Java Virtual Machine (JVM)** is a engine that provides runtime environment to drive the Java Code or applications. It converts Java bytecode into machines language. JVM is a part of Java Run Environment (JRE). In other programming languages, the compiler produces machine code for a particular system. However, Java compiler produces code for a Virtual Machine known as Java Virtual Machine.

![JVM Workflow](../../../images/jvm-workflow.jpg)

Java code is complied into bytecode. This bytecode gets interpreted on different machines. Between host system and Java source, Bytecode is an intermediary language. JVM is also responsible for allocating memory space.

## JVM Architecture

![JVM Architecture](../../../images/jvm-arch.png)

### ClassLoader

The class loader is a subsystem used for loading Java classes during runtime dynamically to the JVM. It performs three major functions viz. Loading, Linking, and Initialization. It is part of the JRE (Java Runtime Environment). Hence, JVM doesn't need to know about the underlying files or file systems in order to run Java programs thanks to class loaders.

#### Built-in Class Loaders

```java
public void printClassLoaders() {
    System.out.println("Class loader of this class:" +
        App.class.getClassLoader());

    System.out.println("Class loader of parent class:" +
        ClassLoader.getSystemClassLoader().getParent());

    System.out.println("Class loader of ArrayList:" +
        ArrayList.class.getClassLoader());
}
```

When executed the above method prints:

```bash
Class loader of this class:sun.misc.Launcher$AppClassLoader@18b4aac2
Class loader of this class:sun.misc.Launcher$ExtClassLoader@5e91993f
Class loader of ArrayList:null
```

As we can see, there are three different class loaders here: **application**, **extension**, and **bootstrap** (displayed as null).

The application class loader loads the class where the example method is contained. An application or system class loader loads our own files in the classpath.

Next, the extension one loads the Logging class. Extension class loaders load classes that are an extension of the standard core Java classes.

Finally, the bootstrap one loads the ArrayList class. A bootstrap or primordial class loader is the parent of all the others.

- **Bootstrap Class Loader**: Java classes are loaded by an instance of _java.lang.ClassLoader_. While, bootstrap class loader loads _java.lang.ClassLoader_. It's mainly responsible for loading JDK internal classes, typically _rt.jar_ and other core libraries located in *$JAVA_HOME/jre/lib* directory. Additionally, Bootstrap class loader serves as a parent of all the other ClassLoader instances. This bootstrap class loader is part of the core JVM and is written in native code as pointed out in the above example. Different platforms might have different implementations of this particular class loader.

- **Extension Class Loader**: The extension class loader is a child of the bootstrap class loader and takes care of loading the extensions of the standard core Java classes so that it's available to all applications running on the platform. Extension class loader loads from the JDK extensions directory, usually *$JAVA_HOME/lib/ext* directory or any other directory mentioned in the *java.ext.dirs* system property.

- **Application Class Loader**: The application or system class loader, on the other hand, takes care of loading all the application level classes into the JVM. It loads files found in the classpath environment variable, `-classpath` or `-cp` command line option. Also, it's a child of Extensions class loader.

#### How Class Loader Works

Class loaders are part of the Java Runtime Environment. When the JVM requests a class, the class loader tries to locate the class and load the class definition into the runtime using the fully qualified class name.

The _java.lang.ClassLoader.loadClass()_ method is responsible for loading the class definition into runtime. It tries to load the class based on a fully qualified name. If the class isn't already loaded, it delegates the request to the parent class loader. This process happens recursively.

Eventually, if the parent class loader doesn’t find the class, then the child class will call _java.net.URLClassLoader.findClass()_ method to look for classes in the file system itself. If the last child class loader isn't able to load the class either, it throws _java.lang.NoClassDefFoundError_ or _java.lang.ClassNotFoundException_.

Let's look at an example of output when ClassNotFoundException is thrown.

```bash
java.lang.ClassNotFoundException: com.baeldung.classloader.SampleClassLoader
    at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
    at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
    at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
    at java.lang.Class.forName0(Native Method)
    at java.lang.Class.forName(Class.java:348)
```

If we go through the sequence of events right from calling _java.lang.Class.forName()_, we can understand that it first tries to load the class through parent class loader and then _java.net.URLClassLoader.findClass()_ to look for the class itself. When it still doesn't find the class, it throws a _ClassNotFoundException_.

#### Linking

- Verify: Bytecode verifier will verify whether the generated bytecode is proper or not if verification fails we will get the verification error.
- Prepare: For all static variables memory will be allocated and assigned with default values.
- Resolve: All symbolic memory references are replaced with the original references from Method Area.

#### Initialization

This is the final phase of ClassLoading; here, all static variables will be assigned with the original values, and the static block will be executed.

### Runtime Data Area

#### Method Area

Method area in JVM stores class structures like metadata, the constant runtime pool, and the code for methods. It is accessible to all threads.

The method area gets created during JVM start-up. It could be of fixed size or vary. Its memory may not be contiguous. JVM implementation can give control to programmer over Method area creation, its sizing etc. If method area memory is not sufficient to satisfy an allocation request then JVM throws _java.lang.OutOfMemoryError_.

#### Heap Area

Heap area in JVM is used for dynamic memory allocation for Java objects and JRE classes at the runtime. New objects are always created in heap space and the references to this objects are stored in stack memory.

This memory model is further broken into smaller parts called generations, these are:

- _Young Generation_ – this is where all new objects are allocated and aged. A minor Garbage collection occurs when this fills up.
- _Old or Tenured Generation_ – this is where long surviving objects are stored. When objects are stored in the Young Generation, a threshold for the object's age is set and when that threshold is reached, the object is moved to the old generation.
- _Permanent Generation_ – this consists of JVM metadata for the runtime classes and application methods.

##### Key Features of Heap Memory

- It's accessed via complex memory management techniques that include Young Generation, Old or Tenured Generation, and Permanent Generation.
- If heap space is full, Java throws _java.lang.OutOfMemoryError_.
- Access to this memory is relatively slower than stack memory.
- This memory, in contrast to stack, isn't automatically de-allocated. It needs Garbage Collector to free up unused objects so as to keep the efficiency of the memory usage.
- Unlike stack, a heap isn't thread-safe and needs to be guarded by properly synchronizing the code.

#### Stack Area

Stack area in JVM is used for static memory allocation and the execution of a thread. It contains primitive values that are specific to a method and references to objects that are in a heap, referred from the method.

Access to this memory is in Last-In-First-Out (LIFO) order. Whenever a new method is called, a new block on top of the stack is created which contains values specific to that method, like primitive variables and references to objects.

When the method finishes execution, it’s corresponding stack frame is flushed, the flow goes back to the calling method and space becomes available for the next method.

##### Key Features of Stack Memory

- It grows and shrinks as new methods are called and returned respectively.
- Variables inside stack exist only as long as the method that created them is running.
- It's automatically allocated and de-allocated when method finishes execution.
- If this memory is full, Java throws _java.lang.StackOverFlowError_.
- Access to this memory is fast when compared to heap memory.
- This memory is thread-safe as each thread operates in its own stack.

##### Stack and Heap in Example

```java
class Person {
    int pid;
    String name;

    Person(int pid, String name) {
        this.pid = pid;
        this.name = name;
    }
}

public class Driver {
    public static void main(String[] args) {
        int id = 23;
        String pName = "Jon";
        Person p = null;
        p = new Person(id, pName);
    }
}
```

Let's analyze this step by step:

- Upon entering the main() method, a space in stack memory would be created to store primitives and references of this method
  - The primitive value of integer _id_ will be stored directly in stack memory
  - The reference variable _p_ of type Person will also be created in stack memory which will point to the actual object in the heap
- The call to the parameterized constructor _Person(int, String)_ from _main()_ will allocate further memory on top of the previous stack. This will store:
  - The this object reference of the calling object in stack memory
  - The primitive value _id_ in the stack memory
  - The reference variable of _String_ argument _personName_ which will point to the actual string from string pool in heap memory
- This default constructor is further calling _setPersonName()_ method, for which further allocation will take place in stack memory on top of previous one. This will again store variables in the manner described above.
- However, for the newly created object _p_ of type Person, all instance variables will be stored in heap memory.

This allocation is explained in this diagram:

![JVM Stack and Heap](../../../images/jvm-stack-heap.jpg)

##### Stack vs Heap

| Parameter | Stack Area | Heap Area |
|:---------:|:----------:|:---------:|
| Application | Stack is used in parts, one at a time during execution of a thread | The entire application uses Heap space during runtime |
| Size | Stack has size limits depending upon OS and is usually smaller then Heap | There is no size limit on Heap |
| Storage | Stores only primitive variables and references to objects that are created in Heap Space | All the newly created objects are stored here |
| Order | It is accessed using Last-in First-out (LIFO) memory allocation system | This memory is accessed via complex memory management techniques that include Young Generation, Old or Tenured Generation, and Permanent Generation. |
| Life | Stack memory only exists as long as the current method is running | Heap space exists as long as the application runs |
| Efficiency | Comparatively much faster to allocate when compared to heap | Slower to allocate when compared to stack |
| Allocation/De-allocation | This Memory is automatically allocated and de-allocated when a method is called and returned respectively | Heap space is allocated when new objects are created and de-allocated by Garbage Collector when they are no longer referenced |

#### Program Counter (PC) Register

Program Counter (PC) register store the address of the JVM instruction which is currently executing. It is an abstract simulation of the physical PC register. In Java, each thread has its separate PC register. It is private to each thread, and the life cycle is consistent with the life cycle of the thread.

#### Native Method Stacks

Native method stacks hold the instruction of _native_ code depends on the _native_ library. It is written in another language instead of Java. Native method stacks may also be used by the implementation of an interpreter for the JVM instruction set in a language such as C. JVM implementations that cannot load native methods and that do not themselves rely on conventional stacks need not supply native method stacks. If supplied, native method stacks are typically allocated per thread when each thread is created.

### Execution Engine

The bytecode, which is assigned to the Runtime Data Area, will be executed by the Execution Engine. The Execution Engine reads the bytecode and executes it piece by piece.

- **Interpreter** – The interpreter interprets the bytecode faster but executes slowly. The disadvantage of the interpreter is that when one method is called multiple times, every time a new interpretation is required.
- **JIT Compiler** – The JIT Compiler neutralizes the disadvantage of the interpreter. The Execution Engine will be using the help of the interpreter in converting byte code, but when it finds repeated code it uses the JIT compiler, which compiles the entire bytecode and changes it to native code. This native code will be used directly for repeated method calls, which improve the performance of the system.
  - Intermediate Code Generator – Produces intermediate code
  - Code Optimizer – Responsible for optimizing the intermediate code generated above
  - Target Code Generator – Responsible for Generating Machine Code or Native Code
  - Profiler – A special component, responsible for finding hotspots, i.e. whether the method is called multiple times or not.
- **Garbage Collector**: GC collects and removes unreferenced objects. Garbage Collection can be triggered by calling System.gc(), but the execution is not guaranteed. Garbage collection of the JVM collects the objects that are created.

**Java Native Interface (JNI)**: JNI will be interacting with the Native Method Libraries and provides the Native Libraries required for the Execution Engine.

**Native Method Libraries**: This is a collection of the Native Libraries, which is required for the Execution Engine.

## How Java Code is Executed in JVM

### Compiling

In Java, programs are not compiled into executable files; they are compiled into bytecode (as discussed earlier), which the JVM (Java Virtual Machine) then executes at runtime. Java source code is compiled into bytecode when we use the _javac_ compiler. The bytecode gets saved on the disk with the file extension `.class`. When the program is to be run, the bytecode is converted, using the just-in-time (JIT) compiler. The result is machine code which is then fed to the memory and is executed.

Java code needs to be compiled twice in order to be executed:

- Java programs need to be compiled to bytecode.
- When the bytecode is run, it needs to be converted to machine code.

The Java classes/bytecode are compiled to machine code and loaded into memory by the JVM when needed the first time. This is different from other languages like C/C++ where programs are to be compiled to machine code and linked to create an executable file before it can be executed.

### Executing

The class files generated by the compiler are independent of the machine or the OS, which allows them to be run on any system. To run, the main class file (the class that contains the method main) is passed to the JVM, and then goes through three main stages before the final machine code is executed. These stages are:

- Class Loader: The main class is loaded into the memory by passing its `.class` file to the JVM, through invoking the latter. All the other classes referenced in the program are loaded through the class loader.
- Bytecode Verifier: After the bytecode of a class is loaded by the class loader, it has to be inspected by the bytecode verifier, whose job is to check that the instructions don’t perform damaging actions. The following are some of the checks carried out:
  - Variables are initialized before they are used.
  - Method calls match the types of object references.
  - Rules for accessing private data and methods are not violated.
  - Local variable accesses fall within the runtime stack.
  - The run time stack does not overflow.
- Just-In-Time Compiler: This is the final stage encountered by the java program, and its job is to convert the loaded bytecode into machine code. When using a JIT compiler, the hardware can execute the native code, as opposed to having the JVM interpret the same sequence of bytecode repeatedly and incurring the penalty of a relatively lengthy translation process. This can lead to performance gains in the execution speed, unless methods are executed less frequently.

#### JIT Compiler

The Just-In-Time (JIT) compiler is the compiler that converts the byte-code to machine code. It compiles byte-code once and the compiled machine code is re-used again and again, to speed up execution. Early Java compilers compiled the byte-code to machine code each time it was used, but more modern compilers cache this machine code for reuse on the machine. Even then, Java's JIT compiling was still faster than an "interpreter-language", where code is compiled from high level language, instead of from byte-code each time it was used.

The standard JIT compiler runs on demand. When a method is called repeatedly, the JIT compiler analyzes the bytecode and produces highly efficient machine code, which runs very fast. The JIT compiler is smart enough to recognize when the code has already been compiled, so as the application runs, compilation happens only as needed. As Java applications run, they tend to become faster and faster, because the JIT can perform runtime profiling and optimization to the code to meet the execution environment. Methods or code blocks which do not run often receive less optimization; those which run often (so called hotspots) receive more profiling and optimization.

### Why Java is Slow

The main reasons behind the slowness of Java are

- Dynamic Linking: Unlike C, linking is done at run-time, every time the program is run in Java.
- Runtime Interpreter: The conversion of byte code into native machine code is done at run-time in Java which furthers slows down the speed.
- Runtime GC: The garbage collector process decides to run and free memory that’s no longer used at run-time in Java.

However, the latest version of Java has addressed the performance bottlenecks to a great extent.

## References

- <https://www.guru99.com/java-virtual-machine-jvm.html>
- <https://www.baeldung.com/java-classloaders>
- <https://www.baeldung.com/java-stack-heap>
- <https://www.geeksforgeeks.org/compilation-execution-java-program/>
- <https://en.wikibooks.org/wiki/Java_Programming/Compilation>
