package recursion;

public class Sum {

    public static int firstNSum(int n){
        // base case
        if(n == 1){
            return n;
        }
        // recursive call
        return n + firstNSum(n-1);
    }

    public static void main(String[] args) {
        System.out.println(firstNSum(10));
    }
}
