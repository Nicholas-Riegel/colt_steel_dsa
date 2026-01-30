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

        SLL<String> list0 = new SLL<String>();
        list0.push_end("Hi");
        list0.push_end("there");
        list0.push_end("you");
        list0.push_end("beautiful");
        list0.push_end("being");
        
        System.out.println(list0.reverse());  
    }
}

// Start by making a node
// piece of data - val
// reference to the next node - next

// Node for singly linked list
class Node<T>{
    
    protected T val;
    protected Node<T> next;

    public Node(T val){
        this.val = val;
        this.next = null;
    }
}

// Singly linked list
class SLL<T>{
    
    protected int length;
    protected Node<T> head;
    protected Node<T> tail;

    public SLL(){
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    // Add to end
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

    // Remove from end
    public T pop_end(){
        
        // Guard
        if (this.head == null){
            throw new IllegalStateException("List is empty.");
        }

        // Main
        T value = null;

        if (this.head == this.tail){
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

    // Add to beginning
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

    // Remove from beginning
    public T pop_start(){
        
        // Guard
        if (this.head == null){
            throw new IllegalStateException("List is empty.");
        }

        // Main
        T value = this.head.val;
        
        if (this.head != this.tail){
            this.head = this.head.next;
        } else {
            this.head = null;
            this.tail = null;
        }
        
        this.length--;

        return value;
    } // Ot(1)

    // Get at
    public T getAt(int i){
        
        // Guards
        if (this.length == 0){
            throw new IllegalStateException("List is empty.");
        } 
        if (i < 0 || i >= this.length){
            throw new IndexOutOfBoundsException("Index out of bounds: " + i + ". Valid range: 0 to " + (this.length - 1));
        }
        
        // Main
        Node<T> current = this.head;
        while (i > 0){
            current = current.next;
            i--;
        }
        return current.val;
    } // Ot(n)

    // Set at
    public SLL<T> setAt(int i, T value){

        // Guard
        if (this.length == 0){
            throw new IllegalStateException("List is empty.");
        } 
        if (i < 0 || i >= this.length){
            throw new IndexOutOfBoundsException("Index out of bounds: " + i + ". Valid range: 0 to " + (this.length - 1));
        }

        // Main
        Node<T> current = this.head;
        while (i > 0){
            current = current.next;
            i--;
        }
        current.val = value;

        return this;
    }// Ot(n)

    // Insert at
    public SLL<T> insertAt(int i, T value){

        if (this.length == 0 || i < 1){
            push_start(value);
        } else if (i >= this.length){
            push_end(value);
        } else {
            Node<T> newNode = new Node<T>(value);
            Node<T> current = this.head;
            while (i > 1){
                current = current.next;
                i--;
            }
            newNode.next = current.next;
            current.next = newNode;
            this.length++;
        }

        return this;
    }// Ot(n)
    
    // Remove at
    public T removeAt(int i){
        
        // Guard
        if (this.length == 0){
            throw new IllegalStateException("List is empty.");
        } 
        if (i < 0 || i >= this.length){
            throw new IndexOutOfBoundsException("Index out of bounds: " + i + ". Valid range: 0 to " + (this.length - 1));
        }
        
        // Main
        T value = null;
        if (i == 0){
            value = pop_start();
        } else if (i == this.length - 1){
            value = pop_end();
        } else {
            Node<T> current = this.head;
            while (i > 1){
                current = current.next;
                i--;
            }
            value = current.next.val;
            current.next = current.next.next;
            this.length--;
        }

        return value;
    }// Ot(n)

    // Convert list to String for printing
    @Override
    public String toString(){

        ArrayList<T> arrlist = new ArrayList<>();
        Node<T> current = this.head;

        while (current != null){
            arrlist.add(current.val);
            current = current.next;
        }
        return arrlist.toString();
    }// Ot(n)



    // Reverse (my solution)
    // prev  mid   next
    // 13 -> 27 -> 32 -> 71
    //       prev  mid   next
    // public SLL<T> reverse(){

    //     // Guard
    //     if (this.head == null) return this;
    //     if (this.head == this.tail) return this;

    //     // Main 
    //     Node<T> prev = this.head;
    //     Node<T> mid = this.head.next;
    //     Node<T> next = this.head.next.next; // only needed for length > 2

    //     if (this.length == 2){

    //         mid.next = prev;
    //         prev.next = null;
    //         this.head = mid;
    //         this.tail = prev;
    //     }

    //     if (this.length > 2){

    //         while(next.next != null){
    //             mid.next = prev;
    //             prev = mid;
    //             mid = next;
    //             next = next.next;
    //         }
    //         mid.next = prev;
    //         next.next = mid;
    //         this.tail = this.head;
    //         this.head = next;
    //         this.tail.next = null;
    //     }

    //     return this;
    // }// Ot(n)

    // Reverse (elegant solution)
    public SLL<T> reverse(){

        Node<T> prev = null;
        Node<T> mid = this.head;
        Node<T> next = null;

        while (mid != null){
            next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }

        this.tail = this.head;
        this.head = prev;
        
        return this;
    }
}