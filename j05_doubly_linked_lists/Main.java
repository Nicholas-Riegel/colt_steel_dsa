package j05_doubly_linked_lists;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DLL<String> dll_0 = new DLL<String>();
        dll_0.add_end("Hi");        
        dll_0.add_end("there");        
        dll_0.add_end("you");        
        dll_0.add_end("beautiful");        
        dll_0.add_end("thing");
        
        System.out.println(dll_0.getAt(3));
    }
}

class Node<T>{

    public T value;
    public Node<T> next = null;
    public Node<T> prev = null;

    Node(T value){
        this.value = value;
    }
}

class DLL<T>{

    public int length = 0;
    public Node<T> head;
    public Node<T> tail;

    // To string
    public String toString(){

        ArrayList<T> arrlist = new ArrayList<>();
        Node<T> current = this.head;
        
        while (current != null){
            arrlist.add(current.value);
            current = current.next;
        }

        return arrlist.toString();
    }
    
    // Add to end
    public DLL<T> add_end(T value){

        Node<T> newNode = new Node<T>(value);

        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        
        this.length++;
        return this;
    }

    // Remove from end
    public T remove_end(){

        T returnValue = null;

        if (this.head == null){
            returnValue = null;
        } else if (this.head == this.tail){
            returnValue = this.tail.value;
            this.head = null;
            this.tail = null;
            this.length--;
        } else {
            returnValue = this.tail.value;
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.length--;
        }

        return returnValue;
    }

    // Add to beginning
    public DLL<T> add_start(T value){

        Node<T> newNode = new Node<T>(value);
        
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        
        this.length++;
        return this;
    }

    // Remove from beginning
    public T remove_start(){

        T returnValue = null;
        
        if (this.head == null) throw new IllegalStateException("List empty.");
        
        else if (this.head == this.tail){
            returnValue = this.head.value;
            this.head = null;
            this.tail = null;
            this.length--;
        } else {
            returnValue = this.head.value;
            this.head = this.head.next;
            this.head.prev = null;
            this.length--;
        }
        
        return returnValue;
    }

    public Node<T> findNode(int i){

        Node<T> node;
        
        if (i < this.length / 2){
            node = this.head;
            while (i > 0){
                node = node.next;
                i--;
            }
        } else {
            node = this.tail;
            i = this.length - 1 - i;
            while (i > 0){
                node = node.prev;
                i--;
            }
        }
        return node;
    }

    // Get at index
    public T getAt(int i){

        if (this.head == null) throw new IllegalStateException("List empty.");
        
        else if (i < 0 || i >= this.length) throw new IndexOutOfBoundsException("Index out of bounds.");
        
        else {
            
            Node<T> targetNode = this.findNode(i);

            return targetNode.value;
        }
    }

    // Set at index
    public DLL<T> setAt(int i, T value){

        if (this.head == null) throw new IllegalStateException("List empty.");
        
        else if (i < 0 || i >= this.length) throw new IndexOutOfBoundsException("Index out of bounds.");
        
        else {

            Node<T> targetNode = this.findNode(i);
            
            targetNode.value = value;
        }
        return this;
    }

    // Insert at index
    public DLL<T> insertAt(int i, T value){

        if (i < 0 || i >= this.length) throw new IndexOutOfBoundsException("Index out of bounds.");
        
        else if (i == 0) this.add_start(value);
        
        else {

            Node<T> newNode = new Node<T>(value);
            Node<T> targetNode = this.findNode(i);

            newNode.next = targetNode;
            newNode.prev = targetNode.prev;
            targetNode.prev.next = newNode;
            targetNode.prev = newNode;

            this.length++;
        }

        return this;
    }

    // Remove from index
    public T removeAt(int i){

        if (this.head == null) throw new IllegalStateException("List empty.");
        
        else if (i < 0 || i >= this.length) throw new IndexOutOfBoundsException("Index out of bounds.");
        
        else if (i == 0) return this.remove_start();
        
        else if (i == this.length - 1) return this.remove_end();
        
        else {

            Node<T> targetNode = this.findNode(i);

            targetNode.prev.next = targetNode.next;
            targetNode.next.prev = targetNode.prev;

            this.length--;

            return targetNode.value;
        }
    }

    // Reverse
    public DLL<T> reverse(){

        Node<T> prev = null;
        Node<T> current = this.head;
        Node<T> next;
        
        while (current != null){

            // Set next (and move next forward in next loop)
            next = current.next;
            
            // Switch next and prev
            current.next = prev;
            current.prev = next;
            
            // Move prev and current forward
            prev = current;
            current = next;
        }
        
        Node<T> temp = this.tail;
        this.tail = this.head;
        this.head = temp;

        return this;
    }
}