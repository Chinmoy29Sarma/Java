package dp;

import java.util.Arrays;

public class UnboundedKnapsack {

    // Basic Recursion
    public static int maxProfit(int[] val, int[] wt, int w, int n){
        // base case
        if(w == 0 || n == 0){ // n stands for number of items
            return 0;
        }
        int profInc = 0, profExcl = 0;
        // choice
        if(wt[n-1] <= w){
            // include
            profInc = val[n-1] + maxProfit(val, wt, w-wt[n-1], n);
        }
        // exclude
        profExcl = maxProfit(val, wt, w, n-1);
        return Math.max(profInc, profExcl);
    }

    // Memoization            O(n*w)
    public static int maxProfMemo(int[] val, int[] wt, int w, int n, int[][] dp){
        // base case
        if(w == 0 || n == 0){
            return 0;
        }
        if(dp[n][w] != -1){
            return dp[n][w];
        }
        // choice
        int profInc = 0, profExcl = 0;
        if(wt[n-1] <= w){
            // include
            profInc = val[n-1] + maxProfMemo(val,  wt, w-wt[n-1], n, dp);
        }
        // exclude
        profExcl = maxProfMemo(val, wt, w, n-1, dp);
        return dp[n][w] = Math.max(profInc, profExcl);
    }


    // Tabulation
    public static int maxProfitTabu(int[] val, int[] wt, int w){
        int n = val.length;
        int[][] dp = new int[n+1][w+1];
        // row means number of items
        // column means total capacity of knapsack

        // Initialize
        // 0th row -> if number of item is 0 then profit is 0 -> dp[0][j] = 0
        // 0th column -> if capacity of knapsack is 0 then so profit -> dp[i][0] = 0

        // i means number of item available
        for(int i=1; i<=n; i++){
            // j means total capacity of knapsack
            for(int j=1; j<=w; j++){
                int weight = wt[i-1]; // ith item present at (i-1) index
                int value = val[i-1];
                int profInc = 0, profExcl = 0;
                if(weight <= j){ // valid
                    // include
                    profInc = value + dp[i][j-weight];
                }
                // exclude
                profExcl = dp[i-1][j];
                dp[i][j] = Math.max(profInc, profExcl);
            }
        }
        print(dp);
        return dp[n][w];
    }

    public static void print(int[][] arr){
        for(int[] a: arr){
            for(int e: a){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Basic Recursion
        int[] val = {15, 14, 10, 45, 30};
        int[] wt  = {2, 5, 1, 3, 4};
        int w = 7;
//        System.out.println(maxProfit(val, wt, w, val.length));

        // Memoization
//        int n = val.length;
//        int[][] dp = new int[n+1][w+1];
//        // Initialize
//        for(int[] arr: dp){
//            Arrays.fill(arr, -1);
//        }
//        System.out.println(maxProfMemo(val, wt, w, n, dp));

        // Tabulation
        System.out.println(maxProfitTabu(val, wt, w));
    }
}
