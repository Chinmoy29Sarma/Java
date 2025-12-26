package array.assignment;

public class SearchOnRotatedArr {

    // QS 2
    static int searchOnRotatedArr(int[] arr, int key){
        int st = 0, end = arr.length;

        while(st <= end){
            int mid = (end-st)/2 + st;

            if(key == arr[mid]){
                return mid;
            }else if(arr[st] <= arr[mid]){
                if(key >= arr[st] && key < arr[mid]){
                    end = mid-1;
                }else{
                    st = mid+1;
                }
            }else{
                if(key > arr[mid] && key <= arr[end]){
                    st = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] arr = {3, 4, 5, 6, 1, 2};
        int key = 2;
        System.out.println(searchOnRotatedArr(arr, key));
    }
}
