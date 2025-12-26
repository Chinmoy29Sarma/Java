package basicSortingAlgorithms;

public class SelectionSort extends BubbleSort{

    static void selectionSort(int[] arr){
        int n = arr.length;

        for(int i=0; i<n; i++){
            int smallest = i;
            for(int j=i+1; j<n; j++){
                smallest = arr[j] < arr[smallest] ? j : smallest;
            }
            swap(arr, i, smallest);
        }
    }
    public static void main(String[] args) {

        int[] arr = {5, 4, 14, 63, 0, 27, 9, 5, 1};
        selectionSort(arr);
        printArr(arr);

    }
}
