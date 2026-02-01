package j06_stacks_queues;

import java.util.ArrayList;

public class StackArrayList<T>{

    private ArrayList<T> arrList = new ArrayList<T>();

    public String toString(){
        return this.arrList.toString();
    }

    public StackArrayList<T> push(T value){
        this.arrList.add(value);
        return this;
    }

    public T pop(){
        return this.arrList.removeLast();
    }
}