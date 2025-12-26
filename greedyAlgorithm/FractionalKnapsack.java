package greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static double frackKnapsack(int[] val, int[] weight, int w){
        int n = val.length;

        // to store ratio and corresponding index
        double[][] ratio = new double[n][2];
        for(int i=0; i<n; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        // sorting the 2d array based on ratio (val/weight)
        Arrays.sort(ratio, Comparator.comparingDouble(o->o[1]));
        double profit = 0;

        // calculating profit
        for(int i=n-1; i>=0; i--){
            int idx = (int)ratio[i][0];
            if(w >= weight[idx]){ // include full weight
                profit += val[idx];
                w -= weight[idx];
            }else{ // include fractional weight
                profit += ratio[i][1] * w;
                break;
            }
        }

        return profit;
    }
    public static void main(String[] args) {
//
//        int[] val = {60, 100, 120};
//        int[] weight = {10, 20, 30};
//        int w = 50;

        int[] val = {100, 70, 400, 60, 700, 200};
        int[] weight = {10, 2, 10, 5, 10, 40};
        int w = 40;
        System.out.println(frackKnapsack(val, weight, w));
    }
}
