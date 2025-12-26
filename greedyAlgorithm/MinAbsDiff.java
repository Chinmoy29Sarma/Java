package greedyAlgorithm;

import java.util.Arrays;

public class MinAbsDiff {
    public static void main(String[] args) {

        int[] A = {2, 5, 1, 0};
        int[] B = {4, 1, 3, 8};

        Arrays.sort(A);
        Arrays.sort(B);

        int minAbsDiff = 0;

        for(int i=0; i<A.length; i++){
            minAbsDiff += Math.abs(A[i]-B[i]);
        }
        System.out.println("Minimum absolute difference = "+minAbsDiff);
    }
}
