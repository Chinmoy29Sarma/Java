package recursion;

public class BinaryString {

    // Note
    // Change on StringBuilder will reflect on each level of recursion.
    // because its store the address in stack but the actual object exist in
    // heap and all reference variable point towards the same object.
    public static void binaryStr(int n, String res){
        // base case
        if(n == 0){
            System.out.println(res);
            return;
        }
        if(n < 0){
            System.out.println(res.substring(0, res.length()-1));
            return;
        }
        // Choice
        // Zero
        binaryStr(n-1, res+0);
        // One & zero
        binaryStr(n-2, res+10);
    }

    public static void main(String[] args) {
        binaryStr(5, "");
    }
}
