package j07_binary_search_trees;

import java.util.ArrayList;

public class BST{
    
    public Node root = null;

    // add (iteratively)
    public boolean add(int val){
        
        Node newNode = new Node(val);

        if (this.root == null){ 
            this.root = newNode;
            return true;
        }

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

    // Breadth First Search (BFS)
    // Visits nodes level by level, starting from the root and moving horizontally
    // across each level before going to the next level. 
    public String breadthFirstSearch(){
        
        // Guard
        if (this.root == null) return "[]";
        
        // Only use queue.add() and .remove(0)
        ArrayList<Node> queue = new ArrayList<>();
        ArrayList<Integer> arrList = new ArrayList<>();
        
        queue.add(this.root);
        
        while (!queue.isEmpty()){
            Node node = queue.remove(0);
            arrList.add(node.value);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return arrList.toString();
    }
    
    // Depth First Search (DFS) 
    public String dfsSearch(String type){
        
        if (this.root == null) return "[]";
        
        ArrayList<Integer> returnList = new ArrayList<>();
        
        if (type.equals("PRE_ORDER")) this.PreOrder(this.root, returnList);
        if (type.equals("POST_ORDER")) this.PostOrder(root, returnList);
        if (type.equals("IN_ORDER")) this.InOrder(root, returnList);
        
        return returnList.toString();
    }
    
    // DFS Pre Order Helper function 
    // Visits nodes in order: root → left subtree → right subtree
    // Processes each node before visiting its children (hence "pre-order")
    public void PreOrder(Node node, ArrayList<Integer> parameterList){
        parameterList.add(node.value);
        if (node.left != null) PreOrder(node.left, parameterList);
        if (node.right != null) PreOrder(node.right, parameterList);
    }
    
    // DFS Post Order Helper function 
    public void PostOrder(Node node, ArrayList<Integer> parameterList){
        if (node.left != null) PostOrder(node.left, parameterList);
        if (node.right != null) PostOrder(node.right, parameterList);
        parameterList.add(node.value);
    }
    
    // DFS In Order Helper function 
    public void InOrder(Node node, ArrayList<Integer> parameterList){
        if (node.left != null) InOrder(node.left, parameterList);
        parameterList.add(node.value);
        if (node.right != null) InOrder(node.right, parameterList);
    }
}