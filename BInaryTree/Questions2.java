package BInaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Questions2 {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void printKthLevel(Node root, int k){
        Queue<Node> q = new LinkedList<>();
        int level = 0;
        q.add(root);
        q.add(null);
        level = 1;
        while (true){
            Node curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    level++;
                }
            }else{
                if(k == level){
                    System.out.print(curr.data+" ");
                }else{
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }

            }
        }
    }

    public static boolean path(Node root, int val, ArrayList<Integer> list){
        if(root == null){
            return false;
        }

        if (root.data == val){
            list.add(root.data);
            return true;
        }

        list.add(root.data);
        boolean left = path(root.left, val, list);
        boolean right = path(root.right, val, list);

        if(left || right){
            return true;
        }else {
            list.removeLast();
            return false;
        }
    }

    public static void kthLevel(Node root, int k){
        // base case
        if (root == null){
            return;
        }else if(k == 1){
            System.out.print(root.data+" ");
            return;
        }
        kthLevel(root.left, k-1);
        kthLevel(root.right, k-1);
    }

    public static int lca(Node root, int a, int b){
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> bl = new ArrayList<>();

        path(root, a, al);
        path(root, b, bl);

        int i=0;
        while (i<al.size() && i<bl.size()){
            if(!al.get(i).equals(bl.get(i))){
                break;
            }
            i++;
        }
        return i != 0 ? al.get(i-1) : -1;
    }

    public static Node lca2(Node root, int a, int b){
        if(root == null || root.data == a || root.data == b){
            return root;
        }

        Node left = lca2(root.left, a, b);
        Node right = lca2(root.right, a, b);

        if(right == null){
            return left;
        }
        if(left == null){
            return right;
        }
        return root;
    }

    public static int minDist(Node root, int a, int b){
        Node lca = lca2(root, a, b);
        int dist1 = distance(lca, a);
        int dist2 = distance(lca, b);
        return dist1 + dist2;
    }

    public static int distance(Node root, int n){
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int left = distance(root.left, n);
        int right = distance(root.right, n);

        return (left == -1) && (right == -1) ? -1 : left == -1 ? right+1 : left+1;
    }

    // Kth ancestor
    public static int kthAncestor(Node root, int n, int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }

        int left = kthAncestor(root.left, n, k);
        int right = kthAncestor(root.right, n, k);

        if(left == -1 && right == -1){
            return -1;
        }
        int dist = Math.max(left, right);
        if(dist+1 == k){
            System.out.println(root.data);
        }
        return dist+1;
    }

    public static int sumTree(Node root){
        if(root == null){
            return 0;
        }
        int data = root.data;
        int left = sumTree(root.left);
        int right = sumTree(root.right);
        root.data = left+ right;
        return root.data + data;
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

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.left = new Node(7);
//        root.right.right.right = new Node(8);
//        root.right.right.right.right = new Node(9);

//        printKthLevel(root, 1);
//        kthLevel(root, 1);
//        System.out.println(lca(root, 2, 5));
//        System.out.println(lca2(root, 4, 3).data);

//        System.out.println(minDist(root, 4, 2));

//        kthAncestor(root, 8, 1);
        sumTree(root);
        preorder(root);

    }
}
