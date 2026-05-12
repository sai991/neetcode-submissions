class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Check rows
        for (int i = 0; i < 9; i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !seen.add(board[i][j])) {
                    return false;
                }
            }
        }

        // Check columns
        for (int j = 0; j < 9; j++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.' && !seen.add(board[i][j])) {
                    return false;
                }
            }
        }

        // Check 3×3 boxes
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                Set<Character> seen = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char val = board[boxRow + i][boxCol + j];
                        if (val != '.' && !seen.add(val)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}