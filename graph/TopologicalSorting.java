package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSorting {

    static class Edge{
        int src, dest;

        Edge(int s, int d){
            src = s;
            dest = d;
        }
    }

    public static void topSort(ArrayList<Edge>[] graph){
        int v = graph.length;
        boolean[] visit = new boolean[v];
        Stack<Integer> s= new Stack<>();

        for(int i=0; i<v; i++){
            if(!visit[i]){
                topSortUtil(graph, i, visit, s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        System.out.println();
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] visit, Stack<Integer> s){
        visit[curr] = true;
        // visit its neighbour
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visit[e.dest]){
                topSortUtil(graph, e.dest, visit, s);
            }
        }
        s.push(curr);
    }

    // topological sorting using bsf
    public static void topSort2(ArrayList<Edge>[] graph){
        int v = graph.length;
        // storing in-degree for each vertex
        int[] indeg = new int[v];
        calcIndeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();

        // adding elements in the queue which has in-degree value 0
        for(int i=0; i<v; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        // bsf
        while (!q.isEmpty()){
            int curr = q.remove();
            // print topological order
            System.out.print(curr+" ");
            // see its neighbour
            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                // reduce the value of in-degree for it's neighbours
                indeg[e.dest]--;
                // if in-degree is zero for any neighbour then add it in the queue
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
    }

    public static void calcIndeg(ArrayList<Edge>[] graph, int[] indeg){
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void main(String[] args) {

        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        // 2 vertex
        graph[2].add(new Edge(2, 3));

        // 3 vertex
        graph[3].add(new Edge(3, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // 5 vertex
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

//        topSort(graph);
        topSort2(graph);

    }
}
