package greedyAlgorithm;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;

public class ActivitySelection {
    public static void main(String[] args) {

        // if sorted based on end time
//        int[] start = {1, 3, 0, 5, 8, 5};
//        int[] end = {2, 4, 6, 7, 9, 9};
//
//        int maxAct = 0; // Maximum number of activity
//        ArrayList<Integer> activity = new ArrayList<>(); // to store activity index
//
//        // select the first activity
//        maxAct = 1;
//        activity.add(0);
//        int lastEnd = end[0];
//
//        for(int i=1; i<end.length; i++){
//            if(start[i] >= lastEnd){
//                maxAct++;
//                activity.add(i);
//                lastEnd = end[i];
//            }
//        }
//
//        System.out.println("Maximum Activity = "+ maxAct);
//        for(int e : activity){
//            System.out.print("A"+e+" ");
//        }
//        System.out.println();

        // if not sorted based on end time
        int[] start = {0, 1, 3, 5, 5, 8};
        int[] end = {6, 2, 4, 7, 9, 9};

        // make 2d array
        int[][] activity = new int[start.length][3];

        for(int i=0; i<start.length; i++){
            activity[i][0] = i; // index
            activity[i][1] = start[i]; // start time
            activity[i][2] = end[i]; // end time
        }

        // lambda function
        Arrays.sort(activity, Comparator.comparingDouble(o->o[2]));

        int maxAct = 0; // maximum number of activity
        ArrayList<Integer> list = new ArrayList<>(); // to store activity index

        // select first activity
        maxAct = 1;
        list.add(activity[0][0]);
        int lastEnd = activity[0][2]; // end time of last activity

        for(int i=1; i<start.length; i++){
            int startTime = activity[i][1]; // start time of current activity
            if(startTime >= lastEnd){
                maxAct++;
                list.add(activity[i][0]);
                lastEnd = activity[i][2];
            }
        }

        System.out.println("Maximum Activity = "+ maxAct);
        for(int e: list){
            System.out.print("A"+e+" ");
        }
    }
}
