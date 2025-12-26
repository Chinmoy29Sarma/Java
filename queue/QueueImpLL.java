package queue;

public class QueueImpLL {

    static class Queue{

        static class Node{
            int data;
            Node next;

            public Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        Node front = null;
        Node rear = null;
        private int size = 0;

        // isEmpty
        public boolean isEmpty(){
            return size == 0;
        }

        // push
        public void push(int data){
            Node node = new Node(data);
            if(front == null){
                front = rear = node;
            }else{
                rear.next = node;
                rear = node;
            }
            size++;
        }

        // pop
        public int pop(){
            if(isEmpty()){
                System.out.println("Invalid Operation");
                return -1;
            }
            int val = front.data;
            if(size == 1){
                front = rear = null;
            }else{
                front = front.next;
            }
            size--;
            return val;
        }

        // peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Invalid Operation");
                return -1;
            }
            return front.data;
        }

        // size
        public int size(){
            return size;
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);

        q.pop();
        q.pop();

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.pop();
        }
    }
}
