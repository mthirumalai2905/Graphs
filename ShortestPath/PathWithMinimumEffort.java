class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, 0, 0});

        int[][] minEffort = new int[rows][cols];
        for(int[] row : minEffort){
            java.util.Arrays.fill(row, Integer.MAX_VALUE);
        }
        minEffort[0][0] = 0;

        while(!minHeap.isEmpty()){
            int[] current = minHeap.poll();
            int effort = current[0];
            int x = current[1];
            int y = current[2];

            if(x == rows - 1 && y == cols - 1){
                return effort;
            }

            for(int[] dir : directions){
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols){
                    int newEffort = Math.max(effort, Math.abs(heights[nx][ny] - heights[x][y]));
                    if(newEffort < minEffort[nx][ny]){
                        minEffort[nx][ny] = newEffort;
                        minHeap.offer(new int[]{newEffort, nx, ny});
                    }
                }
            }
        }
        return 0;
    }
}
