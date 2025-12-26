package array;

public class SearchInSorted2Darr {

    static void search(int[][] arr, int key){
        int n = arr.length, m = arr[0].length;
        int i=0, j=m-1;

        while (i<n && j>=0){
            if(arr[i][j] == key){
                System.out.println("Found at index ("+i+","+j+")");
                return;
            }else if(key > arr[i][j]){
                i++;
            }else{
                j--;
            }
        }
        System.out.println("Key does not exist.");
    }
    public static void main(String[] args) {

        int[][] arr = { {1, 5, 7, 9},
                        {13, 15, 19, 24},
                        {17, 18, 22, 24},
                        {20, 21, 44, 45}};
        int key = 23;
        search(arr, key);
    }
}
