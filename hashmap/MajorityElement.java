package hashmap;
import java.util.HashMap;
import java.util.Set;
public class MajorityElement {
    public static void main(String[] args) {

        int[] nums = {1, 2, 4, 3, 2, 1, 2};
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int e: nums){
            // already element exist
            if(freq.containsKey(e)){
                freq.put(e, freq.get(e)+1);
            }else{
                // new element
                freq.put(e, 1);
            }
        }

        Set<Integer> keys = freq.keySet();
        int maxEle, n = nums.length;
        for(int key: keys){
            int frequency = freq.get(key);
            if(frequency > (n/3)){
                System.out.println(key);
            }
        }

    }
}
