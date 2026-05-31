class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
for (int num : nums) {
    if (!s.add(num)) {
        return num; // duplicate found
    }
}
      return 0;  
    }
}


