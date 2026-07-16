class Solution {
    
    // 4 directions — up, down, left, right
    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Try every cell as starting point
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If first char matches — start DFS
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, 
                        int row, int col, int index) {
        
        // Base case — matched all characters
        if (index == word.length()) {
            return true;
        }
        
        // Boundary check + character match check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] != word.charAt(index)) {
            return false;
        }
        
        // Mark as visited by temporarily modifying cell
        char temp = board[row][col];
        board[row][col] = '#';  // visited marker
        
        // Explore all 4 directions
        boolean found = false;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (dfs(board, word, newRow, newCol, index + 1)) {
                found = true;
                break;  // no need to explore further
            }
        }
        
        // BACKTRACK — restore the cell
        board[row][col] = temp;
        
        return found;
    }
}