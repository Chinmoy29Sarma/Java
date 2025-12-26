package binarySearchTree;

public class BST {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            return new Node(val);
        }
        if(val < root.data){
            // left subTree
            root.left = insert(root.left, val);
        }else{
            // right subTree
            root.right = insert(root.right, val);
        }
        return root;
    }

    // inorder
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(key < root.data){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }

    public static Node mirrorBST(Node root){
        // base case
        if(root == null){
            return root;
        }
        // recursive call
        Node left = mirrorBST(root.left);
        Node right = mirrorBST(root.right);
        // work
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        int[] values = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for(int val : values){
            root = insert(root, val);
        }
        inorder(root);
        System.out.println();

//        System.out.println(search(root, 8));
        root = mirrorBST(root);
        inorder(root);
    }
}
