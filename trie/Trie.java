package trie;

public class Trie {

    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;

        Node(){
            for(Node n : children){
                n = null;
            }
        }
    }

    Node root = new Node();

    public void insert(String word){
        Node curr = root;
        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public boolean search(String word){
        Node curr = root;
        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }
    public static void main(String[] args) {

        String[] words = { "the", "there", "their", "a", "any", "thee"};

        Trie t = new Trie();
        for(String word : words){
            t.insert(word);
        }

        System.out.println(t.search("ther"));
    }
}
