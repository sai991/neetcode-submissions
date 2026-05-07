class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];

        // Count characters of s1
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0, right = 0;
        int count = s1.length();

        while (right < s2.length()) {
            // If char exists in s1, decrease count
            if (freq[s2.charAt(right) - 'a'] > 0) {
                count--;
            }

            freq[s2.charAt(right) - 'a']--;
            right++;

            // If window size equals s1 length
            if (count == 0) return true;

            // Shrink window
            if (right - left == s1.length()) {
                if (freq[s2.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                freq[s2.charAt(left) - 'a']++;
                left++;
            }
        }

        return false;
    }
}
