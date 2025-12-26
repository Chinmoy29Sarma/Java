package array;

public class MaxSubArray {

    // Prefix sum array
    static int[] prefixArr(int[] arr){
        int[] prefix = new int[arr.length];

        prefix[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            prefix[i] = arr[i] + prefix[i-1];
        }
        return prefix;
    }

    // Max Min Subarray Sum
    static void maxMinSubarraySum(int[] arr){
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        int[] prefix = prefixArr(arr);

        for(int i=0; i<n; i++){
            System.out.print(prefix[i]+" ");
        }
        System.out.println();

        for(int i=-1; i<n; i++){
            int sum = 0;
            for(int j=i+1; j<n; j++){
                if(i == -1){
                    sum = prefix[j];
                }else{
                    sum = prefix[j] - prefix[i];
                }
                maxSum = Math.max(maxSum, sum);
                minSum = Math.min(minSum, sum);
            }
        }
        System.out.println("Maximum Sum = "+ maxSum);
        System.out.println("Minimum Sum = "+ minSum);
    }
    public static void main(String[] args) {

        int[] arr = {1, 2, -4, 3, -5, 6, -7};
        maxMinSubarraySum(arr);
    }
}
