package j06_stacks_queues;

import java.util.ArrayList;

// Queue with Singly Linked List
class Queue<T>{

    public int length = 0;
    public Node<T> head = null;
    public Node<T> tail = null;

    public String toString(){

        ArrayList<T> arrList = new ArrayList<>();
        Node<T> current = this.head;

        while (current != null){
            arrList.add(current.value);
            current = current.next;
        }
        return arrList.toString();
    }

    // Add to end
    public Queue<T> enqueue(T val){

        Node<T> newNode = new Node<T>(val);

        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        this.length++;
        return this;
    }// Ot(1)

    // Remove from beginning
    public T dequeue(){
        
        if (this.head == null) throw new IllegalStateException("List is empty.");
        
        T value = this.head.value;
        
        if (this.head == this.tail){
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }
        
        this.length--;
        return value;
    } // Ot(1)
}