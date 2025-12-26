package recursion;

public class SortedArr {

    public static boolean sortedArr(int[] arr, int idx){
        // base case
        if(idx >= arr.length-1){
            return true;
        }
        // work
        if(arr[idx] > arr[idx+1]){
            return false;
        }
        // recursive call
        return sortedArr(arr, idx+1);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 5, 4, 6};
        System.out.println(sortedArr(arr, 0));
    }
}
