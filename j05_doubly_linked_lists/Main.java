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
        
        System.out.println(dll_0.remove_end());
        System.out.println(dll_0);
    }
}

class NodeDLL<T>{

    public T value;
    public NodeDLL<T> next = null;
    public NodeDLL<T> prev = null;

    NodeDLL(T value){
        this.value = value;
    }
}

class DLL<T>{

    public int length = 0;
    public NodeDLL<T> head;
    public NodeDLL<T> tail;

    public DLL<T> add_end(T value){
        NodeDLL<T> newNode = new NodeDLL<T>(value);
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

    public String toString(){

        ArrayList<T> arrlist = new ArrayList<>();
        NodeDLL<T> current = this.head;
        
        while (current != null){
            arrlist.add(current.value);
            current = current.next;
        }

        return arrlist.toString();
    }
}