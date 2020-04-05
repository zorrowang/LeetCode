# Graph

<!-- MarkdownTOC -->

- [Definition](#definition)
- [Graph Types](#graph-types)
  - [Undirected Graph](#undirected-graph)
  - [Directed Graph](#directed-graph)
- [Graph Representations](graph-representations)
  - [Adjacency Matrix](#adjacency-matrix)
  - [Adjacency List](#adjacency-list)
- [Applications of Graph](#applications-of-graph)
  - [Topological Sort](#topological-sort)
  - [Union Find](#union-find)
- [References](#references)

<!-- /MarkdownTOC -->

## Definition

Graph is an abstract data type that is meant to implement the **undirected graph** and **directed graph** concepts from the field of graph theory within mathematics.

A graph data structure consists

- a finite (and possibly mutable) set of _vertices_ (also called _nodes_ or _points_)
- a set of unordered pairs of these vertices for an undirected graph or a set of ordered pairs for a directed graph. These pairs are known as _edges_ (also called _links_ or _lines_), and for a directed graph are also known as _arrows_. The edges may contain weight/value/cost.

## Graph Types

### Undirected Graph

![Undirected graph](../../../images/Undirected.png)

A undirected graph is a pair _G = (V, E)_, where _V_ is a set whose elements are called vertices (singular: vertex), and _E_ is a set of two-sets (sets with two distinct elements) of vertices, whose elements are called edges.

The vertices _x_ and _y_ of an edge _{x, y}_ are called the endpoints of the edge. The edge is said to _join x_ and _y_ and to be _incident_ on _x_ and _y_. A vertex may not belong to any edge.

### Directed Graph

![Directed graph](../../../images/Directed.png)

In formal terms, a directed graph is an ordered pair G = (V, A) where[1]

- _V_ is a set whose elements are called vertices, nodes, or points;
- _A_ is a set of ordered pairs of vertices, called arrows, **directed** edges.

## Graph Representations

The representation of graph includes two components

- A finite set of vertices
- A finite set of unordered or ordered pair of the form (u, v) as edges

### Adjacency Matrix



### Adjacency List

## Applications of Graph

### Topological Sort

### Union Find

## References

- <https://en.wikipedia.org/wiki/Graph_(abstract_data_type)>
- <https://en.wikipedia.org/wiki/Graph_(discrete_mathematics)>
