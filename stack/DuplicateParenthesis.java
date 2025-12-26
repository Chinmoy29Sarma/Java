package stack;

import java.util.Stack;

public class DuplicateParenthesis {

    public static boolean duplicateParenthesis(String exp){
        Stack<Character> st = new Stack<>();
        // Traverse on the string
        for(int i=0; i<exp.length(); i++){
            char curr = exp.charAt(i);

            if(curr == ')'){
                int count = 0;
                while(st.peek() != '('){
                    st.pop();
                    count++;
                }
                st.pop();
                if(count == 0){
                    return true;
                }
            }else{
                st.push(curr);
            }
        }
        return false;
    }
    public static void main(String[] args) {

        String str = "(((a+b)) + (c+d))";
        System.out.println(duplicateParenthesis(str));
    }
}
