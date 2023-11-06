# Heap

Priority Queue = Heap

It's a Binary Tree where 

* every child and grand child is smaller
* Or Every child and grand child is larger (MinHeap)

Thant the current node.

* Whenever a node is added, we must adjust the tree
* Whenever a node is deleted, we must adjust the tree
* There is no traversing the tree (we could, but we don't)

heap is weak ordering

Heap Min condition: Based on a current node every child are smaller (or equal) than me
Heap Max condition: Based on a current node every child are bigger (or equal) than me

Every node is filled from the left to the right et every depth is full before moving on


Stored as an Array.

Given an index I

If you want the left child -> 2i + 1

If you want the right child -> 2i + 2

If you want the parent -> (i - 1) / 2

## Characteristics

* It is self balancing
* It can be used for priority
* Funnest data structure to implement, but easy to get wrong
