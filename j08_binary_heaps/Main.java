package j08_binary_heaps;

public class Main {

    public static void main(String[] args) {
        
        // MaxBinaryHeap mbh = new MaxBinaryHeap();
        // mbh.addLeaf(10);
        // mbh.addLeaf(11);
        // mbh.addLeaf(12);
        // mbh.addLeaf(13);

        // System.out.println(mbh.removeRoot());
        // System.out.println(mbh.removeRoot());
        // System.out.println(mbh.removeRoot());
        // System.out.println(mbh.removeRoot());
        // System.out.println(mbh);

        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.enqueue("soar throat", 5);
        pq.enqueue("broken arm", 1);
        pq.enqueue("fever", 2);
        pq.enqueue("high fever", 1);

        System.out.println(pq.dequeue());
        System.out.println(pq);
    }
}
