class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // Count frequency of each task
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }

        // Find the highest frequency
        int maxFreq = 0;

        for (int i = 0; i < 26; i++) {
            maxFreq = Math.max(maxFreq, freq[i]);
        }

        // Count how many tasks have the highest frequency
        int maxCount = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] == maxFreq) {
                maxCount++;
            }
        }

        // Minimum time based on the most frequent tasks
        int answer = (maxFreq - 1) * (n + 1) + maxCount;

        // If there are enough other tasks to fill the gaps,
        // we don't need idle time.
        return Math.max(answer, tasks.length);
    }
}