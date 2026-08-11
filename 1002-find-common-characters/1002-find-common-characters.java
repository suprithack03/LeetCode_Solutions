class Solution {
    public List<String> commonChars(String[] words) {

        int[] common = new int[26];

        // Frequency of first word
        for (int i = 0; i < words[0].length(); i++) {
            common[words[0].charAt(i) - 'a']++;
        }

        // Compare with remaining words
        for (int i = 1; i < words.length; i++) {

            int[] freq = new int[26];

            for (int j = 0; j < words[i].length(); j++) {
                freq[words[i].charAt(j) - 'a']++;
            }

            // Keep minimum frequency
            for (int j = 0; j < 26; j++) {
                common[j] = Math.min(common[j], freq[j]);
            }
        }

        // Build answer
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            while (common[i] > 0) {
                ans.add(String.valueOf((char) (i + 'a')));
                common[i]--;
            }
        }

        return ans;
    }
}