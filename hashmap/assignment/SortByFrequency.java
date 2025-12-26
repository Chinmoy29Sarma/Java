package hashmap.assignment;
import java.util.TreeMap;
public class SortByFrequency {
    public static void main(String[] args) {

        String str = "tree";

        TreeMap<Character, Integer> map = new TreeMap<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        System.out.println(map);
    }
}
