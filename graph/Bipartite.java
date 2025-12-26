package graph;

import java.util.*;

public class Bipartite {

    static class Edge{
        int src, dest;

        public Edge(int s, int d){
            src = s;
            dest = d;
        }
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++){
            // peeking each vertex
            if(color[i] == -1){
                q.add(i);
                color[i] = 0;

                // Traversing on the graph
                while(!q.isEmpty()){
                    int curr = q.remove();
                    // Finding the neighbours
                    for(int j=0; j<graph[curr].size(); j++){
                        Edge e = graph[curr].get(j);

                        // neighbour that is not visited yet
                        if(color[e.dest] == -1){
                            q.add(e.dest);
                            color[e.dest] = color[curr] == 0 ? 1 : 0;
                        }
                        // neighbour and curr have same color
                        else if(color[e.dest] == color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        // 0 vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));

        // 1 vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // 2 vertex
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        // 3 vertex
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 0));

        // 4 vertex
//        graph[4].add(new Edge(4, 0));
//        graph[4].add(new Edge(4, 3));

        System.out.println(isBipartite(graph));

    }
}
