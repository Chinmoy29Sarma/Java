package array;

public class TrappingRainWater {

    static int trappingWater(int[] arr){
        int n = arr.length, area = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Left Maximum height
        leftMax[0] = arr[0];
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
        }
        // Right Maximum height
        rightMax[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(arr[i], rightMax[i+1]);
        }

        for(int i=1; i<n; i++){
            area += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        return area;
    }
    public static void main(String[] args) {

        int[] height = {4, 2, 0, 6, 3, 2, 5};
        int area = trappingWater(height);
        System.out.println("area = "+ area);
    }
}
