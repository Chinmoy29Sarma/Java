package queue;
import java.util.Stack;

public class QueueImpStack {

    static class Queue{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // isEmpty
        public boolean isEmpty(){
            return s1.isEmpty();
        }

        // add -> O(n)
        public void add(int data){
            if(s1.isEmpty()){
                s1.push(data);
            }else{
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
                s1.push(data);
                while (!s2.isEmpty()){
                    s1.push(s2.pop());
                }
            }
        }

        // remove
        public int remove(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }

        // peek
        public int peek(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
