package j08_binary_heaps;

public class Main {

    public static void main(String[] args) {
        
        MaxBinaryHeap mbh = new MaxBinaryHeap();
        mbh.addLeaf(10);
        mbh.addLeaf(11);
        mbh.addLeaf(12);
        mbh.addLeaf(13);

        System.out.println(mbh.removeRoot());
        System.out.println(mbh.removeRoot());
        // System.out.println(mbh.removeRoot());
        // System.out.println(mbh.removeRoot());
        System.out.println(mbh);
    }
}
