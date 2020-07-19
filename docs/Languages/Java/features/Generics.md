# Generics in Java

<!-- MarkdownTOC -->

- [Needs for Generics](#needs-for-generics)
- [Generic Method](#generic-method)
  - [Generic Type Naming](#generic-type-naming)
  - [Bounded Generics](#bounded-generics)
  - [Multiple Bounds](#multiple-bounds)
- [Generic Class](#generic-class)
- [Generic Interface](#generic-interface)
- [Wildcards in Generics](#wildcards-in-generics)
- [Generics and Primitive Data Types](#generics-and-primitive-data-types)
- [References](#references)

<!-- / MarkdownTOC -->

Generics in Java allows type, including String, Integer or user-defined type, to be a parameter to methods, classes and interfaces. It is a powerful addition to the Java language as it makes the programmer's job easier and less error-prone. Generics enforce type correctness at compile time and, most importantly, enable implementing generic algorithms without causing any extra overhead to our applications.

## Needs for Generics

Let's imagine a scenario where we want to create a list in Java to store Integer; we can be tempted to write:

```java
List list = new LinkedList();
list.add(new Integer(1));
Integer i = list.iterator().next();
```

Surprisingly, the compiler will complain about the last line. It doesn't know what data type is returned. The compiler will require an explicit casting:

```java
Integer i = (Integer) list.iterator.next();
```

There is no contract that could guarantee that the return type of the list is an Integer. The defined list could hold any object. We only know that we are retrieving a list by inspecting the context. When looking at types, it can only guarantee that it is an Object, thus requires an explicit cast to ensure that the type is safe.

This cast can be annoying, we know that the data type in this list is an Integer. The cast is also cluttering our code. It can cause type-related runtime errors if a programmer makes a mistake with the explicit casting.

It would be much easier if programmers could express their intention of using specific types and the compiler can ensure the correctness of such type. This is the core idea behind generics.

Let's modify the first line of the previous code snippet to:

```java
List<Integer> list = new LinkedList<>();
```

By adding the diamond operator <> containing the type, we narrow the specialization of this list only to Integer type i.e. we specify the type that will be held inside the list. The compiler can enforce the type at compile time.

In small programs, this might seem like a trivial addition, however, in larger programs, this can add significant robustness and makes the program easier to read.

## Generic Method

Generic method is written with a single method declaration and can be called with arguments of different types. The compiler will ensure the correctness of whichever type is used. These are some properties of generic methods:

- Generic methods have a type parameter (the diamond operator enclosing the type) before the return type of the method declaration
- Type parameters can be bounded
- Generic methods can have different type parameters separated by commas in the method signature
- Method body for a generic method is just like a normal method

An example of defining a generic method to convert an array to a list:

```java
public <T> List<T> fromArrayToList(T[] a) {
    return Arrays.stream(a).collect(Collectors.toList());
}
```

In this example, the _<T>_ in the method signature implies that the method will be dealing with generic type _T_. This is needed even if the method is returning void.

Generic method can deal with more than one generic type, where this is the case, all generic types must be added to the method signature, for example, if we want to modify the above method to deal with type _T_ and type _G_, it should be written like this:

```java
public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
    return Arrays.stream(a).map(mapperFunction).collect(Collectors.toList());
}

@Test
public void givenArrayOfIntegers_thanListOfStringReturnedOK() {
    Integer[] intArray = {1, 2, 3, 4, 5};
    List<String> stringList
        = Generics.fromArrayToList(intArray, Object::toString);

    assertThat(stringList, hasItems("1", "2", "3", "4", "5"));
}
```

### Generic Type Naming

Oracle recommendation is to use an uppercase letter to represent a generic type and to choose a more descriptive letter to represent formal types. The type parameter names are single, uppercase letters to make it easily distinguishable from Java variables. The most commonly used type parameter names are:

- E – Element (used extensively by the Java Collections Framework, for example ArrayList, Set etc.)
- K – Key (Used in Map)
- N – Number
- T – Type
- V – Value (Used in Map)
- S,U,V etc. – 2nd, 3rd, 4th types

### Bounded Generics

The type parameters can be bounded. Bounded means “restricted“, we can restrict types that can be accepted by a method. For example, we can specify that a method accepts a type and all its subclasses (upper bound) or a type all its superclasses (lower bound).

To declare an upper bounded type we use the keyword _extends_ after the type followed by the upper bound that we want to use. For example:

```java
public <T extends Number> List<T> fromArrayToList(T[] a) {
    // TODO
}
```

The keyword extends is used here to mean that the type _T_ extends the upper bound in case of a class or implements an upper bound in case of an interface.

### Multiple Bounds

A type can also have multiple upper bounds as follows:

```java
public <T extends Number & Comparable> List<T> fromArrayToList(T[] a) {
    // TODO
}
```

If one of the types that are extended by _T_ is a class (i.e _Number_), it must be put first in the list of bounds. Otherwise, it will cause a compile-time error.

## Generic Class

A generic type is a class that is parameterized over types.

```java
public class GenericsType<T> {

    private T t;

    public T get(){
        return this.t;
    }

    public void set(T t1){
        this.t = t1;
    }

    public static void main(String args[]){
        GenericsType<String> type = new GenericsType<>();
        type.set("Testing");                        //valid

        GenericsType type1 = new GenericsType();    //raw type
        type1.set("Testing");                       //valid
        type1.set(10);                              //valid and autoboxing support
    }
}
```

## Generic Interface

Generic interface is very similar as generic class.

```java
public interface Comparable<T> {
    public int compareTo(T o);
}
```

## Wildcards in Generics

Wildcards are represented by the question mark in Java `?` and they are used to refer to an unknown type. Wildcards are particularly useful when using generics and can be used as a parameter type but first, there is an important note to consider.

It is known that _Object_ is the supertype of all Java classes, however, a collection of _Object_ is not the supertype of any collection. For example, a _List<Object>_ is not the supertype of _List<String>_ and assigning a variable of type _List<Object>_ to a variable of type _List<String>_ will cause a compiler error. This is to prevent possible conflicts that can happen if we add heterogeneous types to the same collection.

The Same rule applies to any collection of a type and its subtypes. Consider this example:

```java
public static void paintAllBuildings(List<Building> buildings) {
    buildings.forEach(Building::paint);
}
```

If we imagine a subtype of Building, for example, a House, we can't use this method with a list of House, even though House is a subtype of Building. If we need to use this method with type Building and all its subtypes, then the bounded wildcard can do the magic.

```java
public static void paintAllBuildings(List<? extends Building> buildings) {
    buildings.forEach(Building::paint);
}
```

Now, this method will work with type Building and all its subtypes. This is called an upper bounded wildcard where type Building is the upper bound.

Wildcards can also be specified with a lower bound, where the unknown type has to be a supertype of the specified type. Lower bounds can be specified using the super keyword followed by the specific type, for example, *<? super T>* means unknown type that is a superclass of *T* (= T and all its parents).

## Type Erasure

Generics were added to Java to ensure type safety and to ensure that generics wouldn't cause overhead at runtime, the compiler applies a process called type erasure on generics at compile time.

Type erasure removes all type parameters and replaces it with their bounds or with Object if the type parameter is unbounded. Thus the bytecode after compilation contains only normal classes, interfaces and methods thus ensuring that no new types are produced. Proper casting is applied as well to the Object type at compile time.

This is an example of type erasure:

```java
public <T> List<T> genericMethod(List<T> list) {
    return list.stream().collect(Collectors.toList());
}
```

With type erasure, the unbounded type T is replaced with Object as follows:

```java
// for illustration
public List<Object> withErasure(List<Object> list) {
    return list.stream().collect(Collectors.toList());
}

// which in practice results in
public List withErasure(List list) {
return list.stream().collect(Collectors.toList());
}
```

If the type is bounded, then the type will be replaced by the bound at compile time:

```java
public <T extends Building> void genericMethod(T t) {
    ...
}
```

would change after compilation:

```java
public void genericMethod(Building t) {
    ...
}
```

## Generics and Primitive Data Types

A restriction of generics in Java is that the type parameter cannot be a primitive type.

For example, the following doesn't compile:

```java
List<int> list = new ArrayList<>();
list.add(17);
```

To understand why primitive data types don't work, let's remember that generics are a compile-time feature, meaning the type parameter is erased and all generic types are implemented as type Object.

As an example, let's look at the add method of a list:

```java
List<Integer> list = new ArrayList<>();
list.add(17);
```

The signature of the add method is:

```java
boolean add(E e);
```

And will be compiled to:

```java
boolean add(Object e);
```

Therefore, type parameters must be convertible to Object. Since primitive types don't extend Object, we can't use them as type parameters.

However, Java provides boxed types for primitives, along with autoboxing and unboxing to unwrap them:

```java
Integer a = 17;
int b = a;
```

So, if we want to create a list which can hold integers, we can use the wrapper:

```java
List<Integer> list = new ArrayList<>();
list.add(17);
int first = list.get(0);
```

The compiled code will be the equivalent of:

```java
List list = new ArrayList<>();
list.add(Integer.valueOf(17));
int first = ((Integer) list.get(0)).intValue();
```

Future versions of Java might allow primitive data types for generics. Project [Valhalla](https://openjdk.java.net/projects/valhalla/) aims at improving the way generics are handled. The idea is to implement generics specialization as described in JEP 218.

## References

- <https://www.geeksforgeeks.org/generics-in-java/>
- <https://www.baeldung.com/java-generics>
- <https://www.journaldev.com/1663/java-generics-example-method-class-interface>
