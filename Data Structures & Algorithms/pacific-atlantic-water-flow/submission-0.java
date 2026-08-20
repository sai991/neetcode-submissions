

class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // 1. Populate initial ocean boundary cells
        for (int i = 0; i < m; i++) {
            pacificQueue.add(new int[]{i, 0});
            atlanticQueue.add(new int[]{i, n - 1});
            pacificVisited[i][0] = true;
            atlanticVisited[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            pacificQueue.add(new int[]{0, j});
            atlanticQueue.add(new int[]{m - 1, j});
            pacificVisited[0][j] = true;
            atlanticVisited[m - 1][j] = true;
        }

        // 2. Perform BFS from both oceans
        bfs(pacificQueue, pacificVisited, heights, m, n);
        bfs(atlanticQueue, atlanticVisited, heights, m, n);

        // 3. Find intersection of cells reachable by both oceans
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacificVisited[r][c] && atlanticVisited[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void bfs(Queue<int[]> queue, boolean[][] visited, int[][] heights, int m, int n) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : DIRECTIONS) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Bounds check + visited check + uphill height condition
                if (nr >= 0 && nr < m && nc >= 0 && nc < n 
                        && !visited[nr][nc] 
                        && heights[nr][nc] >= heights[r][c]) {
                    
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}