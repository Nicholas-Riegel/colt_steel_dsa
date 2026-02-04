package j08_binary_heaps;

import java.util.ArrayList;

public class MaxBinaryHeap {

    ArrayList<Integer> mbhArrayList = new ArrayList<>();

    @Override
    public String toString(){
        return this.mbhArrayList.toString();
    }

    public void add(int value){
        mbhArrayList.add(value);
        this.addHelper(mbhArrayList.size() - 1);
    }

    // My second solution (recursive)
    // After adding to the ArrayList
    // If child is greater than parent
    // Switch child and parent
    // then check again 
    public void addHelper(int indexChild){

        // set child and parent values
        int indexParent = (indexChild - 1)/2;
        int valueChild = mbhArrayList.get(indexChild);
        int valueParent = mbhArrayList.get(indexParent);
        
        // if value of child is greater than value of parent
        if (valueChild > valueParent){

            // switch values
            mbhArrayList.set(indexParent, valueChild);
            mbhArrayList.set(indexChild, valueParent);
            
            // run function again (with indexParent for indexChild)
            addHelper(indexParent);
        }
    }
}
