package stack;
import java.util.LinkedList;
public class StackImp {

    static class Stack{
        LinkedList<Integer> list = new LinkedList<>();

        // isEmpty
        public boolean isEmpty(){
            return list.isEmpty();
        }

        // push
        public void push(int val){
            list.addFirst(val);
        }

        // peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            }
            return list.getFirst();
        }

        // pop
        public int pop(){
            if(isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            }
            return list.removeFirst();
        }
    }

    public static void main(String[] args) {

        Stack st = new Stack();

        st.push(1);
        st.push(2);
        st.push(3);

//        System.out.println(st.peek());
//        System.out.println(st.pop());
//        System.out.println(st.peek());
//        System.out.println(st.pop());

        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
}
