

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        // 1. Sort the array to handle duplicates easily
        Arrays.sort(nums);
        
        dfs(nums, 0, res, subset);
        return res;
    }

    private void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> subset) {
        // Base case: if we've made a decision for all elements
        if (i == nums.length) {
            // 2. Add a COPY of the subset, not the reference
            res.add(new ArrayList<>(subset));
            return;
        }

        // Decision 1: Include nums[i]
        subset.add(nums[i]);
        dfs(nums, i + 1, res, subset);
        subset.remove(subset.size() - 1); // backtrack

        // Decision 2: Exclude nums[i] AND skip all duplicates of nums[i]
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        dfs(nums, i + 1, res, subset);
    }
}