# String

A string is traditionally a sequence of characters, either as a literal constant or as some kind of variable.

## String in Java

Strings in Java are Objects that are backed internally by a char array. Since arrays are immutable(cannot grow), Strings are immutable as well. Whenever a change to a String is made, an entirely new String is created.

```java
String str1 = "LeetCode";                   // String literal
String str2 = new String("LeetCode");       // Using new keyword
```

### Memory allotment of String

### String methods

- _int length()_: Returns the number of characters in the String.

```java
String str1 = "LeetCode";
str1.length();
"LeetCode".length();
```

- _char charAt(int i)_: Returns the character at i-th index.

```java
"LeetCode".charAt(3);   // returns: 't'
```

- _String substring(int i)_: Return the substring stating the i-th index character to end.

```java
"LeetCode".substring(3);    // returns: "tCode"
```

- _String substring(int i, int j)_: Returns the substring from i to j-1 index (excluding j-th).

```java
"LeetCode".substring(3, 6);    // returns: "tCo"
```

- _String concat(String str)_: Concatenates specified string to the end of this string.

```java
"LeetCode".concat(" is good");    // returns: "tCo"
```

- _int indexOf(String s)_: Returns the index within the string of the first occurrence of the specified string, -1 if it does not exist.

```java
"LeetCode".indexOf("Code");    // returns: 4
"LeetCode".indexOf("code");    // returns: -1
```

- _int indexOf(String s, int i)_: Returns the index within the string of the first occurrence of the specified string, starting at the i-th index.

```java
"LeetCode".indexOf("Code", 3);    // returns: 4
"LeetCode".indexOf("Code", 5);    // returns: -1
```

- _Int lastIndexOf(String s)_: Returns the index within the string of the last occurrence of the specified string.

```java
"LeetCodeCode".lastIndexOf("Code", 3);    // returns: 8
```

- _boolean equals(Object otherObj)_: Compares this string to the specified object.

```java
"LeetCode".equals("LeetCode");    // returns: true
"LeetCode".equals("leetcode");    // returns: false
```

- _boolean  equalsIgnoreCase(String anotherString)_: Compares string to another string, ignoring case considerations.

```java
"LeetCode".equalsIgnoreCase("LeetCode");    // returns: true
```

- _int compareTo(String anotherString)_: Compares two string lexicographically.

```java
int out = s1.compareTo(s2);
//  This returns difference s1-s2. If :
//  out < 0  // s1 comes before s2
//  out = 0  // s1 and s2 are equal.
//  out > 0   // s1 comes after s2
```

## Classes in Strings in Java

## Things to be clarified in interview

## Techniques

## Reference
