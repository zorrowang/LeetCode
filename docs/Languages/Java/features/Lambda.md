# Lambda Expressions in Java

Java lambda expressions are new in Java 8. Java lambda expressions are Java's first step into functional programming. A Java lambda expression is thus a function which can be created without belonging to any class. A Java lambda expression can be passed around as if it was an object and executed on demand.

## Syntax

The simplest lambda expression contains a single parameter and an expression:

```bash
parameter -> expression
```

To use more than one parameter, wrap them in parentheses:

```bash
(parameter1, parameter2, ...) -> expression
```

Expressions are limited. They have to immediately return a value, and they cannot contain variables, assignments or statements such as if or for. In order to do more complex operations, a code block can be used with curly braces. If the lambda expression needs to return a value, then the code block should have a return statement.

```bash
(parameter1, parameter2, ...) -> {code block}
```

## Using Lambda Expressions

Lambda expressions are usually passed as parameters to a function:

```java
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
    numbers.forEach( (n) -> { System.out.println(n); } );
  }
}
```
