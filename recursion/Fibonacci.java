package recursion;

public class Fibonacci {

    public static int fibonacci(int n){
        // base case
        if(n == 0 || n == 1){
            return n;
        }
        // recursive call & work
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(11));
    }
}
