class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        boolean[][] seen = new boolean[m][n];  // Use boolean, cleaner
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !seen[i][j]) {
                    max = Math.max(max, findDfs(i, j, grid, seen));
                }
            }
        }
        
        return max;
    }
    
    private int findDfs(int i, int j, int[][] grid, boolean[][] seen) {
        // Bounds check and validation
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;  // Out of bounds
        }
        
        if (grid[i][j] == 0 || seen[i][j]) {
            return 0;  // Water or already visited
        }
        
        // Mark as visited
        seen[i][j] = true;
        
        // Count current cell + all 4 directions
        int count = 1;
        count += findDfs(i + 1, j, grid, seen);  // Down
        count += findDfs(i - 1, j, grid, seen);  // Up
        count += findDfs(i, j + 1, grid, seen);  // Right
        count += findDfs(i, j - 1, grid, seen);  // Left
        
        return count;
    }
}
