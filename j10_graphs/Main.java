package j10_graphs;

public class Main{

    public static void main(String[] args) {
        
        AdjacencyList al = new AdjacencyList();
        al.addVertex("Hello");
        al.addVertex("World");
        al.addEdge("Hello", "World");
        // al.removeEdge("Hello", "World");
        // al.removeVertex("World");

        // System.out.println(al.haveEdge("Hello", "World"));
        // System.out.println(al.getVertices());
        System.out.println(al);
    }
}