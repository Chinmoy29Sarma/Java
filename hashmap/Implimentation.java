package hashmap;
import java.util.*;
public class Implimentation {
                    // generics
    static class Hashmap<K, V>{
        private class Node{
            K key;
            V value;
            Node next;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<Node>[] buckets; // N

        @SuppressWarnings("unchecked")
        public Hashmap(){
            this.size = 0;
            this.buckets = new LinkedList[4];
            for(int i=0; i<buckets.length; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            return Math.abs(key.hashCode()) % buckets.length;
        }

        private int searchLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehase(){
            LinkedList<Node>[] oldBuck = buckets;
            buckets = new LinkedList[buckets.length * 2];
            size = 0;
            for(int i=0; i<buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }

            //copy
            for(LinkedList<Node> ll: oldBuck){
                for(Node node: ll){
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int bi = hashFunction(key);
            int di = searchLL(key, bi);

            // update value
            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{ // add new value
                buckets[bi].add(new Node(key, value));
                size++;
            }

            float lamda = (float) size / buckets.length;
            if(lamda > 2.0){
                rehase();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            return di > -1;
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            // key doesn't exist
            if(di == -1){
                return null;
            }
            // key exist
            Node node = buckets[bi].get(di);
            return node.value;
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            // key doesn't exist
            if(di == -1){
                return null;
            }
            // key exist
            size--;
            return buckets[bi].remove(di).value;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            // iterate
            for(LinkedList<Node> ll: buckets){
                for(Node node: ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public int size(){
            return size;
        }
    }
    public static void main(String[] args) {

        Hashmap<String, Integer> hm = new Hashmap<>();

        hm.put("India", 100);
        hm.put("Nepal", 20);
        hm.put("US", 50);

//        System.out.println(hm.containsKey("India"));
//        System.out.println(hm.containsKey("Bhutan"));

//        System.out.println(hm.get("India"));
//        System.out.println(hm.get("Indonesia"));

//        System.out.println(hm.remove("US"));
//        System.out.println(hm.remove("China"));

//        ArrayList<String> keys = hm.keySet();
//        for(String str: keys){
//            System.out.println(str);
//        }

//        System.out.println(hm.isEmpty());
//        System.out.println(hm.size());

        hm.put("Bhutan", 6);
        hm.put("Indonesia", 30);
        hm.put("French", 7);
        hm.put("Canada", 3);
        hm.put("Australia", 10);
        System.out.println("Adding 9th element.");
        hm.put("Japan", 9);
//        hm.put("Vietnam", 9);
        System.out.println(hm.size);
    }
}
