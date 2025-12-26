package greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthChain {
    public static void main(String[] args) {
        // Similar to activity selection
        int[][] pairs = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        // sort the 2D array based on second number
        Arrays.sort(pairs, Comparator.comparingDouble(o->o[1]));

        // select the first pair
        int maxChainLen = 1;
        int chainEnd = pairs[0][1];

        for(int i=1; i<pairs.length; i++){
            if(pairs[i][0] > chainEnd){ // if first number of current is greater than chain end
                maxChainLen++;
                chainEnd = pairs[i][1];
            }
        }

        System.out.println("Maximum chain length = "+maxChainLen);
    }
}
