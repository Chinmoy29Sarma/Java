package recursion;

public class Tiles {

    // Tiles Problem Lecture 21 first video
    public static int tile(int n){
        // base case
        if(n == 0 || n == 1){
            return 1;
        }
        // work & recursive call
        // Tile is placed vertically on the current position
        int ver = tile(n-1);
        // Tile is placed horizontally on the current position
        int hor = tile(n-2);
        return ver + hor;
    }

    public static void main(String[] args) {

        System.out.println(tile(10));
    }
}
