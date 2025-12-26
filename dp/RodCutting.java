package dp;

import java.util.Arrays;

public class RodCutting {

    // Basic  Recursion
    public static int maxProfit(int[] len, int[] price, int l, int n){ // n -> size of length array
        // base case
        if(l == 0 || n == 0){
            return 0;
        }
        // choice
        int profInc = 0, profExcl = 0;
        if(len[n-1] <= l){ // valid
            // include
            profInc = price[n-1] + maxProfit(len, price, l-len[n-1], n);
        }
        // exclude
        profExcl = maxProfit(len, price, l, n-1);
        return Math.max(profInc, profExcl);
    }


    // Memoization                    O(n*l)
    public static int maxProfitMemo(int[] len, int[] price, int l, int n, int[][] dp){ // n -> size of length array
        // base case
        if(l == 0 || n == 0){
            return 0;
        }
        if(dp[n][l] != -1){
            return dp[n][l];
        }
        // choice
        int profInc = 0, profExcl = 0;
        if(len[n-1] <= l){ // valid
            // include
            profInc = price[n-1] + maxProfit(len, price, l-len[n-1], n);
        }
        // exclude
        profExcl = maxProfit(len, price, l, n-1);
        return dp[n][l] = Math.max(profInc, profExcl);
    }

    // Tabulation
    public static int maxProfitTabu(int[] len, int[] price, int l){
        int n = len.length;

        // Row -> Number of pieces available
        // Column -> length of rod
        int[][] dp = new int[n+1][l+1];

        // Initialize
        // 0th row -> number of available pieces 0 -> profit 0
        // 0th column -> length of rod zero -> profit 0

        // i stands for number of pieces available & i-th piece
        for(int i=1; i<=n; i++){
            // j stands for length og rod
            for(int j=1; j<=l; j++){
                int length = len[i-1]; // i-th element present at (i-1) index
                int pr = price[i-1];
                // valid
                if(length <= j){
                    //                    include             // exclude
                    dp[i][j] = Math.max(pr + dp[i][j-length], dp[i-1][j]);
                }
                // invalid
                else{
                    //         exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][l];
    }

    public static void main(String[] args) {

        // Basic Recursion
        int[] len = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int l = 8;
        int n = len.length;
//        System.out.println(maxProfit(len, price, l, n));

        // Memoization
//        int[][] dp = new int[n+1][l+1];
//        for(int[] arr: dp){
//            Arrays.fill(arr, -1);
//        }
//        System.out.println(maxProfitMemo(len, price, l, n, dp));

        // Tabulation
        System.out.println(maxProfitTabu(len, price, l));

    }
}
