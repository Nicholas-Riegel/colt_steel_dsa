package j06_stacks_queues;

import java.util.ArrayList;

// Stack using arrayList
// public class Stack<T>{

//     private ArrayList<T> arrList = new ArrayList<T>();

//     public String toString(){
//         return this.arrList.toString();
//     }

//     public StackArrayList<T> push(T value){
//         this.arrList.add(value);
//         return this;
//     }

//     public T pop(){
//         return this.arrList.removeLast();
//     }
// }

// Stack with Singly Linked List
public class Stack<T> {

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

    // Add to beginning
    public Stack<T> push(T val){
        Node<T> newNode = new Node<T>(val);
        if (this.head == null){
            this.head = newNode;
            this.tail = this.head;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
        return this;
    } // Ot(1)

    // Remove from beginning
    public T pop(){
        if (this.head == null) throw new IllegalStateException("List is empty.");
        T value = this.head.value;
        if (this.head != this.tail){
            this.head = this.head.next;
        } else {
            this.head = null;
            this.tail = null;
        }
        this.length--;
        return value;
    } // Ot(1)
}
