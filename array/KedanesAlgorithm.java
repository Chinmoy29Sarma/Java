package array;

public class KedanesAlgorithm {

    // maximum subarray sum
    static int kedansAlgo(int[] arr){
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
          currSum += arr[i];
          if(currSum < 0){
              currSum = 0;
          }
          maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {-4, 7, -2, -1, 3, 3, -2};
        int max = kedansAlgo(arr);
        System.out.println("Maximum Sum = "+ max);
    }
}
