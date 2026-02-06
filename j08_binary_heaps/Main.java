package j08_binary_heaps;

public class Main {

    public static void main(String[] args) {
        
        MaxBinaryHeap mbh = new MaxBinaryHeap();
        mbh.add(10);
        mbh.add(11);
        mbh.add(12);
        mbh.add(13);

        System.out.println(mbh.removeRoot());
        System.out.println(mbh);
    }
}
