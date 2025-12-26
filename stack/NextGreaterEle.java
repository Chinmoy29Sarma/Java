package stack;
import java.util.Stack;

public class NextGreaterEle {

    public static int[] nextGreaterEle(int[] num){
        int n = num.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){

            while(!st.isEmpty() && num[i] >= st.peek()){
               st.pop();
            }
//            if(st.isEmpty()){
//                nge[i] = -1;
//            }else{
//                nge[i] = st.peek();
//            }
            nge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(num[i]);
        }
        return nge;
    }

    public static void print(int[] arr){
        for(int e : arr){
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int[] num = {6, 8, 0, 1, 3};
        int[] nge = nextGreaterEle(num);
        print(nge);
    }
}
