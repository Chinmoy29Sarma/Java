package dp;

import java.util.Arrays;

public class Knapsack {

    // 0-1 Knapsack
    // Basic Recursion
    public static int knapsack(int[] val, int[] wt, int w, int i){
        // base case
        if(w == 0 || i == val.length){
            return 0;
        }
        // choice
        int prof1 = 0, prof2 = 0;
        if(wt[i] <= w){
            // include the item in bag
            prof1 = val[i] + knapsack(val, wt, w-wt[i], i+1);
        }
        // exclude the item
        prof2 = knapsack(val, wt, w, i+1);
        return Math.max(prof1, prof2);
    }

    // Memoization
    // i stands for number of item available and i-th item
    public static int knapsackMemo(int[] val, int[] wt, int w, int i, int[][] dp){
        // base case
        if(w == 0 || i == val.length+1){
            return 0;
        }
        if(dp[i][w] != -1){
            return dp[i][w];
        }
        // choice
        int prof1 = 0, prof2 = 0;
        if(wt[i-1] <= w){
            // include the item in bag
            prof1 = val[i-1] + knapsackMemo(val, wt, w-wt[i-1], i+1, dp);
        }
        // exclude the item
        prof2 = knapsackMemo(val, wt, w, i+1, dp);
        return dp[i][w] = Math.max(prof1, prof2);
    }

    // Tabulation
    public static int knapsackTabu(int[] val, int[] wt, int w){
        int n = val.length;
        int[][] dp = new int[n+1][w+1];
        // Initialize dp array
        // First row -> means zero item available
        for(int j=0; j<=w; j++){
            dp[0][j] = 0;
        }
        // First column -> means the capacity of knapsack is zero
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }

        // i stands for number of item available and i-th item
        for(int i=1; i<=n; i++){
            // j stands for total capacity of knapsack at any point
            for(int j=1; j<=w; j++){
                int value = val[i-1]; // i th item is present at (i-1)th index
                int weight = wt[i-1];
                if(weight <= j){ // valid
                    int incProfit = value + dp[i-1][j-weight];
                    int exclProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, exclProfit);
                }else{
                    int exclProfit = dp[i-1][j];
                    dp[i][j] = exclProfit;
                }
            }
        }
        print(dp);
        return dp[n][w];
    }

    public static void print(int[][] dp){
        for(int[] num : dp){
            for(int e: num){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int w = 7;

        // Basic Recursion
//        System.out.println(knapsack(val, wt, w, 0));

        // Memoization
//        int[][] dp = new int[val.length+1][w+1];
//        for (int[] ints : dp) {
//            Arrays.fill(ints, -1);
//        }
//        System.out.println(knapsackMemo(val, wt, w, 1, dp));

        System.out.println(knapsackTabu(val, wt, w));
    }
}
