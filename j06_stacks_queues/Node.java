package j06_stacks_queues;

public class Node<T> {

    public T value;
    public Node<T> next = null;

    Node(T val){
        this.value = val;
    }
}
