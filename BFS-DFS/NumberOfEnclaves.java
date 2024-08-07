class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n-1 || j == m-1) && grid[i][j] == 1) {
                    dfs(grid,i, j);
                }
            }
        }

        int s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s += grid[i][j];
            }
        }
        return s;
    }
    public void dfs(int[][] grid,int i ,int j){
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid,i+1, j);
        dfs(grid,i-1, j);
        dfs(grid,i, j+1);
        dfs(grid,i, j-1);
    }
}
