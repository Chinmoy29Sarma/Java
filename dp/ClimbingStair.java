package dp;

public class ClimbingStair {

    // Basic Recursion
    public static int climbingStairRec(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return climbingStairRec(n-1) + climbingStairRec(n-2);
    }

    // Memoization
    public static int climbStairMemo(int n, int[] dp){
        if(n == 0 || n == 1){
            return 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = climbStairMemo(n-1, dp) + climbStairMemo(n-2, dp);
        return dp[n];
    }

    // Tabulation
    public static int climbStairTabu(int stair){
        int[] dp = new int[stair+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=stair; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[stair];
    }
    public static void main(String[] args) {

        int stair = 4;
//        System.out.println(climbingStairRec(stair));
//        System.out.println(climbStairMemo(stair, new int[stair+1]));
        System.out.println(climbStairTabu(stair));

    }
}
