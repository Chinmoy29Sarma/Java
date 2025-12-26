package hashmap;
import java.util.HashMap;
public class Use {
    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();

        // put - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);

        // get - O(1)
        System.out.println(hm.get("India"));
        System.out.println(hm.get("Indonesia"));

        // contains - O(1)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Indonesia"));

        // remove - O(1)
        System.out.println(hm.remove("China"));
        System.out.println(hm.remove("Indonesia"));
        System.out.println(hm);

        // size
        System.out.println(hm.size());

        // isEmpty
        System.out.println(hm.isEmpty());

        // clear
        hm.clear();
        System.out.println(hm);

    }
}
