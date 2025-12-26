package array;

public class BuySellStock {
    static int maxProfit(int[] prices){
        int n = prices.length, maxProfit = 0;
        // Max right array
        int[] maxRight = new int[n];

        maxRight[n-1] = prices[n-1];
        for(int i=n-2; i>=0; i--){
            maxRight[i] = Math.max(prices[i], maxRight[i+1]);
        }

        for(int i=0; i<n; i++){
            maxProfit = Math.max(maxProfit, maxRight[i]-prices[i]);
        }
        return maxProfit;
    }
    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum Profit = "+ maxProfit);
    }
}
