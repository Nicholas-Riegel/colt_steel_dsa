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

        // set child and parent values
        int parentIndex = (childIndex - 1)/2;
        int childValue = maxbhList.get(childIndex);
        int parentValue = maxbhList.get(parentIndex);
        
        // if value of child is greater than value of parent
        if (childValue > parentValue){

            // switch values
            maxbhList.set(parentIndex, childValue);
            maxbhList.set(childIndex, parentValue);
            
            // run again from new index
            addHelper(parentIndex);
        }
    }
}
