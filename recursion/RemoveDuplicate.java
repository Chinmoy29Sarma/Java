package recursion;

public class RemoveDuplicate {

    // Using for loop
    public static String removeDup(String str){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            if(sb.indexOf(curr+"") == -1){
                sb.append(curr);
            }
        }
        return sb.toString();
    }

    // Basic recursive
    public static StringBuilder removeDup2(String str, int len){
        // base case
        if(len == 0){
            return new StringBuilder();
        }
        char curr = str.charAt(len-1);
        StringBuilder sb = new StringBuilder();
        sb = removeDup2(str, len-1);
        if(sb.indexOf(curr+"") == -1){
            sb.append(curr);
        }
        return sb;
    }

    // basic recursion approach 2
    public static StringBuilder removeDup3(String str, int idx, boolean[] map, StringBuilder res){
        // base case
        if(idx == str.length()-1){
            return res;
        }
        // work
        char curr = str.charAt(idx);
        if(!map[curr-'a']){
            res.append(curr);
            map[curr-'a'] = true;
        }
        return removeDup3(str, idx+1, map, res);
    }

    public static void main(String[] args) {
//        System.out.println(removeDup("appnnacollege"));
//        System.out.println(removeDup2("appnnacollege", "appnnacollege".length()));

        String str = "appnnacollege";
        boolean[] map = new boolean[26];
        System.out.println(removeDup3(str, 0, map, new StringBuilder()));
    }
}
