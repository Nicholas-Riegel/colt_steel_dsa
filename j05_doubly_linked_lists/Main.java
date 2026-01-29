package j05_doubly_linked_lists;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DLL<String> dll_0 = new DLL<String>();
        // dll_0.add_end("Hi");        
        // dll_0.add_end("there");        
        // dll_0.add_end("you");        
        // dll_0.add_end("beautiful");        
        // dll_0.add_end("thing");
        System.out.println(dll_0.removeAt(0));
        
        System.out.println(dll_0);
        System.out.println(dll_0.length);
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

    // To string
    public String toString(){

        ArrayList<T> arrlist = new ArrayList<>();
        NodeDLL<T> current = this.head;
        
        while (current != null){
            arrlist.add(current.value);
            current = current.next;
        }

        return arrlist.toString();
    }
    
    // Add to end
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
        NodeDLL<T> newNode = new NodeDLL<T>(value);
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
        if (this.head == null){
            throw new IllegalStateException("List empty.");
        } else if (this.head == this.tail){
            returnValue = this.head.value;
            this.head = null;
            this.tail = null;
            this.length--;
        }else {
            returnValue = this.head.value;
            this.head = this.head.next;
            this.head.prev = null;
            this.length--;
        }
        return returnValue;
    }

    // Get at index
    public T getAt(int i){
        T returnValue = null;
        if (this.head == null){
            throw new IllegalStateException("List empty.");
        } else if (i < 0 || i >= this.length){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        } else {
            if (i < this.length / 2){

                NodeDLL<T> current = this.head;
                while (i > 0){
                    current = current.next;
                    i--;
                }
                returnValue = current.value;
            
            } else {
                
                NodeDLL<T> current = this.tail;
                int indexFromTail = this.length - 1 - i;
                while (indexFromTail > 0){
                    current = current.prev;
                    indexFromTail--;
                }
                returnValue = current.value;
            }
        }
        return returnValue;
    }

    // Set at index
    public DLL<T> setAt(int i, T value){
        if (this.head == null){
            throw new IllegalStateException("List empty.");
        } else if (i < 0 || i >= this.length){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        } else {
            if (i < this.length / 2){

                NodeDLL<T> current = this.head;
                while (i > 0){
                    current = current.next;
                    i--;
                }
                current.value = value;
            } else {
                
                NodeDLL<T> current = this.tail;
                int indexFromTail = this.length - 1 - i;
                while (indexFromTail > 0){
                    current = current.prev;
                    indexFromTail--;
                }
                current.value = value;
            }
        }
        return this;
    }

    // Insert at index
    public DLL<T> insertAt(int i, T value){
        if (i == 0){
            this.add_start(value);
        } else if (i < 0 || i >= this.length){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        } else {

            NodeDLL<T> newNode = new NodeDLL<T>(value);
            
            if (i < this.length / 2){

                NodeDLL<T> current = this.head;
                while (i > 0){
                    current = current.next;
                    i--;
                }
            
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev.next = newNode;
                current.prev = newNode;
            
            } else {
                
                NodeDLL<T> current = this.tail;
                int indexFromTail = this.length - 1 - i;
                while (indexFromTail > 0){
                    current = current.prev;
                    indexFromTail--;
                }
            
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev.next = newNode;
                current.prev = newNode;
            }
            this.length++;
        }
        return this;
    }

    // Remove from index
    public T removeAt(int i){

        T returnValue = null;
        
        if (this.head == null){
            throw new IllegalStateException("List empty.");
        } else if (i < 0 || i >= this.length){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        } else if (i == 0){
            returnValue = this.remove_start();
        } else if (i == this.length - 1){
            returnValue = this.remove_end();
        } else {

            if (i < this.length / 2){

                NodeDLL<T> current = this.head;
                while (i > 0){
                    current = current.next;
                    i--;
                }
                returnValue = current.value;
                current.prev.next = current.next;
                current.next.prev = current.prev;
            } else {
                
                NodeDLL<T> current = this.tail;
                int indexFromTail = this.length - 1 - i;
                while (indexFromTail > 0){
                    current = current.prev;
                    indexFromTail--;
                }
                returnValue = current.value;
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            this.length--;
        }
        return returnValue;
    }

    // Reverse
    public DLL<T> reverse(){
        return this;
    }
}