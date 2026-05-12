class Solution {
    public int longestConsecutive(int[] nums) {
         Set<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            s.add(nums[i]);
        }

         int max = 0;

          // Step 2: For each number, check if it's a sequence START
        for (int num : s) {
            // Only process if this is the start of a sequence
            if (!s.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                
                // Count how long this sequence is
                while (s.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                
                max = Math.max(max, currentLength);
            }
        }
        return max;
        
    }
}

