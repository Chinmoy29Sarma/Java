package dp;

import java.util.Arrays;

public class LongestCommonSubsequence {

    // Basic Recursion
    public static int lcs(String str1, int n, String str2, int m){
        // base case
        if(n == 0 || m == 0){
            return 0;
        }
        // last character same
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return lcs(str1, n-1, str2, m-1) + 1;
        }
        // last character not same
        int ans1 = lcs(str1, n-1, str2, m);
        int ans2 = lcs(str1, n, str2, m-1);
        return Math.max(ans1, ans2);
    }


    // Memoization
    public static int lcsMemo(String str1, int n, String str2, int m, int[][] dp){
        // base case
        if(n == 0 || m == 0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        // last character same
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return dp[n][m] = lcsMemo(str1, n-1, str2, m-1, dp) + 1;
        }
        // last character not same
        int ans1 = lcsMemo(str1, n-1, str2, m, dp);
        int ans2 = lcsMemo(str1, n, str2, m-1, dp);
        return dp[n][m] = Math.max(ans1, ans2);
    }

    // Tabulation
    public static int lcsTabu(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        // Row stands for str1 length
        // Column stands for str2 length
        int[][] dp = new int[n+1][m+1];
        // Initialize
        // 0 th row -> str1 length zero -> lcs is 0
        // 0 th column -> str2 length zero -> lcs is 0

        // i stands for str1 length and i th character
        for(int i=1; i<=n; i++){
            // j stands for str2 length and j th character
            for(int j=1; j<=m; j++){
                // i th character of str1 is equal to j th character of str2
                // i th character is at (i-1) index
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                // last character is not same
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        print(dp);
        return dp[n][m];
    }

    // print
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
        String str1 = "abcde";
        String str2 = "acdegb";
//        System.out.println(lcs(str1, str1.length(), str2, str2.length()));

        // Memoization
//        int n = str1.length(), m = str2.length();
//        int[][] dp = new int[n+1][m+1];
//        for(int[] arr: dp){
//            Arrays.fill(arr, -1);
//        }
//        System.out.println(lcsMemo(str1, n, str2, m, dp));

        // Tabulation
        System.out.println(lcsTabu(str1, str2));

    }
}
