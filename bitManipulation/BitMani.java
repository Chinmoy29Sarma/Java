package bitManipulation;
import java.util.Scanner;
public class BitMani {
    public static void oddOrEven(int a){
        int bitMask = a & 1;
        if(bitMask == 0){
            System.out.println("Number is Even");
        }else{
            System.out.println("Number is Odd");
        }
    }

    public static int getIthBit(int a, int i){
        int bitMask = 1 << i;
        if((a & bitMask) == 0){
            return 0;
        }else {
            return 1;
        }
    }

    public static int setIthBit(int a, int i){
        int bitMask = 1 << i;
        return a | bitMask;
    }

    public static int clearIthBit(int a, int i){
        int bitMask = ~(1<<i);
        return a & bitMask;
    }

    public static int clearLastIBits(int a, int i){
        int bitMask = (~0) << i;
        return a & bitMask;
    }

    public static int clearRangeOfBits(int a, int j, int i){
        int bitMask = ((~0) << (j+1)) | (~((~0) << i));
        return a & bitMask;
    }

    public static int countSetBits(int n){
        int count = 0;
        while(n != 0){
//            if((n & 1) == 1){
//                count++;
//            }
            count += (n & 1) == 1 ? 1 : 0;
            n = n >> 1;
        }
        return count;
    }
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        oddOrEven(a);

//        System.out.println(getIthBit(16, 2));
//        System.out.println(setIthBit(16, 3));
//        System.out.println(clearIthBit(7, 1));
//        System.out.println(clearLastIBits(7, 2));
//        System.out.println(clearRangeOfBits(15, 3, 1));
        System.out.println(countSetBits(12));
    }
}
