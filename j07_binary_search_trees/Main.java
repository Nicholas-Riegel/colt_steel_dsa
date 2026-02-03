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
        System.out.println(bst.depthFirstSearch("PRE_ORDER"));
        System.out.println(bst.depthFirstSearch("IN_ORDER"));
        System.out.println(bst.depthFirstSearch("POST_ORDER"));
    }
}