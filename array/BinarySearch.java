package array;

public class BinarySearch {

    static int binarySearchRecursion(int[] arr, int key, int st, int end){
        if(st > end){
            return -1;
        }
        int mid = (st+end)/2;

        if(key == arr[mid]){
            return mid;
        }else if(key < arr[mid]){
            end = mid-1;
        }else{
            st = mid+1;
        }
        return binarySearchRecursion(arr, key, st, end);
    }

    static int binarySearch(int[] arr, int key){
        int st = 0, end = arr.length-1;

        while(st<=end){
            int mid = (st+end)/2;
            if(key == arr[mid]){
                return mid;
            }else if(key < arr[mid]){
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int key = 3;
//        int index = binarySearch(arr, key);
        int index = binarySearchRecursion(arr, key, 0, arr.length-1);

        if(index == -1){
            System.out.println("Number does not exist");
            return;
        }
        System.out.println("Number is present at index "+ index);
    }
}
