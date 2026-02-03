package j07_binary_search_trees;

public class Main{

    public static void main(String[] args) {

        BST bst = new BST();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(2);
        bst.add(7);

        // System.out.println(bst.breadthFirstSearch());
        System.out.println(bst.dfsSearch("PRE_ORDER"));
        System.out.println(bst.dfsSearch("IN_ORDER"));
        System.out.println(bst.dfsSearch("POST_ORDER"));
    }
}