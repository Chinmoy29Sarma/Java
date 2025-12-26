package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Lec2 {

    static class Edge{
        int src, dest, wt;

        public Edge(int s, int d, int w){
            src = s;
            dest = d;
            wt = w;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        for(int i=0; i< graph.length; i++){
            if(!visited[i]){
                bfsUtil(graph, visited);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){ // Not visited
                System.out.print(curr+" "); // Print
                visited[curr] = true; // is visited
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                dfsUtil(graph, i, vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        // visit the vertex
        System.out.print(curr+" ");
        vis[curr] = true;
        // visit the neighbour
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {

    }
}
