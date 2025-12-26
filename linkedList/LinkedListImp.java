package linkedList;

public class LinkedListImp {
    public static void main(String[] args) {

//        linkedList ll = new linkedList();
//        ll.addFirst(1);
//        ll.addFirst(2);
//        ll.addFirst(3);
//        ll.addFirst(4);
//
//        ll.addLast(5);
//        ll.addLast(6);
//        ll.addLast(7);
//        ll.addLast(8);

//        ll.printLL();
//        ll.addAt(15, 3);
//        ll.printLL();
//        ll.addAt(10, 0);
//        ll.printLL();
//        ll.addAt(100, ll.size());
//        ll.printLL();
//        System.out.println(ll.size());


//        ll.removeFirst();
//        ll.printLL();
//        ll.removeLast();
//        ll.printLL();
//        System.out.println(ll.size());
//
//        System.out.println(ll.search(7));
//        System.out.println(ll.search(17));
//
//        System.out.println(ll.searchRec(7));
//        System.out.println(ll.searchRec(17));

//        ll.reverse();
//        ll.printLL();

//        ll.printLL();
//        System.out.println(ll.removeNth(3));
//        ll.printLL();
//        System.out.println(ll.removeNth(5));
//        ll.printLL();


        linkedList ll = new linkedList();
        ll.addLast(1);
//        ll.addLast(2);
//        ll.addLast(3);
//        ll.addLast(2);
//        ll.addLast(4);
        System.out.println(ll.palindromeLL());
    }
}

class linkedList{

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    private int size;

    // Add on first
    public void addFirst(int data){
        Node node = new Node(data);
        // For empty ll
        if(head == null){
            head = tail = node;
        }else{ // For non empty ll
            node.next = head;
            head = node;
        }
        size++;
    }

    // Add on last
    public void addLast(int data){
        Node node = new Node(data);
        // For empty ll
        if(head == null){
            head = tail = node;
        }else{ // For non empty ll
            tail.next = node;
            tail = node;
        }
        size++;
    }

    // Add at an index
    public void addAt(int data, int index){
        // Out of bound
        if(index > size){
            System.out.println("Index out of bound");
            return;
        }
        if(index == 0){
            addFirst(data);
        }else if(index == size){
            addLast(data);
        }else{
            int i=0; // Iterator
            Node node = new Node(data);
            Node temp = head; // iterator
            while (i < index-1){
                temp = temp.next;
                i++;
            }
            // positioning the node
            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }

    // Remove from first
    public int removeFirst(){
        // For empty ll
        if(head == null){
            System.out.println("LinkedList is empty");
            return -1;
        }
        // For non empty ll
        int val = head.data;
        head = head.next;
        if(size == 1){
            tail = null;
        }
        size--;
        return val;
    }

    // Remove from last
    public int removeLast(){
        // For empty ll
        if(head == null){
            System.out.println("LinkedList is empty");
            return -1;
        }
        // For non empty ll
        int val = tail.data;
        if(size == 1){
            head = tail = null;
            size--;
            return val;
        }
        Node temp = head; // iterator
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    // Print ll
    public void printLL(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public int size(){
        return size;
    }

    // Search in a ll
    public int search(int data){
        int i=0;
        Node temp = head;
        while (temp != null){
            if(data == temp.data){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // Search recursively in ll
    public int searchRec(int key){
        return helperFun(head, key);
    }

    public int helperFun(Node temp, int key){
        // base case
        if(temp == null){
            return -1;
        }
        // work
        if(temp.data == key){
            return 0;
        }
        // recursive call
        int idx = helperFun(temp.next, key);
        return idx == -1 ? -1 : idx+1;
    }

    // Reverse a linkedList
    public void reverse(){
        Node prev, curr, Next;
        prev = null;
        curr = head;
        tail = head;

        while (curr != null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        head = prev;
    }

    // Remove Nth node from end
    public int removeNth(int N){
        if(size == N){
            return removeFirst();
        }
        int idx = size-N;
        int i=0;
        Node temp = head;

        while (i < idx-1){
            temp = temp.next;
            i++;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return val;
    }

    // Palindrome LinkedList
    public boolean palindromeLL(){
        // Find the middle node
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is the middle node
        // reverse the second half
        Node prev, curr, Next;
        prev = null;
        curr = slow;

        while(curr != null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        // Traverse on both list
        Node temp1 = head, temp2 = prev;
        while(temp2 != null){
            if(temp1.data != temp2.data){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

}
