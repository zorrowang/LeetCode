# Java Language

Java is a class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is a general-purpose programming language intended to let application developers write once, run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation. Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) regardless of the underlying computer architecture.

However, with the raise of container, the core feature of Java, WORA, has become less and less attractive. On the contrary, the language level supports (like JVM and runtime GC) make Java very heavy and slow comparing with its opponents, such as Go.

## Java Syntax

Java is built almost exclusively as an object-oriented language. All code is written inside classes, and every data item is an object, with the exception of the primitive data types, (i.e. integers, floating-point numbers, boolean values, and characters), which are not objects for performance reasons.

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

Every line of code that runs in Java must be inside a **class**, appending the suffix _.java_. In the example, the class is named as _HelloWorld_. A class should always start with an uppercase first letter. Java is case-sensitive, _HelloWorld_ and _helloworld_ has different meaning.

The name of the java file **must match** the class name. When saving the file, save it using the class name and add ".java" to the end of the filename. To run the example above on your computer, make sure that Java is properly installed: Go to the Get Started Chapter for how to install Java. The output should be:

```bash
Hello, World!
```

### Main Method

The _main()_ method is required and you will see it in every Java program:

```java
public static void main(String[] args)
```

Any code inside the _main()_ method will be executed. The method name _main_ is not a keyword in the Java language. It is simply the name of the method the Java launcher calls to pass control to the program. Java classes that run in managed environments such as applets and Enterprise JavaBeans do not use or need a _main()_ method. A Java program may contain multiple classes that have main methods, which means that the VM needs to be explicitly told which class to launch from. When the source file contains multiple classes, it is necessary to make one class (introduced by the class keyword) public (preceded by the public keyword) and name the source file with that public class name.

The main method must accept an array of _String_ objects. By convention, it is referenced as args although any other legal identifier name can be used. Since Java 5, the main method can also use variable arguments, in the form of _public static void main(String... args)_, allowing the main method to be invoked with an arbitrary number of String arguments. The effect of this alternate declaration is semantically identical (to the args parameter which is still an array of String objects), but it allows an alternative syntax for creating and passing the array.

The Java launcher launches Java by loading a given class (specified on the command line or as an attribute in a JAR) and starting its _public static void main(String[]) method_. Stand-alone programs must declare this method explicitly. The _String[] args_ parameter is an array of String objects containing any arguments passed to the class. The parameters to main are often passed by means of a command line.

### Method Declaration

The keyword **public** denotes that a method can be called from code in other classes, or that a class may be used by classes outside the class hierarchy. The class hierarchy is related to the name of the directory in which the .java file is located. This is called an access level modifier. Other access level modifiers include the keywords **private** (a method that can only be accessed in the same class) and **protected** (which allows code from the same package to access). If a piece of code attempts to access private methods or protected methods, the JVM will throw a _SecurityException_

The keyword **static** in front of a method indicates a static method, which is associated only with the class and not with any specific instance of that class. Only static methods can be invoked without a reference to an object. Static methods cannot access any class members that are not also static. Methods that are not designated static are instance methods and require a specific instance of a class to operate.

The keyword **void** indicates that the main method does not return any value to the caller. If a Java program is to exit with an error code, it must call _System.exit()_ explicitly.

### Class

Everything in Java is associated with classes and objects, along with its attributes and methods. For example: in real life, a car is an object. The car has attributes, such as weight and color, and methods, such as drive and brake. Usually, class or attribute is a noun, while method is a verb.

A Class is like an object constructor, or a "blueprint" for creating objects.

## Java Execution System

### Java JVM and bytecode

One design goal of Java is portability, which means that programs written for the Java platform must run similarly on any combination of hardware and operating system with adequate run time support. This is achieved by compiling the Java language code to an intermediate representation called Java bytecode, instead of directly to architecture-specific machine code. Java bytecode instructions are analogous to machine code, but they are intended to be executed by a virtual machine (VM) written specifically for the host hardware. End users commonly use a Java Runtime Environment (JRE) installed on their machine for standalone Java applications, or in a web browser for Java applets.

The use of universal bytecode makes porting simple. However, the overhead of interpreting bytecode into machine instructions made interpreted programs almost always run more slowly than native executables. Just-in-time (JIT) compilers that compile byte-codes to machine code during runtime were introduced from an early stage. Java itself is platform-independent and is adapted to the particular platform it is to run on by a Java virtual machine (JVM) for it, which translates the Java bytecode into the platform's machine language.

### Performance

Programs written in Java have a reputation for being slower and requiring more memory than those written in C++ or Go. However, Java community try very hard to improve the execution speed.

Given JVM and runtime GC, the resource utilization of Java program is higher than its opponent, like C++ or Go.

## Difference Between JVM, JRE, and JDK

![JVM vs JRE vs JDK](../../../images/JDK_JRE_JVM.jpg)

### JVM (Java Virtual Machine)

A Java virtual machine (JVM) is a virtual machine that enables a computer to run Java programs as well as programs written in other languages that are also compiled to Java bytecode. The JVM is detailed by a specification that formally describes what is required in a JVM implementation.

The JVM reference implementation is developed by the OpenJDK project as open source code and includes a JIT compiler called HotSpot. The commercially supported Java releases available from Oracle Corporation are based on the OpenJDK runtime. Eclipse OpenJ9 is another open source JVM for OpenJDK.

More details about JVM is [here](./JVM.md).

### JRE (Java Runtime Environment)

The Java Runtime Environment (JRE) released by Oracle is a freely available software distribution containing a stand-alone JVM (HotSpot), the Java standard library (Java Class Library), a configuration tool, and—until its discontinuation in JDK 9—a browser plug-in. It is the most common Java environment installed on personal computers in the laptop and desktop form factor. Mobile phones including feature phones and early smartphones that ship with a JVM are most likely to include a JVM meant to run applications targeting Micro Edition of the Java platform. Meanwhile, most modern smartphones, tablet computers, and other handheld PCs that run Java apps are most likely to do so through support of the Android operating system, which includes an open source virtual machine incompatible with the JVM specification.

### JDK (Java Development Kit)

The Java Development Kit (JDK) is an implementation of either one of the Java Platform, Standard Edition, Java Platform, Enterprise Edition, or Java Platform, Micro Edition platforms[1] released by Oracle Corporation in the form of a binary product aimed at Java developers on Solaris, Linux, macOS or Windows. The JDK includes a private JVM and a few other resources to finish the development of a Java application.[2] Since the introduction of the Java platform, it has been by far the most widely used Software Development Kit (SDK).

## Interview using Java

### Pros

- Java is one of the most popular programming languages. It is accepted in an interview by most of tech companies.

- Java is a strong typed language,which forces to declare every variable with a data type. The code is commonly verbose and clean to read.

### Cons

- The coding efficiency in Java lower than scripting languages, like Python. You have to write more code in an interview.

- Java only accepts to pass by value, not by address.

- Java does not support return with multiple values.

## References

- <https://www.baeldung.com/jvm-vs-jre-vs-jdk>
- <https://en.wikipedia.org/wiki/Java_(programming_language)>
