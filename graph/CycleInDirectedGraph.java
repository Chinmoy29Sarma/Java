package graph;

import java.util.ArrayList;

public class CycleInDirectedGraph {

    static class Edge{
        int src, dest;

        Edge(int s, int d){
            src = s;
            dest = d;
        }
    }

    public static boolean DetectCycle(ArrayList<Edge>[] graph){
        int v = graph.length;
        boolean[] visit = new boolean[v];
        boolean[] stack = new boolean[v];

        for(int i=0; i<v; i++){
            if(!visit[i] && DetectCycleUtil(graph, i, visit, stack)){
                return true;
            }
        }
        return false;
    }

    public static boolean DetectCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] visit, boolean[] stack){
        visit[curr] = true;
        stack[curr] = true;
        // Get the neighbour
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            // neighbour that is not visited yet
            if(!visit[e.dest]){
                if(DetectCycleUtil(graph, e.dest, visit, stack)){
                    return true;
                }
            }
            // neighbour that is visited and still present in the call stack -> means cycle exist
            else if(visit[e.dest] && stack[e.dest]){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {

        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // 2 vertex
//        graph[2].add(new Edge(2, 3));

        // 3 vertex
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 2));


        System.out.println(DetectCycle(graph));
    }
}
