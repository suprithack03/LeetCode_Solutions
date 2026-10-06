class Solution {
    public String reorganizeString(String s) {

        int[] freq = new int[26];

        // Count characters
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find most frequent character
        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > max) {
                max = freq[i];
                maxIndex = i;
            }
        }

        // If one character occurs too many times
        if (max > (s.length() + 1) / 2) {
            return "";
        }

        char[] ans = new char[s.length()];

        int index = 0;

        // Put most frequent character first
        while (freq[maxIndex] > 0) {
            ans[index] = (char) ('a' + maxIndex);
            freq[maxIndex]--;
            index += 2;
        }

        // Put remaining characters
        for (int i = 0; i < 26; i++) {

            while (freq[i] > 0) {

                if (index >= s.length()) {
                    index = 1;
                }

                ans[index] = (char) ('a' + i);
                freq[i]--;

                index += 2;
            }
        }

        return new String(ans);
    }
}