class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r= curr[0];
            int c=curr[1];

            for(int[] di : dir){
                int nr= r+di[0];
                int nc= c+di[1];

                if(nr<0||nr>=m||nc<0||nc>=n||grid[nr][nc]!=Integer.MAX_VALUE){
                    continue;
                }
                grid[nr][nc] = grid[r][c] + 1;

q.add(new int[]{nr, nc});
            }

        }




        
    }

    }

   

