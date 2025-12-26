package dp;

import java.util.Arrays;

public class EditDistance {

    // Basic recursion          O(3^n) 0r O(3^m) the one which is more
    public static int editDist(String word1, int n, String word2, int m){
        // base case
        if(n == 0){
            return m;
        }
        if(m == 0){
            return n;
        }
        // n th character of word1 = m th character of word2
        if(word1.charAt(n-1) == word2.charAt(m-1)){
            return editDist(word1, n-1, word2, m-1);
        }
        // characters are different at respective positions
        // choice
        int add = 1 + editDist(word1, n, word2, m-1);
        int delete = 1 + editDist(word1, n-1, word2, m);
        int replace = 1 + editDist(word1, n-1, word2, m-1);
        return Math.min(add, Math.min(delete, replace));
    }

    // Memoization
    public static int editDistMemo(String word1, int n, String word2, int m, int[][] dp){
        // base case
        if(n == 0){
            return m;
        }
        if(m == 0){
            return n;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        // n th character of word1 = m th character of word2
        if(word1.charAt(n-1) == word2.charAt(m-1)){
            return dp[n][m] = editDist(word1, n-1, word2, m-1);
        }
        // characters are different at respective positions
        // choice
        int add = 1 + editDist(word1, n, word2, m-1);
        int delete = 1 + editDist(word1, n-1, word2, m);
        int replace = 1 + editDist(word1, n-1, word2, m-1);
        return dp[n][m] = Math.min(add, Math.min(delete, replace));
    }

    // Tabulation
//    public static int editDistTabu(String word1, String word2){
//        int n = word1.length();
//        int m = word2.length();
//        int[][] dp = new int[n+1][m+1];
//    }

    public static void main(String[] args) {

        // Basic recursion
        String word1 = "intention";
        int n = word1.length();
        String word2 = "execution";
        int m = word2.length();
//        System.out.println(editDist(word1, n, word2, m));
//        System.out.println(editDist("abcdef", 6, "bdeg", 4));

        // Memoization
//        int[][] dp = new int[n+1][m+1];
//        for(int[] arr: dp){
//            Arrays.fill(arr, -1);
//        }
//        System.out.println(editDistMemo(word1, n, word2, m, dp));
    }
}
