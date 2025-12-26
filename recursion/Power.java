package recursion;

public class Power {

    public static int power(int base, int pow){
        // base case
        if(pow == 0){
            return 1;
        }
        // recursive call & work
        return base * power(base, pow-1);
    }

    public static int powerOptimized(int base, int pow){
        // base case
        if(pow == 0){
            return 1;
        }
        // work & recursive call
        int halfPower = powerOptimized(base, pow/2);
        if(pow%2 == 0){ // even pow
            return halfPower * halfPower;
        }
        // odd pow
        return halfPower * halfPower * base;
    }

    public static void main(String[] args) {

        System.out.println(powerOptimized(2, 10));
    }
}
