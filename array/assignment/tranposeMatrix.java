package array.assignment;

public class tranposeMatrix {

    static int[][] tranposeMat(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int[][] trans = new int[m][n];

        // Traversing on trans
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                trans[i][j] = mat[j][i];
            }
        }
        return trans;
    }

    static void printMat(int[][] mat){
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        int[][] arr = { {1, 2}, {3, 4}, {5, 6}};
        int[][] trans = tranposeMat(arr);
        printMat(trans);
    }
}
