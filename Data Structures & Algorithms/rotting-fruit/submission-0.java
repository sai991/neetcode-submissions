class Solution {
    public int orangesRotting(int[][] grid) {

        int m =grid.length;
        int n=grid[0].length;
        int fresh=0;

        Queue<int[]> q= new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                  q.add(new int[]{i,j});

                if(grid[i][j]==1){
                    fresh++;
                } 

            }
        }

         int min=0;
         int[][] dir ={{-1,0},{1,0},{0,1},{0,-1}};

          while (!q.isEmpty() && fresh > 0) {
    int size = q.size();
    
    for (int i = 0; i < size; i++) {
        int[] curr = q.poll();

        for (int[] c : dir) {
            int nr = curr[0] + c[0];
            int nc = curr[1] + c[1];

            // Skip out of bounds or non-fresh cells
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != 1) {
                continue;
            }

            // Infect fresh fruit
            fresh--;
            grid[nr][nc] = 2;
            q.add(new int[]{nr, nc});
        }
    }
    
    // Increment minute only after processing a full level
    min++;
}

return fresh == 0 ? min : -1;

        
    }

   
}
