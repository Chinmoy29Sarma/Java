package arrayList;
import java.util.ArrayList;

public class Use {

    public static void swap(ArrayList<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        swap(list, 1, 3);
        System.out.println(list);

        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
    }
}
