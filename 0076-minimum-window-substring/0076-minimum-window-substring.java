class Solution {
    public String minWindow(String s, String t) {

        int[] freq = new int[128];

        // Count characters needed from t
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
        }

        int left = 0;
        int count = 0;

        int start = 0;
        int minLen = Integer.MAX_VALUE;

        // Expand window using right
        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            if (freq[c] > 0) {
                count++;
            }

            freq[c]--;

            // Window contains all characters of t
            while (count == t.length()) {

                // Save smallest window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Remove left character
                char remove = s.charAt(left);
                freq[remove]++;

                if (freq[remove] > 0) {
                    count--;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}