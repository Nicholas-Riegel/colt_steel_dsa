package j08_binary_heaps;

import java.util.ArrayList;

public class MaxBinaryHeap {

    ArrayList<Integer> maxbhList = new ArrayList<>();

    @Override
    public String toString(){
        return maxbhList.toString();
    }

    public void add(int value){
        maxbhList.add(value);
        addHelper(maxbhList.size() - 1);
    }

    // Recursive solution
    // after adding to the ArrayList
    // if child is greater than parent
    // switch child and parent
    // then check again 
    public void addHelper(int childIndex){

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
            addHelper(parentIndex);
        }
    }

    public void swap(int index1, int index2){
        // Get the values
        int firstValue = maxbhList.get(index1);
        int secondValue = maxbhList.get(index2);
        // swap
        maxbhList.set(index2, firstValue);
        maxbhList.set(index1, secondValue);        
    }

    // Swap the first value in the values property with the last one
    // Pop from the values property, so you can return the value at the end.
    // Have the new root "sink down" to the correct spot...​
    // Your parent index starts at 0 (the root)
    // Find the index of the left child: 2 * index + 1 (make sure its not out of bounds)
    // Find the index of the right child: 2*index + 2 (make sure its not out of bounds)
    // If the left or right child is greater than the element...swap. If both left and right children are larger, swap with the largest child.
    // The child index you swapped to now becomes the new parent index.  
    // Keep looping and swapping until neither child is larger than the element.
    // Return the old root!
    public Integer removeRoot(){
        
        // Guard
        if (maxbhList.size() == 0) return null;

        // swap first and last values
        swap(0, maxbhList.size() - 1);

        // remove last value
        int returnValue = maxbhList.removeLast();

        // Rearrange Heap
        removeHelper(0);

        // return removed value
        return returnValue;
    }

    // Helper function for removeRoot()
    // Recursively rearrange heap
    public void removeHelper(int parentIndex){

        // get child index
        Integer childIndex = findLargestChildIndex(parentIndex);
        
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
            removeHelper(childIndex);
        }
    }

    // Helper function for removeHelper()
    // find index of largest child or return null
    public Integer findLargestChildIndex(int parentIndex){
        
        // Get the child indexes
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        // if both are ob, return null
        if (leftChildIndex >= maxbhList.size()){
            return null;
        // if only right is ob, return left
        } else if (rightChildIndex >= maxbhList.size()){
            return leftChildIndex;
        // return the index of larger value
        } else {
            int leftChildValue = maxbhList.get(leftChildIndex);
            int rightChildValue = maxbhList.get(rightChildIndex);
            if (leftChildValue > rightChildValue){
                return leftChildIndex;
            } else {
                return rightChildIndex;
            }
        }
    }
}
