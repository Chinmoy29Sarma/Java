package stack;

import java.util.Stack;

public class MaxRectangularArea {

    // Next Smaller element Right
    public static int[] nextSmallerRight(int[] num){
        int n = num.length;
        Stack<Integer> st = new Stack<>();
        int[] nsr = new int[n];

        for(int i=n-1; i>=0; i--){

            while (!st.isEmpty() && num[st.peek()] >= num[i]){
                st.pop();
            }
            nsr[i] = st.isEmpty() ? n : st.peek(); // index
            st.push(i); // index
        }
        return nsr;
    }

    // Next smaller left
    public static int[] nextSmallerLeft(int[] num){
        int n = num.length;
        Stack<Integer> st = new Stack<>();
        int[] nsl = new int[n];

        for(int i=0; i<n; i++){

            while(!st.isEmpty() && num[st.peek()] >= num[i]){
                st.pop();
            }
            nsl[i] = st.isEmpty() ? -1 : st.peek(); // index
            st.push(i); // index
        }
        return nsl;
    }

    // Max rectangular area
    public static int maxArea(int[] height){
        int[] nsr = nextSmallerRight(height);
        int[] nsl = nextSmallerLeft(height);
        int maxA = 0;

        for(int i=0; i<height.length; i++){
            int hght = height[i];
            int width = nsr[i] - nsl[i] - 1;
            int area = hght * width;
            maxA = Math.max(maxA, area);
        }
        return maxA;
    }
    public static void main(String[] args) {

        int[] height = {2, 1, 5, 6, 2, 3};
        System.out.println(maxArea(height));
    }
}
