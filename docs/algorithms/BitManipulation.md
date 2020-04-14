# Bit Manipulation

<!-- MarkdownTOC -->

- [Bitwise Operations](#bitwise-operations)
  - [AND](#and)
  - [NOT](#not)
  - [OR](#or)
  - [XOR](#xor)
  - [Arithmetic Shift](#arithmetic-shift)
  - [Logic Shift](#logic-shift)
- [Bitwise Tasks](#bitwise-tasks)
  - [Get Bit](#get-bit)
  - [Set Bit](#set-bit)
  - [Clear Bits](#clear-bits)
  - [Update Bit](#update-bit)
- [Applications](#applications)
  - [Math Problems](#math-problems)
  - [Optimization Problems](#optimization-problems)
- [References](#references)

<!-- /MarkdownTOC -->

Bit manipulation is the act of algorithmically manipulating bits or other pieces of data shorter than a word. Computer programming tasks that require bit manipulation include low-level device control, error detection and correction algorithms, data compression, encryption algorithms, and optimization.

## Bitwise Operations

Bitwise operation operates on one or more bit patterns or binary numerals at the level of their individual bits. Java is used here for examples.

### AND

**&** is the operator of bitwise AND that takes two equal-length binary representations and performs the logical AND operation.

```java
int i = 1 & 2;  // 0
```

### NOT

**~** is the operator of bitwise NOT that performs logical negation on each bit.

```java
// Boolean NOT
boolean flag = true;
boolean neg = !flag;

// bitwise negation for signed integer
int i = 10; // 1010
int j = ~i; // -11 = 0xFFFFFFF5 = 11111111 11111111 11111111 11110101
```

### OR

**|** is the operator of bitwise OR that takes two bit patterns of equal length and performs the logical inclusive OR operation on each pair of corresponding bits.

```java
int i = 5; // 0101
int j = 3; // 0011
int s = i & j; // 7 = 0111
```

### XOR

**^** is the operator of bitwise XOR that takes two bit patterns of equal length and performs the logical exclusive OR operation on each pair of corresponding bits.

```java
int i = 5; // 0101
int j = 3; // 0011
int s = i ^ j; // 6 = 0110
```

### Arithmetic Shift

**>>** and **<<** are the operators of right and left arithmetic shift that shifts bits to the right but fill in the new bits with the value of the sign bit.

```java
int i = 23;     // 0010111
int j = i << 1; // 0101110 = 46 (23*2)
int s = i >> 1; // 0001011 = 11 (23/2)

//shift negation
i = -23;        // 0xFFFFFFE9 = 11111111 11111111 11111111 11101001
j = i >> 1;     // -12 = 0xFFFFFFF4 = 11111111 11111111 11111111 11110100
```

### Logic Shift

**>>>** is the operator of right logic shift that shifts bits to the right but fill in the new bits with 0.

Note, there is no unsigned left shift operator, because it is identical to the logical (unsigned) left shift.

```java
int i = 23;      // 0010111
int s = i >>> 1; // 0001011 = 11 (23/2)

//shift negation
i = -23;        // 0xFFFFFFE9 = 11111111 11111111 11111111 11101001
j = i >>> 1;    // 2147483636 = 0x7FFFFFF4 = 01111111 11111111 11111111 11110100
```

## Bitwise Tasks

### Get Bit

Return the bit (boolean value) at _i-th_ position.

```java
boolean getBit( int num, int i ) {
    return ((num & (1 << i)) != 0);
}
```

### Set Bit

Set the bit at _i-th_ position to 1.

```java
int setBit( int num, int i, boolean value) {
    return num | (1 << i);
}
```

### Clear Bits

Clear bits at leftmost or rightmost.

```java
int clearBitsRightmost( int num, int i) {
    int mask = ~(-1 >>> (31 - i));
    return num & mask;
}

int clearBitsLeftmost( int num, int i) {
    int mask = ~(-1 << (31 - i));
    return num & mask;
}
```

### Update Bits

Set the bit at _i-th_ position to given boolean value.

```java
int updateBit(int num, int i, boolean val) {
    int value = val ? 1 : 0;
    int mask = ~(1 << i);
    return (num & mask) | (value << i);
}
```

## Applications

There are commonly two categories of bitwise interview questions:

- Math: use bit manipulation to resolve mathematical problems.
- Optimization: use integer bits as storage (_O(1)_ space complexity) to optimize solutions.

### Math Problems

- [Pow of Two](https://leetcode.com/problems/power-of-two/): determine if it is a power of two. The solution is [here](../../src/easy/number/PowerOfTwo.java).

### Optimization Problems

## References

- <https://en.wikipedia.org/wiki/Bit_manipulation>
- <https://en.wikipedia.org/wiki/Bitwise_operation>
