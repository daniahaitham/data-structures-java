# Data Structures & Algorithms in Java

A university data structures project made of three parts. The structures (linked list, stack, queue) are written from scratch instead of using `java.util` collections.

## Part 1: Task Manager (`src/task1`)

A console app for managing tasks, built on custom data structures:

| Feature | Data structure |
|---|---|
| Store all tasks | Custom singly linked list |
| View tasks ordered by due date | Bubble sort on the linked list |
| History of completed tasks | Custom queue (first completed, first shown) |
| Urgent tasks | Custom stack |
| Tasks by category | `HashMap<String, LinkedList>` |

Input errors (non-numbers, an invalid priority) are handled without crashing.

## Part 2: Sorting comparison (`src/comparingAlgos`)

Compares **merge sort** (O(n log n)) with an **enhanced selection sort** that places the minimum and the maximum in each pass. It is timed on sorted, random and reversed arrays.

Sample run (milliseconds):

| Array size | Merge sort | Enhanced selection sort |
|---|---|---|
| 10,000 | 2–3 | 44–95 |
| 100,000 | 9–12 | about 4,400 |

Merge sort stays near-linear as the input grows, while selection sort grows quadratically. To try 1,000,000 elements, change `sizes` in `testClass.java` (selection sort will then take minutes).

## Part 3: Shortest paths (`src/Task3`)

Dijkstra and Bellman-Ford on the same 8-node graph, which contains a negative edge weight. Bellman-Ford returns the correct distances (node 2 is at distance -4). Dijkstra returns 4 for the same node, which shows why it cannot be used with negative weights.

## Run it

Requires JDK 11 or newer.

```bash
javac -d out $(find src -name "*.java")

java -cp out task1.main                 # task manager
java -cp out comparingAlgos.testClass   # sorting benchmark
java -cp out Task3.main                 # Dijkstra vs Bellman-Ford
```

On Windows PowerShell, compile with: `javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName`

## What I learned

- Building a linked list, stack and queue from scratch and using each where its behaviour fits
- Measuring algorithm performance instead of only reasoning about it
- Why algorithm assumptions matter (negative weights break Dijkstra)
- Input validation and exception handling in console programs
