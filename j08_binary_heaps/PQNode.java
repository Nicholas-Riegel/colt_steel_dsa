package j08_binary_heaps;

public class PQNode<T>{
    
    T value;
    int priority;

    PQNode(T value, int priority){
        this.value = value;
        this.priority = priority;
    }

    @Override
    public String toString(){
        return this.priority + ": " + this.value;
    }
}
