package basicSortingAlgorithms;

public class BubbleSort {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void bubbleSort(int[] arr){
        int n = arr.length;

        for(int i=1; i<n; i++){
            for(int j=0; j<n-i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    static void printArr(int[] arr){
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int[] arr = {5, 4, 7, 6, 22, 17};
        bubbleSort(arr);
        printArr(arr);
    }
}
