package leetcode;

public class Prob {

    public static void main(String[] args) {
        Solution s = new Solution();
        long num1 = 9;
        long num2 = 999999999;
        ListNode l1 = s.makeLL(num1);
        ListNode l2 = s.makeLL(num2);

        ListNode res = s.addTwoNumbers(l1, l2);

        ListNode temp = res;
        while(temp != null){
            System.out.print(temp.val);
            temp = temp.next;
        }
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {

    public int num(ListNode l){
        int revNum = 0, num = 0;
        while(l != null){
            revNum = revNum * 10 + l.val;
            l = l.next;
        }

        while(revNum > 0){
            num = num * 10 + revNum % 10;
            revNum = revNum/10;
        }

        return num;
    }

    public ListNode makeLL(long num){
        if(num == 0){
            return new ListNode(0);
        }
        ListNode head = null;
        ListNode tail = null;
        while(num > 0){
            int dig = (int) num % 10;
            num /= 10;
            if(head == null){
                head = tail = new ListNode(dig);
            }else{
                ListNode node = new ListNode(dig);
                tail.next = node;
                tail = node;
            }
        }
        return head;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int num1 = num(l1);
        int num2 = num(l2);

        long res = num1 + num2;

        return makeLL(res);
    }
}

