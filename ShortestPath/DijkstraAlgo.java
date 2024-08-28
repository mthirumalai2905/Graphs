class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.distance));
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        
        pq.add(new Pair(S, 0));
        
        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int node = current.vertex;
            int nodeDist = current.distance;
            
            for(ArrayList<Integer> edge : adj.get(node)){
                int ngbr = edge.get(0);
                int weight = edge.get(1);
                
                if(nodeDist + weight < dist[ngbr]){
                    dist[ngbr] = nodeDist + weight;
                    pq.add(new Pair(ngbr, dist[ngbr]));
                }
            }
        }
        
        return dist;
    }
    static class Pair{
        int vertex;
        int distance;
        
        Pair(int vertex, int distance){
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}

