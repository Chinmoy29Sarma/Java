package stack;
import java.util.Stack;
public class StackQuestion {

    // Qs.1 - Push at the bottom of the stack
    public static void pushAtBottom(Stack<Integer> st, int n){
        // base case
        if(st.isEmpty()){
            st.push(n);
            return;
        }
        // work
        int top = st.pop();
        // recursive call
        pushAtBottom(st, n);
        // work
        st.push(top);
    }

    // Reverse a Stack
    public static void reverse(Stack<Integer> st){
        // base case
        if(st.isEmpty()){
            return;
        }
        // work
        int top = st.pop();
        // recursive call
        reverse(st);
        // push to at the bottom
        pushAtBottom(st, top);
    }

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st);
        pushAtBottom(st, 4);
        System.out.println(st);

        reverse(st);
        System.out.println(st);

    }
}
