class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check which half is sorted
            if (nums[l] <= nums[mid]) {
                // Left half is sorted
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;  // Target in left sorted half
                } else {
                    l = mid + 1;  // Target in right half
                }
            } else {
                // Right half is sorted
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;  // Target in right sorted half
                } else {
                    r = mid - 1;  // Target in left half
                }
            }
        }
        
        return -1;
    }
}

      