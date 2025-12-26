package stack;
import java.util.Stack;

public class StockSpanProb {

    public static int stockSpan(int[] stock){
//        int[] span = new int[stock.length];
        int maxSpan;
        Stack<Integer> st = new Stack<>();

//        span[0] = 1; // Span og first day ( 0 index)
        maxSpan = 1;
        st.push(0); // index of first day

        for(int i=1; i<stock.length; i++){

            while (!st.isEmpty() && stock[i] >= stock[st.peek()]){
                st.pop();
            }
            if(st.empty()){
//                span[i] = i+1;
                maxSpan = Math.max(maxSpan, i+1);
            }else{
//                span[i] = i-st.peek();
                maxSpan = Math.max(maxSpan, i-st.peek());
            }
            st.push(i);
        }

//        for(int e : span){
//            System.out.print(e+" ");
//        }
//        System.out.println();
        return maxSpan;
    }

    public static void main(String[] args) {

        int[] stock = {100, 80, 60, 70, 60, 85, 100};
        System.out.println(stockSpan(stock));
    }
}
