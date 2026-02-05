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

// Iterative solution
// public void sortPostAdd(){

//     int indexChild = mbhArrayList.size() - 1;
//     int indexParent = (indexChild - 1)/2;
//     int parentValue = mbhArrayList.get(indexParent);
//     int childValue = mbhArrayList.get(indexChild);
        
//     while (childValue > parentValue) {

//         mbhArrayList.set(indexParent, childValue);
//         mbhArrayList.set(indexChild, parentValue);
            
//         indexChild = indexParent;
//         indexParent = (indexChild - 1)/2;
            
//         parentValue = mbhArrayList.get(indexParent);
//         childValue = mbhArrayList.get(indexChild);
//     }
// }