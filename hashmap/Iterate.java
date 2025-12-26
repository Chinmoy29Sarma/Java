package hashmap;

import java.util.HashMap;
import java.util.Set;

public class Iterate {
    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("Indonesia", 50);
        hm.put("Malaysia", 10);
        hm.put("China", 150);
        hm.put("Nepal", 5);
        hm.put("Bhutan", 10);

        // Iterate
        Set<String> keys = hm.keySet();
        for(String k: keys){
            System.out.println("Key = "+k+", Value = "+hm.get(k));
        }
    }
}
