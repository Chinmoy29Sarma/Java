package BInaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    int idx = -1;
    public Node buildTree(int[] nodes){
        idx++;
        if(nodes[idx] == -1){
            return null;
        }
        Node node = new Node(nodes[idx]);
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    public void preorder(Node root){
        // base case
        if(root == null){
            System.out.print(-1+" ");
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(true){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public int height(Node root){
        // base case
        if(root == null){
            return 0;
        }
        int leftCount = height(root.left);
        int rightCount = height(root.right);
        return Math.max(leftCount, rightCount) + 1;
    }

    public int countNodes(Node root){
        // base case
        if(root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int sum(Node root){
        // base case
        if(root == null){
            return 0;
        }
        return sum(root.left) + sum(root.right) + root.data;
    }

    class Info{
        int height;
        int diameter;

        public Info(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public Info diameter(Node root){
        // base case
        if(root == null){
            return new Info(0, 0);
        }
        Info left = diameter(root.left);
        Info right = diameter(root.right);
        // work
        int currHeight = Math.max(left.height, right.height) + 1;
        int currDiameter = left.height + right.height + 1;
        int maxDiameter = Math.max(currDiameter, Math.max(left.diameter, right.diameter));
        return new Info(currHeight, maxDiameter);
    }
    public static void main(String[] args) {

//        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);

//        tree.preorder(root);
//        tree.inorder(root);
//        tree.postorder(root);

//        tree.levelOrder(root);
//        System.out.println(tree.height(root));
//        System.out.println(tree.countNodes(root));
//        System.out.println(tree.sum(root));
        System.out.println(tree.diameter(root).diameter);
    }
}
