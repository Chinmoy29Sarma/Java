package graph;

import java.util.ArrayList;

public class Target {

    static class Edge{
        int src, dest;

        Edge(int s, int d){
            src = s;
            dest = d;
        }
    }

    public static void printPath(ArrayList<Edge>[] graph, int src, int dest, ArrayList<Integer> path){
        path.add(src);
        if(src == dest){
            print(path);
            path.removeLast();
            return;
        }

        // visit its neighbour
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            printPath(graph, e.dest, dest, path);
        }

        path.removeLast();

    }

    public static void print(ArrayList<Integer> al){
        for(int e : al){
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 3));

        // vertex 2
        graph[2].add(new Edge(2, 3));

        // vertex 3
        graph[3].add(new Edge(3, 1));

        // vertex 4
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // vertex 5
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        ArrayList<Integer> al = new ArrayList<>();
        printPath(graph, 5, 1, al);

    }
}
