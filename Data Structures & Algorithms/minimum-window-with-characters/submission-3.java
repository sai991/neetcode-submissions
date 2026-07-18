class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Frequency map for characters needed from t
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int formed = 0;                  // # of unique chars in t matched with required frequency
        int required = need.size();      // # of unique chars in t

        // Window character frequency map
        Map<Character, Integer> window = new HashMap<>();

        // Result: [window length, left index, right index]
        int[] result = {-1, 0, 0};

        while (right < s.length()) {
            // Expand window to the right
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Check if current char satisfies the required frequency
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // Try to contract window from the left
            while (left <= right && formed == required) {
                // Update result if this window is smaller
                if (result[0] == -1 || right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }

                // Remove leftmost character from window
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);

        
    }
}
