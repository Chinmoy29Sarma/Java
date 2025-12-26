package hashSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
public class Set {
    public static void main(String[] args) {

        HashSet<String> hs = new HashSet<>();
        hs.add("Delhi");
        hs.add("Mumbai");
        hs.add("Bengaluru");
        hs.add("Noida");
        System.out.println(hs);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Bengaluru");
        lhs.add("Noida");
        System.out.println(lhs);

        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Bengaluru");
        ts.add("Noida");
        System.out.println(ts);
    }
}
