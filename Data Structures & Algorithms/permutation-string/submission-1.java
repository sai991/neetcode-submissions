class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        // 1. Fill map1 with s1 frequencies
        for (char c : s1.toCharArray()) {
            map1[c - 'a']++;
        }

        // 2. Count initial matches (all positions where both are 0)
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (map1[i] == map2[i]) matches++;
        }

        int left = 0;

        // 3. Slide the window across s2
        for (int right = 0; right < s2.length(); right++) {

            // --- ADD right character ---
            int c = s2.charAt(right) - 'a';
            map2[c]++;

            if (map2[c] == map1[c])         matches++;       // just became equal
            else if (map2[c] == map1[c] + 1) matches--;      // just overshot

            // --- REMOVE left character (once window exceeds s1 size) ---
            if (right - left + 1 > s1.length()) {
                int l = s2.charAt(left) - 'a';
                left++;

                if (map2[l] == map1[l])         matches--;   // was equal, now won't be
                else if (map2[l] == map1[l] + 1) matches++;  // was overshot, now equal

                map2[l]--;
            }

            // --- CHECK ---
            if (matches == 26) return true;
        }

        return false;
    }
}