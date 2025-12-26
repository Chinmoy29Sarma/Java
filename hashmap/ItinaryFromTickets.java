package hashmap;
import java.util.HashMap;
public class ItinaryFromTickets {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        // from - to
        map.put("Chennai", "Bengaluru");
        map.put("Mumbai", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");

        HashMap<String, String>  revMap= new HashMap<>();
        // to - from
        // O(n)
        for(String st: map.keySet()){
            //       destination  start
            revMap.put(map.get(st), st);
        }

        // find starting point
        String start = "";
        // O(n)
        for(String st: map.keySet()){
            if(!revMap.containsKey(st)){
                start = st;
                System.out.print(start);
                break;
            }
        }

        // O(n)
        while (map.get(start) != null){
            System.out.print(" -> "+map.get(start));
            start = map.get(start);
        }
    }
}
