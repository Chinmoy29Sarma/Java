package dp;

import java.util.Arrays;

public class TargetSumSubset {

    // Basic Recursion      O(2^n)
    public static boolean targetSum(int[] num, int target, int i){
        // base case
        if(target == 0){
            return true;
        }
        if(i == num.length){
            return false;
        }
        // Choice
        // include
        if(num[i] <= target && targetSum(num, target-num[i], i+1)){
            return true;
        }
        // exclude
        return targetSum(num, target, i+1);
    }

    // Memoization            O(n*target)
    public static boolean targetSumMemo(int[] num, int target, int i, boolean[][] dp){
        // base case
        if(target == 0){
            return true;
        }
        if(i == num.length){
            return false;
        }
        if(!dp[i][target]){
            return dp[i][target];
        }
        // Choice
        if(num[i] <= target){
            // include
            dp[i][target] = targetSumMemo(num, target-num[i], i+1, dp);
            if(dp[i][target]){
                return true;
            }
        }
        return dp[i][target] = targetSumMemo(num, target, i+1, dp);
    }


    // Tabulation
    public static boolean targetSumTabu(int[] num, int target){
        int n = num.length;
        boolean[][] dp = new boolean[n+1][target+1];
        // Initialization
        // First column -> if target sum zero then subset sum doesn't dependent on number
        // of items
        for(int i=0; i<=n; i++){
            dp[i][0] = true;
        }
        // First row -> if number of item zero then whatever the target is (except zero),
        // it won't be achieved means dp[0][j] = false

        // i stands for number of items and i-th item
        for(int i=1; i<=n; i++){
            // j stands for target sum
            for(int j=1; j<=target; j++){
                int v = num[i-1];
                // include
                if(v <= j && dp[i-1][j-v]){
                    dp[i][j] = true;
                }
                // exclude
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);

      return dp[n][target];
    }

    public static void print(boolean[][] arr){
        for(boolean[] a: arr){
            for(boolean v: a){
                if(v){
                    System.out.print(v+"  ");
                }else{
                    System.out.print(v+" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Basic Recursion
        int[] numbers = {4, 2, 7, 1, 3};
        int target = 10;
//        System.out.println(targetSum(numbers, target, 0));

        // Memoization
//        boolean[][] dp = new boolean[numbers.length][target+1];
//        for(boolean[] arr: dp){
//            Arrays.fill(arr, true);
//        }
//        System.out.println(targetSumMemo(numbers, target, 0, dp));

        // Tabulation
        System.out.println(targetSumTabu(numbers, target));
    }
}
