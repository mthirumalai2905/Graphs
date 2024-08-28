import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int[][] directions = {
            {1, 0},   
            {-1, 0},  
            {0, 1},   
            {0, -1},  
            {1, 1},    
            {1, -1},  
            {-1, 1},  
            {-1, -1}  
        };

    
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); 

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int distance = current[2];

            if (row == n - 1 && col == n - 1) {
                return distance;
            }

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (isValid(newRow, newCol, n, grid, visited)) {
                    queue.offer(new int[]{newRow, newCol, distance + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return -1; 
    }

    private boolean isValid(int row, int col, int n, int[][] grid, boolean[][] visited) {
        return row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0 && !visited[row][col];
    }
}
