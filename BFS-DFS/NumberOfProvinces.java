import java.util.ArrayList;

class Solution {
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] vis){
        vis[node] = 1;
        for(Integer it : adjList.get(node)){
            if(vis[it] == 0){
                dfs(it, adjList, vis);
            }a
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int vis[] = new int[V];
        int count = 0;
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                count++;
                dfs(i, adjList, vis);
            }
        }
        return count;
    }
}
