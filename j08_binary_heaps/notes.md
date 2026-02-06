to run:
javac -d bin *.java && java -cp bin j08_binary_heaps.Main
--------------
BINARY HEAPS
Very similar to a binary search tree, but with some different rules!

In a MaxBinaryHeap, parent nodes are always larger than child nodes. 
In a MinBinaryHeap, parent nodes are always smaller than child nodes

MAX BINARY HEAP
Each parent has at most two child nodes
The value of each parent node is always greater than its child nodes
In a max Binary Heap the parent is greater than the children, but there are no guarantees between sibling nodes.
A binary heap is as compact as possible. 
All the children of each node are as full as they can be and left children are filled out first

Array Representation of a Max Binary Heap
Heaps are most often implemented using arrays
The root element will be at index 0

For any index of an array n...
The left child is stored at 2n + 1
The right child is at 2n + 2

For any child node at index  n...
Its parent is at index (n-1)/2 floored

HEAPS ARE USEFULE BECAUSE THEY HAVE A TIME COMPLEXITY OF O(log n) FOR INSERTING AND REMOVING ELEMENTS

PRIORITY QUEUE?

A data structure where each element has a priority. 
Elements with higher priorities are served before elements with lower priorities.

Write a Min Binary Heap - lower number means higher priority.
Each Node has a val and a priority.  Use the priority to build the heap.
Enqueue method accepts a value and priority, makes a new node, and puts it in the right spot based off of its priority.
Dequeue method removes root element, returns it, and rearranges heap using priority.