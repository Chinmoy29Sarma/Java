package recursion;

public class PrintNum {

    public static void printNum(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" ");
        printNum(n-1);
    }

    public static void printNumInc(int n){
        // base case
        if(n == 1){
            System.out.print(n+" ");
            return;
        }
        // recursive call
        printNumInc(n-1);
        System.out.print(n+" ");
    }
    public static void main(String[] args) {
        printNum(10);
        System.out.println();
        printNumInc(10);
    }
}
