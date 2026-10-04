class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> ans = new ArrayList<>();

        int[] last = new int[26];

        // Store last position of every character
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            // Find the last occurrence of current character
            end = Math.max(end, last[s.charAt(i) - 'a']);

            // We have reached the last occurrence
            // of every character in this partition
            if (i == end) {
                ans.add(end - start + 1);
                start = i + 1;
            }
        }

        return ans;
    }
}