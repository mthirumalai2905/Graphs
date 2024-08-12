import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList;
    
    public Graph(int vertices){
        adjList = new HashMap<>();
        for(int i = 0; i < vertices; i++){
            adjList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest){
        adjList.get(src).add(dest);
    }

    public void bfs(int start){
        boolean[] vis = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        vis[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");

            for(int ngbr : adjList.get(node)){
                if(!vis[ngbr]){
                    queue.add(ngbr);
                    vis[ngbr] = true;
                }
            }
        }
    }

    public static void main(String[] args){
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        graph.bfs(0);
    }
}
