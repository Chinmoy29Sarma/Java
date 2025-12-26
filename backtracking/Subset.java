package backtracking;

public class Subset {

    public static void subset(String str, String res, int idx){
        // base case
        if(idx == str.length()){
            System.out.println(res);
            return;
        }
        // Choice
        // character will come
        subset(str, res+str.charAt(idx), idx+1);
        // character will not come
        subset(str, res, idx+1);
    }

    public static void main(String[] args) {
        subset("abc", "", 0);
    }
}
