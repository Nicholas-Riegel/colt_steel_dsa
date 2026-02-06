package j08_binary_heaps;

import java.util.ArrayList;

public class MaxBinaryHeap {

    ArrayList<Integer> maxbhList = new ArrayList<>();

    @Override
    public String toString(){
        return maxbhList.toString();
    }

    public void addLeaf(int value){
        maxbhList.add(value);
        arrangeFromLeaf(maxbhList.size() - 1);
    }

    // Recursive solution
    // after adding to the ArrayList
    // if child is greater than parent
    // switch child and parent
    // then check again 
    public void arrangeFromLeaf(int childIndex){

        // get parent index
        int parentIndex = (childIndex - 1)/2;
        
        // get child and parent values
        int childValue = maxbhList.get(childIndex);
        int parentValue = maxbhList.get(parentIndex);
        
        // if value of child is greater than value of parent
        if (childValue > parentValue){
            // switch values
            swap(childIndex, parentIndex);
            // run again (parentIndex becomes new childIndex)
            arrangeFromLeaf(parentIndex);
        }
    }

    // Swap helper function
    // swaps values in maxbhList
    public void swap(int firstIndex, int secondIndex){
        // Get the values
        int firstValue = maxbhList.get(firstIndex);
        int secondValue = maxbhList.get(secondIndex);
        // swap
        maxbhList.set(secondIndex, firstValue);
        maxbhList.set(firstIndex, secondValue);        
    }

    // Swap first and last values
    // Pop last value to return at the end
    // Have the new root "sink down" to the correct spot
    // Find index of the left child: 2 * index + 1 (make sure its not out of bounds)
    // Find index of the right child: 2 * index + 2 (make sure its not out of bounds)
    // If the left or right child is greater than the element, swap. 
    // If both are larger, swap with the largest child.
    // The child index you swapped to now becomes the new parent index.  
    // Keep looping and swapping until neither child is larger than the element.
    // Return the old root
    public Integer removeRoot(){
        
        // Guard
        if (maxbhList.size() == 0) return null;
        if (maxbhList.size() < 3) return maxbhList.removeFirst(); // optional optimization

        // swap first and last values
        swap(0, maxbhList.size() - 1);

        // remove last value
        int returnValue = maxbhList.removeLast();

        // Rearrange
        arrangeFromRoot(0);

        // return removed value
        return returnValue;
    }

    // Helper function for removeRoot()
    // Recursively rearrange heap
    public void arrangeFromRoot(int parentIndex){

        // get child index
        Integer childIndex = largestChildIndex(parentIndex);
        
        // guard
        if (childIndex == null) return;
        
        // get values
        int parentValue = maxbhList.get(parentIndex);
        int childValue = maxbhList.get(childIndex);

        // if child value is greater than parent value
        if (childValue > parentValue){
            // swap parent and child values
            swap(parentIndex, childIndex);
            // run method again on new index
            arrangeFromRoot(childIndex);
        }
    }

    // Helper function for arrangeFromRoot()
    // find index of largest child or return null
    public Integer largestChildIndex(int parentIndex){
        
        // Get the child indexes
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        // if both are ob, return null
        if (leftChildIndex >= maxbhList.size()) return null;
        
        // if only right is ob, return left
        else if (rightChildIndex >= maxbhList.size()) return leftChildIndex;
        
        // if both are in bounds, return the index of larger value
        else {

            int leftChildValue = maxbhList.get(leftChildIndex);
            int rightChildValue = maxbhList.get(rightChildIndex);

            if (leftChildValue > rightChildValue) return leftChildIndex;
            else return rightChildIndex;
        }
    }
}
