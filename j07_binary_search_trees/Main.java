package j07_binary_search_trees;

public class Main{

    public static void main(String[] args) {

        BST bst = new BST();
        bst.add(8);
        bst.add(3);
        bst.add(9);
        bst.add(4);

        System.out.println(bst.find(0));
    }
}