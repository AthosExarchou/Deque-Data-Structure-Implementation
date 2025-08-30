# Deque Data Structure Implementation

Developed as a group project for the **Data Structures** course at [Harokopio University of Athens – Dept. of Informatics and Telematics](https://www.dit.hua.gr), this project implements a double-ended queue (Deque) data structure in Java, allowing for efficient insertion and deletion of elements at both ends of the queue.
The implementation supports both basic operations like push, pop, and size, as well as iterator functionality for traversing the elements in normal and reverse order.
It also includes automatic resizing of the underlying array when necessary.

## Features

- **Push to Front**: `pushFirst(E elem)`
- **Push to End**: `pushLast(E elem)`
- **Pop from Front**: `popFirst()`
- **Pop from End**: `popLast()`
- **Get First Element**: `first()`
- **Get Last Element**: `last()`
- **Check if Empty**: `isEmpty()`
- **Get Size**: `size()`
- **Clear Queue**: `clear()`
- **Iterators**:
    - **Normal Iterator**: Traverses elements from front to end.
    - **Descending Iterator**: Traverses elements from end to front.

## Classes

### `App.java`
Demonstrates the basic functionality of the `Deque` by performing operations such as pushing, popping, and iterating over the elements.

### `DeQueue.java`
Interface defining the methods supported by the `Deque` data structure.

### `DoubleEndedQueue.java`
Class that implements the `DeQueue` interface, with functionality for managing the underlying array, including automatic resizing and iterators.

### `BasicOperationsTest.java`
JUnit test for checking the basic operations of the `Deque`.

### `DeQueueTest.java`
JUnit test to verify the functionality of the `Deque` with a large number of elements.

### `EdgeCaseTest.java`
JUnit test to verify how the `Deque` handles edge cases such as popping from an empty queue.

### `IteratorsTest.java`
JUnit test to verify that both normal and descending iterators work as expected.

### `ResizingDeQueueTest.java`
JUnit test to verify the automatic resizing behavior (doubling and halving) of the underlying array.

## Dependencies

- Java 17+
- JUnit 4.12

## How To Run

Install maven:

```bash
mvn clean install
```

Compile:

```bash
mvn compile
```

Create a jar:

```bash
mvn package
```

Run main:

```bash
java -cp ./target/queue-1.0-SNAPSHOT.jar org.hua.queue.App
```

To run the tests, use Maven:

```bash
mvn test
```

This will run all the unit tests defined in the project.

## Authors

| Student ID   | Name                          |
|--------------|-------------------------------|
| it2022134    | Exarchou Athos                |
| it22149      | Alexandros-Georgios Zarkalis  |

## License
This project is licensed under the MIT License.
