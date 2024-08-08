
class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    private void bfs(int row, int col, int[][] vis, int[][] grid, List<Pair> shape) {
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        shape.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int currRow = current.first;
            int currCol = current.second;

            for (int i = 0; i < 4; i++) {
                int newRow = currRow + delRow[i];
                int newCol = currCol + delCol[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && vis[newRow][newCol] == 0) {
                    vis[newRow][newCol] = 1;
                    q.add(new Pair(newRow, newCol));
                    shape.add(new Pair(newRow, newCol));
                }
            }
        }
    }

    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Set<String> uniqueShapes = new HashSet<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (vis[row][col] == 0 && grid[row][col] == 1) {
                    List<Pair> shape = new ArrayList<>();
                    bfs(row, col, vis, grid, shape);

                    StringBuilder shapeStr = new StringBuilder();
                    int baseRow = shape.get(0).first;
                    int baseCol = shape.get(0).second;
                    for (Pair p : shape) {
                        shapeStr.append((p.first - baseRow) + ":" + (p.second - baseCol) + " ");
                    }

                    uniqueShapes.add(shapeStr.toString());
                }
            }
        }

        return uniqueShapes.size();
    }
}
