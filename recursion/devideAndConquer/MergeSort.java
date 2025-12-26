package recursion.devideAndConquer;

public class MergeSort {

    // Merge sort
    public static void mergeSort(int[] arr, int si, int ei){
        // base case
        if(si >= ei){
            return;
        }
        // work
        int mid = si + (ei-si)/2;
        // recursive call
        // To sort the left part
        mergeSort(arr, si, mid);
        // To sort the right part
        mergeSort(arr, mid+1, ei);
        // work
        // merge the both sorted part
        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr, int si, int mid, int ei){
        int[] temp = new int[ei-si+1];
        int i = si; // to iterate on left sorted arr
        int j = mid+1; // to iterate on right sorted arr
        int k = 0; // to iterate on temp arr

        // merging both array
        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // coping remaining left part if exist
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        // coping remaining right part if exist
        while(j <= ei){
            temp[k++] = arr[j++];
        }

        // coping the temp arr to main arr
        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

    // Print array
    public static void printArr(int[] arr){
        for(int e : arr){
            System.out.print(e+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {4, 6, 1, 3, 7, -4};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);

    }
}
