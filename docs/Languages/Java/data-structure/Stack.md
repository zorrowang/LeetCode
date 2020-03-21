# Stack

<!-- MarkdownTOC -->

- [Basic Operations](#basic-operations)
- [Implementations](#implementations)
  - [Implementing Stack by Arrays](#implementing-stack–by-arrays)
  - [Implementing Stack by LinkedList](#implementing-stack–by-linkedlist)
- [References](#references)

<!-- /MarkdownTOC -->

Stack is a linear data structure, which follows the operational order LIFO(Last In First Out) or FILO(First In Last Out).

![stack](../../../images/stack.jpg)

## Basic Operations

- _Push_: Constant time O(1), add an item in the stack. If the stack is full, then it is said to be an Overflow condition. O(1)
- _Pop_: Constant time O(1), removes an item from the stack. The items are popped in the reversed order in which they are pushed. If the stack is empty, then it is said to be an Underflow condition.
- _Peek_ or _Top_: Constant time O(1), returns top element of stack.

## Implementations

### Implementing Stack by Arrays

```java
class Stack { 
    int top, capacity;
    int[] val;

    Stack(int capacity) {
        this.top = -1;
        this.capacity = capacity;
        this.val = new int[capacity];
    }
  
    boolean isEmpty() { 
        return top < 0; 
    } 
  
    boolean push(int x) { 
        if (top >= capacity) { 
            return false; // Stack Overflow
        } 
        else { 
            val[++top] = x; 
            return true; 
        } 
    } 
  
    int pop() throws StackUnderflowException { 
        if (top < 0) { 
            throw new StackUnderflowException();
        } 
        else { 
            return val[top--]; 
        } 
    } 
  
    int peek() throws StackUnderflowException { 
        if (top < 0) { 
            throw new StackUnderflowException(); 
        } 
        else { 
            return val[top]; 
        } 
    } 
} 
```

### Implementing Stack by LinkedList

```java

```

## LinkedList Class



## Applications of Stack

- Balancing of symbols
- Infix to Postfix /Prefix conversion
- Redo-undo features at many places like editors, photoshop.
- Forward and backward feature in web browsers
- Used in many algorithms like Tower of Hanoi, tree traversals, stock span problem, histogram problem.
- Other applications can be Backtracking, Knight tour problem, rat in a maze, N queen problem and sudoku solver
- In Graph Algorithms like Topological Sorting and Strongly Connected Components

## References
- <https://en.wikipedia.org/wiki/Stack_(abstract_data_type)>
