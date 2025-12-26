package greedyAlgorithm;

public class IndianCoin {

    public static int minCoin(int val){
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int n = coins.length;
        int ans = 0;

        for(int i=n-1; i>=0; i--){
            while(val >= coins[i]){
                ans++;
                val -= coins[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        System.out.println(minCoin(1230));
    }
}
