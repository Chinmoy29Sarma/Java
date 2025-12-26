package hashSet;
import java.util.HashSet;

public class IterateOnSet {
    public static void main(String[] args) {

        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bengaluru");
        cities.add("Noida");
        cities.add("Kolkata");
        cities.add("Guwahati");

        // Method 1
//        Iterator it = cities.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }

        // Method 2
        for(String city: cities){
            System.out.println(city);
        }
    }
}
