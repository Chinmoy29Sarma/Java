package graph;
import java.util.*;

public class Bfs {

    static class Edge{
        int src, dest, wt;

        public Edge(int s, int d, int w){
            src = s;
            dest = d;
            wt = w;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){ // Not visited
                System.out.print(curr+" "); // Print
                visited[curr] = true; // is visited
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    if(!visited[e.dest]){
                        q.add(e.dest);
                    }
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        // visit the vertex
        System.out.print(curr+" ");
        vis[curr] = true;
        // visit the neighbour
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int target, boolean[] vis){
        if(src == target){
            return true;
        }
        // visited
        vis[src] = true;
        // ask its neighbour
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest] && hasPath(graph, e.dest, target, vis)){
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }
        // 0 vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1 vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5 vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6 vertex
        graph[6].add(new Edge(6, 5, 1));

        bfs(graph);
//        dfs(graph, 0, new boolean[v]);
//        System.out.println(hasPath(graph, 5, 2, new boolean[v]));

    }
}
