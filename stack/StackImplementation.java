package stack;
import java.util.ArrayList;

public class StackImplementation {

    static class Stack{
        ArrayList<Integer> list = new ArrayList<>();

        // isEmpty method
        public boolean isEmpty(){
            return list.isEmpty();
        }

        // push
        public void push(int val){
            list.add(val);
        }

        // peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return list.getLast();
        }

        // pop
        public int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return list.removeLast();
        }

        // size
        public int size(){
            return list.size();
        }
    }

    public static void main(String[] args) {

        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);

        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.pop());
    }
}

