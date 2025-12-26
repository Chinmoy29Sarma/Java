package hashSet;
import java.util.HashSet;
public class CountDistinctEle {
    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};

        // O(n)
        HashSet<Integer> hs = new HashSet<>();
        // iterate the nums array and insert its elements to HashSet
        for(int e: nums){
            hs.add(e);
        }
        System.out.println("Distinct element count : "+hs.size());
        // iterate on HashSet and print all elements
        for(int e: hs){
            System.out.println(e);
        }

        // O(n^2)
//        int n = nums.length;
//        int count = n;
//        for(int i=0; i<n; i++){
//            for(int j=i+1; j<n; j++){
//                if(nums[i] == nums[j]){
//                    count--;
//                    break;
//                }
//            }
//        }
//        System.out.println(count);

    }
}
