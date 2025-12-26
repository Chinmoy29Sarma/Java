package string;

public class StringCompression {

    static String stringCompresser(String str){
        StringBuilder sb = new StringBuilder();
        int counter = 0, n = str.length();

        for(int i=0; i<n; i++){
            if(i+1 < n && str.charAt(i) == str.charAt(i+1)){
                counter++;
            }else{
                counter++;
                sb.append(str.charAt(i));
                if(counter != 1){
                    sb.append(counter);
                }
                counter = 0;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {

        String str = "aaabbccddsssaagsvnxt";
        System.out.println(stringCompresser(str));
    }
}
