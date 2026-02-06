package j08_binary_heaps;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PriorityQueue<T>{

    ArrayList<PQNode<T>> minbhList = new ArrayList<>();

    @Override
    public String toString(){
        return minbhList
            .stream()
            .map(node -> node.priority + ": " + node.value)
            .collect(Collectors.joining("\n")) + "\n";
    }

    public void enqueue(T value, int priority){
        PQNode<T> pqNode = new PQNode<T>(value, priority);
        minbhList.add(pqNode);
        bubbleUp(minbhList.size() - 1);
    }

    // Recursive solution
    // after adding to the ArrayList
    // if child priority is less than parent
    // switch child and parent
    // then check again 
    public void bubbleUp(int childIndex){

        // get parent index
        int parentIndex = (childIndex - 1)/2;
        
        // get child and parent priorities
        int childPriority = minbhList.get(childIndex).priority;
        int parentPriority = minbhList.get(parentIndex).priority;
        
        // if priority of child is less than priority of parent
        if (childPriority < parentPriority){
            // switch values
            swap(childIndex, parentIndex);
            // run again (parentIndex becomes new childIndex)
            bubbleUp(parentIndex);
        }
    }

    // Swap helper function
    // swaps nodes in minbhList
    public void swap(int firstIndex, int secondIndex){
        // Get the nodes
        PQNode<T> firstNode = minbhList.get(firstIndex);
        PQNode<T> secondNode = minbhList.get(secondIndex);
        // swap
        minbhList.set(secondIndex, firstNode);
        minbhList.set(firstIndex, secondNode);        
    }

    // Swap first and last nodes
    // Pop last node to return at the end
    // Have the new root "sink down" to the correct spot
    // Find index of the left child: 2 * index + 1 (make sure its not out of bounds)
    // Find index of the right child: 2 * index + 2 (make sure its not out of bounds)
    // If the left or right child is lower priority than the element, swap. 
    // If both are lower, swap with the lower child.
    // The child index you swapped to now becomes the new parent index.  
    // Keep looping and swapping until neither child is lower priority than the element.
    // Return the old root
    public PQNode<T> dequeue(){

        // Guard
        if (minbhList.size() == 0) return null;
        if (minbhList.size() < 3) return minbhList.removeFirst();
        
        // swap first and last values
        swap(0, minbhList.size() - 1);
        
        // remove last value
        PQNode<T> returnNode = minbhList.removeLast();
        
        // Rearrange
        sinkDown(0);

        // return removed value
        return returnNode;
    }

    // Helper function for removeRoot()
    // Recursively rearrange heap
    public void sinkDown(int parentIndex){

        // get child index
        Integer childIndex = lowestPriorityChildIndex(parentIndex);
        
        // guard
        if (childIndex == null) return;
        
        // get priorities
        int parentPriority = minbhList.get(parentIndex).priority;
        int childPriority = minbhList.get(childIndex).priority;

        // if child priority is less than parent priority
        if (childPriority < parentPriority){
            // swap parent and child values
            swap(parentIndex, childIndex);
            // run method again on new index
            sinkDown(childIndex);
        }
    }

    // Helper function for sinkDown()
    // find index of lowest (highest) priority child or return null
    public Integer lowestPriorityChildIndex(int parentIndex){
        
        // Get the child indexes
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        // if both are ob, return null
        if (leftChildIndex >= minbhList.size()) return null;
        
        // if only right is ob, return left
        else if (rightChildIndex >= minbhList.size()) return leftChildIndex;
        
        // if both are in bounds, return the index of larger value
        else {

            int leftChildPriority = minbhList.get(leftChildIndex).priority;
            int rightChildPriority = minbhList.get(rightChildIndex).priority;

            if (leftChildPriority < rightChildPriority) return leftChildIndex;
            else return rightChildIndex;
        }
    }
}
