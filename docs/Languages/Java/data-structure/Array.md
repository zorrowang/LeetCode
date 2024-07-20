# Array

Array is a data structure consisting of a collection of elements (values or variables), each identified by at least one array index or key. So accessing any element by its index or key is constant time as O(1), and looping the array is linear time as O(n).

This doc will introduce the data structure of the array in Java and techniques for interviews.

<!-- MarkdownTOC -->
- [Array in Java](#array-in-java)
  - [Declaration](#declaration)
  - [Initialization](#initialization)
    - [Array literal](#array-literal)
  - [Access](#access)
  - [Multidimensional Arrays](#multidimensional-arrays)
  - [Using Array in function](#using-array-in-function)
  - [Arrays class in Java](#arrays-class-in-java)
    - [Copying an Array with Arrays.copyOf()](#converting-to-a-list-with-aslistt-a)
    - [Copying an Array with Arrays.copyOf()](#copying-an-array-with-arrayscopyof)
    - [Copying an Array with Arrays.copyOfRange()](#copying-an-array-with-arrayscopyofrange)
    - [Sorting Arrays with Arrays.sort()](#sorting-arrays-with-arrayssort)
    - [Filling Arrays with Arrays.fill()](#filling-arrays-with-arraysfill)
    - [Searching Arrays with Arrays.binarySearch()](#searching-arrays-with-arraysbinarysearch)
    - [Checking if Arrays are Equal with Arrays.equals()](#checking-if-arrays-are-equal-with-arraysequals)
- [Things to be clarified in an interview](#things-to-be-clarified-in-an-interview)
- [Techniques](#techniques)
  - [Two-Pointer Technique](#two-pointer-technique)
  - [Sliding Window Technique](#sliding-window-technique)
  - [Prefix/Suffix Sum](#prefixsuffix-sum)
  - [Dynamic Programming](#dynamic-programming)
- [References](#references)

<!-- /MarkdownTOC -->

## Array in Java

An array can contain primitive data types as well as objects of a class depending on the definition of array. In the case of primitive data types, the actual values are stored in contiguous memory locations. In the case of objects of a class, the actual objects are stored in a heap segment.

- In Java, all arrays are dynamically allocated.
- Since arrays are objects in Java, we can find their length using member length.
- A Java array variable can also be declared like other variables with [] after the data type.
- The variables in the array are ordered and each has an index beginning from 0.
- Java array can also be used as a static field, a local variable, or a method parameter.
- The size of an array must be specified by an int value and not long or short.
- The direct superclass of an array type is Object.
- Every array type implements the interfaces _Cloneable_ and _java.io.Serializable_.

### Declaration

The general form of an array declaration is

```java
Type variableName[];  OR  Type[] variableName;        // One-dimensional array
Type variableName[][];  OR  Type[][] variableName;    // Two-dimensional array
```

An array declaration has two components: the type and the name. Type declares the element type of the array. The element type determines the data type of each element that comprises the array.
Examples:

```java
int intArray[];         // Array of primitive integers
float[][] floatArray;   // Array of primitive floats
String[] strArray;      // Array of strings (string is not primitive in Java)
Object[]  ao;           // Array of base objects
Collection[] ca;        // Array of collections
```

The array declaration as _`int intArray[];`_ does not create any of them in memory. So **no array actually exists**. It simply tells the compiler that this (_`intArray`_) variable will hold an array of the integer type. To link intArray with an actual, physical array of integers, you must allocate one using **new** and assign it to intArray.

### Initialization

The general form of new as it applies to one-dimensional arrays appears as follows:

```java
variableName = new type [size];
```

Here, type specifies the type of data being allocated, size specifies the number of elements in the array, and var-name is the name of array variable that is linked to the array. That is, to use new to allocate an array, you must specify the type and number of elements to allocate.

Examples:

```java
int[] intArray = new int[20];

int[] intArray2;
intArray2 = new int[20];

System.out.println(Arrays.toString(new int[]{1, 2}));  // Array literal, introduced later
```

The elements in the array allocated by the new will automatically be initialized as

- boolean : `false`
- int : `0`
- double : `0.0`
- String : `null`
- User defined type : `null`

Array length cannot be changed once it has been created.

#### Array literal

In a situation, where the size and variables of the array are already known, array literals can be used.

```java
int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
int[] intArray = { 1,2,3,4,5,6,7,8,9,10 };
```

The length of this array determines the length of the created array. There is no need to write the new int[] part in the latest versions of Java

### Access

Each element in the array is accessed via its index. The index begins with _0_ and ends at _(total array size)-1_. All the elements of an array can be accessed using Java for Loop.

```java
for (int i = 0; i < arr.length; i++)
  System.out.println("Element at index " + i + " : "+ arr[i]);
```

### Multidimensional Arrays

Multidimensional arrays are arrays of arrays with each element of the array holding the reference of another array. These are also known as [Jagged Arrays](https://en.wikipedia.org/wiki/Jagged_array). A multidimensional array is created by appending one set of square brackets ([]) per dimension. Examples:

```java
int[][] intArray = new int[10][20];         //a 2D array or matrix
int[][][] intArray2 = new int[10][20][10];   //a 3D array

int[][]c;
c = new int[2][]; // creates 2 rows
c[0] = new int[5]; // 5 columns for row 0
c[1] = new int[3]; // create 3 columns for row 1
```

### Using Array in function

Like variables, we can pass and return arrays in a function.

```java
public static String[] toString(int[] arr) {
  String[] strArray = new String[arr.length];
  for (int i = 0; i < arr.length; i++)
    strArray[i] = String.valueOf(arr[i]);
  return strArray;
}
```

### _Arrays_ class in Java

Java contains a special utility class that makes it easier for you to perform many often-used array operations like copying and sorting arrays, filling in data, searching in arrays etc. The utility class is called Arrays and is located in the standard Java package _java.util_.

#### Converting to a list with _asList(T... a)_

```java
String[] array = {"Larry", "Moe", "Curly"};
List<String> stooges = Arrays.asList(array);
```

#### Copying an Array with _Arrays.copyOf()_

```java
int[] source = new int[10]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int[] dest = Arrays.copyOf(source, source.length);  // the length of new array is 10
```

#### Copying an Array with _Arrays.copyOfRange()_

```java
int[] source = new int[10]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int[] dest = Arrays.copyOf(source, 1, 5);   // the length of new array is 5
```

#### Sorting Arrays with _Arrays.sort()_

```java
int[] nums = new int[10]{10, 3, 4, 9, 6, 1};
Arrays.sort(nums);
```

#### Filling Arrays with _Arrays.fill()_

```java
int[] intArray = new int[10];
Arrays.fill(intArray, 123);
```

#### Searching Arrays with _Arrays.binarySearch()_

```java
int[] ints = {0,2,4,6,8,10};
int index = Arrays.binarySearch(ints, 6);
System.out.println(index);
```

#### Checking if _Arrays are Equal with Arrays.equals()_

```java
int[] ints1 = {0,2,4,6,8,10};
int[] ints2 = {0,2,4,6,8,10};
int[] ints3 = {10,8,6,4,2,0};

boolean ints1EqualsInts2 = Arrays.equals(ints1, ints2);
boolean ints1EqualsInts3 = Arrays.equals(ints1, ints3);

System.out.println(ints1EqualsInts2);     // true
System.out.println(ints1EqualsInts3);     // false
```

## Things to be clarified in an interview

- Is the array sorted or partially sorted?
  If so, it means you can use binary search, in which time complexity is O(lgn).

- Can you manipulate the array in place?
  The reference of an array is a pointer. So any change will be preserved.

- Can you sort the array?
  Sometimes sorting the array first may significantly simplify the problem. Make sure that the order of array elements does not need to be preserved before attempting a sort.

- Are there duplicates in the array? Would it affect the answer?
  Make sure the result is unique or not.

## Techniques

### Two-Pointer Technique

Two-pointers are really an easy and effective technique that is typically used for searching pairs in a sorted array, or one slow-runner and the other fast-runner.

Given a sorted array A (sorted in ascending order), having N integers, find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X.

```java
boolean isSum(int[] nums, int target) {
  int i = 0, j = nums.length;
  while(i < j) {
    int sum = nums[i] + nums[j];
    if (sum == target)  return true;
    else if (sum < target)  i++;
    else  j--;
  }
  return false;
}

```

### Sliding Window Technique

This technique shows how a nested _`for`_ loop in a few problems can be converted to a single _`for`_ loop and hence reducing the time complexity. It can be best understood with the window pane in bus, consider a window of length **n** and the pane which is fixed in it of length **k**.

Applying the sliding window technique :

- We compute the sum of the first k elements out of n terms using a linear loop and store the sum in variable window_sum.
- Then we will graze linearly over the array till it reaches the end and simultaneously keep track of the maximum sum.
- To get the current sum of the block of k elements just subtract the first element from the previous block and add the last element of the current block.

For example, given an array as `{5, 2, -1, 0, 3}` and fixed window size is `3`.

![Sliding window 1](../../../images/sliding-window1.png)

![Sliding window 2](../../../images/sliding-window2.png)

![Sliding window 3](../../../images/sliding-window3.png)

The size of the sliding window is, sometimes, not fixed. In that case, we need to move the pointers inconsistently, but make sure the size should _not_ be `0`.

### Prefix/Suffix Sum

For questions where summation or multiplication of a sub-array is involved, pre-computation using hashing or a prefix/suffix sum/product might be useful.

```java
int[] left = new int[nums.length];
for (int i=1; i<nums.length; i++) {
    left[i] = nums[i-1] + left[i-1];
}
```

### Dynamic Programming

DP is introduced in its own [doc](../../algorithms/DynamicProgramming.md).

## References

- <https://en.wikipedia.org/wiki/Array_data_structure>
- <https://www.geeksforgeeks.org/arrays-in-java/>
- <https://www.geeksforgeeks.org/two-pointers-technique/>
- <https://www.geeksforgeeks.org/window-sliding-technique/>
