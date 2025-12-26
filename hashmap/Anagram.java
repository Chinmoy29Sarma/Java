package hashmap;
import java.util.HashMap;
import java.util.Scanner;
public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        if(str1.length() != str2.length()){
            System.out.println("Not anagram");
            return;
        }

        HashMap<Character, Integer> freq = new HashMap<>();
        // adding characters of str1 to the freq map
        for(int i=0; i<str1.length(); i++){
            char ch = str1.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i<str2.length(); i++){
            char ch = str2.charAt(i);
            if(!freq.containsKey(ch)){
                System.out.println("Not anagram.");
                return;
            }
            freq.put(ch, freq.get(ch)-1);
            if(freq.get(ch) == 0){
                freq.remove(ch);
            }
        }

        if(freq.isEmpty()){
            System.out.println("Anagram");
        }else{
            System.out.println("Not anagram");
        }
    }
}
