package j07_binary_search_trees;


public class BST{
    
    public Node root = null;

    // add (iteratively)
    public boolean add(int val){
        
        Node newNode = new Node(val);

        if (this.root == null) this.root = newNode;

        else {
            Node parent = this.root;
            while (true){
                if (newNode.value == parent.value){
                    return false;
                } else if (newNode.value < parent.value){
                    if (parent.left == null){
                        parent.left = newNode;
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right == null){
                        parent.right = newNode;
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }
        return true;
    }

    // find
    public boolean find(int val){

        if (this.root == null) return false;
        
        Node parent = this.root;
        
        while (true){
            if (val == parent.value){
                return true;
            } else if (val < parent.value){
                if (parent.left == null){
                    break;
                } else {
                    parent = parent.left;
                }
            } else {
                if (parent.right == null){
                    break;
                } else {
                    parent = parent.right;
                }
            }
        }
        return false;
    }
}