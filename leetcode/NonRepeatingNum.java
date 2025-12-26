package leetcode;

public class NonRepeatingNum {
    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 2};
        int res = 0;

        for(int e: nums){
            res ^= e;
            System.out.println(res);
        }
    }
}
