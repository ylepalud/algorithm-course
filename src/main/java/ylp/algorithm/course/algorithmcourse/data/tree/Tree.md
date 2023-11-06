# Tree

Tree are everywhere

### Where are tree

* File system
* DOM
* Compilers
* etc ...

## Operation

### Traversal

Visiting a node then recurse

With Pre, post and recurse steps

### Deep First Search (DFS)

Complexity(n)

In Order while go left before visiting any node

We implicitly use a Stack. This mean we can rewrite this algorithm without recursion

### Breath First Search (BFS)

Complexity(n)

We visit each node of a deep before moving to the next tree level 

We implicitly use a Queue. This mean we can rewrite this algorithm without recursion

BFS preserve the shape of the tree

### Terminology

Root: Top Node

Height: The longest path from the root to the most child node (don't need to be balance)

Binary tree: A tree with 2 link at most by node

General tree: A tree with one to many node

Binary search tree: A tree which has a specific ordering

Leaf: A node without children

Balance tree: A tree is perfectly balanced when any node's left and right children ahve the same height

Branching factor: The amount of children a tree has

## Complexity
