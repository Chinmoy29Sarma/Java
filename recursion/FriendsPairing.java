package recursion;

public class FriendsPairing {

    public static int friendsPair(int n){
        // base case
        if(n == 1 || n == 2){
            return n;
        }
        // Taking Choice
        // Person choose to stay alone
        int single = friendsPair(n-1);
        // Person choose to be paired
        int pair = (n-1) * friendsPair(n-2);
        return single + pair;
    }

    public static void main(String[] args) {

        System.out.println(friendsPair(5));
    }
}
