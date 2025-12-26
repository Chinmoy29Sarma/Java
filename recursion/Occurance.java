package recursion;

public class Occurance {

    public static int firstOccurance(int[] arr, int key, int idx){
        // base case
        if(idx >= arr.length){
            return -1;
        }
        // work
        if(arr[idx] == key){
            return idx;
        }
        // recursive call
        return firstOccurance(arr, key, idx+1);
    }

    public static int lastOccurance(int[] arr, int key, int i){
        // base case
        if(i >= arr.length){
            return -1;
        }
        // recursive call
        int index = lastOccurance(arr, key, i+1);
        if(index == -1 && arr[i] == key){
            return i;
        }
        return index;
    }

    public static void main(String[] args) {

        int[] arr = {10, 15, 6, 8, 2, 3, 7, 7, 8, 3};
//        System.out.println(firstOccurance(arr, 7, 0));
        System.out.println(lastOccurance(arr, 3, 0));
    }
}
