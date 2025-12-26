package queue;
public class QueueImple {

    static class Queue{
        int[] arr = new int[5];
        int front = 0 , rear = -1;
        private int size = 0;

        // isEmpty
        public boolean isEmpty(){
            return size == 0;
        }

        // push
        public void push(int data){
            if(size == arr.length){
                increaseSize();
                System.out.println("Queue is full");
            }
            rear = (rear + 1) % arr.length;
            arr[rear] = data;
            size++;
        }

        // increase size
        public void increaseSize(){
            int[] newArr = new int[2 * arr.length];
            int n = arr.length;
            int i = front;
            int j = 0;
            while(i != rear){
                newArr[j++] = arr[i];
                i = (i+1) % n;
            }
            newArr[j] = arr[i];
            arr = newArr;
            front = 0;
            rear = j;
        }

        // peek
        public int peek(){
            if(size == 0){
                System.out.println("Invalid Operation");
                return -1;
            }
            return arr[front];
        }

        // pop
        public int pop(){
            if(size == 0){
                System.out.println("Invalid Operation");
                return -1;
            }
            int val = arr[front];
            front = (front + 1) % arr.length;
            size--;
            return val;
        }

        // size
        public int size(){
            return size;
        }

        // print
        public void print(){
            for(int e : arr){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);

        q.pop();
        q.pop();

        q.push(5);
        q.push(6);
        q.push(7);
        q.push(8);
        q.push(9);
        q.push(10);

        q.print();
        
        while (!q.isEmpty()){
            System.out.println(q.pop());
        }

        q.print();
    }
}
