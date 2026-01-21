// LINKED LISTS
// A data structure that contains a head, tail and length property.
// Linked Lists consist of nodes, and each node has a value and a pointer to another node or null
// no indexes
// need to start at the beginning and go to the next etc. to get to the last

// Linked Lists 

// Do not have indexes!
// Connected via nodes with a next pointer
// Random access is not allowed

// Arrays and ArrayLists

// Indexed in order!
// Insertion and deletion can be expensive
// Can quickly be accessed at a specific index

import java.util.ArrayList;

public class Main {// this has to be at top to use 'java filename.java'
    
    public static void main(String[] args) {
        
        // Node first = new Node(1);
        // first.next = new Node(2);
        // first.next.next = new Node(3);

        // System.out.println(first.val);
        // System.out.println(first.next.val);
        // System.out.println(first.next.next.val);

        SLL<String> list0 = new SLL<String>();
        list0.push_end("Hi");
        list0.push_end("there!");
        System.out.println(list0.pop_end());
        System.out.println(list0.pop_end());
        System.out.println(list0);
    }
}

// Start by making a node
// piece of data - val
// reference to the next node - next
class Node<T>{
    
    protected T val;
    protected Node<T> next;

    public Node(T val){
        this.val = val;
        this.next = null;
    }
}

class SLL<T>{
    
    protected int length;
    protected Node<T> head;
    protected Node<T> tail;

    public SLL(){
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    public SLL<T> push_end(T val){

        Node<T> newNode = new Node<T>(val);
        
        if (this.head == null){
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.next = newNode;
            this.tail = this.tail.next;
        }
        this.length++;
        return this;
    }// Ot(1)

    public T pop_end(){
        
        T value = null;

        if (this.head == null){
            value = null;
        } else if (this.head == this.tail){
            value = this.head.val;
            this.head = null;
            this.tail = null;
            this.length--;
        } else {
            Node<T> current = this.head;
            while (current.next.next != null){
                current = current.next;
            }
            value = current.next.val;
            current.next = null;
            this.tail = current;
            this.length--;
        }
        
        return value;
    }// Ot(n)

    public SLL<T> push_start(T val){
        Node<T> newNode = new Node<T>(val);
        if (this.head == null){
            this.head = newNode;
            this.tail = this.head;
            this.length++;
        } else {
            newNode.next = this.head;
            this.head = newNode;
            this.length++;
        }
        return this;
    } // Ot(1)

    public T pop_start(){
        T value = null;

        if (this.head != null){
            value = this.head.val;
            if (this.head != this.tail){
                this.head = this.head.next;
            } else {
                this.head = null;
                this.tail = null;
            }
            this.length--;
        }
        return value;
    } // Ot(1)

    @Override
    public String toString(){

        ArrayList<T> arrlist = new ArrayList<>();
        Node<T> current = this.head;

        while (current != null){
            arrlist.add(current.val);
            current = current.next;
        }
        return arrlist.toString();
    }
}