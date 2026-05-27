class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Convert 1D index to 2D
            int row = mid / n;
            int col = mid % n;
            int val = matrix[row][col];

            if (val == target) return true;
            else if (val < target) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }
}