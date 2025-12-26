package array;

public class SpiralMatrix {

    static void spiralMatrix(int[][] arr){

        int n = arr.length, m = arr[0].length;
        int st_col = 0, st_row = 0, end_col = m-1, end_row = n-1;

        while(st_row <= end_row && st_col <= end_col){
            // top
            for(int j=st_col; j<=end_col; j++){
                System.out.print(arr[st_row][j]+" ");
            }
            st_row++;

            // right
            for(int i=st_row; i<=end_row; i++){
                System.out.print(arr[i][end_col]+" ");
            }
            end_col--;

            // bottom
            for(int j=end_col; j>=st_col; j--){
                if(st_row >= end_row){
                    break;
                }
                System.out.print(arr[end_row][j]+" ");
            }
            end_row--;

            // left
            for(int i=end_row; i>=st_row; i--){
                if(st_col >= end_col){
                    break;
                }
                System.out.print(arr[i][st_col]+" ");
            }
            st_col++;
        }
    }
    public static void main(String[] args) {

        int[][] arr = { {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}};
        spiralMatrix(arr);
    }
}
