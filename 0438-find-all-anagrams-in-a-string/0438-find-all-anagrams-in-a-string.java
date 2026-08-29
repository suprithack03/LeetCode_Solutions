class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) {
            return ans;
        }

        int[] count = new int[26];

        // Count characters of p
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add new character
            count[s.charAt(right) - 'a']--;

            // Keep window size = p.length()
            if (right - left + 1 > p.length()) {
                count[s.charAt(left) - 'a']++;
                left++;
            }

            // Check the window
            if (right - left + 1 == p.length()) {

                boolean same = true;

                for (int i = 0; i < 26; i++) {
                    if (count[i] != 0) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    ans.add(left);
                }
            }
        }

        return ans;
    }
}