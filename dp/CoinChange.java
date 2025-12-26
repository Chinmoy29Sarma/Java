package dp;

import java.util.Arrays;

public class CoinChange {

    // Basic Recursion
    public static int totalWays(int[] coins, int val, int n){
        // base case
        if(val == 0){
            return 1;
        }
        if(n == 0){ // n stands for number of coins
            return 0;
        }
        if(coins[n-1] <= val){ // valid
            // choice
            //              include                                exclude
            return totalWays(coins, val-coins[n-1], n) + totalWays(coins, val, n-1);
        }
        // invalid
        // exclude
        return totalWays(coins, val, n-1);
    }

    // Memoization
    public static int totalWaysMemo(int[] coins, int val, int n, int[][] dp){
        // base case
        if(val == 0){
            return 1;
        }
        if(n == 0){ // n stands for number of coins
            return 0;
        }
        if(dp[n][val] != -1){
            return dp[n][val];
        }
        if(coins[n-1] <= val){ // valid
            // choice
            //              include                                exclude
            return dp[n][val] = totalWays(coins, val-coins[n-1], n) + totalWays(coins, val, n-1);
        }
        // invalid
        // exclude
        return dp[n][val] = totalWays(coins, val, n-1);
    }

    // Tabulation
    public static int totalWaysTabu(int[] coins, int val){
        int n = coins.length;
        int[][] dp = new int[n+1][val+1];
        // row -> number of coins
        // column -> value

        // Initialize
        // 0th column -> if value is zero then total ways = 1
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        // 0th row -> if no coin is available then total ways = 0 (Except dp[0][0])

        // i stands for number of coins available and i-th coin
        for(int i=1; i<=n; i++){
            // j stands for value
            for(int j=1; j<=val; j++){
                int coinValue = coins[i-1];
                // valid
                if(coinValue <= j) { // ith coin present at (i-1) index
                    //          include             exclude
                    dp[i][j] = dp[i][j-coinValue] + dp[i-1][j];
                }else{
                    // Invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][val];
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
        int[] coins = {2, 5, 3, 6};
        int val = 10;
        int n = coins.length;
//        System.out.println(totalWays(coins, val, n));

        // Memoization
//        int[][] dp = new int[n+1][val+1];
//        // Initialization
//        for(int[] arr: dp){
//            Arrays.fill(arr, -1);
//        }
//        System.out.println(totalWaysMemo(coins, val, n, dp));

        // Tabulation
        System.out.println(totalWaysTabu(coins, val));
    }
}
