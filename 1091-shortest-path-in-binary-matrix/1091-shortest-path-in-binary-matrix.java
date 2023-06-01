class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        
        int n = grid.length;
        int[]dx = {-1,0,1};
        int[]dy = {-1,0,1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int steps = curr[2];
            
            if (x == n - 1 && y == n - 1) {
                return steps;
            }
            
            for(int i = 0;i<3;i++){
                for(int j = 0;j<3;j++){
                    int nx = x + dx[i];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny, steps + 1});
                    grid[nx][ny] = 1;
                }
                }
            }
        }
        return -1;
    }
}