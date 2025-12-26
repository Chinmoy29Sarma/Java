public class Main {
    public static void main(String[] args) {

        int n = 20, sum = 0;

        for(int i=1; i<=n; i=i+2){
            sum += i;
        }
        System.out.println("Odd number sum - "+ sum);

        sum = 0;
        for(int i=2; i<=n; i=i+2){
            sum += i;
        }
        System.out.println("Even number sum - "+ sum);

        sum = 0;
        for(int i=1; i<=n; i++){
            sum += i;
        }
        System.out.println("Odd number sum - "+ sum);
    }
}