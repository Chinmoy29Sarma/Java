package hashSet;
import java.util.HashSet;
public class UnionIntersection {
    public static void main(String[] args) {

        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};

        // arr1 set
        HashSet<Integer> first = new HashSet<>();
        for(int e: arr1){
            first.add(e);
        }
        System.out.println(first);

        // arr2 set
        HashSet<Integer> second = new HashSet<>();
        for(int e: arr2){
            second.add(e);
        }
        System.out.println(second);

        // Union
        HashSet<Integer> union = new HashSet<>();
        union.addAll(first);
        union.addAll(second);
        System.out.println(union);

        // Intersection
        HashSet<Integer> intersection = new HashSet<>();
        for(int e: union){
            if(first.contains(e) && second.contains(e)){
                intersection.add(e);
            }
        }
        System.out.println(intersection);

    }
}
