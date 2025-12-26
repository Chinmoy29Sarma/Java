package string;

public class UpperCase {

    static String upperCase(String str){
        StringBuilder sb = new StringBuilder();
        if(str.charAt(0) != ' '){
            sb.append(Character.toUpperCase(str.charAt(0)));
        }

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == ' '){
                sb.append(' ');
                if(i+1 < str.length() && str.charAt(i+1) != ' '){
                    sb.append(Character.toUpperCase(str.charAt(i+1)));
                    i++;
                }
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {

        String str = "Do   you   really think I am  affraid of  you";
        System.out.println(upperCase(str));
    }
}
