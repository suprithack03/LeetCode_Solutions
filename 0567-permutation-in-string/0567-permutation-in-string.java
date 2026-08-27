class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count = new int[26];

        // Count characters in s1
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            // Add new character
            count[s2.charAt(right) - 'a']--;

            // Keep window size equal to s1
            if (right - left + 1 > s1.length()) {
                count[s2.charAt(left) - 'a']++;
                left++;
            }

            // Check current window
            if (right - left + 1 == s1.length()) {

                boolean same = true;

                for (int i = 0; i < 26; i++) {
                    if (count[i] != 0) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    return true;
                }
            }
        }

        return false;
    }
}