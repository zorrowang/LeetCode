# Stack

<!-- MarkdownTOC -->

- [Basic Operations](#basic-operations)
- [Implementations](#implementations)
  - [Implementing Stack by Arrays](#implementing-stack–by-arrays)
  - [Implementing Stack by LinkedList](#implementing-stack–by-linkedlist)
- [LinkedList Class](#linkedlist-class)
    - [LinkedList vs Stack](#linkedlist-vs-stack)
    - [Stack Featured Methods](#stack-featured-ethods)
- [Applications of Stack](#applications-of-stack)
  - [Design and Implementation](#design-and-implementation)
    - [Implement Queue using Stacks](#implement-queue-using-stacks)
    - [Implement Two Stacks in One Array](#implement-two-stacks-in-one-array)
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
// Add new node at head
public class Stack {
    StackNode root;

    static class StackNode {
        int val;
        StackNode next;

        StackNode(int val) {
            this.val = val;
        }
    }

    public boolean isEmpty() {
        if (root == null)
            return true;
        else
            return false;
    }

    public void push(int val) {
        StackNode newNode = new StackNode(val);
        if (root == null)
            root = newNode;
        else {
            StackNode temp = root;
            root = newNode;
            newNode.next = temp;
        }
    }

    public int pop() throws StackUnderflowException {
        int popped = Integer.MIN_VALUE;
        if (root == null)
           throw new StackUnderflowException();
        else {
            popped = root.val;
            root = root.next;
        }
        return popped;
    }

    public int peek() throws StackUnderflowException {
        if (root == null)
            throw new StackUnderflowException();
        else
            return root.val;
    }
}
```

## LinkedList Class

_LinkedList_ class provide the support for stack operations.

### LinkedList vs Stack

In Java, both _LinkedList_ and _Stack_ classes represents a last-in-first-out (LIFO) stack of objects. However, _Stack_ extends _Vector_ class, which is synchronized. So it has an overhead than LinkedList. Normally, most Java programmers use LinkedList instead of Vector because they can synchronize explicitly by themselves.

### Stack Featured Methods

- _E pop()_: Pops an element from the stack represented by this list.

- _void push(E e)_: Pushes an element onto the stack represented by this list.

- _E peek()_: Retrieves, but does not remove, the head (first element) of this list.

## Application of Stacks

### Design and Implementation

#### Implement Queue using Stacks

Using two stacks to accomplish it.

- enQueue operation costly
```
enQueue(q, x):
    While stack1 is not empty, push everything from stack1 to stack2.
    Push x to stack1 (assuming size of stacks is unlimited).
    Push everything back to stack1.

deQueue(q):
    If stack1 is empty then error
    Pop an item from stack1 and return it
```

- deQueue operation costly
```
enQueue(q,  x):
    Push x to stack1

deQueue(q):
    If both stacks are empty then error.
    If stack2 is empty
        While stack1 is not empty, push everything from stack1 to stack2.
    Pop the element from stack2 and return it.
```

#### Implement Two Stacks in One Array

Create a data structure twoStacks that represents two stacks. Implementation of twoStacks should use only one array. Following functions must be supported by twoStacks,
- _push1(int x)_ –> pushes x to first stack
- _push2(int x)_ –> pushes x to second stack
- _pop1()_ –> pops an element from first stack and return the popped element
- _pop2()_ –> pops an element from second stack and return the popped element

```
```

## References
- <https://en.wikipedia.org/wiki/Stack_(abstract_data_type)>
