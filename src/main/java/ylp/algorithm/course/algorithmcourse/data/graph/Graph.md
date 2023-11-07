# Graph

So many problems eventually become graph problems. This is by far the largest section of algorithms

## Terminology

A -> B
B -> A
A -> C
C -> D
D -> A


* Cycle: For a given node, if I'm able to come back to the same node i start on 
  * A -> C -> D -> A is a cycle
* Acyclic: a graph without cycle
* Connected: Every node has a path to every other node
* Directed: edge have a direction A -> B
* Undirected: edge doesn't have direction
* Weighted: edge have a weight associated
* Dag: Directed Acyclic Graph
* Node: Vertex, point -> V
* Edge: Connection between two node -> E
    * Complexity = O(V * E) check every edge of every vertex

## Searching and adjacency

You can represent your graph with node as we did for list and tree, but usually it's not the case

### Adjacency list

Most represented

A list of all edges with 

[
    [
    {to: 1, weight: 1 },
    {to: 3, weight: 10 },
    ],
    [],
    [
    {to: 4, weight: 1 },
    ]
]

### adjacency Matrix

[
[0, 0, 10, 0, 0],
[0, 2, 0, 0, 0],
[0, 0, 0, 3, 0],
[0, 0, 0, 0, 1]
]

Indexes represent link if 0 not link if value this is the weight

Least represented because of space in memory O(v^2)

If 100 Node, we need a 100 * 100 matrix

## Basing search

In graph, we need to implement a path in order to keep track of value

We will implement a previous array and a seen array


seen = [false, ....]
previous = [-1, ...]
Queue = [StartNode]

### DFS

Use a stack

### BFS

Use a Queue

### Dijkstra

We will do a BFS because we need a previous path builder.

It's a greedy algorithm

We need a 

previous = [-1 ...]

seen = [false, false ...] (probably not needed with a better data structure)

distance = [Infinite, Infinite, Infinite, 0] 0 is the source

    while hastUnVisited()
        low = getLowestUnseen()
        seen[low] = true
    
        for edge in low
            if seen[edge] continue
            dist = dist [low] + edge.w
            if dist < dist[edge]
                prev[edge = low
                dist[edge] = dist