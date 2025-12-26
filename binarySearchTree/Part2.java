package binarySearchTree;

public class Part2 {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node createBalBST(int[] arr, int st, int end){
        if(end < st){
            return null;
        }
        int mid = (end-st)/2 + st;
        Node root = new Node(arr[mid]);
        root.left = createBalBST(arr, st, mid-1);
        root.right = createBalBST(arr, mid+1, end);
        return root;
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }



    public static void main(String[] args) {

        int[] arr = {3, 5, 6, 8, 10, 11, 12};
        Node root = createBalBST(arr, 0, arr.length-1);
        preorder(root);
    }
}
