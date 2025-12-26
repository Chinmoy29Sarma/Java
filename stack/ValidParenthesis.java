package stack;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean validParenthesis(String brackets){
        Stack<Character> st = new Stack<>();

        // Traverse on the string
        for(int i=0; i<brackets.length(); i++){
            char currB = brackets.charAt(i);
            // Push in the stack if currB is an opening brackets
            if(currB == '(' || currB == '{' || currB == '['){
                st.push(currB);
            }
            // Check in the stack for corresponding opening  bracket
            else if(!st.isEmpty() && ((st.peek() == '(' && currB == ')') ||
                    (st.peek() == '{' && currB == '}') ||
                    (st.peek() == '[' && currB == ']'))){
                // Remove the corresponding opening bracket from
                // the stack
                st.pop();

            }
            else{
                return false;
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        String str = ")(";
        System.out.println(validParenthesis(str));
    }
}
