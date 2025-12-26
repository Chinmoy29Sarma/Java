package bitManipulation;

public class aasignment {

    // Question 1
    // X to the power X
    public static long power(int x){
        long ans = 1;
        int pow = x, base = x;
        while (pow > 0){
            if((pow & 1) == 1){
                ans *= base;
            }
            base  *= base;
            pow = pow >> 1;
        }
        return ans;
    }

    // swap two numbers without using a third variable
    public static void swap(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = "+ a);
        System.out.println("b = "+ b);
    }

    // add one to an integer using bit manipulation
    public static int addOne(int a){
        return -(~a);
    }
    public static void main(String[] args) {
//        System.out.println(power(5));

//        swap(23, 76);

        System.out.println(addOne(4));



    }
}
