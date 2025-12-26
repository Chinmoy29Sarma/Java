package graph;
import java.util.ArrayList;
public class DetectCycle {

    static class Edge{
        int src, dest;

        public Edge(int s, int d){
            src = s;
            dest = d;
        }
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!vis[i] && detectCycleUtil(graph, vis, i, -1)){
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par){
        // visit the curr vertex
        vis[curr] = true;
        // visit its neighbour
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            // neighbour not visited
            if(!vis[e.dest]){
                // visit and asked if cycle exist
                if(detectCycleUtil(graph, vis, e.dest, curr)){
                    return true;
                }
            }
            // neighbour is already visited and it is not parent
            else if(vis[e.dest] && e.dest != par){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1));
//        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // 1 vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // 2 vertex
//        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // 3 vertex
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        // 4 vertex
        graph[4].add(new Edge(4, 3));

        System.out.println(detectCycle(graph));
    }
}
