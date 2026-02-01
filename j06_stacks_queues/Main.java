package j06_stacks_queues;

public class Main{

    public static void main(String[] args) {
        
        // StackArrayList<String> stack = new StackArrayList<>();
        // StackSLL<String> stack = new StackSLL<>();

        // stack.push("Hello");
        // stack.push("world");
        // stack.push("yo!");
        // System.out.println(stack.pop());
        // System.out.println(stack);

        Queue<String> q = new Queue<>();

        q.enqueue("Hi");
        q.enqueue("there");
        q.enqueue("you");
        q.enqueue("beautiful");
        q.enqueue("thing");

        System.out.println(q.dequeue());
        System.out.println(q);
    }
}